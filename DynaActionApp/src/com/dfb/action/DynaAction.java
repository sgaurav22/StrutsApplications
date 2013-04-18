package com.dfb.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

public class DynaAction extends Action{
	
	public ActionForward execute(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response){
		DynaActionForm daf =(DynaActionForm)form;
		String name = (String)daf.get("name");
		String email = (String)daf.get("email");
		int age = (Integer)daf.get("age");
		String addr = (String)daf.get("address");
		request.setAttribute("name", name);
		request.setAttribute("email", email);
		request.setAttribute("age", age);
		request.setAttribute("address", addr);
		
		return mapping.findForward("success");
	}

}
