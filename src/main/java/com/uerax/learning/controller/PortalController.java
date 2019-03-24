package com.uerax.learning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author uerax
 * @date 2018/12/18 17:17
 */

@Controller
public class PortalController {

    @RequestMapping({"/", "/home"})
    public ModelAndView home() {
        return new ModelAndView("commons/home");
    }
}
