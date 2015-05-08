package com.dio.warehousespring;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dio.javamentoring.warehouse.StorageType;



public class StorageCommonFilter implements Filter {
	
	private ApplicationContext context;
	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		
		StorageWebState storageWebState = (StorageWebState) context.getBean("state");
		request.setAttribute("storageWebState", storageWebState);
		
		filterChain.doFilter(request, response);
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		context = new ClassPathXmlApplicationContext("application-context.xml");
		StorageWebState storageWebState = (StorageWebState) context.getBean("state");
		storageWebState.setStorageSelected(StorageType.TXT.name());
	}

}
