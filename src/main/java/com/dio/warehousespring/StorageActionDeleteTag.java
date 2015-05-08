package com.dio.warehousespring;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.dio.javamentoring.warehouse.TVStorage;

public class StorageActionDeleteTag extends SimpleTagSupport {
	
	private int id;
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void doTag() throws JspException, IOException {
		JspContext context = getJspContext();
		StorageWebState storageWebState = (StorageWebState)context.getAttribute("storageWebState");		
		TVStorage storage = storageWebState.getCurrentStorage();
		
		storage.deleteItem(id);
	}
}
