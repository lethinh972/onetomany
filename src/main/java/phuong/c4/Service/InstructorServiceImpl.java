package phuong.c4.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import phuong.c4.Entity.Instructor;
import phuong.c4.Repo.InstructorRepository;

@Service
public class InstructorServiceImpl implements InstructorService {
	@Autowired
	private InstructorRepository instructorRepository;

	@Override
	public List<Instructor> findAll() {
		return instructorRepository.findAll();
	}

	@Override
	public Instructor findOne(int id) {
		return instructorRepository.findById(id).get();
	}

	@Override
	public void save(Instructor in) {
		instructorRepository.save(in);
	}

	@Override
	public void delete(Instructor in) {
		instructorRepository.delete(in);
	}

	@Override
	public void update(Instructor in) {
		instructorRepository.saveAndFlush(in);
		
	}

}
