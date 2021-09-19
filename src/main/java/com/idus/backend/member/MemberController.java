package com.idus.backend.member;

import com.idus.backend.member.dto.GetMemberDetailDto;
import com.idus.backend.member.dto.PostJoinDto;
import com.idus.backend.member.dto.PostSignInDto;
import com.idus.backend.member.dto.SearchMemberListDto;
import com.idus.backend.order.dto.GetOrderListDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    ResponseEntity<GetMemberDetailDto> getCurrentMemberDetail() {
        return ResponseEntity.ok(memberService.getCurrentMemberDetail());
    }

    @GetMapping("/{id}")
    ResponseEntity<GetMemberDetailDto> getCurrentMemberDetail(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.getMemberDetail(id));
    }

    @GetMapping("/{id}/order")
    ResponseEntity<List<GetOrderListDto>> getOrderList(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.getMemberOrderList(id));
    }

    @GetMapping("/list")
    ResponseEntity<Map<String, Object>> getMemberList(SearchMemberListDto dto) {
        return ResponseEntity.ok(memberService.getMemberList(dto));
    }
}
