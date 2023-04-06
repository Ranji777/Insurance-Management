package com.Insurance.Service;

import java.util.List;

import com.Insurance.Entity.InsurancePolicy;
import com.Insurance.Exception.InformationNotFoundException;

public interface InsurancePolicyService {

	InsurancePolicy saveinsurancepolicy(InsurancePolicy policy);

	List<InsurancePolicy> fetchinsurance();

	InsurancePolicy fetchinsurancebyid(Long id) throws InformationNotFoundException;

	void deleteinsurancepolicy(Long id) throws InformationNotFoundException;

	InsurancePolicy updateinsurancepolicy(Long id, InsurancePolicy details) throws InformationNotFoundException;

}
