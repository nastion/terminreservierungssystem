package data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class User implements IUser {
    @Id
    private int id;
    @NotNull
    private String name;
    @NotNull
    private String password;
    @OneToMany(mappedBy = "Notification")
    private Set<Notification> notifications;

    public User() {
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
}
