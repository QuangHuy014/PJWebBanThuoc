package entity;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Study")
public class Study {
    
    @Id
    @Column(name = "studyId")
    private String studyId;
    
    @Column(name = "averageMark")
    private double averageMark;
    
    @Column(name = "Statuss")
    private boolean status;
    
    @Column(name = "registerDay")
    private Date registerDay;
    
   
    @ManyToMany(mappedBy = "studies")
    private List<Student> students;
    
	
	public Study(String studyId, double averageMark, boolean status, Date registerDay, List<Student> students) {
		super();
		this.studyId = studyId;
		this.averageMark = averageMark;
		this.status = status;
		this.registerDay = registerDay;
		this.students = students;
	}

	public Study() {
		super();
	}

	public String getStudyId() {
		return studyId;
	}

	public void setStudyId(String studyId) {
		this.studyId = studyId;
	}

	public double getAverageMark() {
		return averageMark;
	}

	public void setAverageMark(double averageMark) {
		this.averageMark = averageMark;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getRegisterDay() {
		return registerDay;
	}

	public void setRegisterDay(Date registerDay) {
		this.registerDay = registerDay;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}



    
}
