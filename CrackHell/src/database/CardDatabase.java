package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/** 
* @author Arno E-mail: davidxuxin@qq.com
* @version ����ʱ�䣺2016��5��3�� ����3:38:29 
* ��˵��
* ====================================== 
* 5.4 ���� version 1.44
* 1���������ݿ⽨���ϲ����ű�һ�����ݿ�
*/
public class CardDatabase extends SQLiteOpenHelper {

	public CardDatabase(Context context) {
		super(context, "CardDatabase.db", null, 1);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
//		������Կ���ݿ� �ֶΣ�1��id 2��cardNumber 3��area 4��keyCode 5��date��
		String sql = "create table CardDatabase "
				+ "(_id integer primary key autoincrement, "
				+ "cardNumber char(15), "
				+ "area integer(2), "
				+ "keyCode char(15), "
				+ "date char(30))";
		db.execSQL(sql);
//		����������ݿ� �ֶΣ�1��id 2��money 3��key 4��date��
		sql = "create table MoneyDatabase "
				+ "(_id integer primary key autoincrement,"
				+ "money integer(5), "
				+ "key char(40), "
				+ "date char(30))";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
 