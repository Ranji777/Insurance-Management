package com.Insurance.Entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDetails {

	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	
	
	private LocalDate dob;
	
	
	private String address;
	
	private long contact;
	
	 @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	    private Set<InsurancePolicy> insurancePolicies = new HashSet<>();
}
