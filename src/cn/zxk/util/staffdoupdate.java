package cn.zxk.util;

import cn.zxk.pojo.TDot;

import java.util.Date;

public class staffdoupdate {
    private Integer staffId;

    private String staffName;

    private String staffLoginName;

    private String staffPassword;

    private Integer staffAge;

    private String staffSex;

    private String staffPhone;

    private Date hiredate;

    private Integer dotId;

    private String dotName;
    
    private TDot dot;

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffLoginName() {
		return staffLoginName;
	}

	public void setStaffLoginName(String staffLoginName) {
		this.staffLoginName = staffLoginName;
	}

	public String getStaffPassword() {
		return staffPassword;
	}

	public void setStaffPassword(String staffPassword) {
		this.staffPassword = staffPassword;
	}

	public Integer getStaffAge() {
		return staffAge;
	}

	public void setStaffAge(Integer staffAge) {
		this.staffAge = staffAge;
	}

	public String getStaffSex() {
		return staffSex;
	}

	public void setStaffSex(String staffSex) {
		this.staffSex = staffSex;
	}

	public String getStaffPhone() {
		return staffPhone;
	}

	public void setStaffPhone(String staffPhone) {
		this.staffPhone = staffPhone;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public Integer getDotId() {
		return dotId;
	}

	public void setDotId(Integer dotId) {
		this.dotId = dotId;
	}

	public String getDotName() {
		return dotName;
	}

	public void setDotName(String dotName) {
		this.dotName = dotName;
	}

	public TDot getDot() {
		return dot;
	}

	public void setDot(TDot dot) {
		this.dot = dot;
	}

	public staffdoupdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public staffdoupdate(Integer staffId, String staffName, String staffLoginName, String staffPassword,
			Integer staffAge, String staffSex, String staffPhone, Date hiredate, Integer dotId, String dotName,
			TDot dot) {
		this.staffId = staffId;
		this.staffName = staffName;
		this.staffLoginName = staffLoginName;
		this.staffPassword = staffPassword;
		this.staffAge = staffAge;
		this.staffSex = staffSex;
		this.staffPhone = staffPhone;
		this.hiredate = hiredate;
		this.dotId = dotId;
		this.dotName = dotName;
		this.dot = dot;
	}

	@Override
	public String toString() {
		return "staffdoupdate [staffId=" + staffId + ", staffName=" + staffName + ", staffLoginName=" + staffLoginName
				+ ", staffPassword=" + staffPassword + ", staffAge=" + staffAge + ", staffSex=" + staffSex
				+ ", staffPhone=" + staffPhone + ", hiredate=" + hiredate + ", dotId=" + dotId + ", dotName=" + dotName
				+ ", dot=" + dot + "]";
	}

   
}