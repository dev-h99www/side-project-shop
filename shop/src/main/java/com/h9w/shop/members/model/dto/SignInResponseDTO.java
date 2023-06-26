package com.h9w.shop.members.model.dto;

import com.h9w.shop.members.model.dto.MemberDTO;
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
