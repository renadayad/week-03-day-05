package com.example.springhandelday2.repoistory;

import com.example.springhandelday2.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepoistory extends JpaRepository<Bank,Integer> {
}
