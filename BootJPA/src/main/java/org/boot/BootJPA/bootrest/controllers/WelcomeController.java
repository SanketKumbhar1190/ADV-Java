//package org.boot.BootJPA.bootrest.controllers;
//
//
//import org.boot.BootJPA.bootrest.model.Users;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/users")
//public final class WelcomeController {
//    @GetMapping(value = "/welcome")
//    public String welcome() {
//        return "Welcome to the first Rest api";
//    }
//
//    @GetMapping("/getUser")
//    public Users getUser() {
//        Users objUsers = new Users();
//        objUsers.setUserName("dac");
//        objUsers.setPassword("dac@123");
//        return objUsers;
//    }
//}