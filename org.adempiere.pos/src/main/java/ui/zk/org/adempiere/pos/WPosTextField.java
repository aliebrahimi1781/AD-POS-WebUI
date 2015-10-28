/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * Copyright (C) 2003-2014 E.R.P. Consultores y Asociados, C.A.               *
 * All Rights Reserved.                                                       *
 * Contributor(s): Raul Muñoz www.erpcya.com					              *
 *****************************************************************************/

package org.adempiere.pos;

import org.adempiere.webui.apps.AEnv;
import org.adempiere.webui.component.Textbox;
import org.zkoss.zhtml.Table;
import org.zkoss.zhtml.Td;
import org.zkoss.zhtml.Tr;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Div;

/**
 * 
 * @author Raul Muñoz 20/03/2015 
 */
public class WPosTextField extends Div {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2453719110038264481L;
	int keyLayoutId = 0;
	
	private Textbox			f_HiddenField;
	private Textbox			f_TextField;
	private	String 			m_FontSize;
	private	String			m_FontStyle;
	public  static final String PRIMARY = "P";
	public  static final String SECONDARY = "S";
	private Table grid;
	
	
	public int getKeyLayoutId() {
		return keyLayoutId;
	}

	
	public WPosTextField(final int posKeyLayout_ID) {
		super();
		
		keyLayoutId = posKeyLayout_ID;
		f_HiddenField = new Textbox();
		f_HiddenField.setStyle("position:relative; left:-100%; margin-top:-20px; width:100%; height:100%; opacity:0.0");
		f_TextField = new Textbox();
		f_TextField.setHeight("23px");
		f_TextField.setStyle("Font-size:medium; font-weight:bold");
		
		grid = new Table();
		appendChild(grid);
		this.setWidth("100%");
		grid.setStyle("border: none; padding: 0px; margin: 0px;");
		grid.setDynamicProperty("width", "100%");
		grid.setDynamicProperty("border", "0");
		grid.setDynamicProperty("cellpadding", "0");
		grid.setDynamicProperty("cellspacing", "0");

		Tr tr = new Tr();
		grid.appendChild(tr);
		tr.setStyle("width: 100%; border: none; padding: 0px; margin: 0px; white-space:nowrap; ");

		Td td = new Td();
		tr.appendChild(td);
		td.setStyle("border: none; padding: 0px; margin: 0px;");
		
		td.appendChild(f_TextField);
		td.appendChild(f_HiddenField);
		
//		Td btnColumn = new Td();
//		tr.appendChild(btnColumn);
//		btnColumn.setStyle("border: none; padding: 0px; margin: 0px;");
//		f_HiddenField.setTabindex(-1);
////		btnColumn.appendChild(f_HiddenField);

		String style = AEnv.isFirefox2() ? "display: inline"
				: "display: inline-block";
		style = style
				+ ";border: none; padding: 0px; margin: 0px; background-color: transparent;";
		this.setStyle(style);
	}

	public String getFontSize() {
		return m_FontSize;
	}

	public void setFontSize(String p_FontSize) {
		this.m_FontSize = p_FontSize;
	}

	public String getFontStyle() {
		return m_FontStyle;
	}

	public void setFontStyle(String p_FontStyle) {
		this.m_FontStyle = p_FontStyle;
	}
	
	
	public void setWidth(String width){
		f_TextField.setWidth(width);
		grid.setDynamicProperty("width", width);
	}
	
	
	public void setHeight(String height){
		f_TextField.setHeight(height);
		
	}
	
	public void setStyle(String style) {
		f_TextField.setStyle(style);
	}
	
	@Override
	public boolean addEventListener(String Event, EventListener listener)
	{
		addEventListener(listener);
	    return true;
	}
	
	public void addEventListener(EventListener listener)
	{

		f_TextField.addEventListener(Events.ON_FOCUS, listener);
		f_HiddenField.addEventListener(Events.ON_FOCUS, listener);
	     
	}
	
	public void setValue(String value) {
		f_TextField.setValue(value);
	}

	public String getValue() {
		return f_TextField.getValue();
	}
	
	public void setText(String value) {
		if(value != null)
			f_TextField.setValue(value);
		else
			f_TextField.setValue("");
	}
	
	public String getText() {
			return f_TextField.getValue();
	}
	
	public void setReadonly(Boolean readOnly) {
		f_TextField.setReadonly(readOnly);
		f_HiddenField.setReadonly(readOnly);
	}
	
	public Textbox getComponent(String comp) {
		if(comp.equals(PRIMARY)) {
			return f_TextField;
		} else if(comp.equals(SECONDARY)){
			return f_HiddenField;
		}
		return null;
	}
	
	@Override
	public void setFocus(boolean focus){
		f_TextField.setFocus(focus);
	}
			
}
