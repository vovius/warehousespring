package com.dio.warehousespring;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class StorageItemMaintainFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {

		String obj = request.getParameter("editId");
		int id = obj != null ? Integer.valueOf(obj).intValue() : 0;
		StorageWebState storageWebState = (StorageWebState)request.getAttribute("storageWebState");
		request.setAttribute("item", storageWebState.getCurrentStorage().getItemById(id));
		
		filterChain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		

	}

}
