package pe.gob.procalidad.natigu.web.gestion.utilitarios;

import java.io.File;
import java.io.IOException;

public class FileUtil {
	
	public static File fileExists(String rootPath) {
        File dir = new File(rootPath);                
        if (!dir.exists()){
            dir.mkdirs();
        }                
        return dir;
	}
	public static File fileExists2(String rootPath) {
        File dir = new File(rootPath);                
        try {
			if (!dir.createNewFile()){
				dir.delete();
			    System.out.println("Archivo ya existe");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}                
        return dir;
	}
}
