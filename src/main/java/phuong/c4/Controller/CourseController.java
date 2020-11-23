package phuong.c4.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import phuong.c4.Entity.Course;
import phuong.c4.Entity.Instructor;
import phuong.c4.Service.CourseService;
import phuong.c4.Service.InstructorService;

@Controller
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private InstructorService instructorservice;

	@GetMapping("/instructor/addcourse{id}")
	public String addCourse(@PathVariable int id, Model model) {
		model.addAttribute("instructor", instructorservice.findOne(id));
		return "form_addCourse";
	}

	@PostMapping("/instructor/saveCourse")
	public String saveCourse(@RequestParam(value = "id") int id,
			@RequestParam(value = "title") String title,
			@RequestParam(value = "price") int price) {
		
		Instructor instructor = instructorservice.findOne(id);
		Course c = new Course();
		c.setTitle(title);
		c.setPrice(price);
		c.setInstructor(instructor);
		courseService.save(c);

		return "redirect:/instructor";
	}

	@GetMapping("/instructor/viewCourse{id}")
	public String views(@PathVariable int id, Model model) {
		model.addAttribute("course", courseService.findByInstructorID(id));
		return "views_course";
	}
	@GetMapping("/instructor/deleteCourse{id}")
	public String deleteCourse(@PathVariable int id) {
		courseService.delete(id);
		return "redirect:/instructor";
	}
	@GetMapping("/instructor/updateCourse{id}")
	public String updateCourse(@PathVariable int id, Model model) {
		model.addAttribute("course", courseService.findOne(id));
		return "form_Course_update";
	}
	
	
	@PostMapping("/instructor/saveCourseUpdate{id}")
	public String updateC(Model model ,@RequestParam(value = "id") int id,
			@RequestParam(value = "title") String title,
			@RequestParam(value = "price") int price) {
		Course c = courseService.findOne(id);
		c.setTitle(title);
		c.setPrice(price);
		courseService.save(c);
		model.addAttribute("course", courseService.findByInstructorID(id));
		return "redirect:/instructor";
	}
}
