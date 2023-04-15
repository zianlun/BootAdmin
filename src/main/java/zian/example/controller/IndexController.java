package zian.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.util.StringUtils;
import zian.example.dto.UserParam;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {


    @GetMapping({"/"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String index(UserParam userParam, HttpSession session, Model model){
        if(!StringUtils.isEmpty(userParam.getPassword()) && !StringUtils.isEmpty(userParam.getPassword())){
            System.out.println(userParam.getUsername());
            System.out.println(userParam.getPassword());
            session.setAttribute("username",userParam.getUsername());
            return "redirect:/index.html";
        }
        System.out.println(userParam.getUsername());
        System.out.println(userParam.getPassword());
        model.addAttribute("msg", "账号密码错误");
        return "login";
    }

    @GetMapping("/index.html")
    public String indexPage(HttpSession session, Model model){
        System.out.println(session.getAttribute("username"));
        if(!StringUtils.isEmpty((String)session.getAttribute("username"))){
            return "index";
        }
        model.addAttribute("msg", "请先登录");
        return "/login";
    }



}
