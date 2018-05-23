package example.hello;

import example.data.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ExampleController {
    @GetMapping(value = {"/example"})
    public String example(@RequestParam(name="name", required=false, defaultValue="anonymous") String name,
                           @RequestParam(name="password", required=false, defaultValue="") String password, Model model) {

        //creating configuration object
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file

        //creating session factory object
        @SuppressWarnings("deprecation")
        SessionFactory factory=cfg.buildSessionFactory();

        //creating session object
        Session session = factory.openSession();

        Query q = session.createQuery("FROM User WHERE name LIKE '" + name+"'");
        List<User> user = q.list();
        boolean exists = user.size() > 0;
        boolean pw_correct = false;
        for (User u: user) {
            if (u.getPassword().equals(password)) {
                pw_correct = true;
                break;
            }
        }
        model.addAttribute("password_correct", pw_correct);

        model.addAttribute("name", name);
        model.addAttribute("is_existent", exists);


        session.close();
        return "example";
    }

    @GetMapping(value = {"/example/user"})
    public void user(@RequestParam(name="ID") int user_id, Model model) {
        String name = getUsernameById(user_id);
        if (name == null) name = "";
        model.addAttribute("user", name);
    }

    @GetMapping(value = "/example/login")
    public String loginToPage(@RequestParam("username") String username, @RequestParam("password") String password) {
        //creating configuration object
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file

        //creating session factory object
        @SuppressWarnings("deprecation")
        SessionFactory factory=cfg.buildSessionFactory();

        //creating session object
        Session session = factory.openSession();

        Query q = session.createQuery("FROM User WHERE name LIKE '" + username+"'");
        User logged_in = null;
        @SuppressWarnings("unchecked")
        List<User> user = q.list();
        for (User u: user) {
            if (u.getPassword().equals(password))
                logged_in = u;
        }
        session.close();

        if (logged_in != null)
            return "redirect:/example/user?ID="+logged_in.getID();
        else return "redirect:/example";
    }

    private String getUsernameById(int id) {
        //creating configuration object
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file

        //creating session factory object
        @SuppressWarnings("deprecation")
        SessionFactory factory=cfg.buildSessionFactory();

        //creating session object
        Session session = factory.openSession();

        Query q = session.createQuery("FROM User WHERE ID = " + id);
        User logged_in = q.list().size()>0 ? (User) q.list().get(0) : null;
        session.close();

        if (logged_in != null)
            return logged_in.getName();
        else return null;
    }

}