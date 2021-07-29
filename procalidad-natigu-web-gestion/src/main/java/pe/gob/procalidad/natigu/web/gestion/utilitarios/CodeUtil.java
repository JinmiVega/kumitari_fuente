package pe.gob.procalidad.natigu.web.gestion.utilitarios;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class CodeUtil {
	
	public static String parseEncode(String data) {
		if (VO.isEmpty(data)) {
			data = "";
		}else{
			try {
				data= URLEncoder.encode(data, "UTF-8");
				data= URLDecoder.decode(data, "UTF-8");			
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	
}
