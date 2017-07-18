package com.scheduler.bank.scheduler;

import com.scheduler.bank.builder.SchedulerBuilder;
import com.scheduler.bank.model.Account;
import com.scheduler.bank.model.TransferScheduler;
import com.scheduler.bank.model.User;
import com.scheduler.bank.service.TransactionalService;
import com.scheduler.bank.service.TransactionalTransferServiceImpl;
import com.scheduler.bank.util.OperationType;
import org.joda.time.DateTime;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

public class SchedulerCTypeTest {

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
	public void testTransferUntilFiveDaysWithCOperation() throws Exception {
		DateTime registrationDate = new DateTime(new Date());
		DateTime schedulerDate = registrationDate.plusDays(3);
		
		TransferScheduler transactionalScheduler = new SchedulerBuilder()
				.withAccountTo(new Account("01-0444"))
				.withAccountTo(new Account("01-0555"))
				.withTranferValue(new BigDecimal("400.00"))
				.withOperation(OperationType.C)
				.withRegistrationDate(registrationDate)
				.withSchedulerDate(schedulerDate)
				.getTransferScheduler();

		TransactionalService<TransferScheduler> transactionalOperation = new TransactionalTransferServiceImpl().processByType(transactionalScheduler);
		userB.getListScheduler().put(transactionalOperation.getIdTransactional(), Arrays.asList(transactionalScheduler, transactionalOperation));
		Assert.assertEquals(33.20, transactionalOperation.getOrderValue().doubleValue(), 0.00001);
		Assert.assertEquals(366.80, transactionalOperation.getTransactionalValue().doubleValue(), 0.00001);
	}
	
	@Test
	public void testTransferUntilTenDaysWithCOperation() throws Exception {
		DateTime registrationDate = new DateTime(new Date());
		DateTime schedulerDate = registrationDate.plusDays(9);
		
		TransferScheduler transactionalScheduler = new SchedulerBuilder()
				.withAccountTo(new Account("01-0444"))
				.withAccountTo(new Account("01-0555"))
				.withTranferValue(new BigDecimal("400.00"))
				.withOperation(OperationType.C)
				.withRegistrationDate(registrationDate)
				.withSchedulerDate(schedulerDate)
				.getTransferScheduler();

		TransactionalService<TransferScheduler> transactionalOperation = new TransactionalTransferServiceImpl().processByType(transactionalScheduler);
		userA.getListScheduler().put(transactionalOperation.getIdTransactional(), Arrays.asList(transactionalScheduler, transactionalOperation));
		Assert.assertEquals(29.60, transactionalOperation.getOrderValue().doubleValue(), 0.00001);
		Assert.assertEquals(370.40, transactionalOperation.getTransactionalValue().doubleValue(), 0.00001);
	}
	
	@Test
	public void testTransferUntilFifteenDaysWithCOperation() throws Exception {
		DateTime registrationDate = new DateTime(new Date());
		DateTime schedulerDate = registrationDate.plusDays(11);
		
		TransferScheduler transactionalScheduler = new SchedulerBuilder()
				.withAccountTo(new Account("01-0444"))
				.withAccountTo(new Account("01-0555"))
				.withTranferValue(new BigDecimal("400.00"))
				.withOperation(OperationType.C)
				.withRegistrationDate(registrationDate)
				.withSchedulerDate(schedulerDate)
				.getTransferScheduler();

		TransactionalService<TransferScheduler> transactionalOperation = new TransactionalTransferServiceImpl().processByType(transactionalScheduler);
		userA.getListScheduler().put(transactionalOperation.getIdTransactional(), Arrays.asList(transactionalScheduler, transactionalOperation));
		Assert.assertEquals(26.80, transactionalOperation.getOrderValue().doubleValue(), 0.00001);
		Assert.assertEquals(373.20, transactionalOperation.getTransactionalValue().doubleValue(), 0.00001);
		 
	}
	
