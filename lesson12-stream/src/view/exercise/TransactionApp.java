package view.exercise;

import static java.util.Comparator.*;
import static utils.StreamUtils.generate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import bean.Trader;
import bean.Transaction;

public class TransactionApp {

	public static void main(String[] args) {
		var transactions = getTransactions();
		
		var transactions1 = transactions.stream()
				.filter(tran -> tran.getYear() == 2011)
				.sorted(comparing(Transaction::getValue))
				.toList();
		generate("1.Transaction in the year 2011 and sort them by value ascending", transactions1);
		
		var transactions2 = transactions.stream()
				.filter(tran -> tran.getValue() > 300)
				.sorted(comparing(tran -> tran.getTrader().getCity()))
				.toList();
		generate("2.Transaction have value greater than 300 and sort them by trader’s city", transactions2);
		
		var uniqueCities = transactions.stream()
				.map(tran -> tran.getTrader().getCity())
				.collect(Collectors.toSet());
		generate("3.All the unique cities where the traders work", uniqueCities);
		
		var traders4 = transactions.stream()
				.map(Transaction::getTrader)
				.filter(tra -> "Cambridge".equals(tra.getCity()))
				.sorted(comparing(Trader::getName, reverseOrder()))
				.collect(Collectors.toSet());
		generate("4.Trader from Cambridge and sort them by name desc\n", traders4);
		
		var tradersNames = transactions.stream()
				.map(tran -> tran.getTrader().getName())
				.distinct()
				.sorted()
				.collect(Collectors.joining(", "));
		System.out.println("5.A string of all traders’ names sorted alphabetically\n -> " + tradersNames);
		
		System.out.println("\n6.Are any traders based in Milan? -> " + 
				transactions.stream()
					.anyMatch(tran -> "Milan".equals(tran.getTrader().getCity())));
		
		System.out.println("\n7.Count the number of traders in Milan -> " + 
				transactions.stream()
					.map(Transaction::getTrader)
					.filter(tra -> "Milan".equals(tra.getCity()))
					.distinct()
					.count());
		
		var transactions8 = transactions.stream()
				.filter(tran -> "Cambridge".equals(tran.getTrader().getCity()))
				.map(Transaction::getValue)
				.toList();
		generate("\n8.All transactions’ values from the traders living in Cambridge", transactions8);
		
		transactions.stream()
			.mapToInt(Transaction::getValue)
			.max()
			.ifPresentOrElse(
					val -> System.out.println("9.The highest value of all the transactions -> " + val),
					() -> System.out.println("9.Not found the highest value of all the transactions"));
		
		var minValue = transactions.stream()
				.mapToInt(Transaction::getValue)
				.min();
		if (minValue.isPresent())
			generate("\n10.Transaction with the smallest value",
					transactions.stream()
						.filter(tran -> tran.getValue() == minValue.getAsInt())
						.toList());
		else
			System.out.println("\n10.Not found transaction with the smallest value");
	}
	
	public static List<Transaction> getTransactions() {
		// traders
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		
		// transactions
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), 
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), 
				new Transaction(mario, 2012, 700), 
				new Transaction(alan, 2012, 950));
		return transactions;
	}
}
