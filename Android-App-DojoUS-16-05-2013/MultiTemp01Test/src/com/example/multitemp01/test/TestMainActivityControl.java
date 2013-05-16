package com.example.multitemp01.test;

import java.math.BigDecimal;

import com.example.multitemp01.R;
import com.example.multitemp01.MainActivity;
import com.example.multitemp01.logic.KelvinAndFahrenheitTemp;

import android.annotation.TargetApi;
import android.os.Build;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.EditText;

@TargetApi(Build.VERSION_CODES.FROYO)
public class TestMainActivityControl 
extends ActivityInstrumentationTestCase2<MainActivity> {
	
	public TestMainActivityControl(Class<MainActivity> activityClass) {
		super(activityClass);
	}
	
	public TestMainActivityControl() {
		super(MainActivity.class);
	}
	
	public TestMainActivityControl(String s) {
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
	
	
	public void testShowResult() {
		// Test data
		final KelvinAndFahrenheitTemp kft = new KelvinAndFahrenheitTemp();
		kft.setKelvins(new BigDecimal("10"));
		kft.setFahrenheits(new BigDecimal("40"));
		
		try {
			this.runTestOnUiThread(
					new Runnable() {

						@Override
						public void run() {
							ma.showResult(kft);
						}
						
					}
			);
		} catch (Throwable e) {
			e.printStackTrace();
			fail();
		}
		
		// asserts
		EditText et; 
		et = (EditText) ma.findViewById(R.id.editKelvin);
		assertEquals("10", et.getText().toString());
		et = (EditText) ma.findViewById(R.id.editFahrenheit);
		assertEquals("40", et.getText().toString());
	}
	
	
		
	public void testGetCentigradesField_EmptyField() {
		
		// 1. Set the value of the centigrades field
		final EditText view = (EditText) ma.findViewById(R.id.editCentigrados);
		
		
		try {
			this.runTestOnUiThread(
					new Runnable() {

						@Override
						public void run() {
							view.setText("");
						}
						
					}
			);
		} catch (Throwable e) {
			e.printStackTrace();
			fail();
		}

		
		// 2. Set a FakeConverter
		BigDecimal bd = ma.getCentigrades();
		
		// 3. Click boton
		assertEquals(BigDecimal.ZERO, bd);
		
	}

	public void testGetCentigradesField_30dot05Degrees() {
		
		// 1. Set the value of the centigrades field
		final EditText view = (EditText) ma.findViewById(R.id.editCentigrados);
		
		
		try {
			this.runTestOnUiThread(
					new Runnable() {

						@Override
						public void run() {
							view.setText("30.05");
						}
						
					}
			);
		} catch (Throwable e) {
			e.printStackTrace();
			fail();
		}
		
		
		// 2. Set a FakeConverter
		BigDecimal bd = ma.getCentigrades();
		
		// 3. Click boton
		assertEquals("30.05", bd.toString());
		
	}

	
	/**
	 * Aunque el tipo del campo sea no editable, puedo editarlo progra,áticamente.
	 * Esta preba no me vale, tengo que comprbar el tipo.
	 
	public void testEditKelvinField_() {
		final EditText view = (EditText) ma.findViewById(R.id.editKelvin);
		
		try {
			this.runTestOnUiThread(
					new Runnable() {
						@Override
						public void run() {
							view.setText("30.05");
						}
						
					}
			);
		} catch (Throwable e) {
			e.printStackTrace();
			fail();
		}
		
		
		assertEquals("", view.getText().toString());
	}
*/
}
