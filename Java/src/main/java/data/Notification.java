package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Notification {
    @Id
    @GeneratedValue
    private long id;
	private String text;
	private String heading;

    public Notification(String text, String heading) {
        this.text = text;
        this.heading = heading;
    }
}
