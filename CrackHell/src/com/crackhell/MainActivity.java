package com.crackhell;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import arno.CrackArno;
import arno.EditNew;
import database.CardDatabase;

/** 
* @author Arno E-mail: davidxuxin@qq.com
* @version ����ʱ�䣺2016��4��27�� ����12:13:28 
* ��˵�� 
* 5.4  version 1.43����
* 1�������������ݱ�һ�����ݿ⣬�򻯴���
* ===========================================
* 5.3  version 1.42����
* 1����Ӱ�����Ч
* ===========================================
* 5.3  version 1.40����
* 1���޸��洢����bug��ʹ��sqlite���ݿ⽨���������洢
* ���ӹ淶����
* 2��ʹ��AndroidJunit��Ԫ���Ը��ӷ����ҵ�bug* 
* 3���ֽ׶������汾
* =========================================== 
* 5.2  version 1.31����
* 1����xml�ļ���������ʹ���ĵ����������������
* 2��ʹ��string.xml �޸ĵİ汾��ʾ���ø��ӹ淶
* ===========================================
* 3����������⣺XML�ĳ�appendģʽ�Ծ�ֻ��׷��һ����Ϣ
* ���⴦��������KEY��ͬ���µģ��������������sqllite���ѽ�� 5.3 version 1.40��
* ===========================================
* 4.29 version 1.30����
* 1�����¿������뷽ʽ�ÿո����
* 2��������־�����ʽ���������ݲ�������
* ===========================================
* 4.27 version1.20����
* 1���޸����������������bug
* 2����������־�����¼�������˸�ʽ
*/ 
public class MainActivity extends Activity {
	private SoundPool sp1;//����һ��SoundPool
    private int music1;//����һ��������load������������suondID
	private SoundPool sp2;//����һ��SoundPool
    private int music2;//����һ��������load������������suondID
    
	 //��ȡ�����ļ��ж���İ�ť

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	    Button bt1 = (Button) findViewById(R.id.buttonCrack);
	    Button bt2 = (Button) findViewById(R.id.buttonCaculate);
        sp1= new SoundPool(10, AudioManager.STREAM_SYSTEM, 5);//��һ������Ϊͬʱ���������������������ڶ����������ͣ�����Ϊ��������
        music1 = sp1.load(this, R.raw.lowbattery, 1); //����������زķŵ�res/raw���2��������Ϊ��Դ�ļ�����3��Ϊ���ֵ����ȼ�
        sp2= new SoundPool(10, AudioManager.STREAM_SYSTEM, 5);
        music2 = sp2.load(this, R.raw.musicshake, 1); 
        
        //��������
        bt1.setOnClickListener(new Crack());
        bt2.setOnClickListener(new Cal());
	}
	class Crack implements OnClickListener{

		private EditText et1;
		private EditText et2;
		private EditText et3;
		
		SimpleDateFormat formatter = new SimpleDateFormat ("yyyy��MM��dd��  HH:mm:ss");       
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
			Toast.makeText(MainActivity.this, "�ƽ�ɹ�", Toast.LENGTH_SHORT).show();
			
//			�������ݿ�
//			Activity�е�context��getBaseContext()��ȡ
			CardDatabase cdb = new CardDatabase(getBaseContext());
//			������ݿⲻ���ڣ��ȴ����ٴ򿪡�������ھ�ֱ�Ӵ�
			SQLiteDatabase db = cdb.getWritableDatabase();
//			�ֶΣ�1��id 2��cardNumber 3��area 4��keyCode 5��date��
			db.execSQL("insert into CardDatabase(cardNumber,area,keyCode,date) values(?,?,?,?)",
					new Object[]{number1,area,str1re,datestr});
			db.close();
//			���Ű�ť��Ч
			sp1.play(music1, 1, 1, 0, 0, 1);
		}
		
		
	}
	
	class Cal implements OnClickListener{

		private EditText et4;
		private EditText et5;
		
		SimpleDateFormat formatter = new SimpleDateFormat ("yyyy��MM��dd��    HH:mm:ss     ");       
		Date curDate = new  Date(System.currentTimeMillis());//��ȡ��ǰʱ��       
		String datestr = formatter.format(curDate);  

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
			Toast.makeText(MainActivity.this, "�������", Toast.LENGTH_SHORT).show();

			
//			�������ݿ�
//			Activity�е�context��getBaseContext()��ȡ
			CardDatabase cdb = new CardDatabase(getBaseContext());
//			������ݿⲻ���ڣ��ȴ����ٴ򿪡�������ھ�ֱ�Ӵ�
			SQLiteDatabase db = cdb.getWritableDatabase();
//			����������ݿ� �ֶΣ�1��id 2��money 3��key 4��date��
			db.execSQL("insert into MoneyDatabase(money,key,date) values(?,?,?)",
					new Object[]{number2,str2re,datestr});
			db.close();
//			���Ű�ť��Ч
			sp2.play(music2, 1, 1, 0, 0, 1);

		}
		
	}
	
}
