package bean;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * StoreParameters contains store parameters and calculation results
 */
public class StoreParameters {

	private Long storeId;
    private BigDecimal stockPreviousDay;
    private BigDecimal expectedSales;
    private BigDecimal allocationKey;
    private Integer demand;
    private Integer difference;
    private Integer amountAllocated;
    
    public StoreParameters() {
	}

	public StoreParameters(Long storeId, BigDecimal stockPreviousDay, BigDecimal expectedSales, BigDecimal allocationKey,
			Integer demand, Integer difference, Integer amountAllocated) {
		this.storeId = storeId;
		this.stockPreviousDay = stockPreviousDay;
		this.expectedSales = expectedSales;
		this.allocationKey = allocationKey;
		this.demand = demand;
		this.difference = difference;
		this.amountAllocated = amountAllocated;
	}
	
	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public BigDecimal getStockPreviousDay() {
		return stockPreviousDay;
	}

	public void setStockPreviousDay(BigDecimal stockPreviousDay) {
		this.stockPreviousDay = stockPreviousDay;
	}

	public BigDecimal getExpectedSales() {
		return expectedSales;
	}

	public void setExpectedSales(BigDecimal expectedSales) {
		this.expectedSales = expectedSales;
	}

	public BigDecimal getAllocationKey() {
		return allocationKey;
	}

	public void setAllocationKey(BigDecimal allocationKey) {
		this.allocationKey = allocationKey;
	}

	public Integer getDemand() {
		return demand;
	}

	public void setDemand(Integer demand) {
		this.demand = demand;
	}

	public Integer getDifference() {
		return difference;
	}

	public void setDifference(Integer difference) {
		this.difference = difference;
	}

	public Integer getAmountAllocated() {
		return amountAllocated;
	}

	public void setAmountAllocated(Integer amountAllocated) {
		this.amountAllocated = amountAllocated;
	}

	@Override
	public String toString() {
		return "StoreParameters [storeId=" + storeId + ", stockPreviousDay=" + stockPreviousDay + ", expectedSales="
				+ expectedSales + ", allocationKey=" + allocationKey + ", demand=" + demand + ", difference="
				+ difference + ", amountAllocated=" + amountAllocated + "]";
	}

	@Override
    public boolean equals(final Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        final StoreParameters that = (StoreParameters) o;

        return getStoreId().equals(that.getStoreId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeId);
    }    
    
}
