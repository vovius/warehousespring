package com.dio.warehousespring;

import java.text.SimpleDateFormat;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.dio.javamentoring.warehouse.*;

@ApplicationPath("/storages-jersey")
@Path("/storages-jersey")
public class JerseyStorageMaintain {
	
	@Autowired
	private WarehouseSpring storageFactory;

	public void setStorageFactory(WarehouseSpring storageFactory) {
		this.storageFactory = storageFactory;
	}
	
	@GET @Path("/{storageId}/{itemId}")
	@Produces({MediaType.APPLICATION_JSON})
	public TV getStorageItem(@PathParam("storageId") String storageId, 
			                     @PathParam("itemId") int itemId) throws Exception {
		StorageType storageType = StorageType.valueOf(storageId);
		TVStorage storage = storageFactory.getManageService().getStorage(storageType);
		TV item = null;
		if (storage != null) {
			item = storage.getItemById(itemId);
		}
		return item; 
	}
	
	@PUT @Path("/{storageId}/{brand}/{diagonal}/{matrixType}/{dateMade}/{description}")
	@Produces(MediaType.APPLICATION_JSON)
	public TVStorage createStorageItem(@PathParam("storageId") String storageId,
								  @PathParam("brand") String brand,
								  @PathParam("diagonal") int diagonal,
								  @PathParam("matrixType") MatrixType matrixType,
								  @PathParam("dateMade") String dateMade,
								  @PathParam("description") String description) throws Exception {
		
		StorageType storageType = StorageType.valueOf(storageId);
		TVStorage storage = storageFactory.getManageService().getStorage(storageType);
		if (storage != null) {
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
			
			TV item = new TV.Builder()
			                .id(storage.getNewId())
							.brand(brand)
							.diagonal(diagonal)
							.matrixType(matrixType)
							.dateMade(dateFormat.parse(dateMade))
							.description(description)
							.build();
			storage.addItem(item);
			storage.saveLastLoaded();
		}
		
		return storage;
	}
	
	@POST @Path("/{storageId}/{id}/{brand}/{diagonal}/{matrixType}/{dateMade}/{description}")
	@Produces(MediaType.APPLICATION_JSON)
	public TVStorage mergeStorageItem(@PathParam("storageId") String storageId,
			  					  @PathParam("id") int id,
								  @PathParam("brand") String brand,
								  @PathParam("diagonal") int diagonal,
								  @PathParam("matrixType") MatrixType matrixType,
								  @PathParam("dateMade") String dateMade,
								  @PathParam("description") String description) throws Exception {
		
		StorageType storageType = StorageType.valueOf(storageId);
		TVStorage storage = storageFactory.getManageService().getStorage(storageType);
		if (storage != null) {
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
			
			TV item = new TV.Builder()
			                .id(id)
							.brand(brand)
							.diagonal(diagonal)
							.matrixType(matrixType)
							.dateMade(dateFormat.parse(dateMade))
							.description(description)
							.build();
			storage.setItem(item);
			storage.saveLastLoaded();
		}
		
		return storage;
	}
	
	@DELETE @Path("/{storageid}/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public TVStorage deleteStorageItem(@PathParam("storageid") String storageId, 
			                     @PathParam("id") int id) throws Exception {
		StorageType storageType = StorageType.valueOf(storageId);
		TVStorage storage = storageFactory.getManageService().getStorage(storageType);
		if (storage != null) {
			storage.deleteItem(id);
			storage.saveLastLoaded();
		}
		
		return storage;
	}
	
}
