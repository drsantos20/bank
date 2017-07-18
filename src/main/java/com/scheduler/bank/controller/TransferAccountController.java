/**
 * 
 */
package com.scheduler.bank.controller;

import com.scheduler.bank.model.TransferScheduler;
import com.scheduler.bank.service.TransferSchedulerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author Daniel on 16 de jul de 2017
 */

@Controller
@RequestMapping("/transaction")
public class TransferAccountController {
	
    private final Logger LOG = LoggerFactory.getLogger(TransferAccountController.class);
    
    @Autowired
    private TransferSchedulerService transferSchedulerService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<TransferScheduler>> getAll() {
        LOG.info("getting all transfers");
        List<TransferScheduler> transfersByAllUsers = transferSchedulerService.getAll();

        if (transfersByAllUsers == null || transfersByAllUsers.isEmpty()){
            LOG.info("no users found");
            return new ResponseEntity<List<TransferScheduler>>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<TransferScheduler>>(transfersByAllUsers, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<TransferScheduler> get(@PathVariable("id") int id){
        LOG.info("getting transfer with user documentId: {}", id);
        TransferScheduler transfersByAllUsers = transferSchedulerService.findByDocumentId(id);

        if (transfersByAllUsers == null){
            LOG.info("user with documentId {} not found", id);
            return new ResponseEntity<TransferScheduler>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<TransferScheduler>(transfersByAllUsers, HttpStatus.OK);
    }
}
