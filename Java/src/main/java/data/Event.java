package data;


public interface Event {


	void addTeilnehmer(User u);
	void remTeilnehmer(User t);
	void notifyTeilnehmer();

}
