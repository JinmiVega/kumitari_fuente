package pe.gob.procalidad.natigu.base.bean.exception;

public class BeanException extends Exception {

	private static final long serialVersionUID = 9079208649838776152L;

	public BeanException() {
	}

	public BeanException(String arg0) {
		super(arg0);
	}

	public BeanException(Throwable arg0) {
		super(arg0);
	}

	public BeanException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public BeanException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
