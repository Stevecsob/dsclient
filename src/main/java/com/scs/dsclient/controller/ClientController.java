package com.scs.dsclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scs.dsclient.DTO.ClientDTO;
import com.scs.dsclient.service.ClientService;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

	@Autowired
	private ClientService clientService;

	
	@GetMapping
	public List<ClientDTO> findAll() {
		return clientService.findAll();
	}
	

}
