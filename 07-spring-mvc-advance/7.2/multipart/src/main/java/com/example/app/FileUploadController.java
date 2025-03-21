package com.example.app;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/file/upload")
@Controller
public class FileUploadController {
	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);

	// お使いの環境に併せて適宜アップロード先を変更ししてください
	private static final String UPLOAD_PATH = "\\upload_test\\";

	@GetMapping
	public String form(Model model) {
		FileUploadForm form = new FileUploadForm();
		model.addAttribute(form);
		return "form";
	}

	// 当サンプルでは便宜上、RedirectAttributesを使用しております
	@PostMapping
	public String upload(FileUploadForm form, RedirectAttributes redirectAttributes) {

		MultipartFile file = form.getFile();

		String contentType = file.getContentType();
		String parameterName = file.getName();
		String originalFilename = file.getOriginalFilename();
		long fileSize = file.getSize();

		try (InputStream content = file.getInputStream()) {
			// アップロードデータの永続化処理
			String uploadFile = UPLOAD_PATH + originalFilename;
			try (OutputStream output = new FileOutputStream(uploadFile)) {
				int c;
				while ((c = content.read()) != -1)
					output.write(c);
				output.flush();
			}
			redirectAttributes.addFlashAttribute("contentType", contentType);
			redirectAttributes.addFlashAttribute("parameterName", parameterName);
			redirectAttributes.addFlashAttribute("originalFilename", originalFilename);
			redirectAttributes.addFlashAttribute("fileSize", fileSize);
			redirectAttributes.addFlashAttribute("uploadFile", uploadFile);
		} catch (IOException e) {
			logger.error(e.toString());
		}
		return "redirect:/file/upload?complete";
	}

	@GetMapping(params = "complete")
	public String complete() {
		return "complete";
	}
}
