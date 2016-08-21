package action;

import java.util.Map;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import dao.impl.ShowTableImpl;
import entity.LoginUser;

public class Login implements Action {
	private LoginUser loginUser;
	
	public LoginUser getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(LoginUser loginUser) {
		this.loginUser = loginUser;
	}
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String username = loginUser.getUsername();
		String password = loginUser.getPassword();
		ActionContext context = ActionContext.getContext();
		Map session = context.getSession();
		if(!"".equals(password) && password != null && !"".equals(username) && username != null ){
			try {
				if(new ShowTableImpl().login(username, password)){
					session.put("username", username);
					return Action.SUCCESS; 
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return Action.ERROR;
	}

}
