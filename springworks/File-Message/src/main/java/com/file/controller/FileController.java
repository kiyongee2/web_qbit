package com.file.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.file.model.Member;

@RequestMapping("/files")
@Controller
public class FileController {
	
	@GetMapping("/form")
	public String requestForm() {
		return "viewPage";
	}
	
	//Member DTO 사용
	@PostMapping("/form")
	public String submitForm(@ModelAttribute Member member, Model model) {
		String name = member.getName();
		MultipartFile file = member.getFileImage();
		
		String filename = file.getOriginalFilename();
		//File saveFile = new File("c:\\upload\\" + name + "_" + filename);
		String uuid = UUID.randomUUID().toString(); //같은 이름의 파일 업로드 덮어쓰기 방지
		
		File uploadDir = new File("c:\\upload");
		if (!uploadDir.exists()) uploadDir.mkdirs(); //폴더가 없으면 자동 생성
		
		File saveFile = new File(uploadDir, name + "_" + uuid + "_" + filename);
		
		try {
			file.transferTo(saveFile);
			model.addAttribute("data1", "MultipartHttpServletRequest 예제");
			model.addAttribute("data2", filename);
			model.addAttribute("data3", saveFile.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	//@RequestParam() 사용
	/*@PostMapping("/form")
	public String submitForm(@RequestParam("name") String name, 
			@RequestParam("fileImage") MultipartFile file, Model model) {
		
		String filename = file.getOriginalFilename();
		File saveFile = new File("c:\\upload\\" + name + "_" + filename);
		
		try {
			file.transferTo(saveFile);
			model.addAttribute("data1", "MultipartHttpServletRequest 예제");
			model.addAttribute("data2", filename);
			model.addAttribute("data3", saveFile.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "viewPage_process";
	}*/


    //MultipartHttpServletRequest 사용
	/*@PostMapping("/form")
	public String submitForm(MultipartHttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		MultipartFile file = request.getFile("fileImage");
		
		String filename = file.getOriginalFilename();
		File saveFile = new File("c:\\upload\\" + name + "_" + filename);
		
		try {
			file.transferTo(saveFile);
			model.addAttribute("data1", "MultipartHttpServletRequest 예제");
			model.addAttribute("data2", filename);
			model.addAttribute("data3", saveFile.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "viewPage_process";
	}*/
		
		return "viewPage_process";
	}
}
