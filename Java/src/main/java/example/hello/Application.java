package example.hello;

import example.data.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
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

        User u = new User("testuser", "test");
        session.persist(u);

        t.commit();//transaction is commited

        session.close();

        System.out.println("successfully saved");
        SpringApplication.run(Application.class, args);
    }

}