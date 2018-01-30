package test;

public class Test1 {

	/**用于测试
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		char arr[] = new char[5];
//		new Test1().generate(arr, 0);
		StringBuilder sb = new StringBuilder();
		java.util.Properties p = System.getProperties();
		java.util.Set<Object> keyset = p.keySet();
		for (Object key : keyset) {
			sb.append("?"+(String)key+" : "+ p.getProperty((String)key)+"?");
		}
		System.out.print(sb.toString());
		
//		String str = "os.name:"+System.getProperty("os.name")+"\n"
//				+"os.arch:"+System.getProperty("os.arch")+"\n"
//				+"os.version:"+System.getProperty("os.version")+"\n"
//				+"java.version:"+System.getProperty("java.version")+"\n"
//				+"java.vendor:"+System.getProperty("java.vendor")+"\n"
//				+"java.home:"+System.getProperty("java.home")+"\n"
//				+"java.vm.version:"+System.getProperty("java.vm.version")+"\n"
//				+"java.vm.vendor:"+System.getProperty("java.vm.vendor")+"\n"
//				+"java.vm.name:"+System.getProperty("java.vm.name")+"\n"	
//				;
//		System.out.println(str);
	}
	
	/*
	 * java.version	Java 运行时环境版本
java.vendor	Java 运行时环境供应商
java.vendor.url	Java 供应商的 URL
java.home	Java 安装目录
java.vm.specification.version	Java 虚拟机规范版本
java.vm.specification.vendor	Java 虚拟机规范供应商
java.vm.specification.name	Java 虚拟机规范名称
java.vm.version	Java 虚拟机实现版本
java.vm.vendor	Java 虚拟机实现供应商
java.vm.name	Java 虚拟机实现名称
java.specification.version	Java 运行时环境规范版本
java.specification.vendor	Java 运行时环境规范供应商
java.specification.name	Java 运行时环境规范名称
java.class.version	Java 类格式版本号
java.class.path	Java 类路径
java.library.path	加载库时搜索的路径列表
java.io.tmpdir	默认的临时文件路径
java.compiler	要使用的 JIT 编译器的名称
java.ext.dirs	一个或多个扩展目录的路径
os.name	操作系统的名称
os.arch	操作系统的架构
os.version	操作系统的版本
file.separator	文件分隔符（在 UNIX 系统中是“/”）
path.separator	路径分隔符（在 UNIX 系统中是“:”）
line.separator	行分隔符（在 UNIX 系统中是“/n”）
user.name	用户的账户名称
user.home	用户的主目录
user.dir	用户的当前工作目录
	 */
	
	/**
	 * 生成 "abcde"五个字母的全排列字符串
	 */
	public static void permute(java.util.List<Character> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
		}
	}

	char[] data = "abcde".toCharArray();
	public void generate(char[] arr, int n) {	
		if(n==arr.length){
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]);
			}
			System.out.println();
		}else {
			for (int i = 0; i < data.length; i++) {
				arr[n] = data[i];
				generate(arr, n+1);
			}
		}
	}
}
