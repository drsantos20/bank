package com.scheduler.bank.builder;

import com.scheduler.bank.model.Account;
import com.scheduler.bank.model.TransferScheduler;
import com.scheduler.bank.model.User;
import com.scheduler.bank.util.OperationType;
import org.joda.time.DateTime;

import javax.validation.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by drsantos on 7/13/17.
 */
public class SchedulerBuilder {

    private TransferScheduler transferScheduler = new TransferScheduler();

    public SchedulerBuilder  withAccountFrom(Account from) {
        validationAccountField(from);
        transferScheduler.setFrom(from);
        return this;
    }
    
    public SchedulerBuilder  withAccountIdentifyFrom(User user) {
    	validationDateField(user);
        transferScheduler.setUserIdentify(user);
        return this;
    }

    public SchedulerBuilder withAccountTo(Account to) {
        validationAccountField(to);
        transferScheduler.setTo(to);
        return this;
    }

    public SchedulerBuilder withAccountNumber(Account to) {
        validationAccountField(to);
        transferScheduler.setTo(to);
        return this;
    }

    public SchedulerBuilder withTranferValue(BigDecimal transferValue) {
        validationDateField(transferValue);
        transferScheduler.setTransferValue(transferValue);
        return this;
    }

    public SchedulerBuilder withOperation(OperationType operation) {
        validationDateField(operation);
        transferScheduler.setOperation(operation);
        return this;
    }

    public SchedulerBuilder withSchedulerDate(DateTime schedulerDate) {
        validationDateField(schedulerDate);
        transferScheduler.setSchedulerDate(schedulerDate);
        return this;
    }

    public SchedulerBuilder withRegistrationDate(DateTime registrationDate) {
        validationDateField(registrationDate);
        transferScheduler.setRegistrationDate(registrationDate);
        return this;
    }

    public TransferScheduler getTransferScheduler() {
        return transferScheduler;
    }

    public void validationAccountField(Account account) throws ConstraintViolationException {
        if(account != null) {
            ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
            Validator validator = vf.getValidator();
            Set<ConstraintViolation<Account>> constraintViolations = validator
                    .validate(account);

            for (ConstraintViolation<Account> cv : constraintViolations) {
                System.out.println(String.format(
                        "Error the property: [%s], value: [%s], message: [%s]",
                        cv.getPropertyPath(), cv.getInvalidValue(), cv.getMessage()));
                throw new ConstraintViolationException(
                        new HashSet<ConstraintViolation<?>>(constraintViolations));
            }
        } else {
            throw new IllegalArgumentException("The field cannot be null.");
        }

    }

    public void validationTransferScheduler(TransferScheduler transferScheduler) {
        if(transferScheduler != null) {
            if(transferScheduler.getFrom().getNumber().equalsIgnoreCase(transferScheduler.getTo().getNumber())) {
                throw new IllegalArgumentException("the field from cannot be the same of field to");
            }

        }
    }

    public void validationDateField(Object parametro) {
        if (parametro == null) {
            throw new IllegalArgumentException("The field date cannot be null.");
        }
    }
}
