package com.dio.warehousespring;

import com.dio.javamentoring.warehouse.StorageType;
import com.dio.javamentoring.warehouse.TVStorage;
import com.dio.javamentoring.warehouse.Warehouse;

public class StorageWebState {
	
	private Warehouse warehouse;
	private StorageType storageSelected;

	public StorageWebState() {
		warehouse = new Warehouse();
		try {
			warehouse.initTVManageService("C:\\111\\");
		} catch (Exception e) {
			e.printStackTrace();
			warehouse = null;
		}
	}
	
	public String getStorageSelected() {
		return storageSelected.name();
	}


	public void setStorageSelected(String storageSelected) {
		this.storageSelected = StorageType.valueOf(storageSelected);
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}


	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
	
	
	public TVStorage getCurrentStorage() {
		try {
			return warehouse.getStorage(storageSelected);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	


}
