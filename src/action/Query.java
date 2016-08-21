package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;
import dao.impl.ShowTableImpl;
import entity.Student;

public class Query implements Action {

	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		Student stu = new Student();
		if(!"".equals(request.getParameter("id"))){
			stu.setId(Integer.valueOf(request.getParameter("id")));
		}else{
			stu.setId(0);
		}
		stu.setName(request.getParameter("name"));
		stu.setClas(request.getParameter("clas"));
		stu.setAddr(request.getParameter("addr"));
		List list =  new ShowTableImpl().getQueryStuList(stu);
		request.getSession().setAttribute("stuListQ", list);
		int totalPage;
		if(list.size() % 10 == 0 ){
			totalPage = list.size() / 10;
		}else{
			totalPage = list.size() / 10 + 1;
		}
		
		if(list.size() >= 10){
			request.getSession().setAttribute("stuQueryList", list.subList(0, 10));
		}else{
			request.getSession().setAttribute("stuQueryList", list.subList(0, list.size()));
		}
		int page = 0;
		if(list.size() == 0){
		}else{
			page = 1;
		}
		request.getSession().setAttribute("first", "1");
		request.getSession().setAttribute("last", totalPage);
		request.getSession().setAttribute("page", page);
		request.getSession().setAttribute("total", list.size());
		return Action.SUCCESS;
	}

}