	@Test
	public void testTransferUntilTwentyDaysWithCOperation() throws Exception {
		DateTime registrationDate = new DateTime(new Date());
		DateTime schedulerDate = registrationDate.plusDays(16);
		
		TransferScheduler transactionalScheduler = new SchedulerBuilder()
				.withAccountTo(new Account("01-0444"))
				.withAccountTo(new Account("01-0555"))
				.withTranferValue(new BigDecimal("400.00"))
				.withOperation(OperationType.C)
				.withRegistrationDate(registrationDate)
				.withSchedulerDate(schedulerDate)
				.getTransferScheduler();

		TransactionalService<TransferScheduler> transactionalOperation = new TransactionalTransferServiceImpl().processByType(transactionalScheduler);
		userA.getListScheduler().put(transactionalOperation.getIdTransactional(), Arrays.asList(transactionalScheduler, transactionalOperation));
		Assert.assertEquals(21.60, transactionalOperation.getOrderValue().doubleValue(), 0.00001);
		Assert.assertEquals(378.40, transactionalOperation.getTransactionalValue().doubleValue(), 0.00001);
	}
	
	@Test
	public void testTransferUntilTwentyFiveDaysWithCOperation() throws Exception {
		DateTime registrationDate = new DateTime(new Date());
		DateTime schedulerDate = registrationDate.plusDays(24);
		
		TransferScheduler transactionalScheduler = new SchedulerBuilder()
				.withAccountTo(new Account("01-0444"))
				.withAccountTo(new Account("01-0555"))
				.withTranferValue(new BigDecimal("400.00"))
				.withOperation(OperationType.C)
				.withRegistrationDate(registrationDate)
				.withSchedulerDate(schedulerDate)
				.getTransferScheduler();

		TransactionalService<TransferScheduler> transactionalOperation = new TransactionalTransferServiceImpl().processByType(transactionalScheduler);
		userB.getListScheduler().put(transactionalOperation.getIdTransactional(), Arrays.asList(transactionalScheduler, transactionalOperation));
		Assert.assertEquals(17.20, transactionalOperation.getOrderValue().doubleValue(), 0.00001);
		Assert.assertEquals(382.80, transactionalOperation.getTransactionalValue().doubleValue(), 0.00001);
	}
	
	@Test
	public void testTransferUntilThirtyDaysWithCOperation() throws Exception {
		DateTime registrationDate = new DateTime(new Date());
		DateTime schedulerDate = registrationDate.plusDays(30);
		
		TransferScheduler transactionalScheduler = new SchedulerBuilder()
				.withAccountTo(new Account("01-0444"))
				.withAccountTo(new Account("01-0555"))
				.withTranferValue(new BigDecimal("400.00"))
				.withOperation(OperationType.C)
				.withRegistrationDate(registrationDate)
				.withSchedulerDate(schedulerDate)
				.getTransferScheduler();

		TransactionalService<TransferScheduler> transactionalOperation = new TransactionalTransferServiceImpl().processByType(transactionalScheduler);
		userA.getListScheduler().put(transactionalOperation.getIdTransactional(), Arrays.asList(transactionalScheduler, transactionalOperation));
		Assert.assertEquals(8.4, transactionalOperation.getOrderValue().doubleValue(), 0.00001);
		Assert.assertEquals(391.60, transactionalOperation.getTransactionalValue().doubleValue(), 0.00001);
	}
	
	@Test
	public void testTransferBiggerThenThirtyDaysWithCOperation() throws Exception {
		DateTime registrationDate = new DateTime(new Date());
		DateTime schedulerDate = registrationDate.plusDays(35);
		
		TransferScheduler transactionalScheduler = new SchedulerBuilder()
				.withAccountTo(new Account("01-0444"))
				.withAccountTo(new Account("01-0555"))
				.withTranferValue(new BigDecimal("400.00"))
				.withOperation(OperationType.C)
				.withRegistrationDate(registrationDate)
				.withSchedulerDate(schedulerDate)
				.getTransferScheduler();

		TransactionalService<TransferScheduler> transactionalOperation = new TransactionalTransferServiceImpl().processByType(transactionalScheduler);
		userA.getListScheduler().put(transactionalOperation.getIdTransactional(), Arrays.asList(transactionalScheduler, transactionalOperation));
		Assert.assertEquals(4.80, transactionalOperation.getOrderValue().doubleValue(), 0.00001);
		Assert.assertEquals(395.20, transactionalOperation.getTransactionalValue().doubleValue(), 0.00001);
	}

}

