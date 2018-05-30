package view;

import com.sun.org.apache.xpath.internal.operations.Mod;
import example.data.InputWrapper;
import example.data.User;
import jdk.internal.util.xml.impl.Input;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MappingController {
    @GetMapping(value = "/")
    public ModelAndView example(@RequestParam(name="name", required=false, defaultValue="anonymous") String name,
                                @RequestParam(name="password", required=false, defaultValue="") String password) {
        ModelAndView modelAndView = new ModelAndView();
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

        modelAndView.setViewName("dashboard");

        InputWrapper inputWrapper = new InputWrapper();

        modelAndView.addObject("password_correct", pw_correct);
        modelAndView.addObject("user1234", name);
        modelAndView.addObject("inputWrapper", inputWrapper);
        modelAndView.addObject("name", name);
        modelAndView.addObject("is_existent", exists);


        session.close();
        return modelAndView;
    }

    @PostMapping("/dashboard")
    public ModelAndView dashboard(InputWrapper inputWrapper) {
        System.out.println(inputWrapper.getInput());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "DefaultName");
        modelAndView.addObject("inputWrapper", inputWrapper);
        modelAndView.setViewName("dashboard");
        return modelAndView;
    }

    @PostMapping("/signin")
    public ModelAndView signin(String username, String password) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("", username);
        return modelAndView;
    }
}
