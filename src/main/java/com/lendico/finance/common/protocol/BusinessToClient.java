package com.lendico.finance.common.protocol;

import com.lendico.finance.common.exception.ApiException;

import java.util.List;

public interface BusinessToClient<T> {

    /*
    Builds client model from business model.
    Good place to do any formatting & type conversion.
     */
    Object buildOneToOne(T business) throws ApiException;

    /*
    Builds client model List from business model List.
    */
    default List buildManyToMany(List<T> business) throws ApiException {
        return null;
        // throw DevelopmentException - message: Work In Progress
    }
}
