package com.garageplug.task.interviewtask.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Table(name="customer")
@Builder
@AllArgsConstructor
@NoArgsConstructor
    public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Category customerType;
    private String email;
    private Integer discount;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE , CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "fk_cus_id" , referencedColumnName = "id")
    private List<Order> ownedOrders;

}