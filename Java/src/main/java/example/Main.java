package example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    @SuppressWarnings({ "deprecation", "unused", "unchecked" })
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

        example.data.User u = new example.data.User("testuser", "test");

        t.commit();//transaction is commited

        session.close();

        System.out.println("successfully saved");
    }
}