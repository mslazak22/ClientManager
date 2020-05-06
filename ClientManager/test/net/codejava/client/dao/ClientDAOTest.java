package net.codejava.client.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import net.codejava.client.model.Client;

class ClientDAOTest {

	private DriverManagerDataSource dataSource;
	private ClientDAO dao;
	
	@BeforeEach
	void setupBeforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/clientsdb");
		dataSource.setUsername("root");
		dataSource.setPassword("18014aa09c");
		
		dao = new ClientDAOImpl(dataSource);
	}
	@Test
	void testSave() {

		Client client = new Client("Matt Slazak","m_slazak@abc.com","3471234567"); 
		int result = dao.save(client);
		
		assertTrue(result > 0);
	}
	

	@Test
	void testUpdate() {
		Client client = new Client(2,"Micheal Scott","dunder@abc.com","3471234567");
		int result = dao.update(client);
		
		assertTrue(result >0);
	}

	@Test
	void testGet() {
		Integer id = 1;
		Client client = dao.get(id);
		if (client != null) {
			System.out.println(client);
		}
		
		assertNotNull(client);
	}

	@Test
	void testDelete() {
		Integer id = 5;
		int result = dao.delete(id);
		
		assertTrue(result > 0);
	}

	@Test
	void testList() {
		List<Client> listClients = dao.list();
		
		for (Client aClient : listClients) {
			System.out.println(aClient);
		}
		assertTrue(!listClients.isEmpty());
	}

}
