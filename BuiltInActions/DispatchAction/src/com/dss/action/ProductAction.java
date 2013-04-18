package com.dss.action;

import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;

import com.dss.dao.ProductDAO;
import com.dss.dao.ProductDAOImpl;

public class ProductAction extends DispatchAction{
	ProductDAO p;
	ResultSet rs;
	public ProductAction() {
		p = new ProductDAOImpl();
	}
	
	public ActionForward add(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setAttribute("operation", "Product Insertion");	
		DynaActionForm daf = (DynaActionForm)form;
		String pid = daf.getString("pid");
		String pname = daf.getString("pname");
		String pcost = daf.getString("pcost");
		String status = p.add(pid,pname,pcost);
		request.setAttribute("operation", "Addition");
		return mapping.findForward(status);
	}
	
	public ActionForward search(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setAttribute("operation", "Product Search");
		String status = "";
		try{
			DynaActionForm daf = (DynaActionForm)form;
			String pid = daf.getString("pid");
			rs = p.search(pid);
			boolean b = rs.next();
			if (b == true) {
				request.setAttribute("pid", rs.getString(1));
				request.setAttribute("pname", rs.getString(2));
				request.setAttribute("pcost", rs.getString(3));
				status = "display";
			}
			else {
					status = "notexisted";
			}
		}
		catch (Exception e) {
				e.printStackTrace();	
		}
		return mapping.findForward(status);
	}

	public ActionForward delete(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		DynaActionForm daf = (DynaActionForm)form;
		String pid = daf.getString("pid");
		String status = p.delete(pid);
		request.setAttribute("operation", "Deletion");
		return mapping.findForward(status);
	}
}
