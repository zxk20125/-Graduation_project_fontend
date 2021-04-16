package cn.zxk.pojo;

import java.math.BigDecimal;

public class TShipAddress {
    private Integer shipAddressId;

    private String startAddress;

    private String endAddress;

    private BigDecimal shipAddressMoney;

    public Integer getShipAddressId() {
        return shipAddressId;
    }

    public void setShipAddressId(Integer shipAddressId) {
        this.shipAddressId = shipAddressId;
    }

    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }

    public String getEndAddress() {
        return endAddress;
    }

    public void setEndAddress(String endAddress) {
        this.endAddress = endAddress;
    }

    public BigDecimal getShipAddressMoney() {
        return shipAddressMoney;
    }

    public void setShipAddressMoney(BigDecimal shipAddressMoney) {
        this.shipAddressMoney = shipAddressMoney;
    }

	@Override
	public String toString() {
		return "TShipAddress [shipAddressId=" + shipAddressId + ", startAddress=" + startAddress + ", endAddress="
				+ endAddress + ", shipAddressMoney=" + shipAddressMoney + "]";
	}

	public TShipAddress(Integer shipAddressId, String startAddress, String endAddress, BigDecimal shipAddressMoney) {
		this.shipAddressId = shipAddressId;
		this.startAddress = startAddress;
		this.endAddress = endAddress;
		this.shipAddressMoney = shipAddressMoney;
	}

	public TShipAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
}