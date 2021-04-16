package cn.zxk.pojo;

import java.util.Date;

public class TSend {
    private Integer sendId;

    private String waybillId;

    private Integer staffId;

    private Date sendTime;

    private Integer signState;

    private Date stime;

    private String rejectReasons;

    private TStaff staff;

	public Integer getSendId() {
		return sendId;
	}

	public void setSendId(Integer sendId) {
		this.sendId = sendId;
	}

	public String getWaybillId() {
		return waybillId;
	}

	public void setWaybillId(String waybillId) {
		this.waybillId = waybillId;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Integer getSignState() {
		return signState;
	}

	public void setSignState(Integer signState) {
		this.signState = signState;
	}

	public Date getStime() {
		return stime;
	}

	public void setStime(Date stime) {
		this.stime = stime;
	}

	public String getRejectReasons() {
		return rejectReasons;
	}

	public void setRejectReasons(String rejectReasons) {
		this.rejectReasons = rejectReasons;
	}

	public TStaff getStaff() {
		return staff;
	}

	public void setStaff(TStaff staff) {
		this.staff = staff;
	}

	public TSend() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TSend(Integer sendId, String waybillId, Integer staffId, Date sendTime, Integer signState, Date stime,
			String rejectReasons, TStaff staff) {
		this.sendId = sendId;
		this.waybillId = waybillId;
		this.staffId = staffId;
		this.sendTime = sendTime;
		this.signState = signState;
		this.stime = stime;
		this.rejectReasons = rejectReasons;
		this.staff = staff;
	}

	@Override
	public String toString() {
		return "TSend [sendId=" + sendId + ", waybillId=" + waybillId + ", staffId=" + staffId + ", sendTime="
				+ sendTime + ", signState=" + signState + ", stime=" + stime + ", rejectReasons=" + rejectReasons
				+ ", staff=" + staff + "]";
	}
    
    
}