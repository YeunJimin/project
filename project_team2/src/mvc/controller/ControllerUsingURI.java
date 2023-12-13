package mvc.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerUsingURI extends HttpServlet {

	// <커맨드, 핸들러인스턴스> 매핑 정보 저장
	private Map<String, CommandHandler> commandHandlerMap = new HashMap<>();

	public void init() throws ServletException {
		String configFile = getInitParameter("configFile");
		Properties prop = new Properties();
		String configFilePath = getServletContext().getRealPath(configFile);

		try (FileInputStream fis = new FileInputStream(configFilePath)) {
			prop.load(fis);
		} catch (IOException e) {
			throw new ServletException(e);
		}
		// 설정파일로부터 매핑 정보를 읽어와 Properties 객체에 저장

		Iterator keyIter = prop.keySet().iterator();
		while (keyIter.hasNext()) {

			String command = (String) keyIter.next();
			/* 1. 프로퍼티 이름을 커맨드 이름으로 사용 */
			String handlerClassName = prop.getProperty(command);
			/* 2. 커맨드 이름에 해당하는 핸들러 클래스 이름을 Properties에서 구한다 */
			try {
				Class<?> handlerClass = Class.forName(handlerClassName);
				/* 3. 핸들러 클래스 이름을 이용해서 Class객체를 구한다. */
				CommandHandler handlerInstance = (CommandHandler) handlerClass.newInstance();
				/* 4. Class로부터 핸들러 객체를 생성한다. 즉, 2번 과정에서 구한 이름에 해당하는 클래스의 객체를 생성한다. */
				commandHandlerMap.put(command, handlerInstance);
				/* 5. commandHandlerMap에 (커맨드,핸들러 객체) 매핑 정보를 저장한다. */

			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				throw new ServletException(e);
			}
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getRequestURI();
		// URI를 사용하기 위한 메서드 웹 어플리케이션 경로를 제외한 나머지 URI만을 명령어로 사용
		if (command.indexOf(request.getContextPath()) == 0) {
			command = command.substring(request.getContextPath().length());
		}

		CommandHandler handler = commandHandlerMap.get(command);

		if (handler == null) {
			handler = new NullHandler();
		}
		String viewPage = null;
		try {
			viewPage = handler.process(request, response);
			/* 구한 핸들러 객체의 process()메서드를 호출해서 요청을 처리하고, 결과로 보여 줄 뷰 페이지 경로를 리턴값으로 전달받음 */
		} catch (Exception e) {
			throw new ServletException(e);
		}
		if (viewPage != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			/* viewPage가 null이 아닐 경우, 핸들러 인스턴스가 리턴한 뷰 페이지로 이동. */
			dispatcher.forward(request, response);
		}
	}
}