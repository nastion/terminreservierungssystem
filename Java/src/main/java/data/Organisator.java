package data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class Organisator implements User {
	@Id
	@GeneratedValue
	private Poll poll;

    private String name;
    private String password = null;
    //private Controller controller;
    private Notification notification = null;


    public void setDate(Date date) {

	}



	public void notify_User() {

	}

}
