package shop.shoppingmall.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.shoppingmall.dto.MemberDto;
import shop.shoppingmall.entity.Member;
import shop.shoppingmall.entity.MemberHistory;
import shop.shoppingmall.repository.jpa.MemberRepository;
import shop.shoppingmall.repository.mongo.MemberHistoryRepository;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    private final MemberHistoryRepository memberHistoryRepository;

    //private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public void joinProcess(MemberDto memberDto) {

        Member member = Member.dtoToEntity(memberDto);
        memberRepository.save(member);
    }

    @Transactional
    public void addMemberHis(MemberDto memberDto) {
        memberHistoryRepository.insert(MemberHistory.dtoToEntity(memberDto));
        ResponseEntity.ok().build();
    }
}
