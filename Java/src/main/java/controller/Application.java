package controller;

import data.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


public class Application {

    public static void main(String[] args) {
        //creating configuration object
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file

        //creating session factory object
        SessionFactory factory=cfg.buildSessionFactory();

        //creating session object
        Session session=factory.openSession();

        //creating transaction object
        Transaction t=session.beginTransaction();

        Notification n = new Notification("Notification text", "Head");
        User u = new Teilnehmer("org", "test", n);
        User u2 = new Teilnehmer("testuser", "test", n);
        Date d = new Date(2018, 5, 23, 15, 40);
        Poll p = new Poll(d, u, "Test Poll", "Testlocation", (data.User) u);

        session.persist(u);
        session.persist(u2);
        session.persist(p);

        t.commit();//transaction is commited

        session.close();

    }

}
