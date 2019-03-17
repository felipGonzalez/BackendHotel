package com.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.models.Mailbox;
import com.hotel.repository.MailboxRepository;

@Service
public class MailboxService {
	
	@Autowired
	private MailboxRepository mailboxRepository;

	
	public List<Mailbox> getAll() {
		return mailboxRepository.findAll();
	}

	public void save(Mailbox mailbox) {
		mailboxRepository.save(mailbox);
	}

	public void remove(Integer id) {
		mailboxRepository.deleteById(id);
	}
	
}
