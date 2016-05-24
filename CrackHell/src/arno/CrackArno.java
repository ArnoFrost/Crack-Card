package arno;

/**
 * @author Arno E-mail: davidxuxin@qq.com
 * @version 创建时间：2016年4月29日 下午6:25:25
 * 类说明 
 * ==============================
 * 4.29——更新优化分割方式，从逗号改为空格加快输入效率
 * ==============================
 * 5.3——优化算法方式，节约资源空间
 */
public class CrackArno {

	public static String CrackAl(String string,Integer area) {
//	扇区数字为area
//	测试卡号数据：9d e5 c4 61——————0c d3 87 08
//	定义异或检验定值 words1、words2
//		int words1 = 0x9136;
//		int words2 = 0x4369;
		int[] judge=new int[4];						//判断数
		String fixedValue="ff 07 80 69";			//固定值补充
		String fixedValue2=" ff ff ff ff ff ff";
		StringBuilder b = new StringBuilder();		//用于追加字符串的关键

//======================================================================
		int[] key={0x91,0x36,0x43,0x69};			//12扇区秘钥固定值
		int[] key2=new int[4];						//0扇区秘钥运算值
		int[] key3={0x95,0x37,0x23,0x96,0xeb,0x61,0xff,0x07,0x80,0x69,0x95,0x37,0x23,0x96,0xeb,0x61};	//3扇区秘钥固定值
		int[] key4={0xff,0xff,0xff,0xff,0xff,0xff};	//11扇区秘钥默认值
		int[] key5=new int[4];						//1扇区秘钥运算值
//======================================================================
		try {
//	接收卡号


			String IDinput=string;					//赋值给String类型值ID
//	将String的ID卡号放入数组并以十六进制数形式存储
// 	3AFB 检验值数据
			String[] str = IDinput.split("\\s");

//=====================================================================
			int[] ID = new int[str.length];
//		System.out.println("第十二扇区的秘钥 keyA 关键字为：");
//		for(int k=0;k<str.length;k++){				//可用str.length来方便但是由于有固定值省略
/*
 * 经过几次优化调整和bug查询发现这里有一个变量提升为全局变量先赋值出来可以解决之前获取不到值得问题
 * 这也是历时一年的软件破解告一段落的时候
 * */
			for(int i=0;i<4;i++){
				ID[i] = Integer.valueOf(str[i],16);
				judge[i]=ID[i]^key[i];
				key2[i]=ID[i]^key3[i];
				key5[i]=key2[i]^key3[i];
			}
			switch (area) {
				case 12:
					try{

						for(int i=0;i<4;i++){
//					ID[i] = Integer.valueOf(str[i],16);
//			将卡号与12扇区秘钥固定值做异或运算
//					judge[i]=ID[i]^key[i];
							// append StringBuffer追加字符

							if(judge[i]<=15){							//如果遇到出现字符小于等于F则在之前加一个0来补位防止输入误差
								b.append(String.format("0"+"%x"+" ",ID[i]^key[i]));
							}else{
								b.append(String.format("%x"+" ",ID[i]^key[i]));
							}

						}
						b.append("33 90 ");
						b.append(fixedValue);			//固定控制位
						b.append(fixedValue2);
						b.append("");
						return b.toString();
					}catch(Exception e){
						e.printStackTrace();
					}
					break;

				case 3:
				case 6:
				case 9:
				case 15:
				case 0:
					try {

						for(int i=0;i<4;i++){
							//			judge[i]=ID[i]^key3[i];
							//	将卡号与3扇区秘钥固定值做异或运算得到1扇区秘钥，并赋值到1扇区秘钥中
//						key2[i]=ID[i]^key3[i];

							if(key2[i]<=15){							//如果遇到出现字符小于等于F则在之前加一个0来补位防止输入误差
								b.append(String.format("0"+"%x"+" ",key2[i]));
							}else{
								b.append(String.format("%x"+" ",key2[i]));
							}

						}
						b.append("33 90 ");
						b.append(fixedValue+" ");			//固定控制位
						//	循环输出
						for(int i=0;i<4;i++){
							//			judge[i]=ID[i]^key3[i];
							//	将卡号与3扇区秘钥固定值做异或运算得到1扇区秘钥，并赋值到1扇区秘钥中
//						key2[i]=ID[i]^key3[i];

							if(key2[i]<=15){							//如果遇到出现字符小于等于F则在之前加一个0来补位防止输入误差
								b.append(String.format("0"+"%x"+" ",key2[i]));
							}else{
								b.append(String.format("%x"+" ",key2[i]));
							}

						}
						b.append("33 90 ");
						return b.toString();
					} catch (Exception e) {
						e.printStackTrace();
					}
				case 13:
				case 10:
				case 7:
				case 4:
				case 1:
					try {
						for(int i=0;i<4;i++){
//					key5[i]=key2[i]^key3[i];
							//	将1扇区秘钥与3扇区秘钥做异或运算的到2扇区秘钥
							if(key5[i]<=15){							//如果遇到出现字符小于等于F则在之前加一个0来补位防止输入误差
								b.append(String.format("0"+"%x"+" ",key5[i]));
							}else{
								b.append(String.format("%x"+" ",key5[i]));
							}

						}
						b.append("d8 f1 ");
						b.append(fixedValue).append(" ");			//固定控制位

						// 	循环输出
						for(int i=0;i<4;i++){
//					key5[i]=key2[i]^key3[i];
							//	将1扇区秘钥与3扇区秘钥做异或运算的到2扇区秘钥
							if(key5[i]<=15){							//如果遇到出现字符小于等于F则在之前加一个0来补位防止输入误差
								b.append(String.format("0"+"%x"+" ",key5[i]));
							}else{
								b.append(String.format("%x"+" ",key5[i]));
							}

						}
						b.append("d8 f1 ");
						return b.toString();
					} catch (Exception e) {
						e.printStackTrace();
					}
				case 14:
				case 8:
				case 5:
				case 2:
					try {
						for (int i = 0; i < key3.length; i++) {
							if(i==5 || i ==9){
								b.append(String.format("%x"+" ",key3[i]));
							}else if(i!=7){
								b.append(String.format("%x"+" ",key3[i]));
							}else{
								b.append("07 ");
							}
						}
						return b.toString();
					} catch (Exception e) {
						e.printStackTrace();
					}
				case 11:
					try {
						for (int aKey4 : key4) {
							b.append(String.format("%x" + " ", aKey4));
						}
						b.append(fixedValue).append(" ");
						for (int aKey4 : key4) {
//					System.out.format("%x"+" ",key4[i]);
							b.append(String.format("%x" + " ", aKey4));
						}
						return b.toString();
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				default:
					break;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return fixedValue2;

	}
}
