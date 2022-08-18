package com.scs.dsclient.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scs.dsclient.DTO.ClientDTO;
import com.scs.dsclient.entities.Client;
import com.scs.dsclient.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

	public List<ClientDTO> findAll() {
		List<Client> list = clientRepository.findAll(); 
		List<ClientDTO> listDTO =  list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());

		return listDTO;
	}
	
	
	

}
