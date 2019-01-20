package ua.test.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.test.crud.dao.UsersDao;
import ua.test.crud.model.Users;

@Controller
public class CreateController {
	
	@Autowired
	private UsersDao userDao;
	
	@RequestMapping (value = "/create", method = RequestMethod.POST)
	public ModelAndView createUser (
			@RequestParam("name") String name, 
			@RequestParam("pass") String pass,
			ModelAndView model
			) {
		Users user = new Users();
		user.setName(name);
		user.setPass(pass);
		
		int counter = userDao.create(user);
		
		if (counter > 0) {
			model.addObject("msg", "User registration successfully.");
		} else {
			model.addObject("msg", "User registration failed");
		}

		model.setViewName("create");
		
		return model;
	}
}
