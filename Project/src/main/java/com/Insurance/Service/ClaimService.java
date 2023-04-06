package com.Insurance.Service;

import java.util.List;

import com.Insurance.Entity.Claim;
import com.Insurance.Exception.InformationNotFoundException;

public interface ClaimService {

	Claim saveclaim(Claim details);

	List<Claim> fetchclaim();

	Claim fetchclaimbyid(Long id) throws InformationNotFoundException;

	void deleteclaim(Long id) throws InformationNotFoundException;

	Claim updateclaim(Long id, Claim details) throws InformationNotFoundException;

}
