package trs.data;


public interface Event {


	void addTeilnehmer(User u);
	void remTeilnehmer(User u);
	void notifyTeilnehmer();

}
