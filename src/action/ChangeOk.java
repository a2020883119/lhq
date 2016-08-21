package action;

import com.opensymphony.xwork2.Action;
import dao.impl.ShowTableImpl;
import entity.Student;

public class ChangeOk implements Action {
	private Student student;
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(new ShowTableImpl().updateData(student)){
			return Action.SUCCESS;
		}
		return Action.ERROR;
	}

}
