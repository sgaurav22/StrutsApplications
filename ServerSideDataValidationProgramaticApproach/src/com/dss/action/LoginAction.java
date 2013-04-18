package com.dss.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.dss.form.LoginActionForm;

public class LoginAction extends Action{
	
	public ActionForward execute(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)throws Exception {
		LoginActionForm laf = (LoginActionForm)form;
		String uname = laf.getUname();
		String upwd = laf.getUpwd();
		
		if (uname.equals(upwd)) {
			
			return mapping.findForward("success");
		} else {
			return mapping.findForward("failure");
		}
	}
}
