package by.rakovets.course.java.spring.aop.examples;

import by.rakovets.course.java.spring.aop.dao.BaseDAO;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
@Aspect
public class TransactionManagerWithAspects {
    private final SessionFactory sessionFactory;

    @Autowired
    public TransactionManagerWithAspects(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Pointcut("execution(* app.dao.impl.*.find*(..))")
    public void findEntry() {
    }

    @Pointcut("execution(* app.dao.impl.*.save*(..))")
    public void saveEntry() {
    }

    @Pointcut("execution(* app.dao.impl.*.delete*(..)))")
    public void deleteEntry() {
    }

    @Around("findEntry()")
    public Object readOnlyTx(ProceedingJoinPoint pjp) {
        Session session = null;
        Object methodResult = null;
        try {
            session = sessionFactory.getCurrentSession();
            methodResult = process(session, pjp);
        } catch (Throwable t) {
            log.error("Fatal error during invoke " + createMethodInfo(pjp), t);
        } finally {
            closeSession(session);
        }

        return methodResult;
    }

    @Around("deleteEntry() || saveEntry()")
    public Object commitTx(ProceedingJoinPoint pjp) {
        Session session = null;
        Object methodResult = null;
        try {
            session = beginTx();
            methodResult = process(session, pjp);
        } catch (Throwable t) {
            log.error("Fatal error during invoke " + createMethodInfo(pjp));
        } finally {
            finishTx(session);
        }

        return methodResult;
    }

    private Object process(Session session, ProceedingJoinPoint pjp) throws Throwable {
        BaseDAO baseDao = (BaseDAO) pjp.getTarget();
        baseDao.setSession(session);
        return pjp.proceed();
    }

    private String createMethodInfo(ProceedingJoinPoint pjp) {
        return new StringBuilder().
                append("method '").
                append(pjp.getSignature().getDeclaringTypeName()).
                append(".").
                append(pjp.getSignature().getName()).
                append("' with args '").
                append(Arrays.toString(pjp.getArgs())).
                toString();
    }

    private void finishTx(Session session) {
        try {
            if (session != null) {
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            log.error("Error during commit session. Transaction will be rolled back.", e);
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            closeSession(session);
        }
    }

    private void closeSession(final Session session) {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    private Session beginTx() throws HibernateException {
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        return session;
    }
}