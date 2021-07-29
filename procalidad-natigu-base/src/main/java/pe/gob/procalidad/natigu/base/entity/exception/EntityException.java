package pe.gob.procalidad.natigu.base.entity.exception;

public class EntityException extends Exception {

	private static final long serialVersionUID = 9079208649838776152L;

	public EntityException() {
	}

	public EntityException(String arg0) {
		super(arg0);
	}

	public EntityException(Throwable arg0) {
		super(arg0);
	}

	public EntityException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public EntityException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
