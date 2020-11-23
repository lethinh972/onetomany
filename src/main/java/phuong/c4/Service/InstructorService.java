package phuong.c4.Service;

import java.util.List;

import phuong.c4.Entity.Instructor;

public interface InstructorService {
	List<Instructor> findAll();

	Instructor findOne(int id);

	void save(Instructor in);

	void delete(Instructor in);
	
	void update(Instructor in);
}
