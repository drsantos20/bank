package com.scheduler.bank.transactional;

import com.scheduler.bank.builder.SchedulerBuilder;
import com.scheduler.bank.model.Account;
import com.scheduler.bank.model.TransferScheduler;
import com.scheduler.bank.service.TransactionalService;
import com.scheduler.bank.service.TransactionalTypeCServiceImpl;
import com.scheduler.bank.util.OperationType;
import org.joda.time.DateTime;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

public class TransacaoTipoCTest {

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
	public void testTransferUntilFiveDaysWithOperationTypeC() throws Exception {
		DateTime registrationDate = new DateTime(new Date());
		DateTime schedulerDate = registrationDate.plusDays(4);

		TransferScheduler transferScheduler = new SchedulerBuilder()
				.withAccountTo(new Account("01-44444"))
				.withAccountTo(new Account("01-55555"))
				.withTranferValue(new BigDecimal("100.00"))
				.withOperation(OperationType.C)
				.withRegistrationDate(registrationDate)
				.withSchedulerDate(schedulerDate)
				.getTransferScheduler();

		TransactionalService<TransferScheduler> transactionalOperation = new TransactionalTypeCServiceImpl().process(transferScheduler);
		transactions.put(transactionalOperation.getIdTransactional(), Arrays.asList(transferScheduler, transactionalOperation));
		Assert.assertEquals(8.30, transactionalOperation.getOrderValue().doubleValue(), 0.00001);
		Assert.assertEquals(91.70, transactionalOperation.getTransactionalValue().doubleValue(), 0.00001);
	}
	
	@Test
	public void testTransferUntilTenDaysWithOperationTypeC() throws Exception {
		DateTime registrationDate = new DateTime(new Date());
		DateTime schedulerDate = registrationDate.plusDays(7);

		TransferScheduler transferScheduler = new SchedulerBuilder()
				.withAccountTo(new Account("01-44444"))
				.withAccountTo(new Account("01-55555"))
				.withTranferValue(new BigDecimal("100.00"))
				.withOperation(OperationType.C)
				.withRegistrationDate(registrationDate)
				.withSchedulerDate(schedulerDate)
				.getTransferScheduler();

		TransactionalService<TransferScheduler> transactionalOperation = new TransactionalTypeCServiceImpl().process(transferScheduler);
		transactions.put(transactionalOperation.getIdTransactional(), Arrays.asList(transferScheduler, transactionalOperation));
		Assert.assertEquals(7.40, transactionalOperation.getOrderValue().doubleValue(), 0.00001);
		Assert.assertEquals(92.60, transactionalOperation.getTransactionalValue().doubleValue(), 0.00001);
	}
	
	@Test
	public void testTransferUntilFifteenDaysWithOperationTypeC() throws Exception {
		DateTime registrationDate = new DateTime(new Date());
		DateTime schedulerDate = registrationDate.plusDays(14);

		TransferScheduler transferScheduler = new SchedulerBuilder()
				.withAccountTo(new Account("01-44444"))
				.withAccountTo(new Account("01-55555"))
				.withTranferValue(new BigDecimal("100.00"))
				.withOperation(OperationType.C)
				.withRegistrationDate(registrationDate)
				.withSchedulerDate(schedulerDate)
				.getTransferScheduler();

		TransactionalService<TransferScheduler> transactionalOperation = new TransactionalTypeCServiceImpl().process(transferScheduler);
		transactions.put(transactionalOperation.getIdTransactional(), Arrays.asList(transferScheduler, transactionalOperation));
		Assert.assertEquals(6.70, transactionalOperation.getOrderValue().doubleValue(), 0.00001);
		Assert.assertEquals(93.30, transactionalOperation.getTransactionalValue().doubleValue(), 0.00001);
	}
	
