package com.dio.warehousespring;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.dio.javamentoring.warehouse.Bonus;
import com.dio.javamentoring.warehouse.TV;

public class BonusesUpdateTag extends SimpleTagSupport {
	
	private TV tvItem;
	private String bonusName;
	private String action;
	

	public TV getTvItem() {
		return tvItem;
	}



	public void setTvItem(TV tvItem) {
		this.tvItem = tvItem;
	}



	public String getBonusName() {
		return bonusName;
	}



	public void setBonusName(String bonusName) {
		this.bonusName = bonusName;
	}

	
	


	public String getAction() {
		return action;
	}



	public void setAction(String action) {
		this.action = action;
	}



	@Override
	public void doTag() throws JspException, IOException {
		Bonus bonus = tvItem.getBonusByName(bonusName);
		if ("remove".equals(action))
			tvItem.getBonuses().remove(bonus);
		else if ("add".equals(action))
			tvItem.getBonuses().add(new Bonus(bonusName));
	}
	
}
