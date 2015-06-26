package com.dio.warehousespring;

import java.util.List;

import javax.xml.bind.annotation.*;

import com.dio.javamentoring.warehouse.StorageType;

@XmlRootElement(name="storages")
public class WarehouseRESTStorageList {

	
	private int count;
	private List<StorageType> storageList;

	public WarehouseRESTStorageList() {}
	
	public WarehouseRESTStorageList(List<StorageType> storageList) {
		this.storageList = storageList;
		this.count = storageList.size();
	}

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@XmlElement(name="StorageType")
	public List<StorageType> getEmployees() {
		return storageList;
	}
	
	public void setStorageList(List<StorageType> storageList) {
		this.storageList = storageList;
	}
		
}
