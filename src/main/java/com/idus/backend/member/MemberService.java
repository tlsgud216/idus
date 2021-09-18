package com.idus.backend.member;

import com.idus.backend.member.dto.PostSignUpDto;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@AllArgsConstructor
public class MemberService implements UserDetailsService {
    private final BCryptPasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        return memberRepository.findByLoginId(loginId)
                .orElseThrow(() -> new UsernameNotFoundException("해당 계정은 존재하지 않습니다."));
    }

    public long signUp(@RequestBody PostSignUpDto dto) {
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
}
