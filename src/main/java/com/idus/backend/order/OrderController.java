package com.idus.backend.order;

import com.idus.backend.order.dto.GetOrderListDto;
import com.idus.backend.order.dto.PostOderDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Member", tags = "주문")
@AllArgsConstructor
@RestController
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;

    @ApiOperation("로그인 회원 주문 생성")
    @PostMapping("")
    ResponseEntity<Long> postOrder(@RequestBody PostOderDto dto) {
        return ResponseEntity.ok(orderService.postOder(dto));
    }

    @ApiOperation("로그인 회원 주문 목록 조회")
    @GetMapping("/list")
    ResponseEntity<List<GetOrderListDto>> getCurrentMemberOrderList() {
        return ResponseEntity.ok(orderService.getCurrentMemberOrderList());
    }
}
