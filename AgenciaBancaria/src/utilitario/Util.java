package utilitario;

import java.text.NumberFormat;
import java.text.DecimalFormat;

public class Util {

	static NumberFormat formatandoValores = new DecimalFormat("R$ #,##0.00");

	public static String doubletoString(Double valor){
		return formatandoValores.format(valor);
		}
	
}
