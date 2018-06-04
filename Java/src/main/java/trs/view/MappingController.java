package trs.view;

import trs.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import trs.repositories.PollRepository;
import trs.repositories.UserRepository;

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
}
