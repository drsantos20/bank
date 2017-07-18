package com.scheduler.bank.model;

import java.util.HashMap;
import java.util.List;

import javax.validation.constraints.NotNull;

/**
 * Created by drsantos on 7/13/17.
 */
public class User {
    @NotNull
    private Long documentId;
    @NotNull
    private String name;
    private HashMap<Integer, List<?>> listScheduler;
    
	public User(String name) {
		super();
		this.name = name;
	}
	
	public User(Long documentId, String name) {
		super();
		this.documentId = documentId;
		this.name = name;
	}

	public String getName() {
        return name;
    }

	public void setName(String name) {
        this.name = name;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public HashMap<Integer, List<?>> getListScheduler() {
    	if(listScheduler == null) {
    		return listScheduler = new HashMap<Integer, List<?>>();
    	}
    	return listScheduler;
        
    }


}
