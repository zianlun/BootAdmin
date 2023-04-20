package zian.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * @ClassName FormController
 * @Description
 * @Author ljzhang
 * @Date 2023/4/17 13:08
 * @Version 1.0
 */
@Slf4j
@Controller
public class FormController {
    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("username") String username,
                         @RequestParam("university") String university,
                         @RequestPart("avator") MultipartFile avator,
                         @RequestPart("photoes") MultipartFile[] photoes) throws IOException {
        log.info("username{},university{},avator{},photoes{}",username,university,avator.getSize(),photoes.length);
//        avator.transferTo(new File("E:/workSpace/BootAdmin/file" + UUID.randomUUID().toString().replace("-", "") + ".jpg"));
        avator.transferTo(new File("E:/wordkSpace/BootAdmin/file/" + UUID.randomUUID().toString().replace("-", "") + ".jpg"));
        return "index";
    }
}
