package webmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import webmvc.beans.User;

@Controller
public class LoginController {

    @RequestMapping("/login")
    public void prepareUser(Model data) {
        User objUser = new User();
        data.addAttribute("objUser", objUser);
    }

    @RequestMapping("/authenticate")
    public ModelAndView authenticateUser(@ModelAttribute("objUser") User objUser) {
        if (objUser.getUserName().equals("cdac") && objUser.getPassword().equals("cdac@123")) {
            return new ModelAndView("welcome", "msg", "Welcome to the new application in MVC");
        } else {
            return new ModelAndView("failure", "msg", "Invalid authentication");
        }
    }
}