package com.dio.warehousespring;

import java.io.IOException;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.dio.javamentoring.warehouse.TVStorage;

public class StorageActionSaveTag extends SimpleTagSupport {
	
	private StorageWebState storageWebState;
	
	public StorageWebState getStorageWebState() {
		return storageWebState;
	}

	public void setStorageWebState(StorageWebState storageWebState) {
		this.storageWebState = storageWebState;
	}



	@Override
	public void doTag() throws JspException, IOException {
		TVStorage storage = storageWebState.getCurrentStorage();
		
		try {
			storage.saveLastLoaded();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
