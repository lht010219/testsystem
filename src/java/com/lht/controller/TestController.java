package com.lht.controller;

import com.lht.service.RoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class TestController {
    @Autowired
    private RoutineService routineService;

    @RequestMapping("/routine")
    public String routine(HttpServletResponse response, HttpServletRequest request) throws IOException {
        HttpSession session=request.getSession(true);
        Integer id= (Integer) session.getAttribute("id");
        if(id==null){
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }
        return "start";
    }

}
