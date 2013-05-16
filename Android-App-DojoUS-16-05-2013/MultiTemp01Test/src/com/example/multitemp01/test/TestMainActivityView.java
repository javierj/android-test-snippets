package com.example.multitemp01.test;


import com.example.multitemp01.R;
import com.example.multitemp01.MainActivity;

import android.annotation.TargetApi;
import android.os.Build;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.text.Editable;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.FROYO)
public class TestMainActivityView 
extends ActivityInstrumentationTestCase2<MainActivity> {
	
	public TestMainActivityView(Class<MainActivity> activityClass) {
		super(activityClass);
	}
	
	public TestMainActivityView() {
		super(MainActivity.class);
	}
	
	public TestMainActivityView(String s) {
		super(MainActivity.class);
		setName(s);
	}
	

	MainActivity ma;
	View origin;
	
	@Override
	public void setUp() {
		ma = this.getActivity();
		origin = ma.getWindow().getDecorView();
	}
	
	public void testView_LabelGradosCentigrados() {
		
		// 2. Asserting the View
		TextView tv; 
		tv = (TextView) ma.findViewById(R.id.textView2);
		// Existe con ese identificador
		assertNotNull(tv);
		// Contiene el texto que tiene que tener
		String expected = ma.getResources().getString(R.string.centigrados);
		assertEquals(expected, tv.getText() );
		// Está visible en la pantalla
		ViewAsserts.assertOnScreen(origin, tv);
	}

	
	public void testView_EditGradosCentigrados() {
		// 2. Asserting the View
		EditText et; 
		et = (EditText) ma.findViewById(R.id.editCentigrados);
		//assertNotNull(et);
		
		// Que sea solo de números
		assertEquals(et.getInputType(), InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL| InputType.TYPE_NUMBER_FLAG_SIGNED);
		
		// Visible
		ViewAsserts.assertOnScreen(origin, et);
		
		// con foco
		assertTrue(et.hasFocus());
		
		// Vacío
		Editable editText = et.getText();
		String content = editText.toString();
		assertEquals("", content);
		
	}

	
	public void testView_ButtonConvertir() {
		Button bt; 
		bt = (Button) ma.findViewById(R.id.button1);
		assertNotNull(bt);
		

		// Visible
		ViewAsserts.assertOnScreen(origin, bt);
		
		// con el control adecuado
	}
	
	
	public void testInitialValuesForKelvinsAndFahrenheitsAreEmpty() {
		EditText et; 
		et = (EditText) ma.findViewById(R.id.editKelvin);
		assertEquals("", et.getText().toString());
		et = (EditText) ma.findViewById(R.id.editFahrenheit);
		assertEquals("", et.getText().toString());
	}
	
	
	public void testCentigradesViewHasFocus() {
		EditText et; 
		et = (EditText) ma.findViewById(R.id.editCentigrados);
		assertTrue(et.hasFocus());
	}
	


	class SetFocusCommand implements Runnable {

		boolean b = false;
		View v;
		
		public SetFocusCommand(View v) {
			this.v = v;
		}
		
		@Override
		public void run() {
			b = v.requestFocus();
			
		}	
	}
	
	public void testNoFocusforKelvins() {
		EditText et = (EditText) ma.findViewById(R.id.editKelvin);
		final SetFocusCommand setFocus = new SetFocusCommand(et);
		
		/* -- No funciona porque b también dbee ser final
		boolean b = false
		try {
			this.runTestOnUiThread(
					new Runnable() {

						@Override
						public void run() {
							b = et.requestFocus();
						}
						
					}
			);
		} catch (Throwable e) {
			e.printStackTrace();
			fail();
		}
		*/
		
		try {
			this.runTestOnUiThread(setFocus);
		} catch (Throwable e) {
			e.printStackTrace();
			fail();
		}
		assertFalse(setFocus.b);
	}

	public void testNoFocusForFahrenheits() {
		EditText et = (EditText) ma.findViewById(R.id.editFahrenheit);
		final SetFocusCommand setFocus = new SetFocusCommand(et);
		try {
			this.runTestOnUiThread(setFocus);
		} catch (Throwable e) {
			e.printStackTrace();
			fail();
		}
		assertFalse(setFocus.b);
	}


	public void testKelvinsAndFareheitsAreNotEditables_InputTypeIsZero() {
		EditText et = (EditText) ma.findViewById(R.id.editFahrenheit);
		assertEquals( (InputType.TYPE_TEXT_FLAG_MULTI_LINE | InputType.TYPE_CLASS_TEXT), et.getInputType());
		et = (EditText) ma.findViewById(R.id.editKelvin);
		assertEquals(InputType.TYPE_NULL, et.getInputType());

	}
}
