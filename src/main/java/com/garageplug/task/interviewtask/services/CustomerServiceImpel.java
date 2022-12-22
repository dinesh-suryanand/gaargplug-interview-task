package com.garageplug.task.interviewtask.services;

import com.garageplug.task.interviewtask.entity.Category;
import com.garageplug.task.interviewtask.entity.Customer;
import com.garageplug.task.interviewtask.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerServiceImpel implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer addCustomer(Customer c) {
        return customerRepository.save(c);
    }

    @Override
    public Customer updateCustomer(Customer c) {
        return customerRepository.save(c);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(new Customer());
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(this::changeType)
                .toList();
    }

    private Customer changeType(Customer customer) {
        customer.setCustomerType(Category.REGULAR);
        customer.setDiscount(0);

        if (customer.getOwnedOrders().size() < 20 && customer.getOwnedOrders().size() >= 10) {
            customer.setCustomerType(Category.GOLD);
            customer.setDiscount(10);
        }
        if (customer.getOwnedOrders().size() >= 20) {
            customer.setCustomerType(Category.PLATINUM);
            customer.setDiscount(20);
        }
        return customer;
    }

    @Override
    public void sentMail() {
        System.out.println("logic to send mail is Called");
    }


    @Override
    public Integer getDiscount(Customer customer) {
        if (customer.getCustomerType() == Category.GOLD) {
            return 10;
        } else if (customer.getCustomerType() == Category.PLATINUM) {
            return 20;
        } else return 0;
    }


}
