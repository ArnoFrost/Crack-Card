package arno;

/**
 * @author Arno E-mail: davidxuxin@qq.com
 * @version ����ʱ�䣺2016��4��29�� ����6:25:25
 * ��˵�� 
 * ==============================
 * 4.29���������Ż��ָʽ���Ӷ��Ÿ�Ϊ�ո�ӿ�����Ч��
 * ==============================
 * 5.3�����Ż��㷨��ʽ����Լ��Դ�ռ�
 */
public class CrackArno {

	public static String CrackAl(String string,Integer area) {
//	��������Ϊarea
//	���Կ������ݣ�9d e5 c4 61������������0c d3 87 08
//	���������鶨ֵ words1��words2
//		int words1 = 0x9136;
//		int words2 = 0x4369;
		int[] judge=new int[4];						//�ж���
		String fixedValue="ff 07 80 69";			//�̶�ֵ����
		String fixedValue2=" ff ff ff ff ff ff";
		StringBuilder b = new StringBuilder();		//����׷���ַ����Ĺؼ�

//======================================================================
		int[] key={0x91,0x36,0x43,0x69};			//12������Կ�̶�ֵ
		int[] key2=new int[4];						//0������Կ����ֵ
		int[] key3={0x95,0x37,0x23,0x96,0xeb,0x61,0xff,0x07,0x80,0x69,0x95,0x37,0x23,0x96,0xeb,0x61};	//3������Կ�̶�ֵ
		int[] key4={0xff,0xff,0xff,0xff,0xff,0xff};	//11������ԿĬ��ֵ
		int[] key5=new int[4];						//1������Կ����ֵ
//======================================================================
		try {
//	���տ���


			String IDinput=string;					//��ֵ��String����ֵID
//	��String��ID���ŷ������鲢��ʮ����������ʽ�洢
// 	3AFB ����ֵ����
			String[] str = IDinput.split("\\s");

//=====================================================================
			int[] ID = new int[str.length];
//		System.out.println("��ʮ����������Կ keyA �ؼ���Ϊ��");
//		for(int k=0;k<str.length;k++){				//����str.length�����㵫�������й̶�ֵʡ��
/*
 * ���������Ż�������bug��ѯ����������һ����������Ϊȫ�ֱ����ȸ�ֵ�������Խ��֮ǰ��ȡ����ֵ������
 * ��Ҳ����ʱһ�������ƽ��һ�����ʱ��
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
//			��������12������Կ�̶�ֵ���������
//					judge[i]=ID[i]^key[i];
							// append StringBuffer׷���ַ�

							if(judge[i]<=15){							//������������ַ�С�ڵ���F����֮ǰ��һ��0����λ��ֹ�������
								b.append(String.format("0"+"%x"+" ",ID[i]^key[i]));
							}else{
								b.append(String.format("%x"+" ",ID[i]^key[i]));
							}

						}
						b.append("33 90 ");
						b.append(fixedValue);			//�̶�����λ
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
							//	��������3������Կ�̶�ֵ���������õ�1������Կ������ֵ��1������Կ��
//						key2[i]=ID[i]^key3[i];

							if(key2[i]<=15){							//������������ַ�С�ڵ���F����֮ǰ��һ��0����λ��ֹ�������
								b.append(String.format("0"+"%x"+" ",key2[i]));
							}else{
								b.append(String.format("%x"+" ",key2[i]));
							}

						}
						b.append("33 90 ");
						b.append(fixedValue+" ");			//�̶�����λ
						//	ѭ�����
						for(int i=0;i<4;i++){
							//			judge[i]=ID[i]^key3[i];
							//	��������3������Կ�̶�ֵ���������õ�1������Կ������ֵ��1������Կ��
//						key2[i]=ID[i]^key3[i];

							if(key2[i]<=15){							//������������ַ�С�ڵ���F����֮ǰ��һ��0����λ��ֹ�������
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
							//	��1������Կ��3������Կ���������ĵ�2������Կ
							if(key5[i]<=15){							//������������ַ�С�ڵ���F����֮ǰ��һ��0����λ��ֹ�������
								b.append(String.format("0"+"%x"+" ",key5[i]));
							}else{
								b.append(String.format("%x"+" ",key5[i]));
							}

						}
						b.append("d8 f1 ");
						b.append(fixedValue).append(" ");			//�̶�����λ

						// 	ѭ�����
						for(int i=0;i<4;i++){
//					key5[i]=key2[i]^key3[i];
							//	��1������Կ��3������Կ���������ĵ�2������Կ
							if(key5[i]<=15){							//������������ַ�С�ڵ���F����֮ǰ��һ��0����λ��ֹ�������
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
