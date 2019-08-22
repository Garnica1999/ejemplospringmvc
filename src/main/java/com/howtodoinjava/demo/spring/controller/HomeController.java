/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.howtodoinjava.demo.spring.controller;

import java.util.Locale;
import static org.springframework.http.RequestEntity.method;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 * @author sala4
 */
@Controller
public class HomeController {
    
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String home(Locale locale, Model model){
        return "home";
    }
}
