package jwt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping({"/home"})
    public String home() {
        return "Hello JWT";
    }

    @RequestMapping({"/not-home"})
    public String notHome() {
        return "You shouldn't be here";
    }

}