/**
 * 
 */
package com.scheduler.bank.controller;
/**
 * @author Daniel on 16 de jul de 2017
 */


import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.scheduler.bank.builder.SchedulerBuilder;
import com.scheduler.bank.model.Account;
import com.scheduler.bank.model.TransferScheduler;
import com.scheduler.bank.model.User;
import com.scheduler.bank.service.TransferSchedulerService;
import com.scheduler.bank.util.OperationType;

public class TransactionalControllerViewByUserTest {

	private MockMvc mockMvc;

	@Mock
	private TransferSchedulerService transferSchedulerService;

	@InjectMocks
	private TransferAccountController transferAccountController;
	
	@Mock
	TransferScheduler transactionalScheduler;
	

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(transferAccountController).build();
		
		DateTime schedulerDate = new DateTime(new Date());
		schedulerDate.plusDays(10);
		
		transactionalScheduler = new SchedulerBuilder()
				.withAccountFrom(new Account("01-0222"))
				.withAccountIdentifyFrom(new User("Robb"))
				.withAccountTo(new Account("01-0333"))
				.withTranferValue(new BigDecimal("250.00"))
				.withOperation(OperationType.A)
				.withSchedulerDate(schedulerDate)
				.getTransferScheduler();
	}

	@Test
    public void get_all_transfers() throws Exception {
		
        when(transferSchedulerService.getAll()).thenReturn(Arrays.asList(transactionalScheduler));
        
        mockMvc.perform(get("/transaction"))
		        .andExpect(status().isOk())
		        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		        .andExpect(jsonPath("$", hasSize(1)))
		        .andExpect(jsonPath("$[0].from.number", is("01-0222")))
		        .andExpect(jsonPath("$[0].to.number", is("01-0333")))
		        .andExpect(jsonPath("$[0].operation", is("A")))
		        .andExpect(jsonPath("$[0].userIdentify.name", is("Robb")))
		        .andExpect(jsonPath("$[0].transferValue", is(250.00)));
        
		verify(transferSchedulerService, times(1)).getAll();
		verifyNoMoreInteractions(transferSchedulerService);
	}
	
	
	@Test
    public void test_get_by_id_success() throws Exception {
        when(transferSchedulerService.findByDocumentId(1)).thenReturn(transactionalScheduler);
        mockMvc.perform(get("/transaction/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$.from.number", is("01-0222")))
				.andExpect(jsonPath("$.to.number", is("01-0333")))
                .andExpect(jsonPath("$.operation", is("A")))
				.andExpect(jsonPath("$.userIdentify.name", is("Robb")))
				.andExpect(jsonPath("$.transferValue", is(250.00)));

        verify(transferSchedulerService, times(1)).findByDocumentId(1);
		verifyNoMoreInteractions(transferSchedulerService);
    }
	
	
	
	
}
