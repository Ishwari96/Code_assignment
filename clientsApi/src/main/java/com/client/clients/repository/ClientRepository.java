package com.client.clients.repository;

import com.client.clients.model.ClientData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientData, Integer>{

}
