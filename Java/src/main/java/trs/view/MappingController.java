package trs.view;

import org.springframework.web.bind.annotation.PostMapping;
import trs.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import trs.repositories.PollRepository;
import trs.repositories.UserRepository;

import javax.validation.Valid;

@Controller
public class MappingController {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PollRepository pollRepo;

    @GetMapping(value = "/")
    public ModelAndView example(@RequestParam(name="name", required=false, defaultValue="anonymous") String name,
                                @RequestParam(name="password", required=false, defaultValue="") String password) {
        ModelAndView modelAndView = new ModelAndView();

        User user = userRepo.findUserByName(name);
        boolean exists = false;
        boolean pw_correct = false;
        if (user != null) {
            pw_correct  = user.getPassword().equals(password);
            exists = true;
        }

        modelAndView.setViewName("dashboard");

        modelAndView.addObject("password_correct", pw_correct);

        modelAndView.addObject("name", name);
        modelAndView.addObject("is_existent", exists);
        return modelAndView;
    }

    @GetMapping("/register")
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        User u = new User();
        modelAndView.addObject("user", u);
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView confirm_register(@Valid User user) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("Added user " + user.getName() + " with " + user.getPassword());
        User u = new User();
        modelAndView.addObject("user", u);

        if (userRepo.findUserByName(user.getName()) == null) {
            userRepo.save(user);
            modelAndView.addObject("message", "User successfully registered!");
        } else {
            modelAndView.addObject("success", "User already exists!");
        }
        modelAndView.setViewName("register");
        return modelAndView;
    }
}
