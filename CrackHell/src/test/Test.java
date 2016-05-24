package test;

import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;
import database.CardDatabase;
import history.MoneyDatabase;

/** 
* @author Arno E-mail: davidxuxin@qq.com
* @version 创建时间：2016年5月3日 下午4:25:36 
* 类说明 
*/
public class Test extends AndroidTestCase {
	public void testMoney(){
		MoneyDatabase mdb = new MoneyDatabase(getContext(), "MoneyDatabase.db", null, 1);
//		如果数据库不存在，先创建再打开。如果存在就直接打开
		SQLiteDatabase db = mdb.getWritableDatabase();
//		创建金额数据库 字段（1、id 2、money 3、key 4、date）
		db.execSQL("insert into MoneyDatabase(money,key,date) values(?,?,?)",
				new Object[]{"65535","8be74effff90ff0780698be74e083390","2016年5月3日 下午4:25:36"});
		db.close();
		
	}
//	public void testCard(){
////		插入数据库
////		Activity中的context用getBaseContext()获取
//		CardDatabase cdb = new CardDatabase(getContext());
////		如果数据库不存在，先创建再打开。如果存在就直接打开
//		SQLiteDatabase db = cdb.getWritableDatabase();
////		字段（1、id 2、cardNumber 3、area 4、keyCode 5、date）
//		db.execSQL("insert into CardDatabase(cardNumber,area,keyCode,date) values(?,?,?,?)",
//				new Object[]{"12 34 56 78",12,"8be74effff90ff0780698be74e083390","2016年5月3日 下午4:25:36"});
//		db.close();
//	}
}

 