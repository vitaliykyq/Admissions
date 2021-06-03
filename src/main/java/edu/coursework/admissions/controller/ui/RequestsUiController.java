package edu.coursework.admissions.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/ui/requests")
@Controller
public class RequestsUiController {

    @RequestMapping()
    public String showAll(){ return "requests"; }

}
