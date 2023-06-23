package com.shop.admin.members.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class SignInResponseDTO {
    private String token;
    private int exprTime;
    private MemberDTO user;
}
