package test;

import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;
import database.CardDatabase;
import history.MoneyDatabase;

/** 
* @author Arno E-mail: davidxuxin@qq.com
* @version ����ʱ�䣺2016��5��3�� ����4:25:36 
* ��˵�� 
*/
public class Test extends AndroidTestCase {
	public void testMoney(){
		MoneyDatabase mdb = new MoneyDatabase(getContext(), "MoneyDatabase.db", null, 1);
//		������ݿⲻ���ڣ��ȴ����ٴ򿪡�������ھ�ֱ�Ӵ�
		SQLiteDatabase db = mdb.getWritableDatabase();
//		����������ݿ� �ֶΣ�1��id 2��money 3��key 4��date��
		db.execSQL("insert into MoneyDatabase(money,key,date) values(?,?,?)",
				new Object[]{"65535","8be74effff90ff0780698be74e083390","2016��5��3�� ����4:25:36"});
		db.close();
		
	}
//	public void testCard(){
////		�������ݿ�
////		Activity�е�context��getBaseContext()��ȡ
//		CardDatabase cdb = new CardDatabase(getContext());
////		������ݿⲻ���ڣ��ȴ����ٴ򿪡�������ھ�ֱ�Ӵ�
//		SQLiteDatabase db = cdb.getWritableDatabase();
////		�ֶΣ�1��id 2��cardNumber 3��area 4��keyCode 5��date��
//		db.execSQL("insert into CardDatabase(cardNumber,area,keyCode,date) values(?,?,?,?)",
//				new Object[]{"12 34 56 78",12,"8be74effff90ff0780698be74e083390","2016��5��3�� ����4:25:36"});
//		db.close();
//	}
}

 