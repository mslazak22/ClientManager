package net.codejava.client.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import net.codejava.client.model.Client;

public class ClientDAOImpl implements ClientDAO {

	private JdbcTemplate jdbcTemplate;
	
	public ClientDAOImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	@Override
	public int save(Client c) {
		String sql = "INSERT INTO Client (name, email, phone) VALUES (?,?,?)";
		return jdbcTemplate.update(sql, c.getName(), c.getEmail(), c.getPhone() );
		
	}

	@Override
	public int update(Client c) {
		String sql = "UPDATE Client SET name=?, email=?, phone=? WHERE client_id=?";
		return jdbcTemplate.update(sql, c.getName(), c.getEmail(), c.getPhone(), c.getId() );
	}

	@Override
	public Client get(Integer id) {
		String sql = "SELECT * FROM Client WHERE client_id=" + id;
		
		ResultSetExtractor<Client> extractor = new ResultSetExtractor<Client>() {
			@Override
			public Client extractData(ResultSet rs) throws SQLException, DataAccessException{
				if(rs.next()) {
					String name = rs.getString("name");
					String email = rs.getString("email");
					String phone = rs.getString("phone");
					
					return new Client(id, name, email, phone);
					
				}
				return null;
		
			}

		};
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM Client WHERE client_id=" + id;
		
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Client> list() {
		String sql = "SELECT * FROM Client";
		
		RowMapper<Client> rowMapper = new RowMapper<Client>() {
			
			@Override
			public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
			Integer id = rs.getInt("client_id");
			String name = rs.getString("name");
			String email = rs.getString("email");
			String phone = rs.getString("phone");
			
			return new Client(id, name, email, phone);
		}
	};
		return jdbcTemplate.query(sql, rowMapper);
		
	}
	



}
