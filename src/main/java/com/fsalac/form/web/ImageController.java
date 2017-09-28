package com.fsalac.form.web;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fsalac.form.model.PosCustomer;
import com.fsalac.form.model.PosUser;

@Controller
@RequestMapping("/image")
public class ImageController extends BaseController{
	
	private static final Logger LOG = Logger.getLogger(ImageController.class);
	
	@RequestMapping(value = "/picture/{userId}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getThumbImage(@PathVariable long userId) {

		PosUser user = userService.findById(userId);
		byte[] byteArray = null;	
		
		try {
			if(user.getPicture() != null) {
				byteArray = user.getPicture();
				LOG.debug("Image Bytes: " + byteArray.length);
			}else{
				return new ResponseEntity<byte[]>(null, null, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		headers.setCacheControl("max-age=2592000");

		return new ResponseEntity<byte[]>(byteArray, headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/customers/{id}/{fileType}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getCustomerImage(@PathVariable long id, @PathVariable long fileType) {

		PosCustomer customer = customerService.findById(id);
		byte[] byteArray = null;

		if (fileType == 1) {
			byteArray = customer.getProfilePicture();
		} else {
			byteArray = customer.getSignature();
		}

		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_PNG);
		headers.setCacheControl("max-age=2592000");

		return new ResponseEntity<byte[]>(byteArray, headers, HttpStatus.CREATED);
	}
	
}
