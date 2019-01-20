package ua.test.wicket.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ua.test.wicket.dao.UsersDao;
import ua.test.wicket.model.Users;

@Controller
public class ReadController {
	
	@Autowired
	private UsersDao userDao;
	
	@RequestMapping (value = "/read")
	public ModelAndView readUser (ModelAndView model) throws IOException {
		List<Users> listUser = userDao.read();
		
		model.addObject("listUser", listUser);
		model.setViewName("read");
		
		return model;
	}
}
