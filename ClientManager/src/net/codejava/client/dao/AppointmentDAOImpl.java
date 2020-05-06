package net.codejava.client.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import net.codejava.client.model.Appointment;
import net.codejava.client.model.Client;


public class AppointmentDAOImpl implements AppointmentDAO {

	private JdbcTemplate jdbcTemplate;
	
	public AppointmentDAOImpl(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	@Override
	public int save(Appointment a) {
		String sql = "INSERT INTO Appointments (client_name, type, date, time) VALUES (?,?,?,?)";
		return jdbcTemplate.update(sql, a.getName(), a.getType(), a.getDate(), a.getTime() );
	}

	@Override
	public int update(Appointment a) {
		String sql = "UPDATE Appointment SET client_name =?, type=?, date=?, time=? WHERE client_id=?";
		return jdbcTemplate.update(sql, a.getName(), a.getType(), a.getDate(), a.getTime(), a.getId() );
	}

	@Override
	public Appointment get(Integer id) {
String sql = "SELECT * FROM Appointment WHERE client_id=" + id;
		
		ResultSetExtractor<Appointment> extractor = new ResultSetExtractor<Appointment>() {
			@Override
			public Appointment extractData(ResultSet rs) throws SQLException, DataAccessException{
				if(rs.next()) {
					String name = rs.getString("client_name");
					String type = rs.getString("type");
					Date date = rs.getDate("date");
					Time time = rs.getTime("time");
					
					return new Appointment(id, name, type, date, time);
					
				}
				return null;
		
			}

		};
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM Appointment WHERE client_id=" + id;
		
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Appointment> list() {
String sql = "SELECT * FROM Appointment";
		
		RowMapper<Appointment> rowMapper = new RowMapper<Appointment>() {
			
			@Override
			public Appointment mapRow(ResultSet rs, int rowNum) throws SQLException {
			Integer id = rs.getInt("client_id");
			String name = rs.getString("client_name");
			String type = rs.getString("type");
			Date date = rs.getDate("date");
			Time time = rs.getTime("time");
			
			return new Appointment(id, name, type, date, time);
		}
	};
		return jdbcTemplate.query(sql, rowMapper);
		
	}
/*
 * put in client
 * search in client database 
 * after user selects client return id 
	@Override
	public List<Appointment> search(String name) {
		String sql = "SELECT client_id, name, email, phone FROM client WHERE name LIKE '% " + name + " %' ";
		
		RowMapper<Appointment> rowMapper = new RowMapper<Appointment>() {
			
			@Override
			public Appointment mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("client_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				
			return new Client(id, name, email, phone);
		}
	};
		return jdbcTemplate.query(sql, rowMapper);
		
	}
*/
//delete this after
	@Override
	public List<Appointment> search(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
