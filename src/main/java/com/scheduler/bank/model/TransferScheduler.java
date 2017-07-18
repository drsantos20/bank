package com.scheduler.bank.model;

import java.math.BigDecimal;

import org.joda.time.DateTime;

import com.scheduler.bank.util.OperationType;

/**
 * Created by drsantos on 7/13/17.
 */

public class TransferScheduler {
    private Account from;
    private Account to;
    private BigDecimal transferValue;
    private OperationType operation;
    private DateTime registrationDate;
    private DateTime schedulerDate;
    private User userIdentify;
    
    public TransferScheduler() {
    }
    public TransferScheduler(Account from, Account to) {
        this.to = to;
    }
    
	public User getUserIdentify() {
		return userIdentify;
	}
	
	public void setUserIdentify(User userIdentify) {
		this.userIdentify = userIdentify;
	}
	public void setFrom(Account from) {
        this.from = from;
    }

    public Account getFrom() {
        return from;
    }

    public Account getTo() {
        return to;
    }

    public void setTo(Account to) {
        this.to = to;
    }

    public BigDecimal getTransferValue() {
        return transferValue;
    }

    public void setTransferValue(BigDecimal transferValue) {
        this.transferValue = transferValue;
    }

    public OperationType getOperation() {
        return operation;
    }

    public void setOperation(OperationType operation) {
        this.operation = operation;
    }

    public DateTime getSchedulerDate() {
        return schedulerDate;
    }

    public void setSchedulerDate(DateTime schedulerDate) {
        this.schedulerDate = schedulerDate;
    }

    public DateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(DateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
}
