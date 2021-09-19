package com.idus.backend.member.dto;

import com.idus.backend.member.commonTypes.GenderTypes;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PostJoinDto {
    @ApiModelProperty("비밀번호")
    String password;
    
    @ApiModelProperty("이름")
    String name;

    @ApiModelProperty("별명")
    String nickname;

    @ApiModelProperty("휴대전화")
    String phone;

    @ApiModelProperty("이메일")
    String email;

    @ApiModelProperty("성별")
    GenderTypes gender;
}
