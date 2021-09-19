package com.idus.backend.order.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GetCurrentMemberOrderListDto {
    Long id;
    String orderCode;
    String name;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    @QueryProjection
    public GetCurrentMemberOrderListDto(
            Long id,
            String orderCode,
            String name,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        this.id = id;
        this.orderCode = orderCode;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}