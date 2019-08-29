package br.com.cast.avaliacao.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1955936571349708249L;

    final Logger logger = LoggerFactory.getLogger("jsonExceptionLogger");

    private ResponseMessage responseMessage;

    private BusinessException() {
    }

    private BusinessException(Exception e, ResponseMessage responseMessage) {
        this.responseMessage = responseMessage;
        logger.error("BusinessException with sessionId: ", e);
    }

    public static BusinessException of(String message) {
        ResponseMessage response = new ResponseMessage(message);
        return new BusinessException(null, response);
    }

    /**
     * Método get do atributo responseMessageDTO
     *
     * @return O valor do atributo responseMessageDTO
     */
    public ResponseMessage getResponseMessage() {
        return responseMessage;
    }

}
