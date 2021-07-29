package pe.gob.procalidad.natigu.web.gestion.utilitarios;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	
	public Boolean validarCorreo(String correo) {
		Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher mather = pattern.matcher(correo);
		return mather.find();
	}
	
}
