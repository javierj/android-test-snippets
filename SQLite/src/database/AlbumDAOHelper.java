package testsnippets.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class AlbumDAOHelper extends SQLiteOpenHelper {
	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "Albums.db";

	public static final String TABLE_NAME = "Albums";

	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_ICON = "icon";

	private static final String TEXT_TYPE = " TEXT";
	private static final String COMMA_SEP = ",";

	public static final String SQL_CREATE = "CREATE TABLE "
			+ AlbumDAOHelper.TABLE_NAME + " (" + COLUMN_ID
			+ " INTEGER PRIMARY KEY," + COLUMN_NAME + TEXT_TYPE + COMMA_SEP
			+ COLUMN_ICON + TEXT_TYPE + " )";

	public static final String SQL_DELETE = "DROP TABLE IF EXISTS "
			+ TABLE_NAME;

	public AlbumDAOHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	public void onCreate(SQLiteDatabase db) {
		System.out.println("AlbumDAOHelper::onCreate");
		db.execSQL(SQL_CREATE);
	}

	public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		System.err.println("AlbumDAOHelper::onDowngrade - Not implemened.");
		throw (new java.lang.NoSuchMethodError());
	}

	/**
	 * Drops the tables and creates them again
	 * 
	 */
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.d("TestSnippets", "AlbumDAOHelper::onOpgrade.");
		db.execSQL(SQL_DELETE);
		onCreate(db);
	}

	public static String[] GetColumnsAsString() {
		return new String[] { COLUMN_ID, COLUMN_NAME, COLUMN_ICON };
	}

}
