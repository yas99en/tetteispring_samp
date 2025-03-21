package com.example;

// 7.4.4. HandlerMethodArgumentResolverの利用
public class CommonRequestData {
	private String userAgent;
	private String sessionId;

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
}
