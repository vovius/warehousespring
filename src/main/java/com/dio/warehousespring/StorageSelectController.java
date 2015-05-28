package com.dio.warehousespring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.dio.javamentoring.warehouse.StorageType;

public class StorageSelectController extends AbstractController {
	
	public StorageSelectController() {		
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		ModelAndView model = new ModelAndView("StorageSelect");
		
		/*ApplicationContext context = this.getApplicationContext();
		StorageWebState storageWebState = (StorageWebState)context.getBean("storageWebState");
		model.addObject("storageWebState", storageWebState);*/
		return model;
	}
		
}
