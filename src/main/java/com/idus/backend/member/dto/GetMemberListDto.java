package com.idus.backend.member.dto;

import com.idus.backend.member.commonTypes.GenderTypes;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GetMemberListDto {
    Long id;
    String loginId;
    String name;
    String nickname;
    String phone;
    String email;
    GenderTypes gender;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    Long latestOrderId;
    String orderCode;
    String productName;
    LocalDateTime orderCreatedAt;
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
