package dao;

import java.util.List;

import org.hibernate.transform.Transformers;
import org.hibernate.type.StandardBasicTypes;

import persistence.dto.ItemGroupDto;

public class HibernateItemGroupDao extends BaseHibernateDao implements ItemGroupDao {
	
	private static final String Q_GET_AMOUNT_ITEMS_BY_ITEM_GROUP = ""
			+ "SELECT itg.ID " + ItemGroupDto.PROP_ID + ",\n"
			+ "	      itg.NAME " + ItemGroupDto.PROP_NAME + ",\n"
			+ "       SUM(itd.AMOUNT) " + ItemGroupDto.PROP_AMOUNT + "\n"
			+ "  FROM item_group itg\n"
			+ "  JOIN item it\n"
			+ "    ON itg.ID = it.ITEM_GROUP_ID\n"
			+ "  JOIN item_detail itd\n"
			+ "    ON itd.ITEM_ID = it.ID\n"
			+ " GROUP BY itg.ID, itg.NAME";

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<ItemGroupDto> getAmountItemsByItemGroup() {
		return openSession().createNativeQuery(Q_GET_AMOUNT_ITEMS_BY_ITEM_GROUP)
				.addScalar(ItemGroupDto.PROP_ID, StandardBasicTypes.INTEGER)
				.addScalar(ItemGroupDto.PROP_NAME, StandardBasicTypes.STRING)
				.addScalar(ItemGroupDto.PROP_AMOUNT, StandardBasicTypes.INTEGER)
				.setResultTransformer(Transformers.aliasToBean(ItemGroupDto.class))
				.getResultList();
	}
}
