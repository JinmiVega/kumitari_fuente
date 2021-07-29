package pe.gob.procalidad.natigu.web.gestion.utilitarios;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class VO {

	public VO() {
	}
	public static Integer toInteger(String prmString) {
		if (prmString == null || "".equals(prmString)) {
			return null;
		}
		try {
			return Integer.parseInt(prmString);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Long toLong(String prmString) {
		if (prmString == null) {
			return null;
		}
		try {
			return Long.parseLong(prmString);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String toString(Integer prmInteger) {
		if (prmInteger == null) {
			return null;
		}
		try {
			return String.valueOf(prmInteger.intValue());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String toString(Long prmLong) {
		if (prmLong == null) {
			return null;
		}
		try {
			return String.valueOf(prmLong.longValue());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String toString(Double prmDouble) {
		if (prmDouble == null) {
			return null;
		}
		try {
			return String.valueOf(prmDouble.doubleValue());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static boolean isEmpty(Object obj) {
		if ((obj == null) || (obj.toString().trim().length() == 0)) {
			return true;
		}
		return false;
	}
	
	public static boolean isEmptyList(List<?> lista) {

		boolean result = true;

		if (lista != null && lista.size() > 0) {

			result = false;

		}

		return result;
	}

	public static boolean isNull(Object object) {

		boolean result = true;

		if (object != null) {

			result = false;

		}

		return result;
	}

	public static String dateToString(Date date) {

		try {

			if (date != null) {

				String result = "";

				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

				result = sdf.format(date);

				return result;

			} else {
				return "";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public static String dateToStringGregorian(Date date) {

		try {

			if (date != null) {

				String result = "";

				SimpleDateFormat sdf = new SimpleDateFormat("EEEEEEEEE dd 'de'   MMMMM 'de' yyyy");

				result = sdf.format(date);

				return result;

			} else {
				return "";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public static String dateToString2(Date date) {

		try {

			if (date != null) {

				String result = "";

				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

				result = sdf.format(date);

				return result;

			} else {
				return "";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public static Date stringToDate(String strDate) {

		try {

			if (strDate != null) {
				if(strDate.length() <= 0){
					return null;
				}
				Date result = null;

				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

				result = sdf.parse(strDate);

				return result;

			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Double toDouble(String prmString) {
		if (prmString == null) {
			return null;
		}
		try {
			return Double.parseDouble(prmString);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String getAnioActual(){
		try {
			String anioActual = null;
			Date fechaActual = new Date();
			
			SimpleDateFormat formatAnio = new SimpleDateFormat("yyyy");
			anioActual = formatAnio.format(fechaActual);
			return anioActual; 
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}
	
	public static String getAnio(Date date){
		try {
			String anioActual = null;
			
			SimpleDateFormat formatAnio = new SimpleDateFormat("yyyy");
			anioActual = formatAnio.format(date);
			return anioActual; 
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}
	
	public static List<String> getListaAnios(){
		
		int numAnioActual;
		List<String> lstAnio = new ArrayList<String>();
		 
		Date fechaActual = new Date();
        SimpleDateFormat formatAnio = new SimpleDateFormat("yyyy");
        String anioActual = formatAnio.format(fechaActual); 
        
        numAnioActual = Integer.valueOf(anioActual); // Convierte a entero el año actual
        int anioLimite = 2000; // Establecemos un año limite del array
        
        for(int i = 50; i >= 0; i--){
        	if(numAnioActual >= anioLimite){
        		lstAnio.add(String.valueOf(numAnioActual));
        		numAnioActual--;
        	}else{
        		break;
        	}
        }
        
        return lstAnio;
	}
	
	public static int cantidadDias(Date fechaInicial, Date fechaFinal){
		
		long MILLSECS_PER_DAY = 24 * 60 * 60 * 1000; //Milisegundos al día 
		
		if( !VO.isNull(fechaInicial) && !VO.isNull(fechaFinal) ){

			Long diferencia = ( fechaFinal.getTime() - fechaInicial.getTime() )/MILLSECS_PER_DAY; 
			
			return diferencia.intValue();
			
		}else{
			return 0;
		}
	
	}
	
	public static String dateAndHourToString(Date date) {

		try {

			if (date != null) {

				String result = "";

				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

				result = sdf.format(date);

				return result;

			} else {
				return "";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public static Date stringToDateAndHour(String strDate) {

		try {

			if (strDate != null) {

				Date result = null;

				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

				result = sdf.parse(strDate);

				return result;

			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String PadLeft(String stringToPad, int padToLength){
	    String retValue = null;
	    if(stringToPad.length() < padToLength) {
	        retValue = String.format("%0" + String.valueOf(padToLength - stringToPad.length()) + "d%s",0,stringToPad);
	    }
	    else{
	        retValue = stringToPad;
	    }
	    return retValue;
	}
	
	public static boolean isNotNull(Object obj){
		if (obj!=null) {
			return true;
		}
		return false;
	}
	
	public static boolean isNotEmptyList(List<?> lista) {
		
		if (	lista != null 
			&& 	lista.size() > 0) {

			return true;
		}

		return false;
	}
	
	public static List<List<?>> splitList(List<?> lista, int numeroElementos) {

	    List<List<?>> result = new ArrayList<List<?>>();

	    if(!VO.isEmptyList(lista)){
	    	
	    	int numero_particiones = lista.size() / numeroElementos;

		    for (int i = 0; i <= numero_particiones; i++) {

		        int index_inicio = i * numeroElementos;

		        if (index_inicio >= lista.size()) {
		            return result;
		        }

		        int index_fin = (i + 1) * numeroElementos;

		        if (index_fin < lista.size()) {
		            result.add(lista.subList(index_inicio, index_fin));
		        } else {
		            result.add(lista.subList(index_inicio, lista.size()));
		        }

		    }
	    }

	    return result;
	}
	
	public static List<?> randomElementList(List<?> lista) {

	    if(!VO.isEmptyList(lista)){
	    	
	    	Random rndm = new Random();
	        //rndm.setSeed(1000);
	        Collections.shuffle(lista, rndm);
	        for(int i=0; i<lista.size(); i++) {
	            System.out.println("lista ordenada aleatoriamente: " + lista.get(i));
	        }
	    }

	    return lista;
	}
	
	public static String removeSpecialChar(String input) {
		String output = "";
		if(!isEmpty(input)){
			String original = "áàäéèëíìïóòöúùuñÁÀÄÉÈËÍÌÏÓÒÖÚÙÜÑçÇ";
		    String ascii 	= "aaaeeeiiiooouuunAAAEEEIIIOOOUUUNcC";
		    output = input;
		    for (int i=0; i<original.length(); i++) {
		        output = output.replace(original.charAt(i), ascii.charAt(i));
		    }
		}
		
		return output; 
	}
	
}