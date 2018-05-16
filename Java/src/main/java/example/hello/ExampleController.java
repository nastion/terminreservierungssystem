package example.hello;

import example.data.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.hibernate.Query;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class ExampleController {
    @GetMapping(value = {"/example", "/"})
    public String example(@RequestParam(name="name", required=false, defaultValue="anonymus") String name,
                           @RequestParam(name="password", required=false, defaultValue="") String password, Model model) {
        String url = "http://localhost:8080/example/login";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("username", name);
        map.add("password", password);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        ResponseEntity<String> response = restTemplate.postForEntity( url, request , String.class );

        System.out.println("\n\n\n" + response.getBody() + "\n\n\n");

        //creating configuration object
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file

        //creating session factory object
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

    @RequestMapping(value = "/example/login", produces = "application/json")
    @ResponseBody
    public String loginToPage(@RequestParam("username") String username, @RequestParam("password") String password) {
        return "{\"users\": [{\"username\": \"" + username + "\", \"password\": \"" + password + "\"}]}";
    }

}