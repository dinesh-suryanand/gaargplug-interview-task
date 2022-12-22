package com.garageplug.task.interviewtask.controller;

import com.garageplug.task.interviewtask.entity.Category;
import com.garageplug.task.interviewtask.entity.Customer;
import com.garageplug.task.interviewtask.entity.Order;
import com.garageplug.task.interviewtask.services.CustomerServiceImpel;
import com.garageplug.task.interviewtask.services.OrderServiceImpel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerServiceImpel customerServiceImpel;
    private final OrderServiceImpel orderServiceImpel;

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id){
        return customerServiceImpel.getCustomerById(id);
    }

    @GetMapping()
    public List<Customer> getAllCustomers(){
        return customerServiceImpel.getAllCustomers();
    }


    @PostMapping()
    public Customer addCustomer(@RequestBody Customer c){
        return customerServiceImpel.addCustomer(c);
    }

    @PostMapping("/{id}/addOrder")
    public Customer addOrder(@PathVariable Long id, @RequestBody Order order){
        orderServiceImpel.addOrder(id , order);
        return customerServiceImpel.getCustomerById(id);
    }


}
