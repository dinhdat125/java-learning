package service;

import java.util.List;

import persistence.dto.ItemGroupDto;

public interface ItemGroupService {

	List<ItemGroupDto> getAmountItemsByItemGroup();
}
