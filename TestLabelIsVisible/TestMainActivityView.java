package org.gameus.rss.test;

import org.gameus.rss.MainActivity;
import org.gameus.rss.R;

import android.annotation.TargetApi;
import android.os.Build;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.view.View;
import android.widget.TextView;


/**
 * Esta clase describe los componentes de la vista de la actividad principal
 * 
 * @author Javier
 *
 */
@TargetApi(Build.VERSION_CODES.FROYO)
public class TestMainActivityView extends ActivityInstrumentationTestCase2<MainActivity> {

	public TestMainActivityView() {
		this("TestMainActivityView");
	}


	public TestMainActivityView(String s) {
		super(MainActivity.class); 
		setName(s);
	}
	
	public TestMainActivityView(Class<MainActivity> activityClass) {
		super(activityClass);
	}
	
	
	MainActivity ma;
	View origin;

	protected void setUp() throws Exception {
		super.setUp();
		ma = this.getActivity();
		origin = ma.getWindow().getDecorView();
	}
	
	/**
	 * La actividad tiene que tener un titulo en la parte superior 
	 * Al escribir la prueba por primera vez falla porque no existe R.id.gameusTitle
	 */
	public void testTitle() {
		View title = ma.findViewById(R.id.gameusTitle);
		assertNotNull(title);
		
		TextView text = (TextView)title;
		
		//assertNotNull( title.getContentDescription());
		assertEquals("GameUS Reader", 	text.getText().toString());
		ViewAsserts.assertOnScreen(origin, title);
		
	}

}
