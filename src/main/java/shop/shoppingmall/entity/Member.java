package shop.shoppingmall.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import shop.shoppingmall.dto.MemberDto;
import shop.shoppingmall.etc.Address;
import shop.shoppingmall.util.BaseTime;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "members")
public class Member extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String username;

    private String password;

    private String role;

    private String active;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>(); // 하이버네이트가 다른 컬렉션으로 관리해서 따로 초기화하면 안 좋음.

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

    public static Member dtoToEntity(MemberDto memberDto, BCryptPasswordEncoder bCryptPasswordEncoder) {
        return Member.builder()
                .username(memberDto.getUsername())
                .password(bCryptPasswordEncoder.encode(memberDto.getPassword()))
                .role(memberDto.getRole())
                .active(memberDto.getActive())
                .build();
    }

    public void update(MemberDto memberDto) {

        this.username = memberDto.getUsername();
        this.password = memberDto.getPassword();
        this.role = memberDto.getRole();
        this.active = memberDto.getActive();
    }
}
