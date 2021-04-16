package cn.zxk.util;

import java.util.Date;

public class orderTracking {

	private String operation;
	
	private Date time;

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public orderTracking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public orderTracking(String operation, Date time) {
		this.operation = operation;
		this.time = time;
	}

	@Override
	public String toString() {
		return "orderTracking [operation=" + operation + ", time=" + time + "]";
	}
	
	
	
}
