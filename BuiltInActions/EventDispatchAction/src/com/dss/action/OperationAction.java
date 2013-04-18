package com.dss.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.EventDispatchAction;

public class OperationAction extends EventDispatchAction{

	public ActionForward add(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		DynaActionForm daf = (DynaActionForm)form;
		int val1 = (Integer)daf.get("op1");
		int val2 = (Integer)daf.get("op2");
		request.setAttribute("operation", "Addition");
		request.setAttribute("result", (val1+val2));
		return mapping.findForward("result");
	}
	
	public ActionForward sub(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		DynaActionForm daf = (DynaActionForm)form;
		int val1 = (Integer)daf.get("op1");
		int val2 = (Integer)daf.get("op2");
		request.setAttribute("operation", "Subtration");
		request.setAttribute("result", (val1-val2));
		return mapping.findForward("result");
	}
	
	public ActionForward mul(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		DynaActionForm daf = (DynaActionForm)form;
		int val1 = (Integer)daf.get("op1");
		int val2 = (Integer)daf.get("op2");
		request.setAttribute("operation", "Multiply");
		request.setAttribute("result", (val1*val2));
		return mapping.findForward("result");
	}
}
