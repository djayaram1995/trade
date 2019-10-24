package com.socket.trade.config;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

public class SocketTextHandler implements WebSocketHandler {

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		Timer j=new Timer("Hoja"); 
		TimerTask task= new TimerTask() {
			String changing = "0";
			
			@Override
			public void run() {
				try {
					System.out.println(changing);
					Integer b= Integer.parseInt(changing)+1;
					changing= b.toString();
					
					session.sendMessage(new TextMessage(b.toString()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		j.scheduleAtFixedRate(task, 1000, 1000);
		
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}

	

}
