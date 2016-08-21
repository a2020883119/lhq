package action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;
import com.sun.java_cup.internal.action_part;

import dao.impl.ShowTableImpl;

public class Delete implements Action {

	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(new ShowTableImpl().deleteData(Integer.valueOf(request.getParameter("id"))))
		{
			return Action.SUCCESS;
		}else{
			return Action.ERROR;
		}
	}

}
