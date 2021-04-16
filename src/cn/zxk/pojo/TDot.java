package cn.zxk.pojo;

public class TDot {
    private Integer dotId;

    private String dotCity;

    private String dotAddress;

    private String dotName;

    private String dotPhone;

    public Integer getDotId() {
        return dotId;
    }

    public void setDotId(Integer dotId) {
        this.dotId = dotId;
    }

    public String getDotCity() {
        return dotCity;
    }

    public void setDotCity(String dotCity) {
        this.dotCity = dotCity;
    }

    public String getDotAddress() {
        return dotAddress;
    }

    public void setDotAddress(String dotAddress) {
        this.dotAddress = dotAddress;
    }

    public String getDotName() {
        return dotName;
    }

    public void setDotName(String dotName) {
        this.dotName = dotName;
    }

    public String getDotPhone() {
        return dotPhone;
    }

    public void setDotPhone(String dotPhone) {
        this.dotPhone = dotPhone;
    }

	@Override
	public String toString() {
		return "TDot [dotId=" + dotId + ", dotCity=" + dotCity + ", dotAddress=" + dotAddress + ", dotName=" + dotName
				+ ", dotPhone=" + dotPhone + "]";
	}

	public TDot(Integer dotId, String dotCity, String dotAddress, String dotName, String dotPhone) {
		this.dotId = dotId;
		this.dotCity = dotCity;
		this.dotAddress = dotAddress;
		this.dotName = dotName;
		this.dotPhone = dotPhone;
	}

	public TDot() {
		super();
		// TODO Auto-generated constructor stub
	}
}