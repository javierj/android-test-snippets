package test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import junit.framework.TestCase;

public class TestBigDecimal extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	
	public void testCreateBigDecimal_Cero() {
		BigDecimal bd = new BigDecimal(0.0);
		
		assertEquals("Num:"+bd.toString(), "0", bd.toString());
	}

	public void testCreateBigDecimal_Integer() {
		BigDecimal bd = new BigDecimal(3);
		
		assertEquals("Num:"+bd.toString(), "3", bd.toString());
	}

	public void testCreateBigDecimal_Float() {
		BigDecimal bd = new BigDecimal(3.5);
		
		assertEquals("Num:"+bd.toString(), "3.5", bd.toString());
	}

	public void testCreateBigDecimal_NegativeInteger() {
		BigDecimal bd = new BigDecimal(-3);
		
		assertEquals("Num:"+bd.toString(), "-3", bd.toString());
	}

	// No funciona
		public void testCreateBigDecimal_TwoDecimals() {
			 double d = 101.234567;
			
		     DecimalFormat df = new DecimalFormat("#.##");
		     System.out.print(df.format(d));
			 BigDecimal bd = new BigDecimal(df.format(d));
			
		     
			assertEquals("Num:"+bd.toString(), "1.23", bd.toString());
		}
	
	
	// No funciona
	public void testCreateBigDecimal_TwoDecimals_SetScale() {
		//BigDecimal bd = new BigDecimal(23.56123, new MathContext(3) );
		BigDecimal bd = new BigDecimal(23.56123).setScale(2, RoundingMode.HALF_EVEN);
		assertEquals("Num:"+bd.toString(), "23.56", bd.toString());
	}
	
	// No funciona
	public void testCreateBigDecimal_TwoDecimals_ByInt() {
		double d = 1.234567;
		int i = (int)(d * 100);
		double n = Math.floor(((double)i / 100));
		BigDecimal bd = new BigDecimal(n);
		
	     
		assertEquals("Num:"+bd.toString(), "1.23", bd.toString());
	}


}
