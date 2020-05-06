package net.codejava.client.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.codejava.client.dao.AppointmentDAO;
import net.codejava.client.dao.ClientDAO;
import net.codejava.client.model.Client;
import net.codejava.client.model.Appointment;

@Controller
public class MainController {
	
	@Autowired
	private ClientDAO clientDAO;
	private AppointmentDAO appointmentDAO;
	
	
	
	//********************* Client ***************************
	@RequestMapping(value = "/")
	public ModelAndView Home (ModelAndView model) {
		model.setViewName("index");
		
		
		return model;
	}
	
	@RequestMapping(value = "/home")
	public ModelAndView returnHome(ModelAndView model) {
		model.setViewName("index");
		
		
		return model;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newClient (ModelAndView model) {
		Client newClient = new Client();
		model.addObject("client", newClient);
		model.setViewName("client_form");
		
		
		return model;
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listClient (ModelAndView model) {
		List<Client>listClient = clientDAO.list();
		model.addObject("listClient", listClient);
		model.setViewName("client_list");
		
		
		return model;
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveClient (@ModelAttribute Client client) {
		if (client.getId() == null) {
			clientDAO.save(client);
		}else {
			clientDAO.update(client);
		}
		
		
		return new ModelAndView("redirect:/list");
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editClient(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Client client = clientDAO.get(id);
		ModelAndView model = new ModelAndView("client_form");
		model.addObject("client", client);
		
		
		return model;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteClient(@RequestParam Integer id) {
		clientDAO.delete(id);
		
		return new ModelAndView("redirect:/list");
	}
	
	
	//********************* Appointment *********************
		/*@RequestMapping(value = "/appointment")
		public ModelAndView appointment(ModelAndView model) {
			model.setViewName("appointment");
			
			
			return model;
		}
		*/
		@RequestMapping(value = "/newappointment", method = RequestMethod.GET)
		public ModelAndView newAppointment (ModelAndView model) {
			Appointment newAppointment = new Appointment();
			model.addObject("appointment", newAppointment);
			model.setViewName("appointment_form");
			
			
			return model;
		}
		
		@RequestMapping(value = "/appointmentlist", method = RequestMethod.GET)
		public ModelAndView listAppointment (ModelAndView model) {
			List<Appointment>listAppointment = appointmentDAO.list();
			model.addObject("listAppointment", listAppointment);
			model.setViewName("appointment_list");
			
			
			return model;
		}
		
		@RequestMapping(value = "/saveappointment", method = RequestMethod.POST)
		public ModelAndView saveAppointment (@ModelAttribute Appointment appointment) {
			if (appointment.getId() == null) {
				appointmentDAO.save(appointment);
			}else {
				appointmentDAO.update(appointment);
			}
			
			
			return new ModelAndView("redirect:/appointmentlist");
		}
		
		@RequestMapping(value = "/editappointment", method = RequestMethod.GET)
		public ModelAndView editAppointment(HttpServletRequest request) {
			Integer id = Integer.parseInt(request.getParameter("id"));
			Appointment appointment = appointmentDAO.get(id);
			ModelAndView model = new ModelAndView("appointment_form");
			model.addObject("appointment", appointment);
			
			
			return model;
		}
		
		@RequestMapping(value = "/deleteappointment", method = RequestMethod.GET)
		public ModelAndView deleteAppointment(@RequestParam Integer id) {
			appointmentDAO.delete(id);
			
			return new ModelAndView("redirect:/appointmentlist");
		}
		
	
	
}
