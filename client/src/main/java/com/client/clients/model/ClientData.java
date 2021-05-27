package com.client.clients.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class ClientData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int clientId;
	
	private String name;
	
	private String emailId;
	
	public ClientData() {

	}
	/**
	 * Value Assignment constructor
	 * @param clientId
	 * @param name
	 */
	public ClientData(int clientId, String name) {
		super();
		this.clientId = clientId;
		this.name = name;
	}
	
	/**
	 * Getters and Setters for Client POJO
	 * @return
	 */

	public int getClientId() {
		return clientId;
	}
	
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


}
