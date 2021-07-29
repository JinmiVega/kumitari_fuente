/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.procalidad.natigu.core.service.service.implementacion.seguridad.token;

import com.google.gson.Gson;
//import com.iteamdevs.payonline.modelo.entidad.Claim;
//import com.iteamdevs.payonline.modelo.entidad.User;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import io.jsonwebtoken.*;
import pe.gob.procalidad.natigu.core.bean.bean.seguridad.UsuarioBean;

import java.util.Date;

public class generatoken {

	public String key = "M1N3DU2O$7M1N3DU";
	
	public static String createUserJWToken(UsuarioBean user, String encodeKey) {

        //String subjectJson=new Gson().toJson(claim.getSubject());
        // El algoritmo de firma JWT que vamos a utilizar para firmar el token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //  en esta seccion consultamos la llave del token pero en base de datos,
        //si la llave existe para la fecha retorna si es la primera consulta del dia se nerara la llave de token diaria
        // Firmaremos su JWT con su secreto clave de Api
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(encodeKey);

        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        // Vamos a establecer las reclamaciones JWT
        //30*60*1000
        // user.setTtlMillisToken(ttlMillisToken);
        //JwtBuilder builder = Jwts.builder().setId(user.getIdStaff())
        String jsonSubject = new Gson().toJson(user);
        JwtBuilder builder = Jwts.builder().setId(user.getCodigoUsuario().toString())
                .setIssuedAt(now)
                .setIssuer(user.getCodigoUsuario().toString())
                .setSubject(new Gson().toJson(user))
                .signWith(signatureAlgorithm, signingKey);

        // si se ha especificado, vamos a agregar la expiración
        /*
        if (user.getTtlMillisToken() >= 0) {
            long expMillis = nowMillis + user.getTtlMillisToken();
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        */

        // Crea el JWT y lo serializa en una cadena compacta y segura para URL
        return builder.compact();
    }

    public static String createUserJWToken(UsuarioBean user) {

        //String subjectJson=new Gson().toJson(claim.getSubject());
        // El algoritmo de firma JWT que vamos a utilizar para firmar el token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //  en esta seccion consultamos la llave del token pero en base de datos,
        //si la llave existe para la fecha retorna si es la primera consulta del dia se nerara la llave de token diaria
        if (!AppKey.existAppKey()) {
            boolean flag = AppKey.newAppKey();
        }
        // Firmaremos su JWT con su secreto clave de Api
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(AppKey.getAppKey());

        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        // Vamos a establecer las reclamaciones JWT
        //30*60*1000
        //user.setTtlMillisToken(ttlMillisToken);
        //JwtBuilder builder = Jwts.builder().setId(user.getIdStaff())
        //String jsonSubject = new Gson().toJson(user);
        System.out.println("user: ");
        System.out.println("user: "+user.toString());
        System.out.println("user: "+user.getCodPerfilUsuSelec().toString());
        JwtBuilder builder = Jwts.builder().setId(user.getCodigoUsuario().toString())
                .setIssuedAt(now)
                .setIssuer(user.getCodPerfilUsuSelec().toString())
                .setSubject(user.toString())
                .signWith(signatureAlgorithm, signingKey);

        // si se ha especificado, vamos a agregar la expiración
        /*
        if (user.getTtlMillisToken() >= 0) {
            long expMillis = nowMillis + user.getTtlMillisToken();
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        */

        // Crea el JWT y lo serializa en una cadena compacta y segura para URL
        return builder.compact();
    }

}
