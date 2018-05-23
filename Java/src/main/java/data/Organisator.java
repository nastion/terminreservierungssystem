package data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

public class Organisator implements User {
	@Id
	@GeneratedValue
	private Poll poll;
	public void setDate(Date date) {

	}



	public void notify_User() {

	}

}
