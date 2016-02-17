package org.barracuda.core.game.v317.login;

import org.barracuda.core.net.event.JagGrabFileRequest;
import org.barracuda.core.net.interceptor.Interceptor;
import org.barracuda.core.net.message.Message;
import org.barracuda.horvik.bean.Discoverable;
import org.barracuda.horvik.context.request.RequestScoped;
import org.barracuda.horvik.event.Observes;

@RequestScoped
@Discoverable
public class JagGrabInterceptor implements Interceptor<Message, JagGrabFileRequest> {

	@Override
	public JagGrabFileRequest intercept(Message input) {
		return null;
	}
	
	/**
	 * Called when the file request has been passed through to the channel
	 * 
	 * @param request
	 */
	public void on_request(@Observes JagGrabFileRequest request) {
		
	}

}