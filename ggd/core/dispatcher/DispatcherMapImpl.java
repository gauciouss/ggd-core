package ggd.core.dispatcher;

import java.util.HashMap;
import java.util.Map;

public class DispatcherMapImpl implements DispatcherMap {
	
	private static final Map<String, Dispatcher> map = new HashMap<String, Dispatcher>();
	
	public void addDispatcher(String action, Dispatcher bean){
		map.put(action, bean);
	}
	
	/* (non-Javadoc)
	 * @see masterlink.rh.dispatcher.DispatcherMap#find(java.lang.String)
	 */
	@Override
	public Dispatcher find(String action){
		return map.get(action);
	}
	
}
