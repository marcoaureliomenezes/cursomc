package com.marcomenezes.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.marcomenezes.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
}

