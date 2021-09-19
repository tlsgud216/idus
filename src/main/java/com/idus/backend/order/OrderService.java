package com.idus.backend.order;

import com.idus.backend.member.Member;
import com.idus.backend.member.MemberRepository;
import com.idus.backend.order.dto.GetOrderListDto;
import com.idus.backend.order.dto.PostOderDto;
import com.idus.backend.utils.SessionUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class OrderService {
    private final EntityManager entityManager;

    private final MemberRepository memberRepository;
    private final OrderRepository orderRepository;
    private final OrderRepositorySupport orderRepositorySupport;

    // 주문생성
    public Long postOder(PostOderDto dto) {
        Long memberId = SessionUtil.currentMemberId();
        Member memberEntity = memberRepository.findById(memberId).get();

        Orders order = new Orders();
        order.orderCode = this.createOrderCode();
        order.name = dto.getName();
        order.member = memberEntity;
        Orders orderEntity = orderRepository.save(order);

        return orderEntity.id;
    }

    // 주문번호 랜덤생성
    private String createOrderCode() {
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();

        for(int i = 0; i < 20; i++) {
            if(random.nextBoolean()){
                buffer.append((char)((int)(random.nextInt(26))+97));
            }else{
                buffer.append((random.nextInt(10)));
            }
        }
        String orderCode = buffer.toString();

        if (orderRepositorySupport.countByOrderCode(orderCode) > 0) {
            orderCode = this.createOrderCode();
        }

        return orderCode;
    }

    // 주문목록조회
    public List<GetOrderListDto> getOrderListDto() {
        Long memberId = SessionUtil.currentMemberId();
        return orderRepositorySupport.findByMemberId(memberId);
    }
}
