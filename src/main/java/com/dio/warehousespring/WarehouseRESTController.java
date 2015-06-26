package com.dio.warehousespring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.dio.javamentoring.warehouse.StorageType;
import com.dio.javamentoring.warehouse.TVStorage;

@Controller
public class WarehouseRESTController {
	
	private WarehouseSpring warehouseSpring;
	private Jaxb2Marshaller jaxb2Mashaller;
	
	public void setWarehouseSpring(WarehouseSpring warehouseSpring) {
		this.warehouseSpring = warehouseSpring;
	}
	
	public void setJaxb2Mashaller(Jaxb2Marshaller jaxb2Mashaller) {
		this.jaxb2Mashaller = jaxb2Mashaller;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/storage/{id}")
	public ModelAndView getStorageById(@PathVariable String id) throws Exception {
		ModelAndView mav = null;
		try {
			StorageType storageType = StorageType.valueOf(id.toUpperCase());
			if (storageType != null) {
				TVStorage storage = warehouseSpring.getStorage(storageType);
				mav = new ModelAndView("storage", "object", storage);
			}
		} finally {}
		return mav;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/storages", produces="application/json")
	@ResponseBody
	public String getStorages() throws Exception {
		List<StorageType> list = new ArrayList<StorageType>(Arrays.asList(StorageType.values()));
		return list.toString();
	}
	
	/*@RequestMapping(method=RequestMethod.GET, value="/warehouserest/*")
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse responce) throws Exception {
		StorageType storageType = StorageType.HIBERNATE;
		return new ModelAndView("storages", "object", storageType);
	}*/
}
