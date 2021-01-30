package com.povertyFree.povertyLessIndia.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.mail.MailException;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.povertyFree.povertyLessIndia.Service.EmailService;
import com.povertyFree.povertyLessIndia.Service.UserService;
import com.povertyFree.povertyLessIndia.dto.Cities;
import com.povertyFree.povertyLessIndia.dto.MaterialDonation;
import com.povertyFree.povertyLessIndia.dto.Message;
import com.povertyFree.povertyLessIndia.dto.NGO;
import com.povertyFree.povertyLessIndia.dto.States;
import com.povertyFree.povertyLessIndia.dto.Users;
import com.povertyFree.povertyLessIndia.dto.Users;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	EmailService emailServ;
		
	@PostMapping(value = "registerUser")
	public Message index(@RequestBody Users user) {
			System.out.println(user);
			if(userService.AddUser(user)) {
				return new Message("User Registered", true);
			}
			
			return new Message("User Already Registered", false);
	}
	
	@PostMapping(value = "UserValidate")
	public Message userValidate(@RequestBody Users user) {
			System.out.println(user);
			Users user1 = userService.UserValidate(user);
			
			
			if(user1 != null) {
				user1.setPassword("");
				return new Message("User Validated", true, user1);
			}
			else 
			return new Message("Invalid Credentials", false);
			
	}
	
	@GetMapping( value = "getUserDetails")
	public Message getUserDetails(@RequestParam int id) {
		Users user = userService.getUserDetails(id);
		if(user != null) {
			return new Message("User Present", true, user);
		}
		return new Message("oOps Problem occured",false);
	}
	

	@PostMapping(value = "updateUserDetails")
	public Message updateUserDetails(@RequestBody Users user){
		Users user1 = userService.updateUser(user);
		if(user1 != null) {
			return new Message("User Present", true);
		}
		return new Message("oOps Problem occured",false);
	}
	
	@PostMapping(value = "verifyEmailUser")
	public Message verifyUserEmail(@RequestBody String email) {
		System.out.println(email);
		Users user= userService.userEmailCheckAlreadyPresent(email);
		
		if(user != null) {
			return new Message("Email Already Exists Try another!!! ", false);
		}
		else {
			try {
				int n = 10000 + new Random().nextInt(90000);        		 
        		 System.out.println(n);   		  
        		 emailServ.sendEmail(email,n);
        		 return new Message(String.valueOf(n),true);
        		 
      	    } catch( MailException e){
      	    	
      	    	return new Message("OOps problem occcur try again later!!!", false);
      	    }
		}
		
	}
		
	@PostMapping(value = "forgotPasswordUser")
	public Message forgotUserPassword(@RequestBody String email) {
		System.out.println(email);
		Users user = userService.userEmailCheckAlreadyPresent(email);
		if(user == null) {
			return new Message("Email doesn't Exists!!! ", false);
		}
		else {
			try {
       		    		  
       		
       		 emailServ.sendEmailandPassword(user.getEmail(),user.getPassword());
      	      return new Message("Password send to Email",true);
      	    } catch( MailException e){
      	    	
      	    	return new Message("OOps problem occcur try again later!!!", false);
      	    }
		}
	}
	
	@PostMapping(value = "sendMessageContactUs")
	public Message sendMessageContactUs(@RequestBody Users user) {
		System.out.println(user);
		
			try {
       		  emailServ.sendMessageContactUs(user);
      	      return new Message("Thank You For Contacting Us",true);
      	    } catch( MailException e){
      	    	
      	    	return new Message("OOps problem occcur try again later!!!", false);
      	    }
		
	}
	
		
	@GetMapping(value = "getAllCitiesForState" )
	public List<Cities> getListCitites(@RequestParam int id) {
			System.out.println(id);
			
			return userService.getCitites(id);
	}
	
	@GetMapping(value = "getAllStates" )
	public List<States> getListStates() {
			//System.out.println(id);
			
			return userService.getAllStates();
	}
	
	
	@PostMapping(value = "addMaterialDonation")
	public Message addMaterialDonation(@RequestBody MaterialDonation mDonation) {
		
		System.out.println(mDonation);
		MaterialDonation md = userService.addMaterialDonation(mDonation);
			if(md != null) {
				return new Message("Material Added Successfully", true, md);
			}
			return new Message("Cannot Add Donation", false);
	}
	
	@PostMapping(value="UploadUImage")  
    public Message saveimage(@RequestParam("id") String id, @RequestParam MultipartFile file, HttpServletRequest request, 
           HttpSession session) throws Exception{ 
		System.out.println(id);
		System.out.println("Server File Location= ++++++++++++");
		byte[] bytes = file.getBytes();
		
		 String fileName = file.getOriginalFilename();
		 //session.setAttribute("img", fileName);
		String rootPath1 = request.getServletContext().getRealPath("/");
		System.out.println(rootPath1);
		 
		String rootPath = "/home/ec2-user";
		//String rootPath = "C:\\Users\\shri\\Desktop\\FinalProject\\FinalProjectImagesUploads";/home/adinath/uploads
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
	
	
	if(userService.uploadImage(id+fileName,Integer.parseInt(id)) != null) {
		return new Message("Photo Uploaded Successfully", true); 
	}
	
		return new Message("Error while Uploading Photo", false);
    }
	
	
