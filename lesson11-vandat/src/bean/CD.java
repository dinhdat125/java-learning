package bean;

import java.math.BigDecimal;
import java.util.Objects;

public class CD {

	private Integer id;
	private String type;
	private String singer;
	private Integer songs;
	private BigDecimal price;
	
	public CD() {
	}

	public CD(Integer id, String type, String singer, Integer songs, BigDecimal price) {
		this.id = id;
		this.type = type;
		this.singer = singer;
		this.songs = songs;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public Integer getSongs() {
		return songs;
	}

	public void setSongs(Integer songs) {
		this.songs = songs;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof CD))
			return false;
		CD that = (CD)obj;
		return getId().equals(that.getId());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", type=" + type + ", singer=" + singer + ", songs=" + songs + ", price=" + price
				+ "]";
	}
}
