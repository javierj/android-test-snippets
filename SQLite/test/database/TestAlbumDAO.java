package testsnippets.database;

import java.util.List;

import testsnippets.database.Album;
import testsnippets.database.AlbumDAO;

import android.test.AndroidTestCase;

public class TestAlbumDAO extends AndroidTestCase {

	AlbumDAO aDAO;
	Album demoAlbum;
	
	protected void setUp() throws Exception {
		super.setUp();
		aDAO = new AlbumDAO(this.getContext());
		
		demoAlbum = new Album();
		demoAlbum.setName("Album demo");
		demoAlbum.setIcon("icon");
	}

	/**
	 * Remove all fields in table
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		aDAO.clearAll();
	}

	
	public void testStoreNewAlbum() {
		aDAO.storeAlbum(demoAlbum);
		
		List<Album> as = aDAO.recoverAllAlbums();
		assertEquals(1, as.size());
		
		Album a = as.get(0);
		assertEquals("Album demo", a.getName());
		assertEquals("icon", a.getIcon());
	}
	
	public void testSelectAllAlbums_DatabaseEmpty() {
		List<Album> as = aDAO.recoverAllAlbums();
		
		assertNotNull(as);
		assertEquals(0, as.size());
	}

	
}