	@Test
	public void testTransferUntilTwentyDaysWithOperationTypeC() throws Exception {
		DateTime registrationDate = new DateTime(new Date());
		DateTime schedulerDate = registrationDate.plusDays(20);

		TransferScheduler transferScheduler = new SchedulerBuilder()
				.withAccountTo(new Account("01-44444"))
				.withAccountTo(new Account("01-55555"))
				.withTranferValue(new BigDecimal("100.00"))
				.withOperation(OperationType.C)
				.withRegistrationDate(registrationDate)
				.withSchedulerDate(schedulerDate)
				.getTransferScheduler();

		TransactionalService<TransferScheduler> transactionalOperation = new TransactionalTypeCServiceImpl().process(transferScheduler);
		transactions.put(transactionalOperation.getIdTransactional(), Arrays.asList(transferScheduler, transactionalOperation));
		Assert.assertEquals(5.40, transactionalOperation.getOrderValue().doubleValue(), 0.00001);
		Assert.assertEquals(94.60, transactionalOperation.getTransactionalValue().doubleValue(), 0.00001);
	}
	
	@Test
	public void testTransferUntilTwentyFiveDaysWithOperationTypeC() throws Exception {
		DateTime registrationDate = new DateTime(new Date());
		DateTime schedulerDate = registrationDate.plusDays(21);

		TransferScheduler transferScheduler = new SchedulerBuilder()
				.withAccountTo(new Account("01-44444"))
				.withAccountTo(new Account("01-55555"))
				.withTranferValue(new BigDecimal("100.00"))
				.withOperation(OperationType.C)
				.withRegistrationDate(registrationDate)
				.withSchedulerDate(schedulerDate)
				.getTransferScheduler();

		TransactionalService<TransferScheduler> transactionalOperation = new TransactionalTypeCServiceImpl().process(transferScheduler);
		transactions.put(transactionalOperation.getIdTransactional(), Arrays.asList(transferScheduler, transactionalOperation));
		Assert.assertEquals(4.30, transactionalOperation.getOrderValue().doubleValue(), 0.00001);
		Assert.assertEquals(95.70, transactionalOperation.getTransactionalValue().doubleValue(), 0.00001);
	}
	
	@Test
	public void testTransferUntilThirtyDaysWithOperationTypeC() throws Exception {
		DateTime registrationDate = new DateTime(new Date());
		DateTime schedulerDate = registrationDate.plusDays(28);

		TransferScheduler transferScheduler = new SchedulerBuilder()
				.withAccountTo(new Account("01-44444"))
				.withAccountTo(new Account("01-55555"))
				.withTranferValue(new BigDecimal("100.00"))
				.withOperation(OperationType.C)
				.withRegistrationDate(registrationDate)
				.withSchedulerDate(schedulerDate)
				.getTransferScheduler();

		TransactionalService<TransferScheduler> transactionalOperation = new TransactionalTypeCServiceImpl().process(transferScheduler);
		transactions.put(transactionalOperation.getIdTransactional(), Arrays.asList(transferScheduler, transactionalOperation));
		Assert.assertEquals(2.10, transactionalOperation.getOrderValue().doubleValue(), 0.00001);
		Assert.assertEquals(97.90, transactionalOperation.getTransactionalValue().doubleValue(), 0.00001);
	}
	
	@Test
	public void testTransferBiggerThanThirtyDaysWithOperationTypeC() throws Exception {
		DateTime registrationDate = new DateTime(new Date());
		DateTime schedulerDate = registrationDate.plusDays(31);

		TransferScheduler transferScheduler = new SchedulerBuilder()
				.withAccountTo(new Account("01-44444"))
				.withAccountTo(new Account("01-55555"))
				.withTranferValue(new BigDecimal("100.00"))
				.withOperation(OperationType.C)
				.withRegistrationDate(registrationDate)
				.withSchedulerDate(schedulerDate)
				.getTransferScheduler();

		TransactionalService<TransferScheduler> transactionalOperation = new TransactionalTypeCServiceImpl().process(transferScheduler);
		transactions.put(transactionalOperation.getIdTransactional(), Arrays.asList(transferScheduler, transactionalOperation));
		Assert.assertEquals(1.20, transactionalOperation.getOrderValue().doubleValue(), 0.00001);
		Assert.assertEquals(98.80, transactionalOperation.getTransactionalValue().doubleValue(), 0.00001);
	}
	
}

