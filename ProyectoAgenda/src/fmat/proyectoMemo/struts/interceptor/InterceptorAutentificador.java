package fmat.proyectoMemo.struts.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import fmat.proyectoMemo.struts.model.Usuario;

public class InterceptorAutentificador implements Interceptor{
	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub

		Map<String, Object> session = invocation.getInvocationContext().getSession();

		Usuario usuario = (Usuario)session.get("usuario");

		if(usuario == null){
			return Action.INPUT;
		}else{
			return invocation.invoke();
		}
	}
}
