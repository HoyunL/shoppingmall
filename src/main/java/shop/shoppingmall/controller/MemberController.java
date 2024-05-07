package shop.shoppingmall.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import shop.shoppingmall.dto.MemberDto;
import shop.shoppingmall.service.MemberService;

@Controller
@Log4j2
@RequiredArgsConstructor
public class MemberController {

    private final MemberService joinService;

    @GetMapping("/join")
    public String join() {
        return "join";
    }

    @PostMapping("/joinProc")
    public String joinProc(MemberDto memberDto) {

        log.info("memberDto ={}", memberDto);
        joinService.joinProcess(memberDto);

        return "redirect:/login";
    }
}
