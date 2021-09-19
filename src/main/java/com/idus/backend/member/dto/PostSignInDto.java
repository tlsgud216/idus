package com.idus.backend.member.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PostSignInDto {
    @ApiModelProperty("로그인 ID")
    String loginId;

    @ApiModelProperty("비밀번호")
    String password;
}
