package com.scheduler.bank.service;

import com.scheduler.bank.exception.TransferSchedulerException;
import com.scheduler.bank.model.TransferScheduler;
import org.joda.time.Days;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by Daniel on 14/07/2017.
 */
public class TransactionalTypeCServiceImpl implements TransactionalService<TransferScheduler> {

    private static final double PERCENTAGE_UNTIL_FIVE_DAYS = 8.3;
    private static final double PERCENTAGE_UNTIL_TEN_DAYS = 7.4;
    private static final double PERCENTAGE_UNTIL_FIFTEEN_DAYS = 6.7;
    private static final double PERCENTAGE_UNTIL_TWENTY_DAYS = 5.4;
    private static final double PERCENTAGE_UNTIL_TWENTY_FIVE_DAYS = 4.3;
    private static final double PERCENTAGE_UNTIL_THIRTY_DAYS = 2.1;
    private static final double PERCENTAGE_BIGGER_THEN_THIRTY_DAYS = 1.2;

    private BigDecimal operationValue = BigDecimal.ZERO;
    private BigDecimal transactionalValue = BigDecimal.ZERO;

    @Override
    public TransactionalService<TransferScheduler> process(TransferScheduler transferScheduler) throws TransferSchedulerException {
        int schedulerDays = Days.daysBetween(transferScheduler.getRegistrationDate(), transferScheduler.getSchedulerDate()).getDays();

        if ( schedulerDays <= 5 ) {
            operationValue = transferScheduler.getTransferValue()
                    .multiply(new BigDecimal(PERCENTAGE_UNTIL_FIVE_DAYS).divide(new BigDecimal(100)));

            transactionalValue = transferScheduler.getTransferValue().subtract(operationValue);
        }
        else if ( schedulerDays <= 10 ) {
            operationValue = transferScheduler.getTransferValue()
                    .multiply(new BigDecimal(PERCENTAGE_UNTIL_TEN_DAYS).divide(new BigDecimal(100)));

            transactionalValue = transferScheduler.getTransferValue().subtract(operationValue);
        }
        else if ( schedulerDays <= 15 ) {
            operationValue = transferScheduler.getTransferValue()
                    .multiply(new BigDecimal(PERCENTAGE_UNTIL_FIFTEEN_DAYS).divide(new BigDecimal(100)));

            transactionalValue = transferScheduler.getTransferValue().subtract(operationValue);
        }
        else if ( schedulerDays <= 20 ) {
            operationValue = transferScheduler.getTransferValue()
                    .multiply(new BigDecimal(PERCENTAGE_UNTIL_TWENTY_DAYS).divide(new BigDecimal(100)));

            transactionalValue = transferScheduler.getTransferValue().subtract(operationValue);
        }
        else if ( schedulerDays <= 25 ) {
            operationValue = transferScheduler.getTransferValue()
                    .multiply(new BigDecimal(PERCENTAGE_UNTIL_TWENTY_FIVE_DAYS).divide(new BigDecimal(100)));

            transactionalValue = transferScheduler.getTransferValue().subtract(operationValue);
        }
        else if ( schedulerDays <= 30 ) {
            operationValue = transferScheduler.getTransferValue()
                    .multiply(new BigDecimal(PERCENTAGE_UNTIL_THIRTY_DAYS).divide(new BigDecimal(100)));

            transactionalValue = transferScheduler.getTransferValue().subtract(operationValue);
        }
        else {
            operationValue = transferScheduler.getTransferValue()
                    .multiply(new BigDecimal(PERCENTAGE_BIGGER_THEN_THIRTY_DAYS).divide(new BigDecimal(100)));

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
