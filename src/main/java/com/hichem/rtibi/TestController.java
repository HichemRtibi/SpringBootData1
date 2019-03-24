package com.hichem.rtibi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping(path = "/hello")
    public String hello(Model model) {
        model.addAttribute("message", "first page with template engine thymleaf");
        return "hello";
    }
}
