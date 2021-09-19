package com.idus.backend.member;

import com.idus.backend.member.dto.GetCurrentMemberDetailDto;
import com.idus.backend.member.dto.PostJoinDto;
import com.idus.backend.member.dto.PostSignInDto;
import com.idus.backend.member.dto.SearchMemberListDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/api/member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/join")
    ResponseEntity<Long> join(@RequestBody PostJoinDto dto) {
        return ResponseEntity.ok(memberService.join(dto));
    }

    @PostMapping("/sign-in")
    ResponseEntity<Map<String, String>> signIn(@RequestBody PostSignInDto dto) throws Exception {
        return ResponseEntity.ok(memberService.signIn(dto));
    }

    @GetMapping("/info")
    ResponseEntity<GetCurrentMemberDetailDto> getCurrentMemberDetail() {
        return ResponseEntity.ok(memberService.getCurrentMemberDetail());
    }

    @GetMapping("/list")
    ResponseEntity<Map<String, Object>> getMemberList(SearchMemberListDto dto) {
        return ResponseEntity.ok(memberService.getMemberList(dto));
    }
}