//	@PostMapping(value="UploadUImage12")
//	public Message uploadImages(@RequestParam("id") String id, @RequestParam MultipartFile file, HttpServletRequest request, 
//	           HttpSession session) throws Exception {
//		System.out.println(id);
//		MaterialDonation materialDonate = new MaterialDonation(Integer.parseInt(id)); 		
//		String imageUploadLocation = "C:\\Users\\shri\\Desktop\\FinalProject\\FinalProjectImagesUploads"; // "/Volumes/BigSur/users/majrul/Documents/uploads/";
//		String uploadedFileName = file.getOriginalFilename();
//		String targetFileName = id + "-" + uploadedFileName;
//		String finalTargetLocation = imageUploadLocation + targetFileName;
//		try {
//			FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(finalTargetLocation));
//		}
//		catch(IOException e) {
//			e.printStackTrace(); //rather we should throw CustomerServiceException
//		}
//		
//		materialDonate.setuImage(targetFileName);
//		if(userService.uploadImage(materialDonate) != null) {
//			return new Message("Photo Uploaded Successfully", true); 
//		}
//		
//			return new Message("Error while Uploading Photo", false);
//}
//	
//		

	
	@GetMapping(value = "getUserDonationStatus" )
	public List<MaterialDonation> getUserDonationStatus(@RequestParam int id, HttpServletRequest request) {
	
		List<MaterialDonation> md = userService.getUserDonationStatus(id);
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
	
	@GetMapping( value = "getUserDonationHistory")
	public List<MaterialDonation> getUserDonationHistory(@RequestParam int id, HttpServletRequest request){
		List<MaterialDonation> md = userService.getUserDonationHistory(id);
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
	
	
	
	
	
	
	
//	
//	@GetMapping(value = "/sid", produces = MediaType.IMAGE_JPEG_VALUE)
//    public void getImage(@RequestParam("id") String id, HttpServletResponse response) throws IOException {
//			System.out.println(id);
//       // var imgFile = new ClassPathResource("/home/uploads/images/"+id);
//        var imgFile = new ClassPathResource("C:\\Users\\shri\\Desktop\\FinalProject\\FinalProjectImagesUploads\\images\\"+id);
//        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
//        StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
//    }
//	
//	@GetMapping( value = "profile")
//	public void profile(@RequestParam("id") String id, HttpServletRequest request) {
//		
//		
//		//reading the project's deployed folder location
//		//TODO: move all this logic in ProfilePicService class
//		String projPath = request.getServletContext().getRealPath("/");
//		
//		//String downloadPath = projPath + "\\downloads\\";
//		String downloadPath = projPath + "/downloads/";
//		File f = new File(downloadPath);
//		if(!f.exists())
//			f.mkdir();
//		
//		//the original location where the images are present
//		String uploadedPath = "/home/adinath/uploads/images/";
//		//String uploadedPath = "C:\\Users\\shri\\Desktop\\FinalProject\\FinalProjectImagesUploads\\images\\";//"d:/uploads/";
//		String uploadedFileName = id;
//		
//		String sourceFile = uploadedPath + uploadedFileName;
//		String destinationFile = downloadPath + uploadedFileName;
//		try {
//			FileCopyUtils.copy(new File(sourceFile), new File(destinationFile));
//		}
//		catch(IOException e) {
//			e.printStackTrace(); //rather we should throw proper exception
//		}
//		
//		
//	}
//	
	
	
	
	
	
	@PostMapping(value= "checkDecryption")
	public String checkDecryt(@RequestBody Users user) {
//		Crypto _c = new Crypto();  
//		Crypto.AES aes = _c .new AES();  
//		  
//		int keySizeInBits = 128;                                       
//		int keySizeInBytes = keySizeInBits/8;    
//		  
//		// Derive a cryptographic key: PBKDF2  
//		String salt = Utils.byteArrayToHexString(Utils.getRandomBytes(8));  
//		String key = Utils.pbkdf2("Secret Passphrase", salt, 1000, keySizeInBytes);  
//		  
//		// generate IV  
//		byte[] ivBytes = aes.generateIV();  
//		aes.setIV(ivBytes);  
//		  
//		/*** encrypt */    
//		String ciphertext = aes.encrypt("plaintext", key);  
//		  
//		/*** decrypt */    
//		String plaintext = aes.decrypt(ciphertext, key); 
		return "";
	}
	
	
	
	

	@DeleteMapping(value = "deleteUser/{id}")
	public Message deleteUser(@PathVariable int id) {
			System.out.println(id);
			userService.deleteUser(id);
			return new Message("Record Removed",true);
	}
	
	@GetMapping(value = "display" )
	public List<Users> getUsers() {
			//System.out.println(id);
			
			return userService.getAllUsers();
	}
	
	
	
}
