package com.example.demo.controller;

import com.example.demo.qrCode.QRCodeGenerator;
import com.google.zxing.WriterException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Base64;

@Controller
public class QRController {

	private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/static/img/QRCode.png";

	@GetMapping("/qrcode")
	public String getQRCode(Model model) {
		String medium = "https://rahul26021999.medium.com/";
		String github = "http:/localhost:8080//api/employees";

		byte[] image = new byte[0];
		try {

			image = QRCodeGenerator.getQRCodeImage(medium, 250, 250);

			QRCodeGenerator.generateQRCodeImage(github, 250, 250, QR_CODE_IMAGE_PATH);

		} catch (WriterException | IOException e) {
			e.printStackTrace();
		}

		String qrcode = Base64.getEncoder().encodeToString(image);

		model.addAttribute("medium", medium);
		model.addAttribute("github", github);
		model.addAttribute("qrcode", qrcode);

		return "qrcode";
	}
}