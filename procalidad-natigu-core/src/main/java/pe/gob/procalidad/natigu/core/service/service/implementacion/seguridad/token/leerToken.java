/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.procalidad.natigu.core.service.service.implementacion.seguridad.token;

import com.google.gson.Gson;
//import com.iteamdevs.payonline.modelo.entidad.Claim;
//import com.iteamdevs.payonline.modelo.entidad.Mensaje;
//import com.iteamdevs.payonline.modelo.entidad.SubjectToken;
//import com.iteamdevs.payonline.modelo.entidad.User;

import javax.xml.bind.DatatypeConverter;
import io.jsonwebtoken.Jwts;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;
import io.jsonwebtoken.Claims;

public class leerToken {

    public static UsuarioBean parseUserJWT(String jwt, String encodeKey) {
    	UsuarioBean u = new UsuarioBean();
        //Mensaje mensaje=new Mensaje();
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(encodeKey))
                    .parseClaimsJws(jwt).getBody();
            Gson gson = new Gson();
            u = gson.fromJson(claims.getSubject(), UsuarioBean.class);
        } catch (Exception e) {
            //mensaje.setAccion("ERROR");
            //mensaje.setAccion(""+e);
            //u.setMsg(mensaje);
        }
        return u;
    }
     public static Object parseUserJWT(String jwt) {
    	 Object u = new Object();
         //Mensaje mensaje=new Mensaje();
        try {
            System.out.println("llave: "+AppKey.getAppKey());
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(AppKey.getAppKey()))
                    .parseClaimsJws(jwt).getBody();
            
            System.out.println("user: "+claims.getSubject());
            //Gson gson = new Gson();
            //u = gson.fromJson(claims.getSubject(), UsuarioBean.class);
            u = claims.getIssuer();
        } catch (Exception e) {
             //mensaje.setAccion("ERROR");
             //mensaje.setAccion(""+e);
             //u.setMsg(mensaje);
        	u = null;
        }
        return u;
    }
}
