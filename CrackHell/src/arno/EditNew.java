package arno;



/** 
* @author Arno E-mail: davidxuxin@qq.com
* @version ����ʱ�䣺2016��5��3�� ����6:41:54 
* ��˵�� 
* =====================
* 5.3�����Ľ��㷨��Լ�ռ�
*/ 
public class EditNew {
	
	public static String EditNewC(String str) {
	
//		������ֵ����ID��ת������������
		String Number=str;
		StringBuffer b = new StringBuffer();
		try {
			int Money = Integer.parseInt(Number);
//			int Money =str;
//			����̶�ǰ׺�ͺ�׺���ַ��� beg��end
			String Beg="01129600";
			String End="f1ffffffffffffffff";
			int Code = 0x85;
//		����һ��byte�������飬�����ݰ�byte�����Ա��������͵�����	
			byte [] t = new byte[2];
			t[0]=(byte)(Money 		& 0xFF);
			t[1]=(byte)(Money 	>>8 & 0xFF);
//		�õ�����λ���Ĳ��� ��Ҫ��չbyte���鳤��
//			t[2]=(byte)(Money 	>>16& 0xFF);
//			t[3]=(byte)(Money 	>>24& 0xFF);
			
//		�������ı��棬ʹ���������ݵ����ͼ���ΪF1
			byte value=(byte)(t[1]^t[0]^Code);

	//=================================================================================
//		��������

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
