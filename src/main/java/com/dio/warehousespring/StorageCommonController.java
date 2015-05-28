package com.dio.warehousespring;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class StorageCommonController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse responce) throws Exception {
		String dispatcherPath = request.getRequestURI();
		
		// parse to determine the appropriate View
		int point = dispatcherPath.lastIndexOf('.');
		int slash = dispatcherPath.lastIndexOf('/');
		String viewName = "";
		if (point > slash) {
			viewName = dispatcherPath.substring(slash+1, point);
		}
		
		ModelAndView model = null;
		if (StringUtils.isNotEmpty(viewName))
			model = new ModelAndView(viewName);
		return model;
	}

}
