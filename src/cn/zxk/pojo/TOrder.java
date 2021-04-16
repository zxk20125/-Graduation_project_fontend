package cn.zxk.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class TOrder {
    private String orderId;

    private Integer custmerId;

    private Integer dotId;

    private Integer staffId;

    private String sender;

    private String receivingAddress;

    private String receiverPhone;

    private String receiver;

    private String senderAddress;

    private String senderPhone;

    private Integer weight;

    private String resSort;

    private Integer insuredPrice;

    private BigDecimal freight;

    private String paymentMethod;

    private String remarks;

    private Date orderTime;

    private TCustomer customer;
    
    private TStaff staff;
    
    private TWaybill waybill;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Integer getCustmerId() {
		return custmerId;
	}

	public void setCustmerId(Integer custmerId) {
		this.custmerId = custmerId;
	}

	public Integer getDotId() {
		return dotId;
	}

	public void setDotId(Integer dotId) {
		this.dotId = dotId;
	}

	public Integer getStaffId() {
		return staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceivingAddress() {
		return receivingAddress;
	}

	public void setReceivingAddress(String receivingAddress) {
		this.receivingAddress = receivingAddress;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getSenderAddress() {
		return senderAddress;
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}

	public String getSenderPhone() {
		return senderPhone;
	}

	public void setSenderPhone(String senderPhone) {
		this.senderPhone = senderPhone;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getResSort() {
		return resSort;
	}

	public void setResSort(String resSort) {
		this.resSort = resSort;
	}

	public Integer getInsuredPrice() {
		return insuredPrice;
	}

	public void setInsuredPrice(Integer insuredPrice) {
		this.insuredPrice = insuredPrice;
	}

	public BigDecimal getFreight() {
		return freight;
	}

	public void setFreight(BigDecimal freight) {
		this.freight = freight;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public TCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(TCustomer customer) {
		this.customer = customer;
	}

	public TStaff getStaff() {
		return staff;
	}

	public void setStaff(TStaff staff) {
		this.staff = staff;
	}

	public TWaybill getWaybill() {
		return waybill;
	}

	public void setWaybill(TWaybill waybill) {
		this.waybill = waybill;
	}

	public TOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TOrder(String orderId, Integer custmerId, Integer dotId, Integer staffId, String sender,
			String receivingAddress, String receiverPhone, String receiver, String senderAddress, String senderPhone,
			Integer weight, String resSort, Integer insuredPrice, BigDecimal freight, String paymentMethod,
			String remarks, Date orderTime, TCustomer customer, TStaff staff, TWaybill waybill) {
		this.orderId = orderId;
		this.custmerId = custmerId;
		this.dotId = dotId;
		this.staffId = staffId;
		this.sender = sender;
		this.receivingAddress = receivingAddress;
		this.receiverPhone = receiverPhone;
		this.receiver = receiver;
		this.senderAddress = senderAddress;
		this.senderPhone = senderPhone;
		this.weight = weight;
		this.resSort = resSort;
		this.insuredPrice = insuredPrice;
		this.freight = freight;
		this.paymentMethod = paymentMethod;
		this.remarks = remarks;
		this.orderTime = orderTime;
		this.customer = customer;
		this.staff = staff;
		this.waybill = waybill;
	}

	@Override
	public String toString() {
		return "TOrder [orderId=" + orderId + ", custmerId=" + custmerId + ", dotId=" + dotId + ", staffId=" + staffId
				+ ", sender=" + sender + ", receivingAddress=" + receivingAddress + ", receiverPhone=" + receiverPhone
				+ ", receiver=" + receiver + ", senderAddress=" + senderAddress + ", senderPhone=" + senderPhone
				+ ", weight=" + weight + ", resSort=" + resSort + ", insuredPrice=" + insuredPrice + ", freight="
				+ freight + ", paymentMethod=" + paymentMethod + ", remarks=" + remarks + ", orderTime=" + orderTime
				+ ", customer=" + customer + ", staff=" + staff + ", waybill=" + waybill + "]";
	}


}