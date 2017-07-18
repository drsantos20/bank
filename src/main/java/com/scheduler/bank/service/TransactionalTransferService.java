package com.scheduler.bank.service;

import com.scheduler.bank.exception.TransferSchedulerException;

public interface TransactionalTransferService<T> {

	public TransactionalService<T> processByType(T t)
			throws TransferSchedulerException;
	
}
