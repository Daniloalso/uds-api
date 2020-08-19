package br.com.uds.api.exception;

public class PedidoException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final String errorMessage;
	private final String[] objs;
	
	public PedidoException(String errorMessage){
		this.errorMessage = errorMessage;
		this.objs = null;
	}
	
	public PedidoException(String errorMessage, String[] objs){
		this.errorMessage = errorMessage;
		this.objs = objs;
	}
	
	public String getErrorMessage(){
		return this.errorMessage;
	}

	public Object[] getObjs() {
		return objs;
	}
}
