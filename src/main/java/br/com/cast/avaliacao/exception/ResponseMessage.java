package br.com.cast.avaliacao.exception;

public class ResponseMessage {

    public static final String ERROR_EXCEPTION = "Infelizmente nossa API teve um erro não esperado :( ";

    private String message;

    public ResponseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
