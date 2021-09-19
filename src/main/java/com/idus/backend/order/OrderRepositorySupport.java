package com.idus.backend.order;

import com.idus.backend.order.dto.GetOrderListDto;
import com.idus.backend.order.dto.QGetOrderListDto;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory query;
    private final QOrders order = QOrders.orders;

    public OrderRepositorySupport(JPAQueryFactory jpaQueryFactory) {
        super(Orders.class);
        this.query = jpaQueryFactory;
    }

    // 주문번호 생성시 주문번호 유무체크
    public Long countByOrderCode(String orderCode) {
        return query.selectFrom(order)
                .where(order.orderCode.eq(orderCode))
                .fetchCount();
    }

    // 회원별 주문목록 조회
    public List<GetOrderListDto> findByMemberId(Long memberId) {
        return query.select(
                new QGetOrderListDto(
                        order.id,
                        order.orderCode,
                        order.name,
                        order.createdAt,
                        order.updatedAt
                ))
                .from(order)
                .where(order.member.id.eq(memberId)).fetch();
    }

}
