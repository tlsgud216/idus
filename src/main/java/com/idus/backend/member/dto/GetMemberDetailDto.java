package com.idus.backend.member.dto;

import com.idus.backend.member.commonTypes.GenderTypes;
import com.querydsl.core.annotations.QueryProjection;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GetMemberDetailDto {
    @ApiModelProperty("회원 로그인 ID")
    String loginId;

    @ApiModelProperty("회원 이름")
    String name;

    @ApiModelProperty("회원 별명")
    String nickname;

    @ApiModelProperty("회원 전화번호")
    String phone;

    @ApiModelProperty("회원 이메일")
    String email;

    @ApiModelProperty("회원 성별")
    GenderTypes gender;

    @ApiModelProperty("회원 생성일시")
    LocalDateTime createdAt;

    @ApiModelProperty("회원 수정일시")
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
