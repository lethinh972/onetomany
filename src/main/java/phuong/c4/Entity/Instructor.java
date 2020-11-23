package phuong.c4.Entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "instructor")
public class Instructor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition = "BIGINT(1)")
	private int id;

	@Column(name = "firts_name", columnDefinition = "VARCHAR(150)")
	private String firts_name;

	@Column(name = "last_name", columnDefinition = "VARCHAR(150)")
	private String last_name;

	@Column(name = "email", columnDefinition = "VARCHAR(150)")
	private String email;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "instructor")
	private Set<Course> listCourse = new HashSet<>();

	public void setListCourse(Course c) {
	}

	public void setListCourse(Set<Course> listCourse) {
		this.listCourse = listCourse;
	}
	
	

}
