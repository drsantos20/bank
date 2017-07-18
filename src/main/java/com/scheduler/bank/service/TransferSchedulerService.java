/**
 * 
 */
package com.scheduler.bank.service;

import java.util.List;

import com.scheduler.bank.model.TransferScheduler;

/**
 * @author Daniel on 16 de jul de 2017
 */

public interface TransferSchedulerService {
	
	List<TransferScheduler> getAll();

	TransferScheduler findByDocumentId(int id);
	
}
