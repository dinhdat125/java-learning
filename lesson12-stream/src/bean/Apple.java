package bean;

import java.time.LocalDate;
import java.util.Objects;

public class Apple {
	
	private Integer id;
	private String color;
	private String origin;
	private LocalDate expiredDate;
	
	public Apple() {
	}

	public Apple(Integer id, String color, String origin, LocalDate expiredDate) {
		this.id = id;
		this.color = color;
		this.origin = origin;
		this.expiredDate = expiredDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public LocalDate getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(LocalDate expiredDate) {
		this.expiredDate = expiredDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Apple))
			return false;
		Apple that = (Apple)o;
		return getId().equals(that.getId());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}
	
	public static boolean testExpDate(Apple apple) {
		return apple.getExpiredDate().isBefore(LocalDate.now());
	}

	@Override
	public String toString() {
		return "Apple [id=" + id + ", color=" + color + ", origin=" + origin + ", expiredDate=" + expiredDate + "]";
	}
}
