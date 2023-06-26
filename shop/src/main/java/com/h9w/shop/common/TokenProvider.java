package com.h9w.shop.common;

import com.h9w.shop.members.model.dto.MemberDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class TokenProvider {
    // JWT 생성 및 검증을 위한 키 선언
    private final String SECURITY_KEY = "jwtseckey!@";

    //JWT 생성 메서드
    public String create(MemberDTO member) {
        // 만료날짜를 현재 날짜 + 1시간으로 설정
        Date exprTime = Date.from(Instant.now().plus(1 , ChronoUnit.HOURS));

        Claims claims = Jwts.claims()
                .setSubject("access_token").setIssuedAt(new Date()).setExpiration(exprTime);

        claims.put("memberNo", member.getMemberNo());
        claims.put("memberId", member.getMemberId());
        claims.put("memberRole", member.getMemberRole());
        claims.put("memberName", member.getMemberName());

        // JWT 생성 후 반환
        return Jwts.builder()
                //암호화 할 알고리즘 선택 및 키 설정
                .signWith(SignatureAlgorithm.HS512, SECURITY_KEY)
                //데이터를 담은 claims 설정
                .setClaims(claims)
                // 생성
                .compact();

    }

    // JWT 검증
    public String validate(String token) {
        // 매개변수로 받은 token을 키를 사용해서 복호화(decoding)
        Claims claims = Jwts.parser().setSigningKey(SECURITY_KEY).parseClaimsJws(token).getBody();

        // 복호화된 토큰의 payload에서 제목을 가져온다.
        return claims.getSubject();
    }
}
