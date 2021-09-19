package com.idus.backend.member.dto;

import com.idus.backend.member.commonTypes.GenderTypes;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class PostJoinDto {
    @ApiModelProperty("비밀번호 (영문 대문자, 영문 소문자, 특수문자, 숫자 각 1개 이상 포함)")
    @Pattern(regexp = "^.*(?=^.{10,}$)(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$")
    String password;
    
    @ApiModelProperty("이름 (한글, 영문 대소문자)")
    @Pattern(regexp = "^[가-힣A-Za-z]*$")
    String name;

    @ApiModelProperty("별명 (영문 소문자)")
    @Pattern(regexp = "^[a-z]*$")
    String nickname;

    @ApiModelProperty("휴대전화 (숫자)")
    @Pattern(regexp = "^[0-9]*$")
    String phone;

    @ApiModelProperty("이메일")
    @Pattern(regexp = "[0-9a-zA-Z]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$")
    String email;

    @ApiModelProperty("성별")
    GenderTypes gender;
}
