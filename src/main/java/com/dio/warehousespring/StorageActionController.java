package com.dio.warehousespring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class StorageActionController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse responce) throws Exception {
		
		ModelAndView model = new ModelAndView("StorageAction");
		/*ApplicationContext context = this.getApplicationContext();
		StorageWebState storageWebState = (StorageWebState)context.getBean("storageWebState");
		model.addObject("storageWebState", storageWebState);*/
		
		return model;
	}

}
