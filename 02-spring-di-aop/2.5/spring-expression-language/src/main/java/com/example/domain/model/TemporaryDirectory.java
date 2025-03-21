package com.example.domain.model;

import java.io.File;
import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Component;

@Component
public class TemporaryDirectory implements Serializable {

	private static final long serialVersionUID = 1L;

	private final File directory;
	
	// 2.5.3. Bean定義でのSpELの利用 コンストラクタの実装例、アノテーションでの使用例
	@Autowired
	public TemporaryDirectory(@Value("file://#{systemProperties['java.io.tmpdir']}/app") File baseDirectory,
							@Value("#{T(java.util.UUID).randomUUID().toString()}") String id) { 
		this.directory = new File(baseDirectory, id);
	}
	
	public File getDirectory() {
		return directory;
	}
		
}
