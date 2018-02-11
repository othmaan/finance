package com.lendico.finance.common.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static com.lendico.finance.common.util.Constants.ERROR_CODES;

public class ApiException extends WebApplicationException {

    private ERROR_CODES code;
    private String message;

    public ApiException(ERROR_CODES code, String message) {
        super(Response.status(Response.Status.BAD_REQUEST)
                .entity("{\"code\":\"" + code.value() + "\", \"message\":\"" + message + "\"}")
                .type(MediaType.APPLICATION_JSON).build());

        this.code = code;
        this.message = message;
    }

    public ERROR_CODES getCode() {
        return code;
    }

    public ApiException setCode(ERROR_CODES code) {
        this.code = code;
        return this;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public ApiException setMessage(String message) {
        this.message = message;
        return this;
    }

}
