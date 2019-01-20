package ua.test.crud.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.test.crud.dao.UsersDao;
import ua.test.crud.model.Users;

@Controller
public class UpdateController {
	
	@Autowired
	private UsersDao userDao;
	
	@RequestMapping (value = "/update/{userId}")
	public ModelAndView findUserById (
			ModelAndView model,
			@PathVariable("userId") int userId
			) throws IOException {
		List<Users> user = userDao.findUserById(userId);
		model.addObject("listUser", user);
		model.setViewName("update");
		
		return model;
	}
	
	@RequestMapping (value = "/update", method = RequestMethod.POST)
	public ModelAndView updateUser (
			@RequestParam("id") int id,
			@RequestParam("name") String name,
			@RequestParam("pass") String pass,
			ModelAndView model
			) {
		Users user = new Users();
		user.setId(id);
		user.setName(name);
		user.setPass(pass);
		
		int counter = userDao.update(user);
		
		if (counter > 0) {
			model.addObject("msg", "User update successfully.");
		} else {
			model.addObject("msg", "User update failed");
		}

		model.setViewName("update");
		
		return model;
	}

}
