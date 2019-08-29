package br.com.cast.avaliacao.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.cast.avaliacao.exception.BusinessException;
import br.com.cast.avaliacao.exception.ResponseMessage;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseMessage businessExceptionHandleError(BusinessException ex) {
        ResponseMessage message = ex.getResponseMessage();
        return message;
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseMessage exceptionHandleError(Exception ex) {
        ResponseMessage message = new ResponseMessage(ResponseMessage.ERROR_EXCEPTION);
        logger.error("GenericExceptionID: ", ex);
        return message;
    }
}
