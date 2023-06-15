package com.example.recaptcha.user;
import java.util.List;

import com.example.recaptcha.user.CaptchaValidator;
import com.example.recaptcha.user.IUserService;
import com.example.recaptcha.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService service;
    @Autowired
    private CaptchaValidator validator;

    @GetMapping("/register")
    public String registerUser(Model model) {
        model.addAttribute("user", new User());
        return "registerUser5";
    }

    @PostMapping("/save")
    public String saveUser(
            @ModelAttribute User user,
            Model model,
            @RequestParam("g-recaptcha-response") String captcha
    ) {
        if(validator.isValidCaptcha(captcha)) {
            user.setId(1);
            Integer id = service.createUser(user);
            model.addAttribute("message", "User with id : '"+id+"' Saved Successfully !");
            model.addAttribute("user", new User());
        } else{
            model.addAttribute("message", "Please validate captcha first");
        }

        return "registerUser5";
    }

    @GetMapping("/all")
    public String getAllUsers(Model model) {
        List<User> users= service.getAllUsers();
        model.addAttribute("list", users);
        return "listUsers";
    }

}