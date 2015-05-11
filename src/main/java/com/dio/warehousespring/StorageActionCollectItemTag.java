package com.dio.warehousespring;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.dio.javamentoring.warehouse.TV;
import com.dio.javamentoring.warehouse.TVStorage;

public class StorageActionCollectItemTag extends SimpleTagSupport {
	
	private TV item;
	private StorageWebState storageWebState;
	
	public TV getItem() {
		return item;
	}

	public void setItem(TV item) {
		this.item = item;
	}

	public StorageWebState getStorageWebState() {
		return storageWebState;
	}

	public void setStorageWebState(StorageWebState storageWebState) {
		this.storageWebState = storageWebState;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		TVStorage storage = storageWebState.getCurrentStorage();		
		storage.setItem(item);
	}
	
}
