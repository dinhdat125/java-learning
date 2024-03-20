package view;

import static utils.NumberUtils.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import bean.Store;
import model.DataModel;

/**
 	Đọc đề, load dữ liệu cần thiến từ package model.DataModel
 	
 	Bổ sung nếu thông tin chưa có
		
	Thực hiện các bước tính toán theo đề bài và trả về kết quả
		
	Yêu cầu: In thông tin chi tiết kết quả cho từng bước tính toán
 */
		
public class WhAllocatedAmountManager {
    public static void main(String[] args) {
    	
        // B1
        final Integer whAllocationAmount = 300;

        // B2
        final List<Store> data = DataModel.getItems().stream()
        		.filter(store -> Boolean.TRUE.equals(store.getSelected()))
        		.toList();
        
        // B3
        Map<Long, Integer> storeAllocatedValues = doAllocation(data, whAllocationAmount);
        
        // B4
        generate("Amount Allocated -> ", storeAllocatedValues.entrySet());
    }

    /**
     * Do Allocation.
     * Key: storeId with Long type
     * Value: storeAllocatedAmount after calculation with 4 steps
     * @return map of storeId, storeAllocatedAmount
     */
    private static Map<Long, Integer> doAllocation(List<Store> data, Integer whAllocationAmount) {
    	// Step 1
    	// Map<StoreId, ExpectedSales> of Stores is missing expected sales values
    	var expectedSalesOfStore = new LinkedHashMap<Long, BigDecimal>();
    	
        for (Store store: data) {
        	if (store.getExpectedSales() == null) {
        		BigDecimal expectedSales = data.stream()
        				.filter(s -> (s.getStoreId().equals(store.getReferenceStoreId()) 
        								&& s.getExpectedSales() != null))
        				.map(Store::getExpectedSales)
        				.findFirst()
        				.orElse(average(data));
        		
        		expectedSalesOfStore.put(store.getReferenceStoreId(), expectedSales);
        	}
        }
        
        // Copy expectedSales calculated from Map -> List<Store> 
        for (var map: expectedSalesOfStore.entrySet()) {
        	for (Store store: data) {
        		if (store.getReferenceStoreId() != null && store.getReferenceStoreId().equals(map.getKey())) {
        			store.setExpectedSales(map.getValue());
        			break;
        		}
        	}
        }
        
        generate("Step1.List<Store>", data);
        
        // Step 2
        Map<Long, BigDecimal> allocationKey = data.stream()
				.collect(Collectors.toMap(
						Store::getStoreId, 
						s -> s.getExpectedSales().divide(sumExpectedSales(data), 10, RoundingMode.HALF_UP), 
						(v1, v2) -> v1, 
						LinkedHashMap::new));
        generate("Step2.Map<StoreId,AllocationKey>", allocationKey.entrySet());
        
        // Step 3
        Map<Long, Integer> amountAllocated = data.stream()
        		.collect(Collectors.toMap(
        				Store::getStoreId, 
        				s -> {
        					BigDecimal allocationKeyStore = allocationKey.entrySet().stream()
        							.filter(store -> store.getKey().equals(s.getStoreId()))
        							.findFirst()
        							.orElse(null)
        							.getValue();
        					return allocationKeyStore.multiply(bd(whAllocationAmount).add(sumStockPreviousDay(data)))
        							.subtract(s.getStockPreviousDay()).setScale(0, RoundingMode.HALF_UP).intValue();
        				},
        				(v1, v2) -> v1, 
						LinkedHashMap::new));
        generate("Step3.Map<StoreId,Amount Allocated>", amountAllocated.entrySet());
        
        // Step 4
        switch (sumAmountsAllocated(amountAllocated).compareTo(whAllocationAmount)) {
		case 0:
			return amountAllocated;
		case 1:
			while (!sumAmountsAllocated(amountAllocated).equals(whAllocationAmount)) {
        		Map<Long, Integer> demand = data.stream()
        				.collect(Collectors.toMap(
        						Store::getStoreId, 
        						s -> max(s.getExpectedSales().subtract(s.getStockPreviousDay()), bd(0))
        							.setScale(0, RoundingMode.HALF_UP).intValue(),
        						(v1, v2) -> v1,
        						LinkedHashMap::new));
        		generate("Step4.Map<StoreId, Demand>", demand.entrySet());
        		
        		Map<Long, Integer> difference = data.stream()
        				.collect(Collectors.toMap(
        						Store::getStoreId, 
        						s -> {
        							Integer amountAllocatedStore = amountAllocated.entrySet().stream()
                							.filter(a -> a.getKey().equals(s.getStoreId()))
                							.findFirst()
                							.orElse(null)
                							.getValue();
        							Integer demandStore = demand.entrySet().stream()
                							.filter(d -> d.getKey().equals(s.getStoreId()))
                							.findFirst()
                							.orElse(null)
                							.getValue();
        							return amountAllocatedStore - demandStore;
        						},
        						(v1, v2) -> v1,
        						LinkedHashMap::new));
        		generate("Map<StoreId, Difference>", difference.entrySet());
        		
        		// find storeId of Map has difference between Amount Allocated and Demand is biggest
        		// use sorted(desc) -> choose element first. But sorted not enough requirements
        		Long storeIdBiggestDifference = difference.entrySet().stream()
        				.sorted(Entry.comparingByValue(Comparator.reverseOrder()))
            			.findFirst()
            			.orElse(null)
            			.getKey();
        		// Subtract one allocation unit (one case) from Store just found
        		Integer amountAllocatedRepaired = amountAllocated.entrySet().stream()
        				.filter(a -> a.getKey().equals(storeIdBiggestDifference))
        				.findFirst()
        				.orElse(null)
        				.getValue() - 1;
        		amountAllocated.entrySet().stream()
        				.filter(a -> a.getKey().equals(storeIdBiggestDifference))
        				.findFirst()
        				.orElse(null)
        				.setValue(amountAllocatedRepaired);
        	}
			break;
		case -1:
			// tương tự như trên
		}
        
        return amountAllocated;
    }
}
