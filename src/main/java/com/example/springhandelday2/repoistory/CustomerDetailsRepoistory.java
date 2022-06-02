package com.example.springhandelday2.repoistory;

import com.example.springhandelday2.model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDetailsRepoistory extends JpaRepository<CustomerDetails,Integer> {
}
