package com.povertyFree.povertyLessIndia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.povertyFree.povertyLessIndia.Service.AdminService;
import com.povertyFree.povertyLessIndia.dto.Admins;
import com.povertyFree.povertyLessIndia.dto.Cities;
import com.povertyFree.povertyLessIndia.dto.MaterialDonation;
import com.povertyFree.povertyLessIndia.dto.Message;
import com.povertyFree.povertyLessIndia.dto.NGO;
import com.povertyFree.povertyLessIndia.dto.Users;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController {

	@Autowired 
	AdminService adminService;
	
	@PostMapping(value = "loginAdminValidate")
	public Message validateAdmin(@RequestBody Admins admin) {
			Admins admin1 = adminService.checkAdmin(admin);
			System.out.println(admin1);
			if(admin1 != null ) {
				System.out.println(admin1);
				Message m1= new Message("Login Succesfully", true,admin1);
				System.out.println(m1);
				return m1;
			}
			
			return new Message("Invalid Credentials", false);
	}
	
	@GetMapping(value = "getCityList" )
	public List<Cities> getcities() {
			//System.out.println(id);
			
			return adminService.getAllCities();
	}
	
	@GetMapping(value = "getMaterialDonationList")
	public List<MaterialDonation> getMaterialDonationList(){
		
			return adminService.getAllMaterialDonationList();
	}
	
	@GetMapping(value = "getAllNGOList")
	public List<NGO> getAllNGOList(){
		
			return adminService.getAllNGOList();
	}
	
	@GetMapping(value = "getAllUsersList")
	public List<Users> getAllUsersList(){
		
			return adminService.getAllUsersList();
	}
	
	@GetMapping(value = "abortMaterialDonation")
	public Message abortMaterialDonation(@RequestParam int id){
		
			if(adminService.abortMaterialDonation(id)) {
				return new Message("Material Donation Aborted", true);
			}
			return new Message("Fail to Abort Donated Status", false);
	}
	
	@GetMapping(value = "deleteMaterialDonation")
	public Message deleteMaterialDonation(@RequestParam int id){
		
			try {
				if(adminService.deleteMaterialDonation(id)) {
					return new Message("Material Donation Record Deleted", true);
				}
			} catch (Exception e) {
				
				e.printStackTrace();			
			}
			return new Message("Fail to Delete Record", false);
	}	
}
