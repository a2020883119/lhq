package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;
import dao.impl.ShowTableImpl;

public class UsernameExist implements Action {

	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;utf-8");
//		response.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		PrintWriter out = response.getWriter();
		if(new ShowTableImpl().usernameExists(username)){
			out.print("username already exist");
		}
		return null;
	}

}
