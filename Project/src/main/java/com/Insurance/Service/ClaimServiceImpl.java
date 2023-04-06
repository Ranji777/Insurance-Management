package com.Insurance.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Insurance.Entity.Claim;
import com.Insurance.Exception.InformationNotFoundException;
import com.Insurance.Repository.ClaimRepository;

@Service
public class ClaimServiceImpl implements ClaimService{

	
	@Autowired
	private ClaimRepository repoclaim;
	
	
	
	@Override
	public Claim saveclaim(Claim details) {
		return repoclaim.save(details);
	}

	@Override
	public List<Claim> fetchclaim() {
	    return repoclaim.findAll();
	}

	@Override
	public Claim fetchclaimbyid(Long id) throws InformationNotFoundException {
		Optional<Claim> opt=repoclaim.findById(id);
		if(!opt.isPresent())
		{
			throw new InformationNotFoundException("Claim Info not found in this id");
		}
		return opt.get();
		}

	@Override
	public void deleteclaim(Long id) throws InformationNotFoundException {
		Optional<Claim> opt=repoclaim.findById(id);
		if(!opt.isPresent())
		{
			throw new InformationNotFoundException("Claim Info not found in this id");
		}
		opt.get();
		repoclaim.deleteById(id);
	}

	@Override
	public Claim updateclaim(Long id, Claim details) throws InformationNotFoundException {
		Optional<Claim> opt=repoclaim.findById(id);
		if(opt.isPresent())
		{
			Claim cl=opt.get();
			
				cl.setClaimNumber(details.getClaimNumber());
			
			
				cl.setDescription(details.getDescription());
			
			
				cl.setClaimDate(details.getClaimDate());
			
			
				cl.setClaimStatus(details.getClaimStatus());
			
			
				cl.setInsurancePolicy(details.getInsurancePolicy());
			
			return repoclaim.save(cl);
		}
		else
		{
			throw new InformationNotFoundException("Claim Info not found in this id");
		}
	}

}
