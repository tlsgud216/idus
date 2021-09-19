package com.idus.backend.member.dto;

import com.idus.backend.member.commonTypes.GenderTypes;
import com.querydsl.core.annotations.QueryProjection;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GetMemberListDto {
    @ApiModelProperty("회원 ID")
    Long id;

    @ApiModelProperty("회원 로그인 ID")
    String loginId;

    @ApiModelProperty("회원 이름")
    String name;

    @ApiModelProperty("회원 별명")
    String nickname;

    @ApiModelProperty("회원 휴대전화")
    String phone;

    @ApiModelProperty("회원 이메일")
    String email;

    @ApiModelProperty("회원 성별")
    GenderTypes gender;

    @ApiModelProperty("회원 생성일시")
    LocalDateTime createdAt;

    @ApiModelProperty("회원 수정일시")
    LocalDateTime updatedAt;

    @ApiModelProperty("회원 최근 주문 ID")
    Long latestOrderId;

    @ApiModelProperty("회원 최근 주문 번호")
    String orderCode;

    @ApiModelProperty("회원 최근 주문 상풍명")
    String productName;

    @ApiModelProperty("회원 최근주문일시")
    LocalDateTime orderCreatedAt;

    @ApiModelProperty("회원 최근주문 수정일시")
    LocalDateTime orderUpdatedAt;

    @QueryProjection
    public GetMemberListDto(
            Long id,
            String loginId,
            String name,
            String nickname,
            String phone,
            String email,
            GenderTypes gender,
            LocalDateTime createdAt,
            LocalDateTime updatedAt,

            Long latestOrderId,
            String orderCode,
            String productName,
            LocalDateTime orderCreatedAt,
            LocalDateTime orderUpdatedAt
    ) {
        this.id = id;
        this.loginId = loginId;
        this.name = name;
        this.nickname = nickname;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;

        this.latestOrderId = latestOrderId;
        this.orderCode = orderCode;
        this.productName = productName;
        this.orderCreatedAt = orderCreatedAt;
        this.orderUpdatedAt = orderUpdatedAt;
    }
}
