package com.scheduler.bank.scheduler;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import org.joda.time.DateTime;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.scheduler.bank.builder.SchedulerBuilder;
import com.scheduler.bank.model.Account;
import com.scheduler.bank.model.TransferScheduler;
import com.scheduler.bank.model.User;
import com.scheduler.bank.service.TransactionalTransferServiceImpl;
import com.scheduler.bank.service.TransactionalService;
import com.scheduler.bank.util.OperationType;

public class SchedulerDTypeTest {

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
	public void testTransferUntilTwentyFiveThousandWithDOperation() throws Exception {
		DateTime registrationDate = new DateTime(new Date());
		DateTime schedulerDate = registrationDate.plusDays(3);
		
		TransferScheduler transactionalScheduler = new SchedulerBuilder()
				.withAccountTo(new Account("01-0444"))
				.withAccountTo(new Account("01-0555"))
				.withTranferValue(new BigDecimal("23999.00"))
				.withOperation(OperationType.D)
				.withRegistrationDate(registrationDate)
				.withSchedulerDate(schedulerDate)
				.getTransferScheduler();

		TransactionalService<TransferScheduler> transactionalOperation = new TransactionalTransferServiceImpl().processByType(transactionalScheduler);
		user.getListScheduler().put(transactionalOperation.getIdTransactional(), Arrays.asList(transactionalScheduler, transactionalOperation));
		Assert.assertEquals(721.97, transactionalOperation.getOrderValue().doubleValue(), 0.00001);
		Assert.assertEquals(23277.03, transactionalOperation.getTransactionalValue().doubleValue(), 0.00001);
		 
	}
	
	@Test         
	public void testTransferUntilTwentyFiveThousandWithThirtyDaysDOperation() throws Exception {
		DateTime registrationDate = new DateTime(new Date());
		DateTime schedulerDate = registrationDate.plusDays(3);
		
		TransferScheduler transactionalScheduler = new SchedulerBuilder()
				.withAccountTo(new Account("01-0444"))
				.withAccountTo(new Account("01-0555"))
				.withTranferValue(new BigDecimal("120000.00"))
				.withOperation(OperationType.D)
				.withRegistrationDate(registrationDate)
				.withSchedulerDate(schedulerDate)
				.getTransferScheduler();

		TransactionalService<TransferScheduler> transactionalOperation = new TransactionalTransferServiceImpl().processByType(transactionalScheduler);
		user.getListScheduler().put(transactionalOperation.getIdTransactional(), Arrays.asList(transactionalScheduler, transactionalOperation));
		Assert.assertEquals(10.00, transactionalOperation.getOrderValue().doubleValue(), 0.00001);
		Assert.assertEquals(119990.00, transactionalOperation.getTransactionalValue().doubleValue(), 0.00001);
	}
	
	@Test         
	public void  testTransferUntilOneHundredTwentyFiveBiggerThanThirtyDaysWithDOperation() throws Exception {
		DateTime registrationDate = new DateTime(new Date());
		DateTime schedulerDate = registrationDate.plusDays(31);
		
		TransferScheduler transactionalScheduler = new SchedulerBuilder()
				.withAccountTo(new Account("01-0444"))
				.withAccountTo(new Account("01-0555"))
				.withTranferValue(new BigDecimal("120000.00"))
				.withOperation(OperationType.D)
				.withRegistrationDate(registrationDate)
				.withSchedulerDate(schedulerDate)
				.getTransferScheduler();

		TransactionalService<TransferScheduler> transactionalOperation = new TransactionalTransferServiceImpl().processByType(transactionalScheduler);
		user.getListScheduler().put(transactionalOperation.getIdTransactional(), Arrays.asList(transactionalScheduler, transactionalOperation));
		Assert.assertEquals(8.00, transactionalOperation.getOrderValue().doubleValue(), 0.00001);
		Assert.assertEquals(119992.00, transactionalOperation.getTransactionalValue().doubleValue(), 0.00001);
	}
	
	@Test         
	public void testTransferBiggerThanOneHundredTwentyFiveBiggerThanThirtyDaysWithDOperation() throws Exception {
		DateTime registrationDate = new DateTime(new Date());
		DateTime schedulerDate = registrationDate.plusDays(31);
		
		TransferScheduler transactionalScheduler = new SchedulerBuilder()
				.withAccountTo(new Account("01-0444"))
				.withAccountTo(new Account("01-0555"))
				.withTranferValue(new BigDecimal("300000.00"))
				.withOperation(OperationType.D)
				.withRegistrationDate(registrationDate)
				.withSchedulerDate(schedulerDate)
				.getTransferScheduler();

		TransactionalService<TransferScheduler> transactionalOperation = new TransactionalTransferServiceImpl().processByType(transactionalScheduler);
		user.getListScheduler().put(transactionalOperation.getIdTransactional(), Arrays.asList(transactionalScheduler, transactionalOperation));
		Assert.assertEquals(3599.00, transactionalOperation.getOrderValue().longValue(), 0.00001);
		Assert.assertEquals(296400.00, transactionalOperation.getTransactionalValue().longValue(), 0.00001);
	}
	
}

