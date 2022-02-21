import by.rakovets.course.java.spring.framework.example.properties.UserDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class PropertiesApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        context.getEnvironment().setActiveProfiles("dev");
        context.setConfigLocation("application-context.xml");
        context.refresh();
        UserDao service = context.getBean(UserDao.class);
        service.getNameById(1L);

        context.getEnvironment().setActiveProfiles("prod");
        context.refresh();
        service = context.getBean(UserDao.class);
        service.getNameById(1L);
    }
}
