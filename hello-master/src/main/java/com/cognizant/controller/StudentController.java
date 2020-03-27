package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.cognizant.model.Student;
import com.cognizant.service.StudentService;
import com.cognizant.service.StudentServiceImpl;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService=new StudentServiceImpl();

	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("display");

		List<Student> list = studentService.findAll();

		mv.addObject("list", list);

		return mv;

	}
	@RequestMapping(value="create",method=RequestMethod.GET)
	 public ModelAndView createpage() {
		 ModelAndView mv=new ModelAndView("create");
		 Student student=new Student();
		 mv.addObject("student",student);
		 return mv;
	}
	@RequestMapping(value="create",method=RequestMethod.POST)
	 public ModelAndView insert(@ModelAttribute("student") Student student ) {
		 System.out.println("Model Attribute:"+student);
		 ModelAndView mv = new ModelAndView("create");
		 int res=studentService.create(student);
			if(res==1)
			  mv.addObject("msg","Success");
			else
				mv.addObject("msg","Fail");
			return mv;
	}
	@RequestMapping(value="update",method=RequestMethod.GET)
	 public ModelAndView updatepage() {
		 ModelAndView mv=new ModelAndView("update");
		 Student student=new Student();
		 mv.addObject("student",student);
		 return mv;
	}
	@RequestMapping(value="update",method=RequestMethod.POST)
	 public ModelAndView update(@ModelAttribute("student") Student student ) {
		 System.out.println("Model Attribute:"+student);
		 ModelAndView mv = new ModelAndView("update");
		 int res=studentService.update(student);
			if(res>0)
			  mv.addObject("msg","Success");
			else
				mv.addObject("msg","Fail");
			return mv;
	}
	@RequestMapping(value="delete",method=RequestMethod.GET)
	 public ModelAndView deletepage() {
		 ModelAndView mv=new ModelAndView("delete");
		 Student student=new Student();
		 mv.addObject("student",student);
		 return mv;
	}
	@RequestMapping(value="delete",method=RequestMethod.POST)
	 public ModelAndView delete(@ModelAttribute("student") Student student ) {
		 System.out.println("Model Attribute:"+student);
		 ModelAndView mv = new ModelAndView("delete");
		 int res=studentService.delete(student.getId());
			if(res>0)
			  mv.addObject("msg","Success");
			else
				mv.addObject("msg","Fail");
			return mv;
	}
	@RequestMapping(value="countStudent",method=RequestMethod.GET)
	 public ModelAndView countpage() {
		 ModelAndView mv=new ModelAndView("countStudent");
		 int result=studentService.countStudent();
		 mv.addObject("msg",result);
		 return mv;
	}
	@RequestMapping(value="find",method=RequestMethod.GET)
	 public ModelAndView findpage() {
		 ModelAndView mv=new ModelAndView("find");
		 Student student=new Student();
		 mv.addObject("student",student);
		 return mv;
	}
	@RequestMapping(value="find",method=RequestMethod.POST)
	 public ModelAndView find(@ModelAttribute("student") Student student ) {
		 System.out.println("Model Attribute:"+student);
		 List<Student> list=studentService.findByName(student);
		 ModelAndView mv = new ModelAndView("display");
			mv.addObject("list",list);
			return mv;
	}

}
