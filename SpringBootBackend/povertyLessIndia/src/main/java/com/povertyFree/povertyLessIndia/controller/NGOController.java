package com.povertyFree.povertyLessIndia.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.povertyFree.povertyLessIndia.Repository.NGORepo;
import com.povertyFree.povertyLessIndia.Service.EmailService;
import com.povertyFree.povertyLessIndia.Service.EmailServiceImle;
import com.povertyFree.povertyLessIndia.Service.NGOService;
import com.povertyFree.povertyLessIndia.dto.MaterialDonation;
import com.povertyFree.povertyLessIndia.dto.Message;
import com.povertyFree.povertyLessIndia.dto.NGO;
import com.povertyFree.povertyLessIndia.dto.RegisterNewNGO;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class NGOController {

	@Autowired
	NGOService ngoService;
	
	@Autowired
	EmailService emailServ;
	
	
	@PostMapping(value = "registerNGO")
	public Message registerNGO(@RequestBody RegisterNewNGO ngo) {
			System.out.println(ngo);
			
			if(ngoService.registerNGO(ngo)) {
				return new Message("Registration Succesfully", true);
			}
			
			return new Message("Registration Unsuccesfully", false);
	}
	
	@PostMapping(value = "NGOlogin")
	public Message validateNGO(@RequestBody NGO ngo) {
			//System.out.println(ngo);
			NGO ngo1 = ngoService.checkNGO(ngo);
			System.out.println(ngo1);
			if(ngo1 != null ) {
				System.out.println("NGO Logged In");
				return new Message("Login Succesfully", true, ngo1);
			}
			
			return new Message("Invalid Credentials", false);
	}
	
	@GetMapping(value = "ngoacceptDonation")
	public Message acceptDonationNGO(@RequestParam("donateid") String donateId, @RequestParam("ngoId") String ngoId) {
			System.out.println(ngoId +  " " +donateId );
			
			if(ngoService.donationAccept(Integer.parseInt(donateId),Integer.parseInt(ngoId)) != null) {
				return new Message("NGO Accepted Donation Succesfully", true);
			}
			
			return new Message("Donation Acception Unsuccesful", false);
	}
	
	@PostMapping(value = "verifyEmailNGO")
	public Message emailVerifivation(@RequestBody String email) {
			System.out.println(email);
			NGO ngo1 = ngoService.checkNGOEmail(email);
		
		if(ngo1 != null) {
			return new Message("Email already Exists!!! ", false);
		}
		else {
			 try {
        		 int n = 10000 + new Random().nextInt(90000);
        		 
        		 System.out.println(n);        		  
        		
        		 emailServ.sendEmail(email,n);
       	      return new Message(String.valueOf(n),true);
       	    } catch( MailException e){
       	    	
       	    	return new Message("Email Cannot be verified!!!", false);
       	    }
		}
		
			
	}
	
	
	@PostMapping(value = "forgotPasswordNGO")
	public Message forgotPasswordNGO(@RequestBody String email) {
		System.out.println(email);
		NGO ngo = ngoService.checkNGOEmail(email);
		if(ngo == null) {
			return new Message("Email doesn't Exists!!! ", false);
		}
		else {
			try {
       		    		  
       		
       		 emailServ.sendEmailandPassword(ngo.getEmail(),ngo.getPassword());
      	      return new Message("Password send to Email",true);
      	    } catch( MailException e){      	    	
      	    	return new Message("OOps problem occcur try again later!!!", false);
      	    }
		}
	}
	
	@GetMapping(value = "getnotificationNGO")
	public List<MaterialDonation> notificationNGO(@RequestParam int id,HttpServletRequest request) {
		System.out.println("hisldifjj ;lasdkf"+ id);
		NGO ngo = new NGO(id);
		NGO n1 = ngoService.getNGO(ngo);
		
		List<MaterialDonation> md = ngoService.getNGONotification(n1.getCity(), "pending");
		
			for (MaterialDonation materialDonation : md) {
			
			//reading the project's deployed folder location
			//TODO: move all this logic in ProfilePicService class
			String projPath = request.getServletContext().getRealPath("/");
			System.out.println(projPath);
			
			String downloadPath = projPath + "/downloads/";
			//String downloadPath = projPath + "\\downloads\\";
			File f = new File(downloadPath);
			if(!f.exists())
				f.mkdir();
			
			//the original location where the images are present
			
			String uploadedPath = "/home/ec2-user/images/";
			//String uploadedPath = "C:\\Users\\shri\\Desktop\\FinalProject\\FinalProjectImagesUploads\\images\\";//"d:/uploads/";
			String uploadedFileName = materialDonation.getuImage();
			
			String sourceFile = uploadedPath + uploadedFileName;
			String destinationFile = downloadPath + uploadedFileName;
			try {
				FileCopyUtils.copy(new File(sourceFile), new File(destinationFile));
			}
			catch(IOException e) {
				e.printStackTrace(); //rather we should throw proper exception
			}
		}
		return md;

	}
	
	
	@GetMapping(value = "getNGOAcceptedDonation")
	public List<MaterialDonation> getNGOAcceptedDonation(@RequestParam("ngoId") String id,HttpServletRequest request) {
		System.out.println("hisldifjj ;lasdkf"+ id);
		NGO ngo = new NGO(Integer.parseInt(id));
		NGO n1 = ngoService.getNGO(ngo);
		
		List<MaterialDonation> md = ngoService.getNGOAcceptedDonation(ngo);
		
			for (MaterialDonation materialDonation : md) {
			
			//reading the project's deployed folder location
			//TODO: move all this logic in ProfilePicService class
			String projPath = request.getServletContext().getRealPath("/");
			System.out.println(projPath);
			
			String downloadPath = projPath + "/downloads/";
			//String downloadPath = projPath + "\\downloads\\";
			File f = new File(downloadPath);
			if(!f.exists())
				f.mkdir();
			
			//the original location where the images are present
			
			String uploadedPath = "/home/ec2-user/images/";
			//String uploadedPath = "C:\\Users\\shri\\Desktop\\FinalProject\\FinalProjectImagesUploads\\images\\"; //"d:/uploads/";
			String uploadedFileName = materialDonation.getuImage();
			
			String sourceFile = uploadedPath + uploadedFileName;
			String destinationFile = downloadPath + uploadedFileName;
			
			try {
				FileCopyUtils.copy(new File(sourceFile), new File(destinationFile));
			}
			catch(IOException e) {
				e.printStackTrace(); //rather we should throw proper exception
			}
			
		}
		return md;

	}
	
	@PostMapping(value="uploadImageNGO")  
    public Message uploadImageNGO(@RequestParam("id") String id, @RequestParam MultipartFile file, HttpServletRequest request, 
           HttpSession session) throws Exception{ 
		System.out.println(id);
		System.out.println("Server File Location= ++++++++++++");
		byte[] bytes = file.getBytes();
		
		 String fileName = file.getOriginalFilename();
		 //session.setAttribute("img", fileName);
		String rootPath1 = request.getServletContext().getRealPath("/");
		System.out.println(rootPath1);
		 
		String rootPath = "/home/ec2-user";
		//String rootPath = "C:\\Users\\shri\\Desktop\\FinalProject\\FinalProjectImagesUploads";
		File dir = new File(rootPath + File.separator + "images");
		if (!dir.exists())
			dir.mkdirs();
	//System.out.println("root Path : "+ rootPath+"\nabs path : "+dir.getAbsolutePath()+"\nFile sp : "+File.separator+" \n file name : "+ fileName );
	String filePath = dir.getAbsolutePath()+ File.separator +id+fileName;
	
	System.out.println("Server File Location= "+ filePath );
	File serverFile = new File(filePath);
			
	BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
	stream.write(bytes);
	stream.close();
	
	
		if(ngoService.uploadImageNGO(id+fileName,Integer.parseInt(id)) != null) {
			return new Message("Photo Uploaded Successfully", true); 
		}
	
		return new Message("Error while Uploading Photo", false);
    }
	
	@GetMapping( value = "getNGODonationHistory")
	public List<MaterialDonation> getUserDonationHistory(@RequestParam int id, HttpServletRequest request){
		List<MaterialDonation> md = ngoService.getNGODonationHistory(id);
		for (MaterialDonation materialDonation : md) {
			
			//reading the project's deployed folder location
			//TODO: move all this logic in ProfilePicService class
			String projPath = request.getServletContext().getRealPath("/");
			System.out.println(projPath);
			
			String downloadPath = projPath + "/downloads/";
			//String downloadPath = projPath + "\\downloads\\";
			File f = new File(downloadPath);
			if(!f.exists())
				f.mkdir();
			
			//the original location where the images are present
			
			String uploadedPath = "/home/ec2-user/images/";
			//String uploadedPath = "C:\\Users\\shri\\Desktop\\FinalProject\\FinalProjectImagesUploads\\images\\";//"d:/uploads/";
			String uploadedFileName = materialDonation.getuImage();
			String uploadedFileProofNGO = materialDonation.getProof();
			
			String sourceFile = uploadedPath + uploadedFileName;
			String destinationFile = downloadPath + uploadedFileName;
			
			String sourceFileProof = uploadedPath + uploadedFileProofNGO;
			String destinationFileProof = downloadPath + uploadedFileProofNGO;
			
			try {
				FileCopyUtils.copy(new File(sourceFile), new File(destinationFile));
				FileCopyUtils.copy(new File(sourceFileProof), new File(destinationFileProof));
			}
			catch(IOException e) {
				e.printStackTrace(); //rather we should throw proper exception
			}
		}
		return md;
	}
	
	
	
}