package shop.shoppingmall.restcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRestController {

    @GetMapping("/api/test")
    public String hello() {
        return "테스트입니다.";
    }
}
