package zian.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import zian.example.pojo.User;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {
    @GetMapping("/dynamic")
    public String Dynamic(Model model){
        List<User> users =  Arrays.asList(new User("ljzhang","123456"),
                new User("zian","1234567"),
                new User("zahifuyi","88888"));
        model.addAttribute("users",users);
        return "table/dynamic_table";
    }
}
