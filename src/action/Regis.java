package action;

import java.io.PrintWriter;
import java.util.Date;
import com.opensymphony.xwork2.Action;
import dao.impl.ShowTableImpl;
import entity.RegisUser;

public class Regis implements Action {
	private RegisUser regisUser;
	
	public RegisUser getRegisUser() {
		return regisUser;
	}

	public void setRegisUser(RegisUser regisUser) {
		this.regisUser = regisUser;
	}

	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String username = regisUser.getUsername();
		String password1 = regisUser.getPassword1();
		String password2 = regisUser.getPassword2();
		if(!"".equals(password1) && password1 != null && !"".equals(username) && username != null ){
			if(password1.equals(password2)){
				if(!new ShowTableImpl().usernameExists(username)){
					new ShowTableImpl().insertUser(username, password1);
					return Action.SUCCESS;
				}
			}
		}
		return Action.ERROR;
	}

}
