package view.online.exercises;

import static utils.CollectionUtils.*;
import static java.util.Comparator.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import bean.Trader;
import bean.Transaction;

public class Ex01TransactionApp {
	
	public static void main(String[] args) {
		List<Transaction> transactions = getTransactions();
		System.out.println("--- ___ * START * ___ ---");
		
		// 1. Find all transactions in the year 2011 and sort them by value (small to high).
		List<Transaction> transactions1 = findTransactions(transactions, 
														transaction -> transaction.getYear() == 2011);
		transactions1.sort(comparing(Transaction::getValue));
		generate("1.Transaction in the year 2011 and sort them by value ascending\n", transactions1);
		
		// 2. Find all transactions have value greater than 300 and sort them by trader’s city
		List<Transaction> transactions2 = findTransactions(transactions, 
														transaction -> transaction.getValue() > 300);
		transactions2.sort((t1, t2) -> t1.getTrader().getCity().compareTo(t2.getTrader().getCity()));
		generate("2.Transaction have value greater than 300 and sort them by trader’s city\n", transactions2);

		// 3. What are all the unique cities where the traders work?
		List<String> uniqueCities = getTrader(transactions, transaction -> transaction.getTrader().getCity());
		generate("3.All the unique cities where the traders work\n", uniqueCities);

		// 4. Find all traders from Cambridge and sort them by name desc.
		List<Trader> traders4 = findTraders(transactions, 
											transaction -> transaction.getTrader().getCity().equals("Cambridge"));
		traders4.sort(comparing(Trader::getName, reverseOrder()));
		generate("4.Trader from Cambridge and sort them by name desc\n", traders4);

		// 5. Return a string of all traders’ names sorted alphabetically.
		List<String> nameTrader = getTrader(transactions, transaction -> transaction.getTrader().getName());
		nameTrader.sort(String::compareTo);
		generate("5.All traders’ names sorted alphabetically\n", nameTrader);
		
		// 6. Are any traders based in Milan?
		List<Trader> traders6 = findTraders(transactions, 
											transaction -> transaction.getTrader().getCity().equals("Milan"));
		generate("6.Traders based in Milan\n", traders6);
		
		// 7. Count the number of traders in Milan.
		System.out.println("7.Count the number of traders in Milan -> " + traders6.size());
		
		// 8. Print all transactions’ values from the traders living in Cambridge.
		List<Transaction> transactions8 = findTransactions(transactions, 
										transaction -> transaction.getTrader().getCity().equals("Cambridge"));
		System.out.println("8.Transactions’ values from the traders living in Cambridge\n {");
		transactions8.forEach(seq -> {
			System.out.println("    " + seq.getValue());
		});
		System.out.println("\n}");
		
		// 9. What’s the highest value of all the transactions?
		transactions.sort(comparing(Transaction::getValue, reverseOrder()));
		System.out.println("9.The highest value of all the transactions -> " + transactions.get(0).getValue());
		
		// 10. Find the transaction with the smallest value.
		int minValue = transactions.get(transactions.size() - 1).getValue();
		List<Transaction> transactions10 = findTransactions(transactions, 
															transaction -> transaction.getValue() == minValue);
		generate("10.Transaction with the smallest value:\n", transactions10);
		
		System.out.println("--- ___ * FINISH * ___ ---");
	}
	
	private static List<Transaction> findTransactions(List<Transaction> transactions, 
													Predicate<Transaction> predicate) {
		var result = new ArrayList<Transaction>();
		for (Transaction transaction: transactions)
			if (predicate.test(transaction))
				result.add(transaction);
		return result;
	}
	
	private static List<Trader> findTraders(List<Transaction> transactions, Predicate<Transaction> predicate) {
		var result = new ArrayList<Trader>();
		for (Transaction transaction: transactions)
			if (predicate.test(transaction) && !(result.contains(transaction.getTrader())))
				result.add(transaction.getTrader());
		return result;
	}
	
	private static List<String> getTrader(List<Transaction> transactions, 
										Function<Transaction, String> function) {
		var result = new ArrayList<String>();
		for (Transaction transaction: transactions)
			if (!(result.contains(function.apply(transaction))))
				result.add(function.apply(transaction));
		return result;
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