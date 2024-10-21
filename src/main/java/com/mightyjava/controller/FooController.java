package com.mightyjava.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/foo")
public class FooController {

    @Secured("ROLE_MANAGER")
    @GetMapping("/salute")
    public String saluteYourManager(@AuthenticationPrincipal User activeUser)
    {
        return String.format("Hi %s. Foo salutes you!", activeUser.getUsername());
    }
}