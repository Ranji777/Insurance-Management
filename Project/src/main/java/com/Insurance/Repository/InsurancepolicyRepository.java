package com.Insurance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Insurance.Entity.InsurancePolicy;

@Repository
public interface InsurancepolicyRepository extends JpaRepository<InsurancePolicy, Long>{

}
