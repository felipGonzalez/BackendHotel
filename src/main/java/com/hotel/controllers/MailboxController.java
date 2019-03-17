package com.hotel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.models.Mailbox;
import com.hotel.service.MailboxService;
import com.hotel.util.Const;
import com.hotel.util.RestResponse;

@RestController
@RequestMapping("/listMailbox")
@CrossOrigin(origins = {Const.DOMAIN,Const.DOMAIN2,Const.DOMAIN3})
public class MailboxController {

	@Autowired
	private MailboxService mailboxService;

	public  MailboxController() {
	}

	@GetMapping(value="")
	public List<Mailbox> getList(){
		return mailboxService.getAll();
	}

	//agregar producto
	@PostMapping(value="")
	public RestResponse createProduct(@RequestBody Mailbox mailbox) {
		mailboxService.save(mailbox);
		return new RestResponse(HttpStatus.OK.value(), "Operacion exitosa");
	}

	
}
