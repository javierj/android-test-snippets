package testsnippets.database;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public  class AlbumDAO implements BaseColumns {
      
    AlbumDAOHelper mDbHelper;
    SQLiteDatabase db;
    
    public AlbumDAO(Context c) {
    	super();
    	mDbHelper = new AlbumDAOHelper(c);
    	db = this.mDbHelper.getWritableDatabase();
    }
    
    
    public void storeAlbum(Album a) {
    	SQLiteDatabase db = mDbHelper.getWritableDatabase();

    	ContentValues values = new ContentValues();
    	values.put(AlbumDAOHelper.COLUMN_NAME, a.getName());
    	values.put(AlbumDAOHelper.COLUMN_ICON, a.getIcon());

    	db.insert(	AlbumDAOHelper.TABLE_NAME,
    	        null, 
    			values);
    	
    }
    
    public List<Album> recoverAllAlbums() {
		Cursor c = this.getCursorWirhAllAlbums();
		
		List<Album> as = new ArrayList<Album>();
		Album a;
		
		if (c.moveToFirst()) {
		     do {
		    	 a = new Album();
		    	 a.setName(c.getString(1));
		    	 a.setIcon(c.getString(2));
		    	 as.add(a);
		     } while(c.moveToNext());
		}
		
		c.close();
		return as;
	}
	
	/**
	 * Utility method
	 */
	public Cursor getCursorWirhAllAlbums(){
		String[] projection = AlbumDAOHelper.GetColumnsAsString();
		
		Cursor c = db.query(
				AlbumDAOHelper.TABLE_NAME,  // The table to query
			    projection,                               // The columns to return
			    null,                                // The columns for the WHERE clause
			    null,                            // The values for the WHERE clause
			    null,                                     // don't group the rows
			    null,                                     // don't filter by row groups
			    null                                 // The sort order
			    );
		
		return c;
	}

	
	/**
	 * Remove all elements in table.
	 */
	public void clearAll() {
		this.db.delete(AlbumDAOHelper.TABLE_NAME, null, null);		
	}

}