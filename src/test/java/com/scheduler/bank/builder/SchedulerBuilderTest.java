package com.scheduler.bank.builder;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.ConstraintViolationException;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.scheduler.bank.BankApplication;
import com.scheduler.bank.model.Account;
import com.scheduler.bank.util.OperationType;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration(classes = {BankApplication.class})
public class SchedulerBuilderTest {

	@Test(expected=ConstraintViolationException.class)
	public void testInvalidAccountNumberConstraintViolationException() throws Exception {

		new SchedulerBuilder().withAccountFrom(new Account("32433443"))
				.withAccountNumber(new Account("vcsdgfdsgdfgfd"))
				.getTransferScheduler();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSchedulerWithFromNullForIllegalArgumentException() throws Exception {
		
		 DateTime schedulerDate = new DateTime(new Date());
		 schedulerDate.plusDays(10);
		
		new SchedulerBuilder().withAccountFrom(null)
						   .withAccountTo(new Account("01-0222"))
						   .withTranferValue(new BigDecimal(100.0))
						   .withOperation(OperationType.A)
						   .withSchedulerDate(schedulerDate)
						   .getTransferScheduler();
	}
	
	@Test(expected=ConstraintViolationException.class)
	public void testSchedulerToNullForIllegalArgumentException() throws Exception {
		
		 DateTime schedulerDate = new DateTime(new Date());
		 schedulerDate.plusDays(10);

		new SchedulerBuilder().withAccountFrom(new Account("01-03322"))
				.withAccountTo(new Account(null))
				.withTranferValue(new BigDecimal(100.0))
				.withOperation(OperationType.A)
				.withSchedulerDate(schedulerDate)
				.getTransferScheduler();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSchedulerTransferValueNullForIllegalArgumentException() throws Exception {
		
		 DateTime schedulerDate = new DateTime(new Date());
		 schedulerDate.plusDays(10);

		new SchedulerBuilder().withAccountFrom(new Account("01-03322"))
				.withAccountTo(new Account("01-0222"))
				.withTranferValue(null)
				.withOperation(OperationType.A)
				.withSchedulerDate(schedulerDate)
				.getTransferScheduler();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSchedulerOperationNullForIllegalArgumentException() throws Exception {
		
		 DateTime schedulerDate = new DateTime(new Date());
		 schedulerDate.plusDays(10);

		new SchedulerBuilder().withAccountFrom(new Account("01-03322"))
				.withAccountTo(new Account("01-0222"))
				.withTranferValue(new BigDecimal(100.0))
				.withOperation(null)
				.withSchedulerDate(schedulerDate)
				.getTransferScheduler();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSchedulerDateNullForIllegalArgumentException() throws Exception {

		new SchedulerBuilder().withAccountFrom(new Account("01-03322"))
				.withAccountTo(new Account("01-0222"))
				.withTranferValue(new BigDecimal(100.0))
				.withOperation(OperationType.A)
				.withSchedulerDate(null)
				.getTransferScheduler();
	}
}
