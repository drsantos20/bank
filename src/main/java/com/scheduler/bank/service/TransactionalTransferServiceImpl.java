package com.scheduler.bank.service;

import com.scheduler.bank.exception.TransferSchedulerException;
import com.scheduler.bank.model.TransferScheduler;
import com.scheduler.bank.util.OperationType;

/**
 * Created by drsantos on 7/13/17.
 */
public class TransactionalTransferServiceImpl implements TransactionalTransferService<TransferScheduler> {
	
	private TransactionalService<TransferScheduler> transactional;

	private TransactionalService<TransferScheduler> transactionalAType(TransferScheduler transferScheduler)
			throws TransferSchedulerException {
		
		return new TransactionalTypeAServiceImpl().process(transferScheduler);
	}

	private TransactionalService<TransferScheduler> transactionalBTtype(TransferScheduler transferScheduler)
			throws TransferSchedulerException {
		
		return new TransactionalTypeBServiceImpl().process(transferScheduler);
	}

	private TransactionalService<TransferScheduler> transactionalCType(TransferScheduler transferScheduler)
			throws TransferSchedulerException {
		
		return new TransactionalTypeCServiceImpl().process(transferScheduler);
	}

	private TransactionalService<TransferScheduler> transactionalDType(TransferScheduler transferScheduler)
			throws TransferSchedulerException {
		
		if ( transferScheduler.getTransferValue().longValue() <= 25000 ) {
			return transactionalAType(transferScheduler);
		}
		else if ( transferScheduler.getTransferValue().longValue() >= 25000 
				&& transferScheduler.getTransferValue().longValue() <= 120000) {
			
			return transactionalBTtype(transferScheduler);
		} 
		else if ( transferScheduler.getTransferValue().longValue() > 120000 ) {
			return transactionalCType(transferScheduler);
		}
		return transactional;
	}

	public TransactionalService<TransferScheduler> processByType(TransferScheduler transferScheduler)
			throws TransferSchedulerException {

		try {
			if ( OperationType.A.equals(transferScheduler.getOperation()) ) {
				return transactionalAType(transferScheduler);
			}

			else if ( OperationType.B.equals(transferScheduler.getOperation()) ) {
				return transactionalBTtype(transferScheduler);
			}

			else if ( OperationType.C.equals(transferScheduler.getOperation()) ) {
				return transactionalCType(transferScheduler);
			}

			else if ( OperationType.D.equals(transferScheduler.getOperation()) ) {
				return transactionalDType(transferScheduler);
			}

		} catch (Exception e) {
			throw new TransferSchedulerException(e);
		}
		return transactional;
	}
}
