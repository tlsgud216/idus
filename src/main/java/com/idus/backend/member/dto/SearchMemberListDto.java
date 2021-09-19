package com.idus.backend.member.dto;

import com.idus.backend.common.dto.PageableDto;
import com.idus.backend.member.commonTypes.SearchMemberTypes;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SearchMemberListDto extends PageableDto {
    @ApiModelProperty("회원검색타입")
    SearchMemberTypes searchType = null;

    @ApiModelProperty("회원검색값")
    String searchValue;
}
