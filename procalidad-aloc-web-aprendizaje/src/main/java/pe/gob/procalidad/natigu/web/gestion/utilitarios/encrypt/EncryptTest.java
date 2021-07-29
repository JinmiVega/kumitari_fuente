package pe.gob.procalidad.natigu.web.gestion.utilitarios.encrypt;

public class EncryptTest {
	
	public static void main(String[] args) {
		try {
			Encrypt.init("M1N3DU2O");
			System.out.println("+Encrypt pass:");	
			System.out.println(Encrypt.encrypt("1"));
			System.out.println("-Decrypt pass:");
			System.out.println(Encrypt.decrypt("KN67p6T1PAg="));
			System.out.println("--------------------------------");
			Encrypt.init("PR3GU4PR3N");
			System.out.println("+Encrypt pregu:");	
			System.out.println(Encrypt.encrypt("1"));
			System.out.println("-Decrypt pregu:");
			System.out.println(Encrypt.decrypt("qdnCVph9m5M="));
			System.out.println("--------------------------------");
			Encrypt.init("4LT3R4PR3N");
			System.out.println("+Encrypt alter:");	
			System.out.println(Encrypt.encrypt("1"));
			System.out.println("-Decrypt alter:");
			System.out.println(Encrypt.decrypt("bNChPj5jTpk="));
			
		} catch (EncryptException e) {
			e.printStackTrace();
		}
	}

}
