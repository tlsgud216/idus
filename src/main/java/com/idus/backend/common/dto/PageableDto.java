package com.idus.backend.common.dto;

import lombok.Data;

@Data
public class PageableDto {
    int offset = 0;
    int limit = 10;
}
