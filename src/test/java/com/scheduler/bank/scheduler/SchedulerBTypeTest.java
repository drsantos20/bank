package com.scheduler.bank.scheduler;

import com.scheduler.bank.builder.SchedulerBuilder;
import com.scheduler.bank.model.Account;
import com.scheduler.bank.model.TransferScheduler;
import com.scheduler.bank.model.User;
import com.scheduler.bank.service.TransactionalService;
import com.scheduler.bank.service.TransactionalTransferServiceImpl;
import com.scheduler.bank.service.TransactionalTypeAServiceImpl;
import com.scheduler.bank.util.OperationType;
import org.joda.time.DateTime;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

public class SchedulerBTypeTest {

	private static User userA;
	private static User userB;

	@BeforeClass
	public static void inicializa() {
		userA = new User(36319221836L, "John Snow");
		userB = new User(36319221836L, "Robb Stark");
	}
	
	@AfterClass
	public static void finaliza() {
		userA.getListScheduler().size();
		userB.getListScheduler().size();
	}
	
	@Test
	public void testTransferUntilThirtyDaysWithBOperation() throws Exception {
		DateTime registrationDate = new DateTime(new Date());
		DateTime schedulerDate = registrationDate.plusDays(3);
		
		TransferScheduler transactionalScheduler = new SchedulerBuilder()
				.withAccountTo(new Account("01-0444"))
				.withAccountTo(new Account("01-0555"))
				.withTranferValue(new BigDecimal("500.00"))
				.withOperation(OperationType.B)
				.withRegistrationDate(registrationDate)
				.withSchedulerDate(schedulerDate)
				.getTransferScheduler();
		
		TransactionalService<TransferScheduler> transactionalOperation = new TransactionalTransferServiceImpl().processByType(transactionalScheduler);
		userA.getListScheduler().put(transactionalOperation.getIdTransactional(), Arrays.asList(transactionalScheduler, transactionalOperation));
		Assert.assertEquals(10.00, transactionalOperation.getOrderValue().doubleValue(), 0.00001);
		Assert.assertEquals(490.00, transactionalOperation.getTransactionalValue().doubleValue(), 0.00001);
	}
	
	@Test
	public void testTransferBiggerThanThirtyDaysWithBOperation() throws Exception {
		DateTime registrationDate = new DateTime(new Date());
		DateTime schedulerDate = registrationDate.plusDays(31);
		 
		TransferScheduler transactionalScheduler = new SchedulerBuilder()
				.withAccountTo(new Account("01-0444"))
				.withAccountTo(new Account("01-0555"))
				.withTranferValue(new BigDecimal("400.00"))
				.withOperation(OperationType.B)
				.withRegistrationDate(registrationDate)
				.withSchedulerDate(schedulerDate)
				.getTransferScheduler();
		
		TransactionalService<TransferScheduler> transactionalOperation = new TransactionalTransferServiceImpl().processByType(transactionalScheduler);
		userB.getListScheduler().put(transactionalOperation.getIdTransactional(), Arrays.asList(transactionalScheduler, transactionalOperation));
		Assert.assertEquals(8.00, transactionalOperation.getOrderValue().doubleValue(), 0.00001);
		Assert.assertEquals(392.00, transactionalOperation.getTransactionalValue().doubleValue(), 0.00001);
	}

}
