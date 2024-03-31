package entity;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Student")
public class Student {
    
    @Id
    @Column(name = "studentId")
    private String studentId;
    
    @Column(name = "lastName")
    private String lastName;
    
    @Column(name = "firstName")
    private String firstName;
    
    @Column(name = "birthDay")
    private Date birthDay;
    
    @ManyToMany
    @JoinTable(name = "student_study",
        joinColumns = @JoinColumn(name = "student_id"),//bảng trung gian để lưu trữ thông tin về mối quan hệ giữa 2 thực the
        inverseJoinColumns = @JoinColumn(name = "study_id"))//chỉ định đây là khóa ngoại
    private List<Study> studies;


	public Student(String studentId, String lastName, String firstName, Date birthDay, List<Study> studies) {
		super();
		this.studentId = studentId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthDay = birthDay;
		this.studies = studies;
	}

	public Student() {
		super();
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public List<Study> getStudies() {
		return studies;
	}

	public void setStudies(List<Study> studies) {
		this.studies = studies;
	}



   
}
