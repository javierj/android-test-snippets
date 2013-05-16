package com.example.multitemp01.logic;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TempConversor {
	
	private static final BigDecimal Kelvin = new BigDecimal(273);

	public KelvinAndFahrenheitTemp convert(double d) {
		return this.convert(new BigDecimal(d));
	}
	
	public KelvinAndFahrenheitTemp convert(BigDecimal bd) {

		KelvinAndFahrenheitTemp kft = new KelvinAndFahrenheitTemp();
		
		
		kft.setKelvins(fromCelciusToKelvins(bd));
		kft.setFahrenheits(this.fromCelciusToFahrenheit(bd));
		
		return kft;
	}
	
	BigDecimal fromCelciusToFahrenheit(BigDecimal cel) {
		BigDecimal mul01 = cel.multiply(new BigDecimal("1.8"));
		return mul01.add(new BigDecimal("32").setScale(2, RoundingMode.HALF_EVEN));
	}

	BigDecimal fromCelciusToKelvins(BigDecimal cel) {
		return cel.subtract(Kelvin).setScale(2, RoundingMode.HALF_EVEN);
	}

}
