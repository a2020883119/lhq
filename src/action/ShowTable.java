package action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import dao.impl.ShowTableImpl;

public class ShowTable implements Action {
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		ShowTableImpl std = new ShowTableImpl();
		@SuppressWarnings("rawtypes")
		List list = std.getStuList();
		int totalPage;
		if(list.size() % 10 == 0 ){
			totalPage = list.size() / 10;
		}else{
			totalPage = list.size() / 10 + 1;
		}
		int page = 1;
		if(list.size() >= 10){
			session.put("stuList", list.subList(0, 10));
		}else{
			session.put("stuList", list.subList(0, list.size()));
		}
		session.put("first", "1"); 
		session.put("last", totalPage);
		session.put("page", page);
		session.put("total", list.size());
		return Action.SUCCESS;
	}
	
}
