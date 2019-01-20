package ua.test.wicket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.test.wicket.dao.UsersDao;
import ua.test.wicket.model.Users;

@Controller
public class LoginController {
	
	@Autowired
	private UsersDao userDao;
	
	@RequestMapping (value = "/login", method = RequestMethod.POST)
	public ModelAndView userLogin (
			@RequestParam("name") String name,
			@RequestParam("pass") String pass
			) {
		ModelAndView model = new ModelAndView();
		Users user = new Users();
		user.setName(name);
		user.setPass(pass);
		
		String userName = userDao.login(user);
		if (userName != null) {
			//model.addObject("msg", "Welcome, " + userName + ". Your pass is correct");
			model.setViewName("redirect:read");
		} else {
			model.addObject("msg", "Sorry, wrong User of Password");
			model.setViewName("login");
		}
		
		return model;
	}
}
 