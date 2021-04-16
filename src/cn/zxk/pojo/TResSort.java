package cn.zxk.pojo;

import java.math.BigDecimal;

public class TResSort {
    private Integer resSortId;

    private String resSort;

    private BigDecimal resSortMoney;

    public Integer getResSortId() {
        return resSortId;
    }

    public void setResSortId(Integer resSortId) {
        this.resSortId = resSortId;
    }

    public String getResSort() {
        return resSort;
    }

    public void setResSort(String resSort) {
        this.resSort = resSort;
    }

    public BigDecimal getResSortMoney() {
        return resSortMoney;
    }

    public void setResSortMoney(BigDecimal resSortMoney) {
        this.resSortMoney = resSortMoney;
    }

	@Override
	public String toString() {
		return "TResSort [resSortId=" + resSortId + ", resSort=" + resSort + ", resSortMoney=" + resSortMoney + "]";
	}

	public TResSort(Integer resSortId, String resSort, BigDecimal resSortMoney) {
		this.resSortId = resSortId;
		this.resSort = resSort;
		this.resSortMoney = resSortMoney;
	}

	public TResSort() {
		super();
		// TODO Auto-generated constructor stub
	}
}