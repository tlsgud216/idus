package com.idus.backend.member;

import com.idus.backend.member.dto.PostSignUpDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/member")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/sign-up")
    ResponseEntity<Long> signUp(@RequestBody PostSignUpDto dto) {
        return ResponseEntity.ok(memberService.signUp(dto));
    }

}
