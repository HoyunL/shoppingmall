package shop.shoppingmall.dto;

import lombok.Data;

@Data
public class MemberDto {

    private String username;

    private String password;

    private String role;

    private String active;

}
