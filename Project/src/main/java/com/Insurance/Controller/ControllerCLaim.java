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

import com.Insurance.Entity.Claim;
import com.Insurance.Exception.InformationNotFoundException;
import com.Insurance.Service.ClaimService;

@RestController
@RequestMapping("/api")
public class ControllerCLaim {

	@Autowired
	private ClaimService claim;
	
	@PostMapping("/claim")
	public Claim saveclaim(@RequestBody Claim details)
	{
		return claim.saveclaim(details);
	}
	
	@GetMapping("/claim")
	public List<Claim> fetchclaim()
	{
		return claim.fetchclaim(); 
	}
	
	@GetMapping("/claim/{id}")
	public Claim fetchclaimbyid(@PathVariable("id") Long id) throws InformationNotFoundException
	{
		return claim.fetchclaimbyid(id);
	}
	
	@DeleteMapping("/claim/{id}")
	public String deleteclaim(@PathVariable("id") Long id) throws InformationNotFoundException
	{
		claim.deleteclaim(id);
		return "Claim details deleted succesfully in this id";
	}
	
	@PutMapping("/claim/{id}")
	public Claim updateclaim(@PathVariable("id") Long id, @RequestBody Claim details) throws InformationNotFoundException
	{
		return claim.updateclaim(id,details);
	}
}
