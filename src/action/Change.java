package action;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

import dao.impl.ShowTableImpl;
import entity.Student;

public class Change implements Action {
	private Student stu;
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
	public String execute() throws Exception {
		stu = new Student();
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		int id = 0;
		if(!"".equals(request.getParameter("id")) && request.getParameter("id") != null){
			id = Integer.parseInt(request.getParameter("id"));
		}
		if(new ShowTableImpl().exists(id)){
			stu.setId(id);
			List list = new ShowTableImpl().getQueryStuList(stu);
			if(!list.isEmpty()){
				Iterator it = list.iterator();
				while(it.hasNext()){
					stu = (Student)it.next();
					return Action.SUCCESS;
				}
			}
		}
		return Action.ERROR;
	}

}
