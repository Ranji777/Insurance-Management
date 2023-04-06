package com.Insurance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Insurance.Entity.ClientDetails;

@Repository
public interface RepositoryClient extends JpaRepository<ClientDetails, Long>{

}
