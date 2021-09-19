package com.idus.backend.member;

import com.idus.backend.config.JwtTokenProvider;
import com.idus.backend.member.dto.*;
import com.idus.backend.utils.SessionUtil;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class MemberService implements UserDetailsService {
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    private final MemberRepository memberRepository;
    private final MemberRepositorySupport memberRepositorySupport;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        return memberRepository.findByLoginId(loginId)
                .orElseThrow(() -> new UsernameNotFoundException("해당 계정은 존재하지 않습니다."));
    }

    // 회원가입
    public long join(PostJoinDto dto) {
        Member member = new Member();
        member.loginId = dto.getEmail();
        member.password = passwordEncoder.encode(dto.getPassword());
        member.name = dto.getName();
        member.nickname = dto.getNickname();
        member.phone = dto.getPhone();
        member.email = dto.getEmail();
        member.gender = dto.getGender();
        Member memberEntity = memberRepository.save(member);

        return memberEntity.id;
    }

    // 로그인
    public Map<String, String> signIn(PostSignInDto dto) throws Exception {
        Member memberEntity = memberRepository.findByLoginId(dto.getLoginId())
                .orElseThrow(() -> new UsernameNotFoundException("해당 계정은 존재하지 않습니다."));

        if (!passwordEncoder.matches(dto.getPassword(), memberEntity.getPassword()))
            throw new Exception();

        String token = jwtTokenProvider.createToken(dto.getLoginId(), memberEntity.id);

        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("token", token);

        return resultMap;
    }

    // 로그인회원 상세정보 조회
    public GetCurrentMemberDetailDto getCurrentMemberDetail() {
        Long memberId = SessionUtil.currentMemberId();
        return memberRepositorySupport.findByMemberId(memberId);
    }

    // 회원목록 조회 (with 최근주문조회)
    public Map<String, Object> getMemberList(SearchMemberListDto dto) {
        JPAQuery<GetMemberListDto> query =  memberRepositorySupport.findMemberListWithLatestOrder(dto);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("count", query.fetchCount());
        resultMap.put("list", query.fetch());
        return resultMap;
    }
}
