package com.idus.backend.member.dto;

import com.idus.backend.member.commonTypes.GenderTypes;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GetMemberDetailDto {
    String loginId;
    String name;
    String nickname;
    String phone;
    String email;
    GenderTypes gender;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    @QueryProjection
    public GetMemberDetailDto(
            String loginId,
            String name,
            String nickname,
            String phone,
            String email,
            GenderTypes gender,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        this.loginId = loginId;
        this.name = name;
        this.nickname = nickname;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;

    }
}
