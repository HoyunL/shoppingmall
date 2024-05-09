package shop.shoppingmall.restController;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import shop.shoppingmall.dto.MemberDto;
import shop.shoppingmall.service.MemberService;

@RestController
@RequiredArgsConstructor
public class MemberRestController {

    private final MemberService memberService;

    @PostMapping("/api/v1/memberHis")
    public ResponseEntity<Void> addMember(@RequestBody MemberDto memberDto) {
        memberService.addMemberHis(memberDto);
        return ResponseEntity.ok().build();
    }
}
