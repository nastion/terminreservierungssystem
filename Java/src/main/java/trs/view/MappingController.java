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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Controller
public class MappingController {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PollRepository pollRepo;

    @Autowired
    private trs.controller.Controller controller;

    /**
     * Get-Mapping for registering a user
     * @return the ModelAndView for Spring
     */
    @GetMapping("/register")
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        User u = new User();
        modelAndView.addObject("user", u);
        return modelAndView;
    }

    /**
     * Post-Mapping for registering a user<br />
     * Registers the user
     * @param user the user to register
     * @return the ModelAndView for Spring
     */
    @PostMapping("/register")
    public ModelAndView confirm_register(@Valid User user) {
        ModelAndView modelAndView = new ModelAndView();

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

    /**
     * Get-Mapping for the dashboard
     * @return the ModelAndView for Spring
     */
    @GetMapping(value = {"/", "/dashboard"})
    public ModelAndView dashboard() {
        ModelAndView modelAndView = new ModelAndView();
        if (controller.getCurrentUser() == null) {
            modelAndView.setViewName("signin");
            User user = new User();
            modelAndView.addObject("user", user);
            return modelAndView;
        }
        modelAndView.setViewName("dashboard");
        Poll poll = new Poll();
        poll.setDescription("Tolles Event");
        poll.setTitle("Event124");
        User user = controller.getCurrentUser();
        poll.setOrganisator(user);

        pollRepo.save(poll);
        //pollRepo.deleteAll();
        Set<Poll> polls = pollRepo.findAllByOrganisator(user);

        modelAndView.addObject("user", user);
        modelAndView.addObject("polls", polls);
        return modelAndView;
    }

    /**
     * Get-Mapping for creating an event
     * @return the ModelAndView for spring
     */
    @GetMapping("/eventErstellen")
    public ModelAndView eventErstellen() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("eventErstellen");
        Poll poll = new Poll();

        List<Date> all_dates = new ArrayList<>();
        for (int i= 0; i < 10; i++)
            all_dates.add(new Date());

        modelAndView.addObject("all_dates", all_dates);
        modelAndView.addObject("poll", poll);
        return modelAndView;
    }

    /**
     * Post-Mapping for creating an event<br />
     * Creates the event
     * @param event the event to create
     * @return the ModelAndView for Spring
     */
    @PostMapping("/eventErstellen")
    public ModelAndView eventErstellenPost(@Valid Poll event) {
        ModelAndView modelAndView = new ModelAndView();

        controller.getEventController().createEvent(event);
        Poll poll = new Poll();

        modelAndView.addObject("poll", poll);
        return modelAndView;
    }

    /**
     * Get-Mapping for logging in
     * @return the ModelAndView for Spring
     */
    @GetMapping("/signin")
    public ModelAndView signin() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("signin");

        User user = new User();
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    /**
     * Post-Mapping for logging in
     * @param user the user to login
     * @return the ModelAndView for Spring
     */
    @PostMapping("/signin")
    public ModelAndView login(@Valid User user) {
        ModelAndView modelAndView = new ModelAndView();

        if (controller.getUserController().login(user.getName(), user.getPassword())) {
            modelAndView.addObject("user", controller.getCurrentUser());
            modelAndView.addObject("polls", pollRepo.findAllByOrganisator(controller.getCurrentUser()));
            modelAndView.setViewName("dashboard");
        } else {
            user = new User();
            modelAndView.setViewName("signin");
            modelAndView.addObject("user", user);
            modelAndView.addObject("message", "Error: Username or Password wrong");
        }

        return modelAndView;
    }

    /**
     * Get-Mapping for the polls
     * @return the ModelAndView for Spring
     */
    @GetMapping("/eventAbstimmen")
    public ModelAndView eventAbstimmen() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("eventAbstimmen");

        User user = new User();

        modelAndView.addObject("name", user.getName());
        return modelAndView;
    }

    /**
     * Get-Mapping for the result of an event
     * @return the ModelAndView for Spring
     */
    @GetMapping("/eventResult")
    public ModelAndView eventResult() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("eventResult");

        User user = new User();

        modelAndView.addObject("name", user.getName());
        return modelAndView;
    }


}

