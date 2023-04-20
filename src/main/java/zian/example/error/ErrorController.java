package zian.example.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

    @RequestMapping("/methError")
    public void methError() {
        int result = 1 / 0;
    }
}
