package com.dio.warehousespring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller
public class StorageCommonController extends AbstractController {

	@Override
	@RequestMapping(value="/Storage*")
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
