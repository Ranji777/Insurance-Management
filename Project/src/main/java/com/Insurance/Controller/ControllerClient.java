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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Insurance.Entity.ClientDetails;
import com.Insurance.Exception.InformationNotFoundException;
import com.Insurance.Service.ClientService;

@RestController
@RequestMapping("/api")
public class ControllerClient {

	@Autowired
	private ClientService client;
	
	
	
	@PostMapping("/clients")
	public ClientDetails saveclient(@RequestBody ClientDetails details)
	{
		return client.saveclient(details);
	}
	
	@GetMapping("/clients")
	public List<ClientDetails> fetchclient()
	{
		return client.fetchclient();
	}
	
	@GetMapping("/clients/{id}")
	public ClientDetails fetchclientbyid(@PathVariable("id") Long id) throws InformationNotFoundException
	{
		return client.fetchclientbyid(id);
	}
	
	@DeleteMapping("/clients/{id}")
	public String deletebyid(@PathVariable("id") Long id) throws InformationNotFoundException
	{
		client.deletebyid(id);
		return "Client data with id deleted successfuly";
	}
	
	@PutMapping("/clients/{id}")
	public ClientDetails updateclient(@PathVariable("id") Long id, @RequestBody ClientDetails details) throws InformationNotFoundException
	{
		return client.updateclient(id,details);
	}
}
