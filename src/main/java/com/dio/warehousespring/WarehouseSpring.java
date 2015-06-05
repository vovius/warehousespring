package com.dio.warehousespring;

import java.util.List;

import com.dio.javamentoring.warehouse.*;

public class WarehouseSpring extends Warehouse {
	
	private static WarehouseSpring warehouseSpring;
	
	public WarehouseSpring() throws Exception {
		super();
	}
	
	public static WarehouseSpring initStorageFactory(String factoryFolder) throws Exception {
		warehouseSpring = new WarehouseSpring();
		warehouseSpring.getManageService().createStorageFactory(factoryFolder);
		return warehouseSpring;
	}
	
	public TVStorage initStorageByType(StorageType storageType) throws Exception {
		getManageService().initByStorageType(storageType);
		return getManageService().getStorage(storageType); 
	}
	
	public List<TVStorage> getStorages() throws Exception {
		return getManageService().getStorages();
	}
		
}
