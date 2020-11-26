package apap.tutorial.haidokter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
