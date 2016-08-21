package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

public class QueryPage implements Action {

	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		List list = (List) request.getSession().getAttribute("stuListQ");
		int totalPage;
		if(list.size() % 10 == 0 ){
			totalPage = list.size() / 10;
		}else{
			totalPage = list.size() / 10 + 1;
		}
		int page = Integer.valueOf(request.getParameter("p"));
		request.getSession().setAttribute("first", "1");
		request.getSession().setAttribute("last", totalPage);
		switch (Integer.valueOf(request.getParameter("n"))) {
			case 1:
				if(page != 1){
					request.getSession().setAttribute("page", page - 1);
					page--;
				}else{
					request.getSession().setAttribute("page", page);
				}
				if(list.size() >= 10){
					request.getSession().setAttribute("stuQueryList", list.subList(page * 10 - 10, page * 10));
				}else{
					request.getSession().setAttribute("stuQueryList", list.subList(0, list.size())); 
				}
				return Action.SUCCESS;
			case 2:
				if(page != totalPage){
					request.getSession().setAttribute("page", page + 1);
					page++;
					request.getSession().setAttribute("page", page);
					if(page * 10 == list.size()){
						request.getSession().setAttribute("stuQueryList", list.subList(page * 10 - 10, page * 10)); 
					}else{
						if(page == totalPage){
							request.getSession().setAttribute("stuQueryList", list.subList(page * 10 - 10, list.size()));
						}else{
							request.getSession().setAttribute("stuQueryList", list.subList(page * 10 - 10, page * 10)); 
						}
					}
				}
				return Action.SUCCESS;
			case 3:
				request.getSession().setAttribute("page", totalPage);
				request.getSession().setAttribute("stuQueryList", list.subList(totalPage * 10 - 10, list.size()));
				return Action.SUCCESS;
			case 0:
				request.getSession().setAttribute("page", 1);
				request.getSession().setAttribute("stuQueryList", list.subList(0, 10));
				return Action.SUCCESS;
		}
		
		return null;
	}

}
