package persistence.dto;

import java.util.Objects;

public class ItemGroupDto {
	
	public static String PROP_ID = "igId";
	public static String PROP_NAME = "igName";
	public static String PROP_AMOUNT = "amount";

	private Integer igId;
	private String igName;
	private Integer amount;
	
	public ItemGroupDto() {
	}

	public ItemGroupDto(Integer igId, String igName, Integer amount) {
		this.igId = igId;
		this.igName = igName;
		this.amount = amount;
	}

	public Integer getIgId() {
		return igId;
	}

	public void setIgId(Integer igId) {
		this.igId = igId;
	}

	public String getIgName() {
		return igName;
	}

	public void setIgName(String igName) {
		this.igName = igName;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "ItemGroupDto [igId=" + igId + ", igName=" + igName + ", amount=" + amount + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getIgId());
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof ItemGroupDto))
			return false;
		ItemGroupDto that = (ItemGroupDto)o;
		return getIgId().equals(that.getIgId());
	}
}
