package by.rakovets.course.java.spring.webmvc.rest.server.model;

public class User {
    private long id;
    private String login;
    private String password;
    private String aboutMe;
    private boolean subscription;

    public User() {
    }

    public User(long id, User user) {
        this.id = id;
        this.login = user.getLogin();
        this.password = user.getPassword();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public boolean isSubscription() {
        return subscription;
    }

    public void setSubscription(boolean subscription) {
        this.subscription = subscription;
    }
}
