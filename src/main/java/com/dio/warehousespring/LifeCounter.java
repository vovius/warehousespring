package com.dio.warehousespring;

import java.io.Serializable;

public class LifeCounter implements Serializable {
	
	private long timeCreated;

	public LifeCounter() {
		timeCreated = System.currentTimeMillis();
	}
	
	public long getLifePeriod() {
		return System.currentTimeMillis() - timeCreated;
	}
}
