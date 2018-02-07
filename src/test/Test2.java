package test;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = "123456".split("\\.");
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
		
		System.out.println("12345".endsWith("5"));
		
//		System.out.println(Integer.toBinaryString(16));
//		System.out.println(Double.toHexString(Double.parseDouble("0.5")));
		System.out.println((0.5)*2);
//		Double d = Double.parseDouble("2.5");
//		System.out.println(d.longValue());
	}

}
