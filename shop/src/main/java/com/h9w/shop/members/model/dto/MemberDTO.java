package com.h9w.shop.members.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MemberDTO {
    private int memberNo;
    private String memberId;
    private String memberName;
    private String memberPassword;
    private String memberRole;
}
