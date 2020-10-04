package br.com.dbccompany.exception;

public class ExceptionVenda  extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;

	public ExceptionVenda(String msg) {
		super(msg);
		this.msg = msg;
	}

	public String getMessage() {
		return msg;
	}

}
