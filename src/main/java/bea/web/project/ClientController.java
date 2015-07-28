package bea.web.project;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bea.web.model.Client;


@Controller
public class ClientController {

	//We  have passed a blank Client object with name "command" because
	//the spring framework expects an object with name "command" if
	//you are using <form:form> tags in yours JSP file. So when client()
	//method is called it returns client.jsp view
	@RequestMapping(value = "/client", method = RequestMethod.GET)
	public ModelAndView client(){
		return new ModelAndView("client","command",new Client());
	}

	@RequestMapping(value="/addClient", method=RequestMethod.POST)
	public String addClient(@ModelAttribute("SpringWeb") Client client,ModelMap model){
		model.addAttribute("name", client.getName());
	    model.addAttribute("age", client.getAge());
	    model.addAttribute("id", client.getId());
	      
	    return "result";
	}
	
}
