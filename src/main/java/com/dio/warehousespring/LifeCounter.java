package com.dio.warehousespring;

public class LifeCounter {
	
	private long timeCreated;

	public LifeCounter() {
		timeCreated = System.currentTimeMillis();
	}
	
	public long getLifePeriod() {
		return System.currentTimeMillis() - timeCreated;
	}
}
