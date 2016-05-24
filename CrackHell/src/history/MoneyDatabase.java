package history;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/** 
* @author Arno E-mail: davidxuxin@qq.com
* @version 创建时间：2016年5月3日 下午3:42:30 
* 类说明 
*/
public class MoneyDatabase extends SQLiteOpenHelper {

	public MoneyDatabase(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
//		创建金额数据库 字段（1、id 2、money 3、key 4、date）
		String sql = "create table MoneyDatabase "
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
 