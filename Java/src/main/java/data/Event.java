package data;


public interface Event {

	String descripition = null;
	String location = null;
	User user = null;
	//private Controller controller;

	void addTeilnehmer(User u);
	void remTeilnehmer(User t);
	void notifyTeilnehmer();

}
