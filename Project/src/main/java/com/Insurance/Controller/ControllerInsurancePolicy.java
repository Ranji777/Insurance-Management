package com.Insurance.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Insurance.Entity.InsurancePolicy;
import com.Insurance.Exception.InformationNotFoundException;
import com.Insurance.Service.InsurancePolicyService;

@RestController
@RequestMapping("/api")
public class ControllerInsurancePolicy {
	
	@Autowired
	private InsurancePolicyService insurance;
	
	
	@PostMapping("/policies")
	public InsurancePolicy saveinsurancepolicy(@RequestBody InsurancePolicy policy)
	{
		return insurance.saveinsurancepolicy(policy);
	}
	
	
	@GetMapping("/policies")
	public List<InsurancePolicy> fetchinsurance()
	{
		return insurance.fetchinsurance();
	}
	
	@GetMapping("/policies/{id}")
	public InsurancePolicy fetchinsurancebyid(@PathVariable("id") Long id) throws InformationNotFoundException
	{
		return insurance.fetchinsurancebyid(id);
	}
	
	@DeleteMapping("/policies/{id}")
	public String deleteinsurancepolicy(@PathVariable("id") Long id) throws InformationNotFoundException
	{
		insurance.deleteinsurancepolicy(id);
		return "Insurance details on id deleted suucessfully";
	}
	
	@PutMapping("/policies/{id}")
	public InsurancePolicy updateinsurancepolicy(@PathVariable("id") Long id, @RequestBody
			                                       InsurancePolicy details) throws InformationNotFoundException
	{
		return insurance.updateinsurancepolicy(id,details);
	}

}
