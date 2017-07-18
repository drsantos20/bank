package com.scheduler.bank.transactional;

import com.scheduler.bank.builder.SchedulerBuilder;
import com.scheduler.bank.model.Account;
import com.scheduler.bank.model.TransferScheduler;
import com.scheduler.bank.service.TransactionalService;
import com.scheduler.bank.service.TransactionalTypeBServiceImpl;
import com.scheduler.bank.util.OperationType;
import org.joda.time.DateTime;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

public class TransacaoTipoBTest {
	
	private static Map<Integer, List<?>> transactions;
	
	@BeforeClass
	public static void init() {
		transactions = new HashMap<Integer, List<?>>();
	}
	
	@AfterClass
	public static void end() {
		transactions.size();
	}

	@Test
	public void testTransferUntilThirtyDaysWithBOperation() throws Exception {
		DateTime registrationDate = new DateTime(new Date());
		DateTime schedulerDate = registrationDate.plusDays(30);

		TransferScheduler transferScheduler = new SchedulerBuilder()
				.withAccountTo(new Account("01-44444"))
				.withAccountTo(new Account("01-55555"))
				.withTranferValue(new BigDecimal("100.00"))
				.withOperation(OperationType.B)
				.withRegistrationDate(registrationDate)
				.withSchedulerDate(schedulerDate)
				.getTransferScheduler();

		TransactionalService<TransferScheduler> transactionalOperation = new TransactionalTypeBServiceImpl().process(transferScheduler);
		transactions.put(transactionalOperation.getIdTransactional(), Arrays.asList(transferScheduler, transactionalOperation));
		Assert.assertEquals(10.00, transactionalOperation.getOrderValue().longValue(), 0.00001);
		Assert.assertEquals(90.00, transactionalOperation.getTransactionalValue().longValue(), 0.00001);
	}
	
	@Test
	public void testTransferBiggerThenThirtyDaysWithBOperation() throws Exception {
		DateTime registrationDate = new DateTime(new Date());
		DateTime schedulerDate = registrationDate.plusDays(70);

		TransferScheduler transferScheduler = new SchedulerBuilder()
				.withAccountTo(new Account("01-44444"))
				.withAccountTo(new Account("01-55555"))
				.withTranferValue(new BigDecimal("100.00"))
				.withOperation(OperationType.B)
				.withRegistrationDate(registrationDate)
				.withSchedulerDate(schedulerDate)
				.getTransferScheduler();

		TransactionalService<TransferScheduler> transactionalOperation = new TransactionalTypeBServiceImpl().process(transferScheduler);

		transactions.put(transactionalOperation.getIdTransactional(), Arrays.asList(transferScheduler, transactionalOperation));
		
		Assert.assertEquals(8.00, transactionalOperation.getOrderValue().longValue(), 0.00001);
		Assert.assertEquals(92.00, transactionalOperation.getTransactionalValue().longValue(), 0.00001);
	}

}

