package org.engripaye.authorizationserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConsentController {

    @GetMapping("/oauth2/consent")
    public String consent(
            @RequestParam("client_id") String clientId,
            @RequestParam("scope") String scope,
            @RequestParam("state") String state,
            @RequestParam(name = "user_code", required = false) String userCode,
            @RequestParam(name = "redirect_uri", required = false) String redirectUri,
            Model model) {

        model.addAttribute("clientId", clientId);
        model.addAttribute("scope", scope);
        model.addAttribute("state", state);
        model.addAttribute("userCode", userCode);
        model.addAttribute("redirectUri", redirectUri);

        return "consent"; // Thymeleaf or JSP page name
    }
}
