package com.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.models.Mailbox;

public interface MailboxRepository extends JpaRepository<Mailbox, Integer>{

}
