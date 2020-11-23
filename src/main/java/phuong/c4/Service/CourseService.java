package phuong.c4.Service;

import java.util.List;

import phuong.c4.Entity.Course;


public interface CourseService {
	List<Course> findAll();

	Course findOne(int id);

	void save(Course co);

	void delete(int id);
	
	List<Course> findByInstructorID(int id);
	void deleteByInstructorID(int id);
}
