package homework;

public class MatrixUtils {

	public static void show(Matrix matrix) {
		for (int i = 0; i < matrix.getRow(); i++) {
			for (int j = 0; j < matrix.getColumn(); j++)
				System.out.print(matrix.getValue()[i][j] + "\t");
			System.out.println("");
		}	
	}
	
	public static void horseSaddle(Matrix matrix) {
		int min;
		int max = 0;
		int temp = 0;
		for (int i = 0; i < matrix.getRow(); i++) {				//duyệt từng hàng
			
			min = matrix.getValue()[i][0];						//gán min là phần tử đầu tiền trong hàng
			for (int j = 0; j < matrix.getColumn(); j++) {		//duyệt từng phần tử trong hàng để tìm min
				if (matrix.getValue()[i][j] < min) {
					min = matrix.getValue()[i][j];
					temp = j;									//tìm được chỉ số cột của min
				}
			}
			
			//xét cột chứa phần tử min, để tìm max
			max = matrix.getValue()[0][temp];					//cho max là phần tử đầu tiên trong cột
			for (int k = 0; k < matrix.getRow(); k++) {			//duyệt từng phần tử trong cột để tìm max
				max = matrix.getValue()[k][temp] > max ? matrix.getValue()[k][temp] : max;
			}
			
			if (min == max) {									//nếu phần tử min cũng chính là max thì đó
				System.out.println("Ma trận có phần tử yên ngựa là --> " + max);	//là phần tử yên ngựa
				return;											//tìm được thì dừng chương trình vì ma trận
			}													//chỉ có 1 phần tử yên ngựa
		}
		System.out.println("Ma trận không có phần tử yên ngựa");
	}
}
