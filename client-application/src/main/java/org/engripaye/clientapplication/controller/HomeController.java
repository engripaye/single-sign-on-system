package org.engripaye.clientapplication.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "Welcome to the public homepage.";
    }

    @GetMapping("/secure")
    @ResponseBody
    public String secure(@AuthenticationPrincipal OidcUser oidcUser) {
        return "Hello, " + oidcUser.getFullName() + "! Your email: " + oidcUser.getEmail();
    }
}
