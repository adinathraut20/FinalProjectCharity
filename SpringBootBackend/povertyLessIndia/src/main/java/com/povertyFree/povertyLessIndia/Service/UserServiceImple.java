package com.povertyFree.povertyLessIndia.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.povertyFree.povertyLessIndia.Repository.CitiesRepo;
import com.povertyFree.povertyLessIndia.Repository.StatesRepo;
import com.povertyFree.povertyLessIndia.Repository.UserMaterialDonateRepo;
import com.povertyFree.povertyLessIndia.Repository.UserRepo;
import com.povertyFree.povertyLessIndia.dto.Cities;
import com.povertyFree.povertyLessIndia.dto.MaterialDonation;
import com.povertyFree.povertyLessIndia.dto.States;
import com.povertyFree.povertyLessIndia.dto.Users;

@Service
public class UserServiceImple implements UserService {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	UserMaterialDonateRepo userMDonateRepo;
	

	
	@Autowired
	StatesRepo statesRepo;
	
	@Autowired
	CitiesRepo citiesRepo;
	
	@Override
	public boolean AddUser(Users user) {
	
		if(null == userRepo.save(user)) {
			return false;
		}
		return true;
	}


	@Override
	public boolean deleteUser(int id) {
		userRepo.deleteById(id);
		return true;
	}


	@Override
	public List<Users> getAllUsers() {
		Iterable<Users> UI = userRepo.findAll();
		Iterator<Users> UItr = UI.iterator();
		List<Users> ULi = new ArrayList<Users>();
		while(UItr.hasNext()) {
			ULi.add(UItr.next());
		}
		return ULi;
	}


	@Override
	public Users UserValidate(Users user) {
		return userRepo.findByEmailAndPassword(user.getEmail(), user.getPassword());
	}


	@Override
	public MaterialDonation addMaterialDonation(MaterialDonation mDonation) {
		try {			
			String time1 = java.time.LocalTime.now().toString();
			String []timeArr = time1.split(":");
			String timeF = timeArr[0]+":"+timeArr[1]+":"+timeArr[2].charAt(0)+timeArr[2].charAt(1);
			System.out.println(java.time.LocalDate.now());
			System.out.println(timeF);
			mDonation.setDate1(java.time.LocalDate.now().toString());
			mDonation.setTime(timeF);
			mDonation.setStatus("pending");			
			System.out.println(mDonation);
			
			return userMDonateRepo.save(mDonation);
		}
		catch(Exception ex) {
			System.out.println(ex.getStackTrace());
			return null;
		}
	}


	@Override
	public List<States> getAllStates() {
		Iterable<States> UI = statesRepo.findAll();
		Iterator<States> UItr = UI.iterator();
		List<States> ULi = new ArrayList<States>();
		while(UItr.hasNext()) {
			ULi.add(UItr.next());
		}
		return ULi;
		
	}


	@Override
	public List<Cities> getCitites(int stateId) {
		States state1 = new States();
		state1.setStateId(stateId);
		Iterable<Cities> UI = citiesRepo.findByState(state1);
		Iterator<Cities> UItr = UI.iterator();
		List<Cities> ULi = new ArrayList<Cities>();
		while(UItr.hasNext()) {
			ULi.add(UItr.next());
		}
		return ULi;

	}


	@Override
	public Users userEmailCheckAlreadyPresent(String email) {
		
		return userRepo.findByEmail(email);
	}


	@Override
	public MaterialDonation uploadImage(String uImage,int donationId ) {
		
		if(userMDonateRepo.findById(donationId).isPresent()) {
		
			MaterialDonation md = userMDonateRepo.findById(donationId).get();
			md.setuImage(uImage);
			System.out.println(md);
			return userMDonateRepo.save(md);
		}else {
		return null;
		}
	}


	@Override
	public List<MaterialDonation> getUserDonationStatus(int id) {
		
		Users user = new Users(id);
	 
		 Iterable<MaterialDonation> mdI = userMDonateRepo.findByUserAndStatus(user, "pending");
			
			Iterator<MaterialDonation> mdItr = mdI.iterator();
			List<MaterialDonation> mdLi = new ArrayList<MaterialDonation>();
			while(mdItr.hasNext()) {
				mdLi.add(mdItr.next());
			}
			
			mdI = userMDonateRepo.findByUserAndStatus(user, "accepted");
			
			mdItr = mdI.iterator();
			
			while(mdItr.hasNext()) {
				mdLi.add(mdItr.next());
			}
				
			return mdLi;
	}


	@Override
	public List<MaterialDonation> getUserDonationHistory(int id) {
		Users user = new Users(id);
		 
		 Iterable<MaterialDonation> mdI = userMDonateRepo.findByUserAndStatus(user, "Completed");
			
			Iterator<MaterialDonation> mdItr = mdI.iterator();
			List<MaterialDonation> mdLi = new ArrayList<MaterialDonation>();
			while(mdItr.hasNext()) {
				mdLi.add(mdItr.next());
			}
				
			return mdLi;
	}


	@Override
	public Users getUserDetails(int id) {
		if(userRepo.findById(id).isPresent()) {
			return userRepo.findById(id).get();
		}
		return null;
	}


	@Override
	public Users updateUser(Users user) {	
		return userRepo.save(user);
	}



}