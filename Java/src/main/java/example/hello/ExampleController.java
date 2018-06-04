package example.hello;

import trs.data.User;
import trs.repositories.UserRepository;
import example.data.UserService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ExampleController {
    @Autowired
    UserRepository userService;

    @GetMapping(value = {"/example"})
    public String example(@RequestParam(name="name", required=false, defaultValue="anonymous") String name,
                           @RequestParam(name="password", required=false, defaultValue="") String password, Model model) {

        //model.addAttribute("password_correct", pw_correct);

        model.addAttribute("name", name);
        //model.addAttribute("is_existent", exists);

        return "example";
    }

    @GetMapping("example/register")
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();


        modelAndView.setViewName("register");

        User u = new User();
        modelAndView.addObject("user", u);

        return modelAndView;
    }

    @PostMapping("example/register")
    public ModelAndView confirm_register(@Valid User user) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("Added user " + user.getName() + " with " + user.getPassword());
        User u = new User();
        modelAndView.addObject("user", u);
        modelAndView.addObject("success", "User successfully registered!");

        if (userService.findUserByName(user.getName()) == null)
            userService.save(user);
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @GetMapping(value = {"/example/user"})
    public void user(@RequestParam(name="ID") int user_id, Model model) {
        String name = null;
        if (userService.findById((long) user_id).isPresent())
            name = userService.findById((long) user_id).get().getName();
        if (name == null) name = "";
        model.addAttribute("user", name);
    }

    @GetMapping("/example/login")
    public ModelAndView loginScreen() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();

        modelAndView.addObject("user", user);

        return modelAndView;
    }
}