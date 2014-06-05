package fmat.proyectoMemo.servlets.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fmat.proyectoMemo.struts.model.Usuario;

/**
 * Servlet Filter implementation class UsuarioFilter
 */
@WebFilter(urlPatterns = {"/addEvent","/showInfo"})
public class UsuarioFilter implements Filter {

    /**
     * Default constructor. 
     */
    public UsuarioFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		Usuario usuario = (Usuario) ((HttpServletRequest)request).getSession().getAttribute("usuario");
		int id = usuario.getIdUsuario();
		System.out.println("ID"+id);
		if(usuario!=null && id!=0){
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}else{
			if(id == 0){
			((HttpServletResponse) response).sendRedirect("/portalsesion.jsp");
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
