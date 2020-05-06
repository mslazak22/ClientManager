package net.codejava.client.dao;

import java.util.List;

import net.codejava.client.model.Client;

public interface ClientDAO {
	public int save(Client c);
	
	public int update(Client client);
	
	public Client get(Integer id);
	
	public int delete(Integer id);
	
	public List<Client> list();
	
}
