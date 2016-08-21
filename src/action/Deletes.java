package action;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;
import dao.impl.ShowTableImpl;

public class Deletes implements Action {
	private String [] nums;
	public String [] getNums() {
		return nums;
	}
	public void setNums(String[] nums) {
		this.nums = nums;
	}
	public String execute() throws Exception {
		ShowTableImpl dle = new ShowTableImpl();
		int num = -1;
		if(nums != null){
			for(String str : this.getNums()){
				try {
					num = Integer.valueOf(str);
					dle.deleteData(num);
				} catch (Exception e) {
					// TODO: handle exception
					return Action.ERROR;
				}
			}
			return Action.SUCCESS;
		}
		return Action.ERROR;
	}

}
