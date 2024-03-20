package view.list;

import static utils.CollectionUtils.generate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex03AList_ObjectType {

	public static void main(String[] args) {
		
		// Object type: single & custom
		
		// new ArrayList<>() -> dynamic array supports add, remove, get, set
		List<String> sequences = new ArrayList<>();
		
		// add
		sequences.add("sgk-12");
		sequences.add("sgk-46");
		sequences.add("sgk-829");
		sequences.add("stk-88");
		sequences.add("stk-99");
		sequences.add("sgk-175");
		sequences.add("sgk-829");
		
		// remove:
		// --> Duyệt từng phần tử trong list, nếu phần tử nào 'equals'
		// với phần tử cần remove --> remove
		// --> chỉ remove phần tử đầu tiên equals với phần tử cần xóa
		sequences.remove("sgk-829");
		
		// remove with condition
		// + for index: ignore
		// + for each : ConcurrentModificationException(fail first)

		// phân biệt for each với iterator
		// + for each: truy cập bất kỳ phần tử nào lúc đang for
		//			-> khi lỡ thay đổi size của array (xóa/thêm phần tử) thì vòng for sẽ lỗi
		// + iterator: chỉ truy cập tới phần tử mà iterator đang duyệt đến(tuần tự)
		
		// removeIf
		/*
		sequences.removeIf(new Predicate<String>() {
			@Override
			public boolean test(String seq) {
				return seq.startsWith("stk");
			}
		});
		-->
		*/
		sequences.removeIf(seq -> seq.startsWith("stk"));
		
		// get(i)
		// set(i, newValue)
		// contains:
		// --> Duyệt từng phần tử trong list, nếu phần tử nào 'equals'
		// với phần tử đang kiểm tra --> true
		boolean hasSgk12 = sequences.contains("sgk-12");
		System.out.println("hasSgk12 --> " + hasSgk12);
		
		/*
		 * In
		sequences.forEach(new Consumer<String>() {
			@Override
			public void accept(String seq) {
				System.out.println(seq);
			}
		});
		--> sequences.forEach(seq -> System.out.println(seq));
			or: sequences.forEach(System.out::println);
		 */

		generate("sequences", sequences);
		
		// ==============================================================
		
		// java.util.Arrays#ArrayList(fixed size(length))
		// UnsupportedOperationException --> add, remove
		// support --> get, set
		List<Integer> numbers = Arrays.asList(5, 2, 4, 5, 2, 2);
		numbers.add(27);
		numbers.remove(5);
		numbers.set(0, 99);
		System.out.println("numbers --> " + numbers.size());
		
		// java.util.ImmutableCollections --> immutable list
		// UnsupportedOperationException --> add, remove, replaceAll, set, sort
		List<String> letters = List.of("a", "b", "c", "d");
		letters.add("zaa");
		letters.remove(2);
		letters.set(1, "t");
		System.out.println("letters --> " + letters.size());
	}
}
