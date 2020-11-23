package phuong.c4.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phuong.c4.Entity.Course;
import phuong.c4.Repo.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	@Override
	public Course findOne(int id) {
		return courseRepository.findById(id).get();
	}

	@Override
	public void save(Course co) {
		courseRepository.save(co);
	}

	@Override
	public void delete(int id) {
		courseRepository.deleteById(id);
	}

	@Override
	public List<Course> findByInstructorID(int id) {
		return courseRepository.findByInstructor(id);
	}

	@Override
	public void deleteByInstructorID(int id) {
		courseRepository.deleteByInstructor(id);
	}



}
