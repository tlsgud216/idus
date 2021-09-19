package com.idus.backend.member.dto;

import com.idus.backend.member.commonTypes.GenderTypes;
import lombok.Data;

@Data
public class PostJoinDto {
    String password;
    String name;
    String nickname;
    String phone;
    String email;
    GenderTypes gender;
}
