package com.client.clients.ClientRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.client.clients.repository.ClientRepository;

@DataJpaTest
//@RunWith(SpringRunner.class)
 class ClientRepositoryTest {


	@Autowired
	ClientRepository clientRepository;

	@Test
	void check_todo_count() {
		assertEquals(3, clientRepository.count());
	}
	 
}