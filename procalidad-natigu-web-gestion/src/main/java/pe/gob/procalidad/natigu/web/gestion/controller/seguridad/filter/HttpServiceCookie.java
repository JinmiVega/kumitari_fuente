package pe.gob.procalidad.natigu.web.gestion.controller.seguridad.filter;

import java.util.Calendar;
import java.util.TimeZone;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.time.FastDateFormat;

public class HttpServiceCookie {
	
	private static final FastDateFormat expiresDateFormat= FastDateFormat.getInstance("EEE, dd MMM yyyy HH:mm:ss zzz", TimeZone.getTimeZone("GMT"));


    public static void addCookie(HttpServletResponse response, Cookie cookie, String sameSite) {

        StringBuilder c = new StringBuilder(64+cookie.getValue().length());

        c.append(cookie.getName());
        c.append('=');
        c.append(cookie.getValue());

        append2cookie(c,"domain",   cookie.getDomain());
        append2cookie(c,"path",     cookie.getPath());
        append2cookie(c,"SameSite", sameSite);
        c.append("; HttpOnly");

        if (cookie.getSecure()) {
            c.append("; secure");
        }
       
        
        
        if (cookie.getMaxAge()>=0) {
            append2cookie(c,"Expires", getExpires(cookie.getMaxAge()));
        }

        response.addHeader("Set-Cookie", c.toString());
    }

    private static String getExpires(int maxAge) {
        if (maxAge<0) {
            return "";
        }
        Calendar expireDate = Calendar.getInstance();
        expireDate.setTime(new java.util.Date());
        expireDate.add(Calendar.SECOND,maxAge);

        return expiresDateFormat.format(expireDate);
    }

    private static void append2cookie(StringBuilder cookie, String key, String value) {
        if (key==null || 
                value==null || 
                key.trim().equals("") 
                || value.trim().equals("")) {
            return;
        }

        cookie.append("; ");
        cookie.append(key);
        cookie.append('=');
        cookie.append(value);
    }

}