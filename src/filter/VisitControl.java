package filter;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.crypto.spec.IvParameterSpec;
import javax.interceptor.InvocationContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class VisitControl implements Interceptor {

	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("拦截器关闭");
	}

	public void init() {
		// TODO Auto-generated method stub
		System.out.println("拦截器开启");
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("\r拦截开始:" + sdf.format(new Date()));
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
//		System.out.println(req.getContextPath());///web
//		System.out.println(req.getRequestURI());///web/login.jsp
		if("/login.action".equals(req.getServletPath()) || "/regis.action".equals(req.getServletPath())){
				System.out.println("拦截无效:" + req.getServletPath());
				return invocation.invoke();
		}
		if("/regis.jsp".equals(req.getServletPath()) || "/login.jsp".equals(req.getServletPath()) || "/js/js.js".equals(req.getServletPath()) || "/usernameExist.action".equals(req.getServletPath())){
			System.out.println("拦截无效:" + req.getServletPath());
			return invocation.invoke();
		}
		System.out.println("当前用户:" + req.getSession().getAttribute("username")); 
		if(req.getSession().getAttribute("username") != null){
			req.getSession().getAttribute("username").toString(); 
			System.out.println("拦截无效:" + req.getServletPath());
			return invocation.invoke();
		}else{
			// TODO: handle exception
			System.out.println("拦截成功: " + req.getServletPath());
			return Action.ERROR;
		}
	}

}
