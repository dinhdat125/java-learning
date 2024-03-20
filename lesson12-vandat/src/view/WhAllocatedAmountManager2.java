package view;

import static java.util.Comparator.*;
import static utils.NumberUtils.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import bean.Store;
import bean.StoreParameters;
import model.DataModel;
	
public class WhAllocatedAmountManager2 {
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
        generate("Amount Allocated final", storeAllocatedValues.entrySet());
    }

    /**
     * Do Allocation.
     * Key: storeId with Long type
     * Value: storeAllocatedAmount after calculation with 4 steps
     * @return map of storeId, storeAllocatedAmount
     */
    private static Map<Long, Integer> doAllocation(List<Store> data, Integer whAllocationAmount) {
    	// Step 1
    	var para = new HashSet<StoreParameters>();
    	for (Store store: data) {
        	if (store.getExpectedSales() == null) {
        		BigDecimal expectedSales = data.stream()
        				.filter(s -> (s.getStoreId().equals(store.getReferenceStoreId()) 
        								&& s.getExpectedSales() != null))
        				.map(Store::getExpectedSales)
        				.findFirst()
        				.orElse(average(data));
        		
        		para.add(new StoreParameters(store.getStoreId(), store.getStockPreviousDay(), expectedSales, 
        					null, null, null, null));
        	}
        }
    	para.addAll(data.stream()
    			.map(s -> new StoreParameters(s.getStoreId(), s.getStockPreviousDay(), s.getExpectedSales(), 
    					null, null, null, null))
    			.collect(Collectors.toCollection(HashSet::new)));
    	generate("Step1.List<StoreParameters>", para);
    	
    	// Step 2
    	BigDecimal sumExpectedSales = sum(para, StoreParameters::getExpectedSales);
    	for (var p: para) {
    		p.setAllocationKey(p.getExpectedSales().divide(sumExpectedSales, 10, RoundingMode.HALF_UP));
    	}
    	generate("Step2.List<StoreParameters> after having Allocation Key", para);
    	
    	// Step 3
    	BigDecimal sumStockPreviousDay = sum(para, StoreParameters::getStockPreviousDay);
    	for (var p: para) {
    		p.setAmountAllocated(p.getAllocationKey().multiply(bd(whAllocationAmount).add(sumStockPreviousDay))
    							.subtract(p.getStockPreviousDay()).setScale(0, RoundingMode.HALF_UP).intValue());
    	}
    	generate("Step3.List<StoreParameters> after having Amount Allocated", para);
    	
    	// Step 4
    	Map<Long, Integer> amountAllocated = para.stream()
    			.collect(Collectors.toMap(
    					StoreParameters::getStoreId, 
    					StoreParameters::getAmountAllocated, 
    					(v1, v2) -> v1, 
    					HashMap::new));
    	
        switch (sumAmountsAllocated(amountAllocated).compareTo(whAllocationAmount)) {
		case 0:
			return amountAllocated;
		case 1:
			while (!sumAmountsAllocated(amountAllocated).equals(whAllocationAmount)) {
				for (var p: para) {
					p.setDemand(max(p.getExpectedSales().subtract(p.getStockPreviousDay()), bd(0))
								.setScale(0, RoundingMode.HALF_UP).intValue());
					p.setDifference(p.getAmountAllocated() - p.getDemand());
				}
        		generate("Step4\nList<StoreParameters> after having Demand and Difference", para);
        		
        		StoreParameters storeParametersNeedRepair = para.stream()
        				.sorted(comparing(StoreParameters::getDifference, reverseOrder())
        						.thenComparing(StoreParameters::getDemand)
        						.thenComparing(StoreParameters::getExpectedSales)
        						.thenComparing(StoreParameters::getStoreId))
            			.findFirst()
            			.orElse(null);
        		Integer amountAllocatedRepaired = storeParametersNeedRepair.getAmountAllocated() - 1;
        		storeParametersNeedRepair.setAmountAllocated(amountAllocatedRepaired);
        		generate("List<StoreParameters> after fixed Amount Allocated", para);
        		
        		amountAllocated.entrySet().stream()
        				.filter(a -> a.getKey().equals(storeParametersNeedRepair.getStoreId()))
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

	private static BigDecimal sum(HashSet<StoreParameters> para, Function<StoreParameters, BigDecimal> function) {
		return para.stream()
				.map(function)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}
}
