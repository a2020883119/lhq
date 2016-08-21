package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;
import dao.impl.ShowTableImpl;
import entity.Student;

public class Insert implements Action {
	private Student student;
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Student stu = new Student();
		stu.setName(request.getParameter("name"));
		stu.setClas(request.getParameter("clas"));
		stu.setAddr(request.getParameter("addr"));
		if(new ShowTableImpl().insertData(stu)){ 
			return Action.SUCCESS;
		}else{
			return Action.ERROR;
		}
	}

}
