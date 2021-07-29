package pe.gob.procalidad.natigu.core.service.service.implementacion.seguridad.token;

//import com.iteamdevs.payonline.utilitarios.PostgreSQLJDBC;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class AppKey {
	 public static String generaKey() {
	        // create new key
	        SecretKey secretKey = null;
	        try {
	            secretKey = KeyGenerator.getInstance("AES").generateKey();
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	        String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
	        return encodedKey;
	    }

	    public static boolean existAppKey() {
	        boolean appKey = true;
	        /*
	        CallableStatement cs = null;
	        ResultSet rs = null;
	        Connection cn = PostgreSQLJDBC.conexion();
	        try {
	            cn.setAutoCommit(false);
	            cs = cn.prepareCall("{? = call sch_payonline.eco_ufn_parameter_config_get_key_app()}");
	            cs.registerOutParameter(1, Types.OTHER);
	            cs.execute();
	            rs = (ResultSet) cs.getObject(1);
	            if (rs.next()) {
	                appKey = true;
	            } else {
	                appKey = false;
	            }
	        } catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        } finally {
	            try {
	                cn.close();
	            } catch (SQLException ex) {
	                System.out.println(ex.getMessage());
	            }
	        }
	        */
	        return appKey;
	    }

	    public static String getAppKey() {
	    	
	        String appKey = "M1N3DU2O$7M1N3DU";
	        /*
	        CallableStatement cs = null;
	        ResultSet rs = null;
	        Connection cn = PostgreSQLJDBC.conexion();
	        try {
	            cn.setAutoCommit(false);
	            cs = cn.prepareCall("{? = call sch_payonline.eco_ufn_parameter_config_get_key_app()}");
	            cs.registerOutParameter(1, Types.OTHER);
	            cs.execute();
	            rs = (ResultSet) cs.getObject(1);
	            if (rs.next()) {
	                appKey = rs.getString(1);
	            }
	        } catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        } finally {
	            try {
	                cn.close();
	            } catch (SQLException ex) {
	                System.out.println(ex.getMessage());
	            }
	        }
	        */
	        return appKey;
	        
	    }

	    public static boolean newAppKey() {
	    	
	        boolean flag = false;
	        /*
	        String actualizo = "";
	        CallableStatement cs = null;
	        ResultSet rs = null;
	        String strKey = generaKey();
	        Connection cn = PostgreSQLJDBC.conexion();
	        try {
	            cn.setAutoCommit(false);
	            cs = cn.prepareCall("{? = call sch_payonline.eco_ufn_parameter_config_update(?)}");
	            cs.registerOutParameter(1, Types.OTHER);
	            cs.setString(2, strKey);
	            cs.execute();
	            cn.commit();
	            rs = (ResultSet) cs.getObject(1);
	            if (rs.next()) {
	                actualizo = rs.getString(1);
	            }
	            if (actualizo.equals("UPD")) {
	                flag = true;
	            } else {
	                flag = false;
	            }
	        } catch (SQLException ex) {
	            System.out.println(ex.getMessage());
	        } finally {
	            try {
	                cn.close();
	            } catch (SQLException ex) {
	                System.out.println(ex.getMessage());
	            }
	        } 
	        */
	        return flag;
	       
	    }
}
