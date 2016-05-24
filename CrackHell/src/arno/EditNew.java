package arno;



/** 
* @author Arno E-mail: davidxuxin@qq.com
* @version 创建时间：2016年5月3日 下午6:41:54 
* 类说明 
* =====================
* 5.3——改进算法节约空间
*/ 
public class EditNew {
	
	public static String EditNewC(String str) {
	
//		接收数值赋给ID并转换成整型数字
		String Number=str;
		StringBuffer b = new StringBuffer();
		try {
			int Money = Integer.parseInt(Number);
//			int Money =str;
//			定义固定前缀和后缀的字符串 beg、end
			String Beg="01129600";
			String End="f1ffffffffffffffff";
			int Code = 0x85;
//		定义一个byte类型数组，将数据按byte存入以便用于异或和的运算	
			byte [] t = new byte[2];
			t[0]=(byte)(Money 		& 0xFF);
			t[1]=(byte)(Money 	>>8 & 0xFF);
//		拿到更多位数的操作 需要扩展byte数组长度
//			t[2]=(byte)(Money 	>>16& 0xFF);
//			t[3]=(byte)(Money 	>>24& 0xFF);
			
//		运算结果的保存，使得整条数据的异或和检验为F1
			byte value=(byte)(t[1]^t[0]^Code);

	//=================================================================================
//		输出结果：

			if (t[1]!=0) {
				b.append(String.format(Beg+"%x"+"%x"+"%x"+End,t[1],t[0],value));
			}
			else if(t[1]==0 & t[0]==0){
				b.append(String.format(Beg+"0000"+"%x"+End,value));
			}
			else if(t[1]==0){
				b.append(String.format(Beg+"00"+"%x"+End,value));
			}
			return b.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b.toString();
		
		

		
		
	}
}
