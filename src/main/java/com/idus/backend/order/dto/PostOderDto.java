package com.idus.backend.order.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PostOderDto {
    @ApiModelProperty("주문상품명")
    String name;
}
