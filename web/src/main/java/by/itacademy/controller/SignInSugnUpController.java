package by.itacademy.controller;

import by.itacademy.entity.User;
import by.itacademy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignInSugnUpController {
    private final UserService userService;

    @Autowired
    public SignInSugnUpController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public User user(){
        return new User();
    }

    @GetMapping(path = "/signin")
    public String getSignInPage(){
       return "signin";
    }

    @GetMapping(path = "/signup")
    public String getSignUpPage(){
        return "signup";
    }

    @PostMapping("/signup")
    public String saveUser(User user){
        userService.create(user);
        return "signup";
    }

}
