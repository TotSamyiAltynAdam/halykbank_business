package kz.halykbank.halykbank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    @GetMapping("/organization")
    public String organition() {
        return "organization";
    }
}
