package shop.shoppingmall.entity;


import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import shop.shoppingmall.dto.MemberDto;
import shop.shoppingmall.etc.Address;
import shop.shoppingmall.util.BaseTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "MEMBER_HISTORY")
public class MemberHistory extends BaseTime {

    @Id
    private String id;

    private String username;

    private String password;

    private String role;

    private String active;

    private Address address;

    public static MemberHistory dtoToEntity(MemberDto memberDto, BCryptPasswordEncoder bCryptPasswordEncoder) {
        return MemberHistory.builder()
                .username(memberDto.getUsername())
                .password(bCryptPasswordEncoder.encode(memberDto.getPassword()))
                .role(memberDto.getRole())
                .active(memberDto.getActive())
                .build();
    }

    public static MemberHistory dtoToEntity(MemberDto memberDto) {
        return MemberHistory.builder()
                .username(memberDto.getUsername())
                .password(memberDto.getPassword())
                .role(memberDto.getRole())
                .active(memberDto.getActive())
                .build();
    }
}
