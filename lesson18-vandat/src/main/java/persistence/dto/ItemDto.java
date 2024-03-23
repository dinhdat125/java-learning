package persistence.dto;

import java.sql.Time;
import java.util.Objects;

public class ItemDto {

	public static String PROP_ID = "itId";
	public static String PROP_NAME = "itName";
	public static String PROP_CREATED_AT = "createdTime";

	private Integer itId;
	private String itName;
	private Time createdTime;
	
	public ItemDto() {
	}

	public ItemDto(Integer itId, String itName, Time createdTime) {
		this.itId = itId;
		this.itName = itName;
		this.createdTime = createdTime;
	}

	public Integer getItId() {
		return itId;
	}

	public void setItId(Integer itId) {
		this.itId = itId;
	}

	public String getItName() {
		return itName;
	}

	public void setItName(String itName) {
		this.itName = itName;
	}

	public Time getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Time createdTime) {
		this.createdTime = createdTime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getItId());
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof ItemDto))
			return false;
		ItemDto that = (ItemDto)o;
		return getItId().equals(that.getItId());
	}

	@Override
	public String toString() {
		return "ItemDto [itId=" + itId + ", itName=" + itName + ", createdTime=" + createdTime + "]";
	}

}
