package test;

/**使用回溯方法生成所有 n 位长的字符串。
 * @author sumuxi
 *
 */
public class Binary {
	static int A[];
	public static void binary1(int n) {
		if (n<1) {
			for (int i = 0; i < A.length; i++) {
				System.out.print(A[i]);
			}
			System.out.println();
		}else {
			A[n-1] = 0;
			binary1(n-1);
			A[n-1] = 1;
			binary1(n-1);
		}
	}
	
	public static void binary2(int n) {
		if (n == A.length) {
			for (int i = 0; i < A.length; i++) {
				System.out.print(A[i]);
			}
			System.out.println();
		}else {
			A[n] = 0;
			binary2(n+1);
			A[n] = 1;
			binary2(n+1);
		}
	}
	//static int num = 0;
	public static void kString(int n, int k) {
		if (n<1) {
			for (int i = A.length-1; i >= 0; i--) {
				System.out.print(A[i]);
			}
			System.out.println();
			//num++;
		}else {
			for (int i = 0; i < k; i++) {
				A[n-1] = i;
				kString(n-1, k);
			}
		}
	}
	
	public static void main(String[] args) {
		A = new int[4];
//		binary1(A.length);
//		binary2(0);
		kString(A.length, 3);
		//System.out.println(num);

	}

}

