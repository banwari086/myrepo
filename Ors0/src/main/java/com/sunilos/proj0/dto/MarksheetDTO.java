package com.sunilos.proj0.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ST_MARKSHEET")

public class MarksheetDTO extends BaseDTO {
	 @Column(name = "ROLLNO", length = 20)
	    protected String rollNo = null;

	    @Column(name = "NAME", length = 50)
	    protected String name = null;

	    @Column(name = "PHYSICS")
	    protected Integer physics;

	    @Column(name = "CHEMISTRY")
	    protected Integer chemistry;

	    @Column(name = "MATHS")
	    protected Integer maths;

	    @Column(name = "STUDENTID")
	    protected Long studentId;

	    public Long getStudentId() {
	        return studentId;
	    }

	    public void setStudentId(Long studentId) {
	        this.studentId = studentId;
	    }

	    public String getRollNo() {
	        return rollNo;
	    }

	    public void setRollNo(String rollNo) {
	        this.rollNo = rollNo;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public Integer getPhysics() {
	        return physics;
	    }

	    public void setPhysics(Integer physics) {
	        this.physics = physics;
	    }

	    public Integer getChemistry() {
	        return chemistry;
	    }

	    public void setChemistry(Integer chemistry) {
	        this.chemistry = chemistry;
	    }

	    public Integer getMaths() {
	        return maths;
	    }

	    public void setMaths(Integer maths) {
	        this.maths = maths;
	    }

	    public String getKey() {
	        return id + "";
	    }

	    public String getValue() {
	        return rollNo;
	    }

}
