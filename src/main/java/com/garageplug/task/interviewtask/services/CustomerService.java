package com.garageplug.task.interviewtask.services;

import com.garageplug.task.interviewtask.entity.Category;
import com.garageplug.task.interviewtask.entity.Customer;
import com.garageplug.task.interviewtask.entity.Order;

import java.util.List;
import java.util.Optional;


public interface CustomerService {
    Customer addCustomer(Customer c);

    Customer updateCustomer(Customer c);

    Customer getCustomerById(Long id);

    List<Customer> getAllCustomers();

    void sentMail();
    Integer getDiscount(Customer customer);


}
