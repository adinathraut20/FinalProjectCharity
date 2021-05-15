package com.povertyFree.povertyLessIndia.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import com.povertyFree.povertyLessIndia.Repository.CitiesRepo;
import com.povertyFree.povertyLessIndia.Repository.NGORepo;
import com.povertyFree.povertyLessIndia.Repository.StatesRepo;
import com.povertyFree.povertyLessIndia.Repository.UserMaterialDonateRepo;
import com.povertyFree.povertyLessIndia.dto.Cities;
import com.povertyFree.povertyLessIndia.dto.MaterialDonation;
import com.povertyFree.povertyLessIndia.dto.NGO;
import com.povertyFree.povertyLessIndia.dto.RegisterNewNGO;
import com.povertyFree.povertyLessIndia.dto.States;

@Service
public class NGOServiceImple implements NGOService {

	
	
	
	@Autowired
	UserMaterialDonateRepo uMDR;
	
	@Autowired
	NGORepo ngoRepo;
	
	@Autowired
	StatesRepo stateRepo;
	
	@Autowired
	CitiesRepo citiesRepo;

	@Override
	public NGO checkNGO(NGO ngo) {
		
		return ngoRepo.findByEmailAndPassword(ngo.getEmail(), ngo.getPassword());
	}
	
	
	@Override
	public MaterialDonation donationAccept(int donateId , int ngoId) {
	
		if(uMDR.findById(donateId).isPresent()) {
			
			MaterialDonation md = uMDR.findById(donateId).get();
			md.setNgo(new NGO(ngoId));
			md.setStatus("accepted");
			System.out.println(md);
			return uMDR.save(md);
		}
		else {			
		return null;
	}
}


	@Override
	public boolean registerNGO(RegisterNewNGO ngo) {
	try {
		
		States state1 = stateRepo.findByStateName(ngo.getState());
		Cities city1 = null;
		if(state1 == null) {
			States state = new States();
			state.setStateName(ngo.getState());
			state1 = stateRepo.save(state);
			city1 = citiesRepo.findByCityName(ngo.getCity());
			if(city1 == null) {
				Cities city = new Cities();
				city.setState(state1);
				city.setCityName(ngo.getCity());
				city1=citiesRepo.save(city);
			}		
			
		}else {
			city1 = citiesRepo.findByCityName(ngo.getCity());
			if(city1 == null) {
				Cities city = new Cities();
				city.setState(state1);
				city.setCityName(ngo.getCity());
				city1=citiesRepo.save(city);
			}	
		}	
			System.out.println(ngo);
			NGO ngoNew = new NGO();
			ngoNew.setEmail(ngo.getEmail());
			ngoNew.setContact(ngo.getContact());
			ngoNew.setNgoName(ngo.getNgoName());
			ngoNew.setState(state1);
			ngoNew.setCity(city1);
			ngoNew.setLocation(ngo.getLocation());
			ngoNew.setAddress(ngo.getAddress());
			ngoNew.setPassword(ngo.getPassword());
			ngoNew.setRegNo(ngo.getRegNo());
			System.out.println(ngoNew);
			ngoRepo.save(ngoNew);
		
		return true;
	}
	catch(Exception ex) {
		System.out.println(ex.getStackTrace());
		return false;
	}
	}


	@Override
	public NGO checkNGOEmail(String email) {
		
		return ngoRepo.findByEmailIgnoreCase(email);
	}


	@Override
	public List<MaterialDonation> getNGONotification(Cities cityId, String status) {
		
		Iterable<MaterialDonation> mdI = uMDR.findByCityAndStatus(cityId, status);
		
		Iterator<MaterialDonation> mdItr = mdI.iterator();
		List<MaterialDonation> mdLi = new ArrayList<MaterialDonation>();
		while(mdItr.hasNext()) {
			mdLi.add(mdItr.next());
		}
		
		return mdLi;
	}


	@Override
	public NGO getNGO(NGO ngo) {		
		return ngoRepo.findByNgoId(ngo.getNgoId());
	}


	@Override
	public List<MaterialDonation> getNGOAcceptedDonation(NGO ngo) {
			
		Iterable<MaterialDonation> mdI = uMDR.findByNgoAndStatus(ngo, "accepted");
		
		Iterator<MaterialDonation> mdItr = mdI.iterator();
		List<MaterialDonation> mdLi = new ArrayList<MaterialDonation>();
		while(mdItr.hasNext()) {
			mdLi.add(mdItr.next());
		}
		
		return mdLi;
	}


	@Override
	public MaterialDonation uploadImageNGO(String filePath, int donateId) {
		MaterialDonation md;
		if(uMDR.findById(donateId).isPresent()) {
			md =  uMDR.findById(donateId).get();
			md.setProof(filePath);
			md.setStatus("Completed");
			return uMDR.save(md);
		}
		return null;
	}


	@Override
	public List<MaterialDonation> getNGODonationHistory(int ngoId) {
		NGO ngo = new NGO(ngoId);
		
		Iterable<MaterialDonation> mdI = uMDR.findByNgoAndStatus(ngo, "Completed");
		
		Iterator<MaterialDonation> mdItr = mdI.iterator();
		List<MaterialDonation> mdLi = new ArrayList<MaterialDonation>();
		while(mdItr.hasNext()) {
			mdLi.add(mdItr.next());
		}
		
		return mdLi;
	}


	

	
	

}