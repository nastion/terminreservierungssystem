package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Teilnehmer implements User {
	@Id
	@GeneratedValue
	private Poll poll;




	public void notify_User() {

	}

}
