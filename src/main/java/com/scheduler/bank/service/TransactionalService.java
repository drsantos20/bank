package com.scheduler.bank.service;

import com.scheduler.bank.exception.TransferSchedulerException;

import java.math.BigDecimal;

/**
 * Created by drsantos on 7/13/17.
 */
public interface TransactionalService<T> {

    public TransactionalService<T> process(T t) throws TransferSchedulerException;

    public BigDecimal getOrderValue();

    public BigDecimal getTransactionalValue();

    public Integer getIdTransactional();
    
}
