/**
 * 
 */
package com.scheduler.bank.service;

import com.scheduler.bank.builder.SchedulerBuilder;
import com.scheduler.bank.model.Account;
import com.scheduler.bank.model.TransferScheduler;
import com.scheduler.bank.model.User;
import com.scheduler.bank.util.OperationType;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Daniel on 16 de jul de 2017
 */
@Service
public class TransferSchedulerServiceImpl implements TransferSchedulerService {
	
	
	private static TransferScheduler mock() {
		
		DateTime schedulerDate = new DateTime(new Date());
		schedulerDate.plusDays(10);

		TransferScheduler transactionalScheduler = new SchedulerBuilder()
					.withAccountFrom(new Account("01-0222"))
					.withAccountIdentifyFrom(new User(1L,"Daniel"))
					.withAccountTo(new Account("01-0333"))
					.withTranferValue(new BigDecimal("100.00"))
					.withOperation(OperationType.A)
					.withSchedulerDate(schedulerDate)
					.getTransferScheduler();
		
		return transactionalScheduler;
		
	}
	
	static List<TransferScheduler> transfers = new ArrayList<TransferScheduler>(
            Arrays.asList(mock()));

	@Override
	public List<TransferScheduler> getAll() {
		return transfers;
	}


	@Override
	public TransferScheduler findByDocumentId(int id) {

		List<TransferScheduler> transfersFiltred =
				transfers
						.stream()
						.filter(p -> p.getUserIdentify().getDocumentId() == 1L)
						.collect(Collectors.toList());

		for (TransferScheduler transferScheduler : transfersFiltred){
                return transferScheduler;
        }
        return null;
	}
}
