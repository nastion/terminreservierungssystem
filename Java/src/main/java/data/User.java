package data;

import controller.Controller;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class User implements IUser {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String password;
    @OneToMany
    private Set<Notification> notifications;

    @ManyToMany
    private Set<Poll> events;

    @Transient
    private Controller controller;

    public User() {

    }

    public User(String name, String password) {
        this.setName(name);
        this.setPassword(password);
    }

    @Override
    public void notify_User(Event event) {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Set<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(Set<Notification> notifications) {
        this.notifications = notifications;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Set<Poll> getEvents() {
        return events;
    }

    public void setEvents(Set<Poll> events) {
        this.events = events;
    }
}
