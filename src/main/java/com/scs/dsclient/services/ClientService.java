package com.scs.dsclient.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scs.dsclient.services.exceptions.ResourceNotFoundException;
import com.scs.dsclient.DTO.ClientDTO;
import com.scs.dsclient.entities.Client;
import com.scs.dsclient.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

	public List<ClientDTO> findAll() {
		List<Client> list = clientRepository.findAll(); 
		return ClientDTO.listConvert(list);
	}
	
	
	@Transactional(readOnly = true)
    public ClientDTO findById(Long id) {
        Optional<Client> obj = clientRepository.findById(id);
        Client entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new ClientDTO(entity);
	}
}
