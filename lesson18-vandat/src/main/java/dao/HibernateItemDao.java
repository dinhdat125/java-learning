package dao;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.transform.Transformers;
import org.hibernate.type.DateType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.hibernate.type.TimeType;

import persistence.dto.ItemDto;
import persistence.entities.Item;

public class HibernateItemDao extends BaseHibernateDao implements ItemDao {

	private static final String Q_GET_ITEMS_BY_SALES_DATE = ""
			+ "SELECT it.ID AS " + ItemDto.PROP_ID + ",\n"
			+ "	      it.NAME AS " + ItemDto.PROP_NAME + ",\n"
			+ "       cast(od.CREATED_AT AS TIME) AS " + ItemDto.PROP_CREATED_AT + "\n"
			+ "  FROM item it\n"
			+ "  JOIN item_detail itd\n"
			+ "    ON it.ID = itd.ITEM_ID\n"
			+ "  JOIN order_detail odd\n"
			+ "    ON odd.ITEM_DETAIL_ID = itd.ID\n"
			+ "  JOIN `order` od\n"
			+ "    ON od.ID = odd.ORDER_ID\n"
			+ " WHERE cast(od.CREATED_AT AS DATE) = :pDate\n"
			+ " ORDER BY " + ItemDto.PROP_CREATED_AT + " DESC, " + ItemDto.PROP_ID;
	
	private static final String Q_GET_TOP_THREE_MOST_ITEM_OF_YEAR = ""
			+ "SELECT it.ID " + ItemDto.PROP_ID + ",\n"
			+ "       it.NAME " + ItemDto.PROP_NAME + "\n"
			+ "  FROM item it\n"
			+ "  JOIN item_detail itd\n"
			+ "    ON it.ID = itd.ITEM_ID\n"
			+ "  JOIN order_detail odd\n"
			+ "    ON odd.ITEM_DETAIL_ID = itd.ID\n"
			+ "  JOIN `order` od\n"
			+ "    ON od.ID = odd.ORDER_ID\n"
			+ " WHERE year(od.CREATED_AT) = :pYear\n"
			+ " GROUP BY it.ID, it.NAME\n"
			+ " ORDER BY sum(odd.AMOUNT) DESC, it.ID DESC\n"
			+ " LIMIT 3";
	
	private static final String Q_GET_TOP_THREE_MOST_ITEM_OF_YEAR_SOLUTION_2 = ""
			+ "SELECT it.NAME\n"
			+ "  FROM item it\n"
			+ "  JOIN item_detail itd\n"
			+ "    ON it.ID = itd.ITEM_ID\n"
			+ "  JOIN order_detail odd\n"
			+ "    ON odd.ITEM_DETAIL_ID = itd.ID\n"
			+ "  JOIN `order` od\n"
			+ "    ON od.ID = odd.ORDER_ID\n"
			+ " WHERE year(od.CREATED_AT) = :pYear\n"
			+ " GROUP BY it.ID, it.NAME\n"
			+ " ORDER BY sum(odd.AMOUNT) DESC, it.ID DESC\n"
			+ " LIMIT 3";
	
	private static final String GET_ALL_ITEMS = ""
			+ "SELECT * FROM item";
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<ItemDto> getItemsBySalesDate(LocalDate localDate) {		
		Date date = Date.valueOf(localDate);
		return openSession().createNativeQuery(Q_GET_ITEMS_BY_SALES_DATE)
				.setParameter("pDate", date, DateType.INSTANCE)
				.addScalar(ItemDto.PROP_ID, IntegerType.INSTANCE)
				.addScalar(ItemDto.PROP_NAME, StringType.INSTANCE)
				.addScalar(ItemDto.PROP_CREATED_AT, TimeType.INSTANCE)
				.setResultTransformer(Transformers.aliasToBean(ItemDto.class))
				.getResultList();
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<ItemDto> getTopThreeMostItemsOfYear(int year) {
		return openSession().createNativeQuery(Q_GET_TOP_THREE_MOST_ITEM_OF_YEAR)
				.setParameter("pYear", year)
				.addScalar(ItemDto.PROP_ID, IntegerType.INSTANCE)
				.addScalar(ItemDto.PROP_NAME, StringType.INSTANCE)
				.setResultTransformer(Transformers.aliasToBean(ItemDto.class))
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getTopThreeMostItemsOfYearSolution2(int year) {
		return openSession().createNativeQuery(Q_GET_TOP_THREE_MOST_ITEM_OF_YEAR_SOLUTION_2)
				.setParameter("pYear", year)
				.getResultList();
	}
	
	@Override
	public List<Item> getAll() {
		return openSession()
				.createNativeQuery(GET_ALL_ITEMS, Item.class)
				.getResultList();
	}
}
