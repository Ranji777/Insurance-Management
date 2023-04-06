package com.Insurance.Service;

import java.util.List;

import com.Insurance.Entity.ClientDetails;
import com.Insurance.Exception.InformationNotFoundException;

public interface ClientService {

	ClientDetails saveclient(ClientDetails details);

	List<ClientDetails> fetchclient();

	ClientDetails fetchclientbyid(Long id) throws InformationNotFoundException;

	void deletebyid(Long id) throws InformationNotFoundException;

	ClientDetails updateclient(Long id, ClientDetails details) throws InformationNotFoundException;

}
