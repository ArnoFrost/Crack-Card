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
* @version 创建时间：2016年4月27日 上午12:13:28 
* 类说明 
* 5.4  version 1.43——
* 1、整合两个数据表到一个数据库，简化代码
* ===========================================
* 5.3  version 1.42——
* 1、添加按键音效
* ===========================================
* 5.3  version 1.40——
* 1、修复存储问题bug，使用sqlite数据库建立两个表格存储
* 更加规范调用
* 2、使用AndroidJunit单元测试更加方便找到bug* 
* 3、现阶段完整版本
* =========================================== 
* 5.2  version 1.31——
* 1、用xml文件保存数据使得文档更清晰，方便调用
* 2、使用string.xml 修改的版本显示设置更加规范
* ===========================================
* 3、待解决问题：XML改成append模式仍旧只能追加一条信息
* 问题处理是由于KEY相同导致的，解决方法可以用sqllite（已解决 5.3 version 1.40）
* ===========================================
* 4.29 version 1.30——
* 1、更新卡号输入方式用空格隔开
* 2、调整日志输出格式，加入数据插入日期
* ===========================================
* 4.27 version1.20——
* 1、修复了扇区单独运算的bug
* 2、增加了日志输出记录并调整了格式
*/ 
public class MainActivity extends Activity {
	private SoundPool sp1;//声明一个SoundPool
    private int music1;//定义一个整型用load（）；来设置suondID
	private SoundPool sp2;//声明一个SoundPool
    private int music2;//定义一个整型用load（）；来设置suondID
    
	 //获取布局文件中定义的按钮

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	    Button bt1 = (Button) findViewById(R.id.buttonCrack);
	    Button bt2 = (Button) findViewById(R.id.buttonCaculate);
        sp1= new SoundPool(10, AudioManager.STREAM_SYSTEM, 5);//第一个参数为同时播放数据流的最大个数，第二数据流类型，第三为声音质量
        music1 = sp1.load(this, R.raw.lowbattery, 1); //把你的声音素材放到res/raw里，第2个参数即为资源文件，第3个为音乐的优先级
        sp2= new SoundPool(10, AudioManager.STREAM_SYSTEM, 5);
        music2 = sp2.load(this, R.raw.musicshake, 1); 
        
        //设置侦听
        bt1.setOnClickListener(new Crack());
        bt2.setOnClickListener(new Cal());
	}
	class Crack implements OnClickListener{

		private EditText et1;
		private EditText et2;
		private EditText et3;
		
		SimpleDateFormat formatter = new SimpleDateFormat ("yyyy年MM月dd日  HH:mm:ss");       
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
			Toast.makeText(MainActivity.this, "破解成功", Toast.LENGTH_SHORT).show();
			
//			插入数据库
//			Activity中的context用getBaseContext()获取
			CardDatabase cdb = new CardDatabase(getBaseContext());
//			如果数据库不存在，先创建再打开。如果存在就直接打开
			SQLiteDatabase db = cdb.getWritableDatabase();
//			字段（1、id 2、cardNumber 3、area 4、keyCode 5、date）
			db.execSQL("insert into CardDatabase(cardNumber,area,keyCode,date) values(?,?,?,?)",
					new Object[]{number1,area,str1re,datestr});
			db.close();
//			播放按钮音效
			sp1.play(music1, 1, 1, 0, 0, 1);
		}
		
		
	}
	
	class Cal implements OnClickListener{

		private EditText et4;
		private EditText et5;
		
		SimpleDateFormat formatter = new SimpleDateFormat ("yyyy年MM月dd日    HH:mm:ss     ");       
		Date curDate = new  Date(System.currentTimeMillis());//获取当前时间       
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
//			吐司对话框
			Toast.makeText(MainActivity.this, "计算完成", Toast.LENGTH_SHORT).show();

			
//			插入数据库
//			Activity中的context用getBaseContext()获取
			CardDatabase cdb = new CardDatabase(getBaseContext());
//			如果数据库不存在，先创建再打开。如果存在就直接打开
			SQLiteDatabase db = cdb.getWritableDatabase();
//			创建金额数据库 字段（1、id 2、money 3、key 4、date）
			db.execSQL("insert into MoneyDatabase(money,key,date) values(?,?,?)",
					new Object[]{number2,str2re,datestr});
			db.close();
//			播放按钮音效
			sp2.play(music2, 1, 1, 0, 0, 1);

		}
		
	}
	
}
