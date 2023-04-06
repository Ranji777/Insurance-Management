package com.Insurance.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Insurance.Entity.ClientDetails;
import com.Insurance.Exception.InformationNotFoundException;
import com.Insurance.Repository.RepositoryClient;

@Service
public class ClientServiceImpl implements ClientService {

	
	@Autowired
	private RepositoryClient repo;
	
	
	
	
	
	@Override
	public ClientDetails saveclient(ClientDetails details) {
	     return repo.save(details);
	}

	@Override
	public List<ClientDetails> fetchclient() {
		return repo.findAll();
	}
	
	@Override
	public ClientDetails fetchclientbyid(Long id) throws InformationNotFoundException {
		
		Optional<ClientDetails> opt = repo.findById(id);
		
		if(!opt.isPresent())
		{
			throw new InformationNotFoundException("Client is not available in this id");
		}
		return opt.get();
		
	}

	@Override
	public void deletebyid(Long id) throws InformationNotFoundException {
		Optional<ClientDetails> opt =repo.findById(id);
				if(opt.isPresent())
				{
					ClientDetails det=opt.get();
					repo.deleteById(id);
				}
				else
				{
					throw new InformationNotFoundException("No Dept available in the id");
				}
	}

	@Override
	public ClientDetails updateclient(Long id, ClientDetails details) throws InformationNotFoundException {
		Optional<ClientDetails> opt = repo.findById(id);
	    if(opt.isPresent())
	    {
	    	ClientDetails det=opt.get();
		   
			det.setName(details.getName());
		   
		   
			det.setDob(details.getDob());
		   
		   
			det.setAddress(details.getAddress());
		   
		   
			det.setContact(details.getContact());
		   
		   return repo.save(det);
	    }
	   
	    else
	    {
	    	throw new InformationNotFoundException("No Dept available in the id");
	    }

	}

}
