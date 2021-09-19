package com.idus.backend.member.dto;

import com.idus.backend.common.dto.PageableDto;
import com.idus.backend.member.commonTypes.SearchMemberTypes;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SearchMemberListDto extends PageableDto {
    SearchMemberTypes searchType = null;
    String searchValue;
}
