package com.sec01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebForwardController {

    @RequestMapping({ "/", "/courses", "/students" })
    public String forwardToReact() {
        return "forward:/index.html"; // static에 index가 있기에 forward해주기
    }
}
