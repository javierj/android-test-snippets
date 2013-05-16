package com.example.multitemp01.logic;

import java.math.BigDecimal;

public class KelvinAndFahrenheitTemp {

	BigDecimal kelvins;
	BigDecimal fahrenheits;
	
	public String getKelvinsAsSTring() {
	
		return kelvins.toString();
	}

	public void setKelvins(BigDecimal bd) {
		kelvins = bd;
		
	}

	public String getFahrenheitsAsString() {
		
		return fahrenheits.toString();
	}

	public void setFahrenheits(BigDecimal bd) {
		fahrenheits = bd;
		
	}

}
