package kr.soft.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/test")
    public String test() {
        System.out.println("Test");
        return "test.html";
    }
}
