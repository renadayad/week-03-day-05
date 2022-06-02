package com.example.springhandelday2.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor @NoArgsConstructor @Data
public class CustomerDetailsDTO {
    private Integer id ;
    private Integer age;
    private Double balance;
}
