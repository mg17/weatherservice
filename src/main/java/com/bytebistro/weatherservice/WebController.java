package com.bytebistro.weatherservice;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
public class WebController extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/signup-result").setViewName("signup-result");
    }

    @GetMapping("/")
    public String showForm(SignupForm signupForm) {
        return "signup";
    }

    @PostMapping("/")
    public String checkSignupInfo(@Valid SignupForm signupForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "form";
        else
            return "redirect:/signup-result";
    }
}
