package com.idus.backend.member;

import com.idus.backend.member.dto.GetMemberDetailDto;
import com.idus.backend.member.dto.PostJoinDto;
import com.idus.backend.member.dto.PostSignInDto;
import com.idus.backend.member.dto.SearchMemberListDto;
import com.idus.backend.order.dto.GetOrderListDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(value = "Member", tags = "회원")
@AllArgsConstructor
@RestController
@RequestMapping("/api/member")
public class MemberController {
    private final MemberService memberService;

    @ApiOperation("회원가입")
    @PostMapping("/join")
    ResponseEntity<Long> join(@RequestBody PostJoinDto dto) {
        return ResponseEntity.ok(memberService.join(dto));
    }

    @ApiOperation("로그인")
    @PostMapping("/sign-in")
    ResponseEntity<Map<String, String>> signIn(@RequestBody PostSignInDto dto) throws Exception {
        return ResponseEntity.ok(memberService.signIn(dto));
    }

    @ApiOperation("로그인 회원 상세 조회")
    @GetMapping("/info")
    ResponseEntity<GetMemberDetailDto> getCurrentMemberDetail() {
        return ResponseEntity.ok(memberService.getCurrentMemberDetail());
    }

    @ApiOperation("회원 상세 조회")
    @GetMapping("/{id}")
    ResponseEntity<GetMemberDetailDto> getCurrentMemberDetail(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.getMemberDetail(id));
    }

    @ApiOperation("회원 주문 목록 조회")
    @GetMapping("/{id}/order")
    ResponseEntity<List<GetOrderListDto>> getOrderList(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.getMemberOrderList(id));
    }

    @ApiOperation("회원 목록 조회(with 최근 주문)")
    @GetMapping("/list")
    ResponseEntity<Map<String, Object>> getMemberList(SearchMemberListDto dto) {
        return ResponseEntity.ok(memberService.getMemberList(dto));
    }
}
