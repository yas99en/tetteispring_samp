package com.example.app.api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

// 6.5.1 エラーの情報を保持するクラスの実装例
public class ApiError implements Serializable {
	private static final long serialVersionUID = 1L;
	private String message;

	// 6.5.4 エラーの詳細情報を保持するクラスの実装例
	private static class Detail implements Serializable {
		private static final long serialVersionUID = 1L;
		private final String target;
		private final String message;

		private Detail(String target, String message) {
			this.target = target;
			this.message = message;
		}

		public String getTarget() {
			return target;
		}

		public String getMessage() {
			return message;
		}
	}

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private final List<Detail> details = new ArrayList<>();

	@JsonProperty("documentation_url")
	private String documentationUrl;

	public String getMessage() {
		return message;
	}

	public void setMessage(String massage) {
		this.message = massage;
	}

	public String getDocumentationUrl() {
		return documentationUrl;
	}

	public void setDocumentationUrl(String documentationUrl) {
		this.documentationUrl = documentationUrl;
	}

	public void addDetail(String target, String message) {
		details.add(new Detail(target, message));
	}

	public List<Detail> getDetails() {
		return details;
	}

}