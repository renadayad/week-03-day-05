package com.example.springhandelday2.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity

public class CustomerDetails {
 @Id
 private Integer id ;
    @NotNull(message = "age must be not null")
    private Integer age;
    @NotNull(message = "balance must be not null")
    private Double balance;


    @OneToOne(cascade  = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customers customer;

}
