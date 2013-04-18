package com.dss.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.LookupDispatchAction;

public class OperationAction extends LookupDispatchAction{

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
	protected Map<String,String> getKeyMethodMap() {
		
		Map<String,String> m = new HashMap<String,String>();
		m.put("button.add", "add");
		m.put("button.sub", "sub");
		m.put("button.mul", "mul");
		return m;
	}

}
