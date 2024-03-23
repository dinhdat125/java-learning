package dao;

import java.util.List;

import persistence.dto.ItemGroupDto;

public interface ItemGroupDao {

	List<ItemGroupDto> getAmountItemsByItemGroup();
}
