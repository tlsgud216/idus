package com.idus.backend.member.dto;

import com.idus.backend.member.commonTypes.GenderTypes;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class GetMemberDetailDto {
    Long id;
    String loginId;
    String name;
    String nickname;
    String phone;
    String email;
    GenderTypes gender;

    @QueryProjection
    public GetMemberDetailDto(
            Long id,
            String loginId,
            String name,
            String nickname,
            String phone,
            String email,
            GenderTypes gender
    ) {
        this.id = id;
        this.loginId = loginId;
        this.name = name;
        this.nickname = nickname;
        this.phone = phone;
        this.email = email;
        this.gender = gender;

    }
}
