package com.ssafy.penetration.penetration.homeController;

import org.springframework.web.bind.annotation.GetMapping;

public class homeController {

    @GetMapping("/")
    public String homeArgumentResolver(){
        return "index.html";
    }
}
