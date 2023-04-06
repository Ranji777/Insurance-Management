package com.Insurance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Insurance.Entity.Claim;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {

}
