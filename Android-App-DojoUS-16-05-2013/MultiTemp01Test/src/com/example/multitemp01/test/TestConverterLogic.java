package com.example.multitemp01.test;

import junit.framework.TestCase;
import com.example.multitemp01.logic.*;

public class TestConverterLogic extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testConvertionFromCeroCentigradesToKelvins() {
		TempConversor tc = new TempConversor(); 
		KelvinAndFahrenheitTemp temp = tc.convert(0.0);
		
		assertEquals("-273.00", temp.getKelvinsAsSTring());
	}

	public void testConvertionFromCeroCentigradesToFahrenheits() {
		TempConversor tc = new TempConversor(); 
		KelvinAndFahrenheitTemp temp = tc.convert(0.0);
		
		assertEquals("32.00", temp.getFahrenheitsAsString());
	}


	public void testConvertionWithToDecimalsToKelvins() {
		TempConversor tc = new TempConversor(); 
		KelvinAndFahrenheitTemp temp = tc.convert(0.55);
		
		assertEquals("-272.45", temp.getKelvinsAsSTring());
	}


}
