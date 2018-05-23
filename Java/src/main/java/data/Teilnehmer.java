package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Teilnehmer implements User {
	@Id
	@GeneratedValue
	private Poll poll;

	private String name;
	private String password = null;
	//private Controller controller;
	private Notification notification = null;


	public void notify_User() {

	}

}
