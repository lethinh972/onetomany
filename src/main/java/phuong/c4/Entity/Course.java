package phuong.c4.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "BIGINT(1)")
	private int id;

	@Column(name = "title", columnDefinition = "VARCHAR(150)")
	private String title;

	@Column(name = "price", columnDefinition = "BIGINT")
	private int price;

	@ManyToOne
	@JoinColumn(name = "instructor_id", nullable = false)
	private Instructor instructor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public Course(int id, String title, int price, Instructor instructor) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.instructor = instructor;
	}

	public Course() {
		super();
	}

	public void setInstructor(Course instructor2) {
		// TODO Auto-generated method stub
		
	}
	
	

}
