package com.idus.backend.member;

import com.idus.backend.member.commonTypes.SearchMemberTypes;
import com.idus.backend.member.dto.*;
import com.idus.backend.order.QOrders;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory query;
    private final QMember member = QMember.member;
    private final QOrders order = QOrders.orders;

    public MemberRepositorySupport(JPAQueryFactory jpaQueryFactory) {
        super(Member.class);
        this.query = jpaQueryFactory;
    }

    // 회원정보상세조회
    public GetCurrentMemberDetailDto findByMemberId(Long memberId) {
        return query.select(
                new QGetMemberDetailDto(
                    member.loginId,
                    member.name,
                    member.nickname,
                    member.phone,
                    member.email,
                    member.gender,
                    member.createdAt,
                    member.updatedAt
                ))
                .from(member)
                .where(member.id.eq(memberId)).fetchOne();
    }


    // 회원목록 조회 (with 최근주문조회)
    public JPAQuery<GetMemberListDto> findMemberListWithLatestOrder(SearchMemberListDto dto) {
        JPAQuery<GetMemberListDto> baseQuery = query.select(
                new QGetMemberListDto(
                        member.id,
                        member.loginId,
                        member.name,
                        member.nickname,
                        member.phone,
                        member.email,
                        member.gender,
                        member.createdAt,
                        member.updatedAt,

                        order.id,
                        order.orderCode,
                        order.name,
                        order.createdAt,
                        order.updatedAt
                ))
                .from(member)
                .leftJoin(order).on(order.id.eq(
                        query.select(order.id.max())
                                .from(order)
                        .where(order.member.id.eq(member.id))
                ));

        if (dto.getSearchType() == SearchMemberTypes.NAME)
            baseQuery = baseQuery.where(member.name.eq(dto.getSearchValue()));
        else if (dto.getSearchType() == SearchMemberTypes.EMAIL)
            baseQuery = baseQuery.where(member.email.eq(dto.getSearchValue()));

        return baseQuery
                .limit(dto.getLimit())
                .offset(dto.getOffset())
                .orderBy(member.id.desc());
    }
}
