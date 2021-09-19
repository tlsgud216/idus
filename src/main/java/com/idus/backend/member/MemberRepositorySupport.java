package com.idus.backend.member;

import com.idus.backend.member.dto.GetMemberDetailDto;
import com.idus.backend.member.dto.QGetMemberDetailDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory query;
    private final QMember member = QMember.member;

    public MemberRepositorySupport(JPAQueryFactory jpaQueryFactory) {
        super(Member.class);
        this.query = jpaQueryFactory;
    }

    public GetMemberDetailDto findByMemberId(Long memberId) {
        return query.select(
                new QGetMemberDetailDto(
                        member.id,
                    member.loginId,
                    member.name,
                    member.nickname,
                    member.phone,
                    member.email,
                    member.gender
                ))
                .from(member)
                .where(member.id.eq(memberId)).fetchOne();
    }
}
