package entity;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Clazz")
public class Clazz {
    
    @Id
    @Column(name = "classId")
    private String classId;
    
    @Column(name = "clazzName")
    private String clazzName;
    
    @Column(name = "semester")
    private String semester;
    
    @Column(name = "credit")
    private int credit;
    
    @Column(name = "password")
    private String password;
    
    @OneToMany(mappedBy = "clazz", cascade = CascadeType.ALL)
    private List<Study> studies;

	public Clazz(String classId, String clazzName, String semester, int credit, String password) {
		super();
		this.classId = classId;
		this.clazzName = clazzName;
		this.semester = semester;
		this.credit = credit;
		this.password = password;
	}

	public Clazz() {
		super();
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getClazzName() {
		return clazzName;
	}

	public void setClazzName(String clazzName) {
		this.clazzName = clazzName;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

   
}
