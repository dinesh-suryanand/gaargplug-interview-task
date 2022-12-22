package com.garageplug.task.interviewtask.services;

import com.garageplug.task.interviewtask.entity.Customer;
import com.garageplug.task.interviewtask.entity.Order;
import com.garageplug.task.interviewtask.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpel implements OrderService{


    private final OrderRepository orderRepository;
    private final CustomerServiceImpel customerService;

    @Override
    public void addOrder( Long id ,Order o) {
        Customer customer = customerService.getCustomerById(id);
        List<Order> ownedOrders = customer.getOwnedOrders();
        ownedOrders.add(o);
        customer.setOwnedOrders(ownedOrders);
    }

}
