package com.dio.warehousespring;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="warehouse")
public class WarehouseREST {

	private int id;
    private String content;
    
    public WarehouseREST() {};

    public WarehouseREST(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
