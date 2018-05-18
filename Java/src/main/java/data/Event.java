package data;


public interface Event {

	String descripition = null;
	String location;
	User user;
	//private Controller controller;

	void addTeilnehmer(User u);
	void remTeilnehmer(User t);
	void notifyTeilnehmer();

}
