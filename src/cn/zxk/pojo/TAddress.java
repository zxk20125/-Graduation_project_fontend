package cn.zxk.pojo;

public class TAddress {
    private Integer addressId;

    private Integer customerId;

    private String addressName;

    private String address;

    private String phone;

    private TCustomer customer;
    
	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public TCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(TCustomer customer) {
		this.customer = customer;
	}

	public TAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TAddress(Integer addressId, Integer customerId, String addressName, String address, String phone,
			TCustomer customer) {
		this.addressId = addressId;
		this.customerId = customerId;
		this.addressName = addressName;
		this.address = address;
		this.phone = phone;
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "TAddress [addressId=" + addressId + ", customerId=" + customerId + ", addressName=" + addressName
				+ ", address=" + address + ", phone=" + phone + ", customer=" + customer + "]";
	}
    
   
}