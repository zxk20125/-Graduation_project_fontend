package cn.zxk.pojo;

public class TFeedback {
    private Integer feedbackId;

    private Integer customerId;

    private String feedbackContent;

    private String mailxbox;

    private TCustomer customer;

	public Integer getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getFeedbackContent() {
		return feedbackContent;
	}

	public void setFeedbackContent(String feedbackContent) {
		this.feedbackContent = feedbackContent;
	}

	public String getMailxbox() {
		return mailxbox;
	}

	public void setMailxbox(String mailxbox) {
		this.mailxbox = mailxbox;
	}

	public TCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(TCustomer customer) {
		this.customer = customer;
	}

	public TFeedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TFeedback(Integer feedbackId, Integer customerId, String feedbackContent, String mailxbox,
			TCustomer customer) {
		this.feedbackId = feedbackId;
		this.customerId = customerId;
		this.feedbackContent = feedbackContent;
		this.mailxbox = mailxbox;
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "TFeedback [feedbackId=" + feedbackId + ", customerId=" + customerId + ", feedbackContent="
				+ feedbackContent + ", mailxbox=" + mailxbox + ", customer=" + customer + "]";
	}
    
    
}