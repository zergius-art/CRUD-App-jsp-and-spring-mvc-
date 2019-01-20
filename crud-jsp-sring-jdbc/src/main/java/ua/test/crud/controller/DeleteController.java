package ua.test.crud.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ua.test.crud.dao.UsersDao;

@Controller
public class DeleteController {
	
	@Autowired
	private UsersDao userDao;
	
	@RequestMapping (value = "/delete/{userId}")
	public ModelAndView deleteStudentById (
			ModelAndView model,
			@PathVariable("userId") int userId
			) throws IOException {
		int counter = userDao.delete(userId);
		
		if (counter > 0) {
			model.addObject("msg", "User deleted succefully");
		} else {
			model.addObject("msg", "User delete failed");
		}
		
		model.setViewName("delete");
		
		return model;
	}
}
