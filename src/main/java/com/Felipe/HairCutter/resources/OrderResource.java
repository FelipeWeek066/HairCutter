package com.Felipe.HairCutter.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Felipe.HairCutter.entities.Order;
import com.Felipe.HairCutter.entities.DTOs.OrderDTO;
import com.Felipe.HairCutter.mappers.OrderMapper;
import com.Felipe.HairCutter.services.OrderService;

@RestController
@RequestMapping(value = "/Orders")
public class OrderResource {
	@Autowired
	private OrderService orderService;

	@GetMapping
	public ResponseEntity<List<OrderDTO>> findAll() {
		// transform to DTO.
		return ResponseEntity.ok()
				.body(orderService.findAll().stream().map(x -> OrderMapper.INSTANCE.orderToOrderDTO(x)).toList());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<OrderDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(OrderMapper.INSTANCE.orderToOrderDTO(orderService.findById(id)));
	}

	@PostMapping
	public ResponseEntity<OrderDTO> insertOrder(@RequestBody OrderDTO orderdto) {
		return ResponseEntity.ok().body(OrderMapper.INSTANCE
				.orderToOrderDTO(orderService.insert(OrderMapper.INSTANCE.orderDTOToOrder(orderdto))));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<OrderDTO> updateOrder(@PathVariable Long id, @RequestBody Order hairJobOrder) {
		return ResponseEntity.ok().body(OrderMapper.INSTANCE.orderToOrderDTO(orderService.update(id, hairJobOrder)));
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Order> deleteOrder(@PathVariable Long id) {
		orderService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
