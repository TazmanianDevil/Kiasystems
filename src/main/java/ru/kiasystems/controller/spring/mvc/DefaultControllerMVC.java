package ru.kiasystems.controller.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class DefaultControllerMVC {
    @RequestMapping(method = RequestMethod.GET)
    public String showWelcome(Model uiModel) {
        return "welcome";
    }
}
