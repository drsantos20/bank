package com.scheduler.bank.scheduler;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import com.scheduler.bank.service.TransactionalTransferServiceImpl;
import org.joda.time.DateTime;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.scheduler.bank.builder.SchedulerBuilder;
import com.scheduler.bank.model.Account;
import com.scheduler.bank.model.TransferScheduler;
import com.scheduler.bank.model.User;
import com.scheduler.bank.service.TransactionalTypeAServiceImpl;
import com.scheduler.bank.service.TransactionalService;
import com.scheduler.bank.util.OperationType;

public class SchedulerATypeTest {

	private static User user;
	
	@BeforeClass
	public static void init() {
		user = new User(36319221836L, "John Snow");
	}
	
	@AfterClass
	public static void end() {
		user.getListScheduler().size();
	}
	
	@Test
	public void testTransferWithAOperation() throws Exception {
		DateTime schedulerDate = new DateTime(new Date());
		schedulerDate.plusDays(3);
		 
		TransferScheduler transactionalScheduler = new SchedulerBuilder()
				.withAccountTo(new Account("01-0444"))
				.withAccountTo(new Account("01-0555"))
				.withTranferValue(new BigDecimal("400.00"))
				.withOperation(OperationType.A)
				.withSchedulerDate(schedulerDate)
				.getTransferScheduler();
		
		
		TransactionalService<TransferScheduler> transactionalOperation = new TransactionalTransferServiceImpl().processByType(transactionalScheduler);

		user.getListScheduler().put(transactionalOperation.getIdTransactional(), Arrays.asList(transactionalScheduler, transactionalOperation));

		Assert.assertEquals(14.00, transactionalOperation.getOrderValue().doubleValue(), 0.00001);
		Assert.assertEquals(386.00, transactionalOperation.getTransactionalValue().doubleValue(), 0.00001);
	}
	
}

