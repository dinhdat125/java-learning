package view.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
//import java.util.LinkedHashMap;
//import java.util.TreeMap;

public class Ex01VehicleModelDemo {

	public static void main(String[] args) {
		// Map<K, V> -> Entry<K, V>
		Map<Integer, String> models = new HashMap<>();
		// put<K, V> --> hashing(K) --> hashed --> store to memory
		
		//       HashMap: unordered(k đảm bảo thứ tự đưa vào), unsorted
		// LinkedHashMap:   ordered, unsorted
		//       TreeMap:            sorted(by key ascending, required key(comparable))
		
		models.put(92, "Quảng Nam");
		models.put(43, "Đà Nẵng");
		models.put(75, "Thừa Thiên Huế");
		models.put(74, "Quảng Trị");
		models.put(73, "Quảng Bình");
		
		// Cơ chế nào để khi put mới 1 phần tử vào Map --> biết được key đã tồn tại hay ko?
		
		// List<T> để kiểm tra 1 phần tử tồn tại hay ko:
		// duyệt từng phần tử xem có ai equals với phần tử cần kiểm tra hay ko
		// nếu có return true. Với Custom_Object: thay vì compare equals theo địa chỉ
		//										 thì phải override equals theo thuộc tính
		
		// Map.put(newKey, newValue)
		// Map<K, V> (HashMap và LinkedHashMap) để kiểm tra 1 phần tử tồn tại hay ko:
		// duyệt từng phần tử trong map xem có 1. key nào equals với newKey hay ko
		//									và 2. key này cùng hashcode với newKey hay ko
		// nếu thỏa mãn 2 điều kiện trên --> newKey đã tồn tại
		// else --> chưa tồn tại trong map
		// Đối với TreeMap: cũng duyệt từng phần tử nhưng k phải sử dụng hàm equals và hashcode
		//					mà sử dụng hàm compare hoặc compareTo
		
		// mặc định
		// boolean equals()   --> so sánh địa chỉ
		// int     hashcode() --> trả về địa chỉ mà JVM cấp phát cho đối tượng
		
		// xử lý với Custom_Object
		// override equals theo thuộc tính cần so sánh 2 đối tượng bằng nhau
		// override hashcode theo thuộc tính cần so sánh 2 đối tượng có hashing bằng nhau
		// lưu ý: 2 override phải theo cùng 1 thuộc tính
		
		models.put(43, "ĐN"); // override value if key available
		models.putIfAbsent(73, "QB"); // put if key absent
		
		// print by entry, key, value
		// List<T>, Set<T>
		Set<Entry<Integer, String>> entries = models.entrySet();
		for (Entry<Integer, String> entry: entries) {
			System.out.println(entry);
		}
		
	}
}
