package phuong.c4.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import phuong.c4.Entity.Instructor;
import phuong.c4.Service.CourseService;
import phuong.c4.Service.InstructorService;

@Controller
public class InstructorController {
	@Autowired
	private InstructorService instructorservice;

	@Autowired
	private CourseService courseService;

	@GetMapping({ "/", "/instructor" })
	public String indexCon(Model model) {
		List<Instructor> list = instructorservice.findAll();
		// List<Course> courses=courseService.findAll();
		model.addAttribute("list", list);
		return "home_instructor";
	}

	@GetMapping("/instructor/createInstructor")
	public String CreateCon(Model model) {
		Instructor instructor = new Instructor();
		model.addAttribute("instructor", instructor);
		return "form_Instructor";
	}

	@PostMapping(value = "/instructor/saveInstructor")
	public String saveCon(@ModelAttribute("instructor") Instructor instructor) {
		instructorservice.save(instructor);
		return "redirect:/instructor";
	}

	@GetMapping("/instructor/updateInstructor{id}")
	public String updateCon(@PathVariable int id, Model model) {
		model.addAttribute("instructor", instructorservice.findOne(id));
		return "form_Instructor_update";
	}

	@PostMapping("/instructor/saveUpdate")
	public String update(@RequestParam(value = "id") int id, @RequestParam(value = "firts_name") String firts_name,
			@RequestParam(value = "last_name") String last_name, @RequestParam(value = "email") String email) {
		Instructor instructor = instructorservice.findOne(id);
		instructor.setFirts_name(firts_name);
		instructor.setLast_name(last_name);
		instructor.setEmail(email);
		instructorservice.update(instructor);
		return "redirect:/instructor";
	}

	@GetMapping("/instructor/deleteInstructor{id}")
	public String deleteCon(@PathVariable int id) {
		Instructor instructor = instructorservice.findOne(id);
		courseService.deleteByInstructorID(id);
		instructorservice.delete(instructor);
		return "redirect:/instructor";
	}


}
