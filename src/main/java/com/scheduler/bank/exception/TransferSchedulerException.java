package com.scheduler.bank.exception;

/**
 * Created by drsantos on 7/13/17.
 */
public class TransferSchedulerException extends Exception {

    private static final long serialVersionUID = 1L;

    public TransferSchedulerException(String message) {
        super(message);
    }

    public TransferSchedulerException(Throwable cause) {
        super(cause);
    }

    public TransferSchedulerException(String message, Throwable cause) {
        super(message, cause);
    }

    public TransferSchedulerException(String message, Throwable cause,
                                     boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
