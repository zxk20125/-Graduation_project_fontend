package cn.zxk.pojo;

import java.math.BigDecimal;

public class TResWeight {
    private Integer resWeightId;

    private Integer resWeight;

    private BigDecimal resWeightMoney;

    public Integer getResWeightId() {
        return resWeightId;
    }

    public void setResWeightId(Integer resWeightId) {
        this.resWeightId = resWeightId;
    }

    public Integer getResWeight() {
        return resWeight;
    }

    public void setResWeight(Integer resWeight) {
        this.resWeight = resWeight;
    }

    public BigDecimal getResWeightMoney() {
        return resWeightMoney;
    }

    public void setResWeightMoney(BigDecimal resWeightMoney) {
        this.resWeightMoney = resWeightMoney;
    }

	@Override
	public String toString() {
		return "TResWeight [resWeightId=" + resWeightId + ", resWeight=" + resWeight + ", resWeightMoney="
				+ resWeightMoney + "]";
	}

	public TResWeight(Integer resWeightId, Integer resWeight, BigDecimal resWeightMoney) {
		this.resWeightId = resWeightId;
		this.resWeight = resWeight;
		this.resWeightMoney = resWeightMoney;
	}

	public TResWeight() {
		super();
		// TODO Auto-generated constructor stub
	}
}