package com.scheduler.bank.service;

import com.scheduler.bank.exception.TransferSchedulerException;
import com.scheduler.bank.model.TransferScheduler;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by drsantos on 7/13/17.
 */
public class TransactionalTypeAServiceImpl implements TransactionalService<TransferScheduler> {

    private static final int TAX = 2;
    private static final double PERCENTAGE = 3;

    private BigDecimal operationValue = BigDecimal.ZERO;
    private BigDecimal transactionalValue = BigDecimal.ZERO;

    public TransactionalService<TransferScheduler> process(TransferScheduler transferScheduler) throws TransferSchedulerException {
        operationValue = transferScheduler
                .getTransferValue()
                .multiply(new BigDecimal(PERCENTAGE).divide(new BigDecimal(100)))
                .add(new BigDecimal(TAX));

        transactionalValue = transferScheduler.getTransferValue().subtract(operationValue);
        return this;
    }
    @Override
    public BigDecimal getOrderValue() {
        return operationValue;
    }

    @Override
    public BigDecimal getTransactionalValue() {
        return transactionalValue;
    }

    @Override
    public Integer getIdTransactional() {
        return new Random().nextInt(1000);
    }
}


