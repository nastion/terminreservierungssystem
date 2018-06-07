package trs.view;

import org.springframework.web.bind.annotation.PostMapping;
import trs.data.Poll;
import trs.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import trs.repositories.PollRepository;
import trs.repositories.UserRepository;

import javax.validation.Valid;
import java.util.Set;

@Controller
public class MappingController {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PollRepository pollRepo;

    @Autowired
    private trs.controller.Controller controller;

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

        System.out.println(controller == null);
        if (controller.getUserController().createUser(user)) {
            System.out.println("Added user " + user.getName() + " with " + user.getPassword());
            modelAndView.addObject("message", "User successfully registered!");
        } else {
            modelAndView.addObject("message", "User already exists!");
        }

        User u = new User();
        modelAndView.addObject("user", u);
        modelAndView.setViewName("register");
        return modelAndView;
    }



    @GetMapping("/dashboard")
    public ModelAndView dashboard() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dashboard");
        Poll poll = new Poll();
        poll.setDescripition("Tolles Event");
        poll.setTitle("Event124");
        User user = userRepo.findUserByName("user");
        poll.setOrganisator(user);

        pollRepo.save(poll);
        //pollRepo.deleteAll();
        Set<Poll> polls = pollRepo.findAllByOrganisator(user);

        modelAndView.addObject("name", user.getName());
        modelAndView.addObject("polls", polls);
        return modelAndView;
    }

    @GetMapping("/eventErstellen")
    public ModelAndView eventErstellen() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("eventErstellen");
        Poll poll = new Poll();
        poll.getTitle();
        poll.getDescripition();
        poll.getDate();
        poll.getLocation();

        User user = new User();
        pollRepo.save(poll);
        Set<Poll> polls = pollRepo.findAllByOrganisator(user);

        modelAndView.addObject("name", user.getName());
        modelAndView.addObject("polls", polls);
        return modelAndView;
    }
}

