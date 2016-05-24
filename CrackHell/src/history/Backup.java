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
* @version 创建时间：2016年4月27日 上午12:13:28 
* 类说明  
* 4.29 version 1.30——
* 1、更新卡号输入方式用空格隔开
* 2、调整日志输出格式，加入数据插入日期
* version1.20——
* 1、修复了扇区单独运算的bug
* 2、增加了日志输出记录并调整了格式
*/ 
public class Backup extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 //获取布局文件中定义的按钮
        Button bt1 = (Button) findViewById(R.id.buttonCrack);
        Button bt2 = (Button) findViewById(R.id.buttonCaculate);
        //设置侦听
        bt1.setOnClickListener(new Crack());
        bt2.setOnClickListener(new Cal());
	}
	class Crack implements OnClickListener{

		private EditText et1;
		private EditText et2;
		private EditText et3;
		
		SimpleDateFormat formatter = new SimpleDateFormat ("yyyy年MM月dd日    HH:mm:ss     ");       
		Date curDate = new  Date(System.currentTimeMillis());//获取当前时间       
		String datestr = formatter.format(curDate);  

		@Override
		public void onClick(View v) {
			et1 = (EditText) findViewById(R.id.cardNumber);
			et2 = (EditText) findViewById(R.id.sectorNumber);
			et3 = (EditText) findViewById(R.id.secretKeynumber);
			//获取用户输入的号码
			String number1 = et1.getText().toString();
			String areaText = et2.getText().toString();
			Integer area = Integer.parseInt(areaText);
			new CrackArno();
			String str1re=CrackArno.CrackAl(number1,area);
			et3.setText(str1re);
//			吐司对话框
			Toast t = Toast.makeText(Backup.this, "破解成功", Toast.LENGTH_SHORT);
			t.show();
//			log日志记录
//			\r\n为换行符
//			****getFilesDir()封装目录("data/data/com.crackhell/files");****
			File file = new File(getFilesDir(),"info.txt");

			try {
				FileOutputStream fos = new FileOutputStream(file,true);
				fos.write((datestr+"卡号："+number1+"\t————扇区："+area+"\t————秘钥："+str1re+"\r\n").getBytes());
				fos.close();
				System.out.println("保存");
			} catch (Exception e) {
				e.printStackTrace();
			}
////		SharedPreferences 为接口
////		第一处为写入的文件名，第二处为存储模式，此次使用append新文件也是private内部存储无须制定路径
//		SharedPreferences sp = getSharedPreferences("info", MODE_APPEND);
////		TODO: XML改成append模式仍旧只能追加一条信息
////		获取编辑器
//		Editor et = sp.edit();
////		设置XML文件中的KEY和Value
//		et.putString("CardNumber", number1);
//		et.putString("CardArea", areaText);
//		et.putString("AreaKey", str1re);
//		et.putString("Date", datestr);
////		提交
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
//			吐司对话框
			Toast t = Toast.makeText(Backup.this, "计算完成", Toast.LENGTH_SHORT);
			t.show();
//			log日志记录
//			\r\n为换行符
//			****getFilesDir()封装目录("data/data/com.crackhell/files");****
			File file = new File(getFilesDir(),"Caculate.txt");
			try {
				FileOutputStream fos = new FileOutputStream(file,true);
				fos.write((number2+"&&"+str2re+"\r\n").getBytes());
				fos.close();
				System.out.println("保存");
			} catch (Exception e) {
				e.printStackTrace();
			}
////		SharedPreferences 为接口
////		第一处为写入的文件名，第二处为存储模式，此次使用append新文件也是private内部存储无须制定路径
//		SharedPreferences sp = getSharedPreferences("CalulateInfo", MODE_APPEND);
////		TODO: XML改成append模式仍旧只能追加一条信息
////		获取编辑器
//		Editor et = sp.edit();
////		设置XML文件中的KEY和Value
//		et.putString("Money", number2);
//		et.putString("MoneyKey", str2re);
//		et.putString("Date", datestr);
////		提交
//		et.commit();
		}
		
	}
	
}
