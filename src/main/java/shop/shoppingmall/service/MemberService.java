package shop.shoppingmall.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.shoppingmall.dto.MemberDto;
import shop.shoppingmall.entity.Member;
import shop.shoppingmall.repository.MemberRepository;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public void joinProcess(MemberDto memberDto) {

        Member member = Member.dtoToEntity(memberDto, bCryptPasswordEncoder);
        memberRepository.save(member);
    }
}
