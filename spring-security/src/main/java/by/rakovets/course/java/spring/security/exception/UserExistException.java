package by.rakovets.course.java.spring.security.exception;

public class UserExistException extends Exception {
    public UserExistException(String message) {
        super(message);
    }
}
