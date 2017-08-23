package ggd.core.dispatcher;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import ggd.core.CoreException;

public interface Dispatcher {
	
	public void handler(ModelAndView view, HttpServletRequest request) throws CoreException;
	
}
