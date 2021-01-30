package com.povertyFree.povertyLessIndia.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.povertyFree.povertyLessIndia.Repository.AdminRepo;
import com.povertyFree.povertyLessIndia.Repository.CitiesRepo;
import com.povertyFree.povertyLessIndia.Repository.NGORepo;
import com.povertyFree.povertyLessIndia.Repository.UserMaterialDonateRepo;
import com.povertyFree.povertyLessIndia.Repository.UserRepo;
import com.povertyFree.povertyLessIndia.dto.Admins;
import com.povertyFree.povertyLessIndia.dto.Cities;
import com.povertyFree.povertyLessIndia.dto.MaterialDonation;
import com.povertyFree.povertyLessIndia.dto.NGO;
import com.povertyFree.povertyLessIndia.dto.Users;

@Service
public class AdminServiceImple implements AdminService {

	@Autowired
	AdminRepo adminRepo;
	
	@Autowired
	CitiesRepo citiesRepo;
	
	@Autowired
	UserMaterialDonateRepo uMDR;
	
	@Autowired
	NGORepo ngoRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Override
	public Admins checkAdmin(Admins admin) {
		return adminRepo.findByEmailAndPassword(admin.getEmail(), admin.getPassword());
	}


	@Override
	public List<Cities> getAllCities() {
		
		Iterable<Cities> UI = citiesRepo.findAll();
		Iterator<Cities> UItr = UI.iterator();
		List<Cities> NLi = new ArrayList<Cities>();
		while(UItr.hasNext()) {
			NLi.add(UItr.next());
		}
		return NLi;
	}


	@Override
	public List<MaterialDonation> getAllMaterialDonationList() {
		
		Iterable<MaterialDonation> UI = uMDR.findAll();
		Iterator<MaterialDonation> UItr = UI.iterator();
		List<MaterialDonation> NLi = new ArrayList<MaterialDonation>();
		while(UItr.hasNext()) {
			NLi.add(UItr.next());
		}
		return NLi;
	}


	@Override
	public List<NGO> getAllNGOList() {
		
		Iterable<NGO> UI = ngoRepo.findAll();
		Iterator<NGO> UItr = UI.iterator();
		List<NGO> NLi = new ArrayList<NGO>();
		while(UItr.hasNext()) {
			NLi.add(UItr.next());
		}
		return NLi;
	}


	@Override
	public List<Users> getAllUsersList() {
		
		Iterable<Users> UI = userRepo.findAll();
		Iterator<Users> UItr = UI.iterator();
		List<Users> NLi = new ArrayList<Users>();
		while(UItr.hasNext()) {
			NLi.add(UItr.next());
		}
		return NLi;
	}


	@Override
	public boolean abortMaterialDonation(int id) {
		if(uMDR.findById(id).isPresent()) {
			MaterialDonation md = uMDR.findById(id).get();
			md.setStatus("Aborted");
			MaterialDonation md1 = uMDR.save(md);
			if(md1 != null) {
				return true;
			}
		}
		return false;
	}


	@Override
	public boolean deleteMaterialDonation(int id) throws Exception {
		 uMDR.deleteById(id);
		return true;
	}
}
