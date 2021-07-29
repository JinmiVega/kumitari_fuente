package pe.gob.procalidad.natigu.web.gestion.utilitarios;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ResourceUtil {

	private static final String BUNDLE_NAME = "config";
	private static final ResourceBundle RESOURCE_BUNDLE_NAME = ResourceBundle.getBundle(BUNDLE_NAME);

	public static String getKey(String key) {
		try {
			return RESOURCE_BUNDLE_NAME.getString(key);
		} catch (MissingResourceException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
