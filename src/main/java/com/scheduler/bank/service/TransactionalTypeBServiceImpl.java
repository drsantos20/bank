package com.scheduler.bank.service;

import com.scheduler.bank.exception.TransferSchedulerException;
import com.scheduler.bank.model.TransferScheduler;
import org.joda.time.Days;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by Daniel on 14/07/2017.
 */
public class TransactionalTypeBServiceImpl implements TransactionalService<TransferScheduler> {

    private static final int TAX_UNTIL_THIRTY_DAYS = 10;
    private static final int TAX = 8;

    private BigDecimal operationValue = BigDecimal.ZERO;
    private BigDecimal transactionalValue = BigDecimal.ZERO;

    @Override
    public TransactionalService<TransferScheduler> process(TransferScheduler transferScheduler) throws TransferSchedulerException {
        int schedulerDay = Days.daysBetween(transferScheduler.getRegistrationDate(), transferScheduler.getSchedulerDate()).getDays();
        if ( schedulerDay <= 30 ) {
            operationValue = new BigDecimal(TAX_UNTIL_THIRTY_DAYS);
            transactionalValue = transferScheduler.getTransferValue().subtract(operationValue);

        } else {
            operationValue = new BigDecimal(TAX);
            transactionalValue = transferScheduler.getTransferValue().subtract(operationValue);
        }
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
