package phuong.c4.Repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import phuong.c4.Entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {
	@Query(value = "select * from course where instructor_id=?1",nativeQuery = true)
	List<Course> findByInstructor(int id);
	
	@Modifying
	@Transactional
	@Query(value = "delete from onetomany.course where instructor_id=?1",nativeQuery = true)
	public void deleteByInstructor(int id);
}
