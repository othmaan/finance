package com.lendico.finance.common.protocol;

import com.lendico.finance.common.exception.ApiException;

public interface ClientToBusiness<T> {

    /*
    Maps client model to business model.
    Good place to do any formatting & type conversion
    */
    T map() throws ApiException;
}
