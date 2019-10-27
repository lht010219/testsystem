package com.lht.controller;

import com.lht.pojo.Topic;
import com.lht.service.RoutineService;
import org.aspectj.asm.IModelFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.UsesSunHttpServer;
import org.springframework.lang.UsesSunMisc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.TileObserver;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RoutineController {
    @Autowired
    private RoutineService routineService;

    int s=110;
    int s_y=300;
    int p=80;
    int p_y=300;
    int d=10;
    int d_y=40;
    int sum=s+p+d;

    @RequestMapping("/routine_test")
    public void routine_test(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        HttpSession session=request.getSession(true);
        List<Topic> topicList=new ArrayList<>();
        Integer id= (Integer) session.getAttribute("id");
        if(id==null){
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else {
            List<Topic> topicList1=create1();
            List<Topic> topicList2=create2();
            List<Topic> topicList3=create3();
            topicList.addAll(topicList1);
            topicList.addAll(topicList2);
            topicList.addAll(topicList3);
            session.setAttribute("topicList",topicList);
            response.sendRedirect(request.getContextPath()+"/routine_start");
        }
    }

    @RequestMapping("/routine_start")
    public void routine_start(HttpServletResponse response,HttpServletRequest request,Model model) throws IOException {
        HttpSession session=request.getSession(true);
        Integer id= (Integer) session.getAttribute("id");
        if(id==null){
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else{
            session.setAttribute("o",0);
            response.sendRedirect(request.getContextPath()+"/test");
        }
    }

    @RequestMapping("/test")
    public String test(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException {
        HttpSession session=request.getSession(true);
        Integer id= (Integer) session.getAttribute("id");
        if(id==null){
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else{
            List<Topic> topicList= (List<Topic>) session.getAttribute("topicList");
            Integer o= (Integer) session.getAttribute("o");
            Topic topic=topicList.get(o);
            session.setAttribute("topic",topic);
            session.setAttribute("answer",topic.getAnswer());
            session.setAttribute("type",topic.type);
            model.addAttribute("t",topic);
            model.addAttribute("o",o+1);
        }
        return "test";
    }

    @RequestMapping("/next_pc")
    public void next(String answer,String answer1,String answer2,String answer3,String answer4,HttpServletResponse response,HttpServletRequest request) throws IOException {
        HttpSession session=request.getSession(true);
        float num=100;
        Integer id= (Integer) session.getAttribute("id");
        if(id==null){
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }
        Integer o= (Integer) session.getAttribute("o");
        int type= (int) session.getAttribute("type");
        if(sum==(o+1)) {
            response.sendRedirect(request.getContextPath() + "/num");
        }else if(type==3){
            String ans= (String) session.getAttribute("answer");
            String a=null;
            if(a==null){
                if(answer1!=null){
                    a=answer1;
                    if(answer2!=null){
                        a=a+answer2;
                    }
                    if(answer3!=null){
                        a=a+answer3;
                    }
                    if(answer4!=null){
                        a=a+answer4;
                    }
                }else{
                    if(answer2!=null){
                        a=answer2;
                        if(answer3!=null){
                            a=a+answer3;
                        }
                        if(answer4!=null){
                            a=a+answer4;
                        }
                    }else{
                        if(answer3!=null){
                            a=answer3;
                            if(answer4!=null){
                                a=a+answer4;
                            }
                        }else{
                            if(answer4!=null){
                                a=answer4;
                            }
                        }
                    }
                }
            }
            if(!ans.equals(a)){
                num= (float) (num-0.5);
                response.sendRedirect(request.getContextPath()+"/error");
            }else{
                session.setAttribute("o",o+1);
                response.sendRedirect(request.getContextPath()+"/test");
            }
        }else{
            String ans= (String) session.getAttribute("answer");
            if(!ans.equals(answer)){
                num= (float) (num-0.5);
                response.sendRedirect(request.getContextPath()+"/error");
            }else{
                session.setAttribute("o",o+1);
                response.sendRedirect(request.getContextPath()+"/test");
            }
        }
    }

    @RequestMapping("/error")
    public String error(Model model,HttpServletRequest request,HttpServletResponse response) throws IOException {
        HttpSession session=request.getSession(true);
        Integer id= (Integer) session.getAttribute("id");
        if(id==null){
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }
        Topic topic= (Topic) session.getAttribute("topic");
        Integer o= (Integer) session.getAttribute("o");
        model.addAttribute("t",topic);
        model.addAttribute("o",o+1);
        return "error";
    }

    @RequestMapping("/next")
    public void next(HttpServletRequest request,Model model,HttpServletResponse response) throws IOException {
        HttpSession session=request.getSession(true);
        Integer id= (Integer) session.getAttribute("id");
        if(id==null){
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }
        List<Topic> topicList= (List<Topic>) session.getAttribute("topicList");
        Integer o= (Integer) session.getAttribute("o");
        session.setAttribute("o",o+1);
        response.sendRedirect(request.getContextPath()+"/test");
    }

    @RequestMapping("/num")
    public String num(HttpServletRequest request,HttpServletResponse response) throws IOException {
        HttpSession session=request.getSession(true);
        Integer id= (Integer) session.getAttribute("id");
        if(id==null){
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }

        return "num";
    }

    public int create1_random(){
        List<Integer> topicNum1=routineService.routineTest1();
        int i1=topicNum1.size();
        int r1= (int) ((Math.random()*i1)+1);
        Integer r=null;
        for(int i=0;i<i1;i++){
            r=topicNum1.get(r1-1);
        }
        return r;
    }

    public int create2_random(){
        List<Integer> topicNum2=routineService.routineTest2();
        int i2=topicNum2.size();
        int r2= (int) ((Math.random()*i2)+1);
        Integer r=null;
        for(int i=0;i<i2;i++){
            r=topicNum2.get(r2-1);
        }
        return r;
    }

    public int create3_random(){
        List<Integer> topicNum3=routineService.routineTest3();
        int i3=topicNum3.size();
        int r3= (int) ((Math.random()*i3)+1);
        Integer r=null;
        for(int i=0;i<i3;i++){
            r=topicNum3.get(r3-1);
        }
        return r;
    }

    public List<Topic> create1(){
        List<Integer> arr1=new ArrayList<>();
        List<Topic> topicList1 = new ArrayList<>();

        for(int i=0;i<s_y;i++){
            int r1=create1_random();
            if(arr1.size()==s){
                break;
            }else if(!arr1.contains(r1)){
                Topic topics=routineService.routineList1(r1);
                arr1.add(r1);
                topicList1.add(topics);
            }
        }
        return topicList1;
    }

    public List<Topic> create2(){
        List<Integer> arr2=new ArrayList<>();
        List<Topic> topicList2 = new ArrayList<>();

        for(int i=0;i<p_y;i++){
            int p1=create2_random();
            if(arr2.size()==p){
                break;
            }else if(!arr2.contains(p1)){
                Topic topics=routineService.routineList2(p1);
                arr2.add(p1);
                topicList2.add(topics);
            }
        }
        return topicList2;
    }

    public List<Topic> create3(){
        List<Integer> arr3=new ArrayList<>();
        List<Topic> topicList3 = new ArrayList<>();

        for(int i=0;i<d_y;i++){
            int d1=create3_random();
            if(arr3.size()==d){
                break;
            }else if(!arr3.contains(d1)){
                Topic topics=routineService.routineList3(d1);
                arr3.add(d1);
                topicList3.add(topics);
            }
        }
        return topicList3;
    }


}
