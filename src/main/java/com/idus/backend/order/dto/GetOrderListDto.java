package com.idus.backend.order.dto;

import com.querydsl.core.annotations.QueryProjection;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GetOrderListDto {
    @ApiModelProperty("주문 ID")
    Long id;

    @ApiModelProperty("주문번호")
    String orderCode;

    @ApiModelProperty("주문상풍명")
    String name;
    
    @ApiModelProperty("주문생성일시")
    LocalDateTime createdAt;

    @ApiModelProperty("주문 수정일시")
    LocalDateTime updatedAt;

    @QueryProjection
    public GetOrderListDto(
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