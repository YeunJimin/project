package hex.main.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.controller.CommandHandler;

public class MainHandler implements CommandHandler {

	
	
	  private static final String FORM_VIEW = "/WEB_INF/view/main"; //메인폼 경로

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		return "/WEB-INF/view/ApplyMain.jsp";
	}

	
}
