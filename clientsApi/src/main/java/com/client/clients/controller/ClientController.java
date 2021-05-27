package com.client.clients.controller;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.client.clients.model.ClientData;
import com.client.clients.model.Expenses;
import com.client.clients.repository.ClientRepository;


@RestController
public class ClientController {

	@Autowired
	public ClientRepository clientRepository;

	/**
	 * Create a User
	 * @param clients
	 * @return
	 */
	@PostMapping("/client")
	public ResponseEntity<ClientData> addNewClientData(@RequestBody ClientData clients) {
		ClientData savedData = clientRepository.save(clients);

		return new ResponseEntity<>(savedData, HttpStatus.CREATED);
	}

	/**
	 * Fetch client details using id
	 * @param clientId
	 * @return name of the client uisng ResponseEntity
	 */
	@GetMapping("/client/{clientId}")
	public ResponseEntity<ClientData> getClientDetailsById(@PathVariable int clientId) {
		Optional<ClientData> result = clientRepository.findById(clientId);
		ResponseEntity<ClientData> response = null;

		if (result.isPresent())
			response = new ResponseEntity<>(result.get(), HttpStatus.OK);
		else
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return response;
	}

	/**
	 * Fetch expenses of respective client
	 * @param clientId
	 * @return total of all the expenses of the client
	 */
	@GetMapping("/client/{clientId}/expenses/total")
	public int getClientExpenseDetailsById(@PathVariable int clientId) {
		String url = "http://localhost:9001/expense/client/" + clientId;
		RestTemplate restTemplate = new RestTemplate();
		int total = 0;
		try {

			ResponseEntity<Expenses[]> responseEntity = restTemplate.getForEntity(url, Expenses[].class);
			Expenses[] userArray = responseEntity.getBody();
			Arrays.stream(userArray).map(Expenses::getAmountSpent).collect(Collectors.toList());
			for (Expenses amount : userArray) {
				if (null != amount)
					total += amount.getAmountSpent();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return total;
	}

}
