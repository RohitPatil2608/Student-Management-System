package com.jspiders.student_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jspiders.student_management_system.pojo.AdminPOJO;
import com.jspiders.student_management_system.pojo.StudentPOJO;
import com.jspiders.student_management_system.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;

	//.................................home page controller...................................
	// Home controller
		@GetMapping("/home")
		public String home(@SessionAttribute(name = "login", required = false)AdminPOJO admin, ModelMap map) {
			if (admin != null) {
				return "HomePage";
			}
			map.addAttribute("msg", "Please login first...!!!");
			return "LoginPage";
		}
		
//********************************************************************************************************************************************************************
//********************************************************************************************************************************************************************
		
	// ..................................add form controller.......................................
	@GetMapping("/add")
	public String addPage(ModelMap map,@SessionAttribute(name = "login", required = false)AdminPOJO admin) {
		if(admin!=null) {
			return "AddStudent";
		}
		map.addAttribute("msg", "Please login first...!!!");
		return "LoginPage";
	}

	//.....................................add data controller.........................................
	@PostMapping("/add")
	public String AddStudent(@RequestParam String name, @RequestParam String email, @RequestParam long mobile,@RequestParam String address, ModelMap map,@SessionAttribute(name = "login", required = false)AdminPOJO admin) {
		if(admin !=null) {
			StudentPOJO pojo = service.addStudent(name, email, mobile, address);

			// Success case:
			if (pojo != null) {
				map.addAttribute("msg", "Data inserted successfully...!!!");
				return "AddStudent";
			}
			// Failure case:
			map.addAttribute("msg", "Data not inserted...!!!");
			return "AddStudent";
		}
		map.addAttribute("msg", "Please login first...!!!");
		return "LoginPage";
	}

//********************************************************************************************************************************************************************
//********************************************************************************************************************************************************************
	
	//...................................search page controller.............................................
	@GetMapping("/search")
	public String searchPage(ModelMap map,@SessionAttribute(name = "login", required = false)AdminPOJO admin) {
		if(admin !=null) {
			return "SearchStudent";
		}
		map.addAttribute("msg", "Please login first...!!!");
		return "LoginPage";
	}

	//....................................search data controller............................................
	@PostMapping("/search")
	public String searchStudent(@RequestParam int id, ModelMap map,@SessionAttribute(name = "login", required = false)AdminPOJO admin) {
		if(admin!=null) {
			StudentPOJO pojo = service.searchStudent(id);
			
			//success case
			if(pojo!=null) {
				map.addAttribute("student", pojo);
				map.addAttribute("msg", "Student record found...!!!");
				return "SearchStudent";
			}
			
			// failure case
			map.addAttribute("msg", "Student record doesn't found...!!!");
			return "SearchStudent";
		}
		map.addAttribute("msg", "Please login first...!!!");
		return "LoginPage";
	}
	
//********************************************************************************************************************************************************************
//********************************************************************************************************************************************************************
	
	//.......................................Update page controller............................................
		@GetMapping("/update")
		public String updatePage(ModelMap map,@SessionAttribute(name = "login", required = false)AdminPOJO admin) {
			if(admin!=null) {
				List<StudentPOJO> students = service.allStudents();
				map.addAttribute("students", students);
				return "UpdateStudent";
			}
			map.addAttribute("msg", "Please login first...!!!");
			return "LoginPage";
		}
		
		//.................................Update view controller............................................
		@PostMapping("/update")
		public String updateForm(@RequestParam int id, ModelMap map,@SessionAttribute(name = "login", required = false)AdminPOJO admin) {
			if(admin!=null) {
				StudentPOJO pojo = service.searchStudent(id);
				
				// Success
				if (pojo != null) {
					map.addAttribute("student", pojo);
					return "UpdateStudent";
				}
				// Failure
				map.addAttribute("msg", "Student data does not exist...!!!");
				List<StudentPOJO> students = service.allStudents();
				map.addAttribute("students", students);
				return "UpdateStudent";
			}
			map.addAttribute("msg", "Please login first...!!!");
			return "LoginPage";
		}
		
		//...................................Update data controller..............................................
		@PostMapping("/updateData")
		public String updateStudent(@RequestParam int id,@RequestParam String name,@RequestParam String email,@RequestParam long mobile,@RequestParam String address,ModelMap map,@SessionAttribute(name = "login", required = false)AdminPOJO admin) {
			if(admin!=null) {
				StudentPOJO pojo = service.updateStudent(id, name, email, mobile, address);
				
				//Success
				if (pojo != null) {
					map.addAttribute("msg", "Student data updated...!!!");
					List<StudentPOJO> students = service.allStudents();
					map.addAttribute("students", students);
					return "UpdateStudent";
				}
				//Failure
				map.addAttribute("msg", "Student data not updated...!!!");
				List<StudentPOJO> students = service.allStudents();
				map.addAttribute("students", students);
				return "UpdateStudent";
			}
			map.addAttribute("msg", "Please login first...!!!");
			return "LoginPage";
		}

//********************************************************************************************************************************************************************
//********************************************************************************************************************************************************************
		
	// ........................................Remove page controller................................................
		@GetMapping("/remove")
		public String removePage(ModelMap map,@SessionAttribute(name = "login", required = false)AdminPOJO admin) {
			if(admin!=null) {
				List<StudentPOJO> students = service.allStudents();
				map.addAttribute("students", students);
				return "RemoveStudent";
			}
			map.addAttribute("msg", "Please login first...!!!");
			return "LoginPage";	
		}

		// ......................................Remove data controller..............................................
		@PostMapping("/remove")
		public String removeStudent(@RequestParam int id, ModelMap map,@SessionAttribute(name = "login", required = false)AdminPOJO admin) {
			if(admin!=null) {
				StudentPOJO pojo = service.removeStudent(id);
				
				// Success
				if (pojo != null) {
					List<StudentPOJO> students = service.allStudents();
					map.addAttribute("students", students);
					map.addAttribute("msg", "Student data removed successfully...!!!");
					return "RemoveStudent";
				}
				// Failure
				List<StudentPOJO> students = service.allStudents();
				map.addAttribute("students", students);
				map.addAttribute("msg", "Student data does not exist...!!!");
				return "RemoveStudent";
			}
			map.addAttribute("msg", "Please login first...!!!");
			return "LoginPage";
		}

}

