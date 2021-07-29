package pe.gob.procalidad.natigu.base.repository.exception;

public class DAOException extends Exception {

	private static final long serialVersionUID = 9079208649838776152L;

	public DAOException() {
	}

	public DAOException(String arg0) {
		super(arg0);
	}

	public DAOException(Throwable arg0) {
		super(arg0);
	}

	public DAOException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public DAOException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
