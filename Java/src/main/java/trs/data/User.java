package trs.data;

import trs.controller.Controller;

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

    @Transient
    private Controller controller;

    @OneToMany(mappedBy = "organisator")
    private Set<Poll> org_polls;

    @ManyToMany
    private Set<Poll> events;

    public User() {

    }

    /***
     * Konstruktor
     * @param name
     * @param password
     */
    public User(String name, String password) {
        this.setName(name);
        this.setPassword(password);
    }

    /***
     * Notifies User with the Description from  an event
     * @param event
     */
    @Override
    public void notify_User(Event event) {
        System.out.println("Notifying user for " + ((Poll) event).getDescription());
    }
    /*
        Generated getter/setter
     */
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
}
