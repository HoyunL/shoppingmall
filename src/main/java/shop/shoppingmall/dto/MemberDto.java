package shop.shoppingmall.dto;

import lombok.Data;
import shop.shoppingmall.etc.Address;

@Data
public class MemberDto {

    private String username;

    private String password;

    private String role;

    private String active;

    private Address address;
}
