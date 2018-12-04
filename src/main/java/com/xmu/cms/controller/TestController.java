package com.xmu.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author JuboYu on 2018/11/27.
 * @version 1.0
 */
@RestController
@RequestMapping(value = "/api/test")
public class TestController {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String sender;

    @GetMapping(value = "/testSession")
    public String testSession(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        HttpSession session = httpServletRequest.getSession();
        if (session.getAttribute("userType") == null) {
            session.setAttribute("userType", "student");
            return "No user login";
        } else {
            return session.getAttribute("userType").toString();
        }

    }

    @GetMapping(value = "/getSession")
    public String getSession(HttpSession session) {
        return session.getId();
    }

    @GetMapping(value = "/testHolder")
    public String testHolder() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession();
        return session.getAttribute("userType").toString();
    }

    @GetMapping(value = "/getUserType")
    public Object getUserType(HttpSession session) {
        return session.getAttribute("userType");
    }

    @GetMapping(value = "/getUser")
    public Object getUserId(HttpSession session) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println(authentication.toString());
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return authentication.getName();
        }
        return null;
    }

}
