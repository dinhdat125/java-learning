package service;

import java.util.List;

import dao.HibernateItemGroupDao;
import dao.ItemGroupDao;
import persistence.dto.ItemGroupDto;

public class ItemGroupServiceImpl implements ItemGroupService {
	
	private ItemGroupDao itemGroupDao;

	public ItemGroupServiceImpl() {
		itemGroupDao = new HibernateItemGroupDao();
	}
	
	@Override
	public List<ItemGroupDto> getAmountItemsByItemGroup() {
		return itemGroupDao.getAmountItemsByItemGroup();
	}
}
