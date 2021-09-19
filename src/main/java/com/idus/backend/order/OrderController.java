package com.idus.backend.order;

import com.idus.backend.order.dto.GetOrderListDto;
import com.idus.backend.order.dto.PostOderDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("")
    ResponseEntity<Long> postOrder(@RequestBody PostOderDto dto) {
        return ResponseEntity.ok(orderService.postOder(dto));
    }

    @GetMapping("/list")
    ResponseEntity<List<GetOrderListDto>> getOrderList() {
        return ResponseEntity.ok(orderService.getOrderListDto());
    }
}