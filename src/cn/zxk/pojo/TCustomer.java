package cn.zxk.pojo;

public class TCustomer {
    private Integer customerId;

    private String customerName;

    private String customerLoginName;

    private String customerPassword;

    private Integer customerAge;

    private String customerSex;

    private String customerPhone;

    private String idCardNo;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerLoginName() {
        return customerLoginName;
    }

    public void setCustomerLoginName(String customerLoginName) {
        this.customerLoginName = customerLoginName;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public Integer getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(Integer customerAge) {
        this.customerAge = customerAge;
    }

    public String getCustomerSex() {
        return customerSex;
    }

    public void setCustomerSex(String customerSex) {
        this.customerSex = customerSex;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

	public TCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TCustomer(Integer customerId, String customerName, String customerLoginName, String customerPassword,
			Integer customerAge, String customerSex, String customerPhone, String idCardNo) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerLoginName = customerLoginName;
		this.customerPassword = customerPassword;
		this.customerAge = customerAge;
		this.customerSex = customerSex;
		this.customerPhone = customerPhone;
		this.idCardNo = idCardNo;
	}

	@Override
	public String toString() {
		return "TCustomer [customerId=" + customerId + ", customerName=" + customerName + ", customerLoginName="
				+ customerLoginName + ", customerPassword=" + customerPassword + ", customerAge=" + customerAge
				+ ", customerSex=" + customerSex + ", customerPhone=" + customerPhone + ", idCardNo=" + idCardNo + "]";
	}
    
}