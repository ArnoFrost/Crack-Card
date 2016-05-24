package history;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.crackhell.R;
import com.crackhell.R.id;
import com.crackhell.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import arno.CrackArno;
import arno.EditNew;

/** 
* @author Arno E-mail: davidxuxin@qq.com
* @version ����ʱ�䣺2016��4��27�� ����12:13:28 
* ��˵��  
* 4.29 version 1.30����
* 1�����¿������뷽ʽ�ÿո����
* 2��������־�����ʽ���������ݲ�������
* version1.20����
* 1���޸����������������bug
* 2����������־�����¼�������˸�ʽ
*/ 
public class Backup extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 //��ȡ�����ļ��ж���İ�ť
        Button bt1 = (Button) findViewById(R.id.buttonCrack);
        Button bt2 = (Button) findViewById(R.id.buttonCaculate);
        //��������
        bt1.setOnClickListener(new Crack());
        bt2.setOnClickListener(new Cal());
	}
	class Crack implements OnClickListener{

		private EditText et1;
		private EditText et2;
		private EditText et3;
		
		SimpleDateFormat formatter = new SimpleDateFormat ("yyyy��MM��dd��    HH:mm:ss     ");       
		Date curDate = new  Date(System.currentTimeMillis());//��ȡ��ǰʱ��       
		String datestr = formatter.format(curDate);  

		@Override
		public void onClick(View v) {
			et1 = (EditText) findViewById(R.id.cardNumber);
			et2 = (EditText) findViewById(R.id.sectorNumber);
			et3 = (EditText) findViewById(R.id.secretKeynumber);
			//��ȡ�û�����ĺ���
			String number1 = et1.getText().toString();
			String areaText = et2.getText().toString();
			Integer area = Integer.parseInt(areaText);
			new CrackArno();
			String str1re=CrackArno.CrackAl(number1,area);
			et3.setText(str1re);
//			��˾�Ի���
			Toast t = Toast.makeText(Backup.this, "�ƽ�ɹ�", Toast.LENGTH_SHORT);
			t.show();
//			log��־��¼
//			\r\nΪ���з�
//			****getFilesDir()��װĿ¼("data/data/com.crackhell/files");****
			File file = new File(getFilesDir(),"info.txt");

			try {
				FileOutputStream fos = new FileOutputStream(file,true);
				fos.write((datestr+"���ţ�"+number1+"\t��������������"+area+"\t����������Կ��"+str1re+"\r\n").getBytes());
				fos.close();
				System.out.println("����");
			} catch (Exception e) {
				e.printStackTrace();
			}
////		SharedPreferences Ϊ�ӿ�
////		��һ��Ϊд����ļ������ڶ���Ϊ�洢ģʽ���˴�ʹ��append���ļ�Ҳ��private�ڲ��洢�����ƶ�·��
//		SharedPreferences sp = getSharedPreferences("info", MODE_APPEND);
////		TODO: XML�ĳ�appendģʽ�Ծ�ֻ��׷��һ����Ϣ
////		��ȡ�༭��
//		Editor et = sp.edit();
////		����XML�ļ��е�KEY��Value
//		et.putString("CardNumber", number1);
//		et.putString("CardArea", areaText);
//		et.putString("AreaKey", str1re);
//		et.putString("Date", datestr);
////		�ύ
//		et.commit();
		}
		
		
	}
	
	class Cal implements OnClickListener{

		private EditText et4;
		private EditText et5;

		@Override
		public void onClick(View v) {
			et4 = (EditText) findViewById(R.id.moneyNumber);
			et5 = (EditText) findViewById(R.id.moneySecretkey);
			
			String number2 = et4.getText().toString();
//			Integer money = Integer.parseInt(number2);
			new EditNew();
			String str2re=EditNew.EditNewC(number2);
			et5.setText(str2re);
//			��˾�Ի���
			Toast t = Toast.makeText(Backup.this, "�������", Toast.LENGTH_SHORT);
			t.show();
//			log��־��¼
//			\r\nΪ���з�
//			****getFilesDir()��װĿ¼("data/data/com.crackhell/files");****
			File file = new File(getFilesDir(),"Caculate.txt");
			try {
				FileOutputStream fos = new FileOutputStream(file,true);
				fos.write((number2+"&&"+str2re+"\r\n").getBytes());
				fos.close();
				System.out.println("����");
			} catch (Exception e) {
				e.printStackTrace();
			}
////		SharedPreferences Ϊ�ӿ�
////		��һ��Ϊд����ļ������ڶ���Ϊ�洢ģʽ���˴�ʹ��append���ļ�Ҳ��private�ڲ��洢�����ƶ�·��
//		SharedPreferences sp = getSharedPreferences("CalulateInfo", MODE_APPEND);
////		TODO: XML�ĳ�appendģʽ�Ծ�ֻ��׷��һ����Ϣ
////		��ȡ�༭��
//		Editor et = sp.edit();
////		����XML�ļ��е�KEY��Value
//		et.putString("Money", number2);
//		et.putString("MoneyKey", str2re);
//		et.putString("Date", datestr);
////		�ύ
//		et.commit();
		}
		
	}
	
}
