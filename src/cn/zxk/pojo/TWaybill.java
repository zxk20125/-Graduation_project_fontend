package cn.zxk.pojo;

import java.util.Date;
import java.util.List;

public class TWaybill {
    private String waybillId;

    private String orderId;

    private Date receiptTime;

    private Date confirmTime;

    private Date paymentTime;

    private Date cancelTime;

    private Date finishTime;

    private TOrder order;

    private List<TLogistics> logistics;
    
    private List<TSend> send;

	public String getWaybillId() {
		return waybillId;
	}

	public void setWaybillId(String waybillId) {
		this.waybillId = waybillId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Date getReceiptTime() {
		return receiptTime;
	}

	public void setReceiptTime(Date receiptTime) {
		this.receiptTime = receiptTime;
	}

	public Date getConfirmTime() {
		return confirmTime;
	}

	public void setConfirmTime(Date confirmTime) {
		this.confirmTime = confirmTime;
	}

	public Date getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}

	public Date getCancelTime() {
		return cancelTime;
	}

	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public TOrder getOrder() {
		return order;
	}

	public void setOrder(TOrder order) {
		this.order = order;
	}

	public List<TLogistics> getLogistics() {
		return logistics;
	}

	public void setLogistics(List<TLogistics> logistics) {
		this.logistics = logistics;
	}

	public List<TSend> getSend() {
		return send;
	}

	public void setSend(List<TSend> send) {
		this.send = send;
	}

	public TWaybill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TWaybill(String waybillId, String orderId, Date receiptTime, Date confirmTime, Date paymentTime,
			Date cancelTime, Date finishTime, TOrder order, List<TLogistics> logistics, List<TSend> send) {
		this.waybillId = waybillId;
		this.orderId = orderId;
		this.receiptTime = receiptTime;
		this.confirmTime = confirmTime;
		this.paymentTime = paymentTime;
		this.cancelTime = cancelTime;
		this.finishTime = finishTime;
		this.order = order;
		this.logistics = logistics;
		this.send = send;
	}

	@Override
	public String toString() {
		return "TWaybill [waybillId=" + waybillId + ", orderId=" + orderId + ", receiptTime=" + receiptTime
				+ ", confirmTime=" + confirmTime + ", paymentTime=" + paymentTime + ", cancelTime=" + cancelTime
				+ ", finishTime=" + finishTime + ", order=" + order + ", logistics=" + logistics + ", send=" + send
				+ "]";
	}

	
}