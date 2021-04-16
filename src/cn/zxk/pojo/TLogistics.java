package cn.zxk.pojo;

import java.util.Date;

public class TLogistics {
    private Integer logisticsId;

    private String waybillId;

    private Integer staffId;

    private String logisticsType;

    private String startDotName;

    private String targetDotName;

    private Date time;

    private TStaff staff;

	public Integer getLogisticsId() {
		return logisticsId;
	}

	public void setLogisticsId(Integer logisticsId) {
		this.logisticsId = logisticsId;
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

	public String getLogisticsType() {
		return logisticsType;
	}

	public void setLogisticsType(String logisticsType) {
		this.logisticsType = logisticsType;
	}

	public String getStartDotName() {
		return startDotName;
	}

	public void setStartDotName(String startDotName) {
		this.startDotName = startDotName;
	}

	public String getTargetDotName() {
		return targetDotName;
	}

	public void setTargetDotName(String targetDotName) {
		this.targetDotName = targetDotName;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public TStaff getStaff() {
		return staff;
	}

	public void setStaff(TStaff staff) {
		this.staff = staff;
	}

	public TLogistics() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TLogistics(Integer logisticsId, String waybillId, Integer staffId, String logisticsType, String startDotName,
			String targetDotName, Date time, TStaff staff) {
		this.logisticsId = logisticsId;
		this.waybillId = waybillId;
		this.staffId = staffId;
		this.logisticsType = logisticsType;
		this.startDotName = startDotName;
		this.targetDotName = targetDotName;
		this.time = time;
		this.staff = staff;
	}

	@Override
	public String toString() {
		return "TLogistics [logisticsId=" + logisticsId + ", waybillId=" + waybillId + ", staffId=" + staffId
				+ ", logisticsType=" + logisticsType + ", startDotName=" + startDotName + ", targetDotName="
				+ targetDotName + ", time=" + time + ", staff=" + staff + "]";
	}
    
    
}