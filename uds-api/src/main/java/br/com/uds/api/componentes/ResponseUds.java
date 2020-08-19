package br.com.uds.api.componentes;

public class ResponseUds {

	private final Object object;
	
    private final String message;
    
    public ResponseUds(final Object object) {
        this.object = object;
        this.message = null;
    }
    
    public ResponseUds(final Object object, final String message) {
        this.object = object;
        this.message = message;
    }
    
    public Object getObject() {
        return object;
    }
    
    public String getMessage() {
        return message;
    }

}
