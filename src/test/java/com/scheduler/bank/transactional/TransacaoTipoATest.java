package com.scheduler.bank.transactional;

import com.scheduler.bank.builder.SchedulerBuilder;
import com.scheduler.bank.model.Account;
import com.scheduler.bank.model.TransferScheduler;
import com.scheduler.bank.service.TransactionalService;
import com.scheduler.bank.service.TransactionalTypeAServiceImpl;
import com.scheduler.bank.util.OperationType;
import org.joda.time.DateTime;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

public class TransacaoTipoATest {
	
	@BeforeClass
	public static void init() {
		transactions = new HashMap<Integer, List<?>>();
	}
	
	@AfterClass
	public static void end() {
		transactions.size();
	}

	private static Map<Integer, List<?>> transactions;

	@Test
	public void testTransferWithAOperation() throws Exception {
		
		DateTime dataAgendamento = new DateTime(new Date());
		dataAgendamento.plusDays(10);

		TransferScheduler transactionalScheduler = new SchedulerBuilder()
					.withAccountTo(new Account("01-0222"))
					.withAccountTo(new Account("01-0222"))
					.withTranferValue(new BigDecimal("100.00"))
					.withOperation(OperationType.A)
					.withSchedulerDate(dataAgendamento)
					.getTransferScheduler();

		TransactionalService<TransferScheduler> transactionalOperation = new TransactionalTypeAServiceImpl().process(transactionalScheduler);

		transactions.put(transactionalOperation.getIdTransactional(), Arrays.asList(transactionalScheduler, transactionalOperation));
		
		Assert.assertEquals(5.00, transactionalOperation.getOrderValue().longValue(), 0.00001);
		Assert.assertEquals(95.00, transactionalOperation.getTransactionalValue().longValue(), 0.00001);
	}
	
}

