package view;

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
public class MappingController {
    @GetMapping(value = {"/"})
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
        return "dashboard";
    }
}
