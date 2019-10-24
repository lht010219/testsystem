package com.lht.controller;

import com.lht.pojo.User;
import com.lht.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response,String username, String password) throws IOException {
        HttpSession session=request.getSession(true);
        List<User> userList=loginService.login(username,password);
        if(userList.size()!=0){
            int id=userList.get(0).getId();
            session.setAttribute("id",id);
            session.setAttribute("username",username);
            response.sendRedirect(request.getContextPath()+"/index");
        }else{
            session.setAttribute("loginerror","loginerror");
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }
    }

    @RequestMapping("/index")
    public String index(HttpServletResponse response,HttpServletRequest request) throws IOException {
        HttpSession session=request.getSession(true);
        Integer id= (Integer) session.getAttribute("id");
        if(id==null){
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }
        return "index";
    }

    @RequestMapping("/exit")
    public void exit(HttpServletRequest request,HttpServletResponse response) throws IOException {
        HttpSession session=request.getSession(true);
        session.invalidate();
        response.sendRedirect(request.getContextPath()+"/index.jsp");
    }
}
