package com.example.springhandelday2.repoistory;

import com.example.springhandelday2.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepoistory extends JpaRepository<Customers,Integer> {
}
