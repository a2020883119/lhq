package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;
import dao.impl.ShowTableImpl;
import entity.Student;

public class InsertOne implements Action {

	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Student stu = new Student();
		stu.setName("测试数据");
		stu.setClas("测试数据");
		stu.setAddr("测试数据");
		new ShowTableImpl().insertData(stu);
		return Action.SUCCESS;
	}

}
