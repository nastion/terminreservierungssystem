package data;

import javax.persistence.Embeddable;

@Embeddable
public interface IUser {
	void notify_User(Event event);
}
