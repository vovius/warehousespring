package com.dio.warehousespring;

import com.dio.javamentoring.warehouse.StorageType;
import com.dio.javamentoring.warehouse.TVStorage;
import com.dio.javamentoring.warehouse.Warehouse;

public class StorageWebState {
	
	private StorageType storageSelected;
	private Warehouse warehouse;
	private WarehouseSpring warehouseSpring;

	public StorageWebState() {}
	
	public StorageWebState(StorageType storageType) {
		this.storageSelected = storageType;
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
	
	

	public WarehouseSpring getWarehouseSpring() {
		return warehouseSpring;
	}

	public void setWarehouseSpring(WarehouseSpring warehouseSpring) {
		this.warehouseSpring = warehouseSpring;
	}

	public TVStorage getCurrentStorage() {
		try {
			return warehouseSpring.getManageService().getStorage(storageSelected);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


}
