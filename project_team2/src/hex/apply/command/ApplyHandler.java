package hex.apply.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import hex.apply.service.ApplyService;
import mvc.controller.CommandHandler;

public class ApplyHandler implements CommandHandler {
	
	
	private static final String FORM_VIEW = "/WEB-INF/view/ApplyMain.jsp";
	private ApplyService applyService = new ApplyService();
	

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
	if(req.getMethod().equalsIgnoreCase("GET")) {
		return processForm(req,res);
	}else if(req.getMethod().equalsIgnoreCase("POST")) {
		return processSubmit(req,res);
		
	}else {
		res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		return null;
	}
	}
	
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res)
	throws Exception{
		String trans_num = trim(req.getParameter("trans_num"));
		String item = trim(req.getParameter("item"));
		String change_num = trim(req.getParameter("change_num"));
		String t_date = trim(req.getParameter("t_date"));

		Map<String,Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		if(id==null || id.isEmpty())
			errors.put("id", Boolean.TRUE);
		if(password==null || password.isEmpty())
			errors.put("password", Boolean.TRUE);
		
		if(!errors.isEmpty()) {
			return FORM_VIEW;
			
		}
		try {
			Goods goods = applyService.(id, password);
			req.getSession().setAttribute("authUser", user);
			res.sendRedirect(req.getContextPath()+"/index.jsp");
			return null;
		}catch(InputFailException e) {
			errors.put("idOrPwNotMatch", Boolean.TRUE);
			return FORM_VIEW;
			
		}

	}
	
	private String trim(String str) {
		return  str == null?null:str.trim();
		
	}

}
