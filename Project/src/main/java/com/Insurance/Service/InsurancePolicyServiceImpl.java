package com.Insurance.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Insurance.Entity.InsurancePolicy;
import com.Insurance.Exception.InformationNotFoundException;
import com.Insurance.Repository.InsurancepolicyRepository;

@Service
public class InsurancePolicyServiceImpl implements InsurancePolicyService{

	
    @Autowired
    private InsurancepolicyRepository repoins;
    
	
    
    @Override
	public InsurancePolicy saveinsurancepolicy(InsurancePolicy policy) {
	     return repoins.save(policy);
	}


	@Override
	public List<InsurancePolicy> fetchinsurance() {
		return repoins.findAll();
		}


	@Override
	public InsurancePolicy fetchinsurancebyid(Long id) throws InformationNotFoundException {
		Optional<InsurancePolicy> opt=repoins.findById(id);
		if(opt.isPresent())
		{
			return opt.get();
			
		}
		else {
			throw new InformationNotFoundException("Insurance policy is not available in given id");
		}
	}


	@Override
	public void deleteinsurancepolicy(Long id) throws InformationNotFoundException {
		Optional<InsurancePolicy> opt=repoins.findById(id);
		if(!opt.isPresent())
		{
			throw new InformationNotFoundException("Insurance policy is not available in in given id ");
		}
		opt.get();
		repoins.deleteById(id);
	}


	@Override
	public InsurancePolicy updateinsurancepolicy(Long id, InsurancePolicy details) throws InformationNotFoundException {
		Optional<InsurancePolicy> opt=repoins.findById(id);
		if(opt.isPresent())
		{
			InsurancePolicy ins=opt.get();
			
				ins.setPolicyNumber(details.getPolicyNumber());
			
			
				ins.setType(details.getType());
			
			
				ins.setCoverageAmount(details.getCoverageAmount());
			
			
				ins.setPremium(details.getPremium());
			
			
				ins.setStartDate(details.getStartDate());
			
			
				ins.setEndDate(details.getEndDate());
			
			
				ins.setClient(details.getClient());
			
			return repoins.save(ins);
		}
		else
		{
			throw new InformationNotFoundException("Insurance policy is not available in in given id ");
		}
	}

}
