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

import com.file.model.FileEntity;
import com.file.model.MemberDTO;
import com.file.service.FileService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@RequestMapping("/ex01")
@Controller
public class FileController {
	
	private FileService service;
	
	@GetMapping("/form")
	public String requestForm() {
		return "viewPage";
	}
	
	@PostMapping("/form")
	public String submitForm(@ModelAttribute MemberDTO member, 
			Model model) {
		try {
			service.saveFile(member, model);
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("data1", e.getMessage()); 
		}
		return "viewPage_result";	
	}
	
	/*@PostMapping("/form")
	public String submitForm(@ModelAttribute MemberDTO member, 
			Model model) {
		String name = member.getName();  //이름
		MultipartFile file = member.getFileImage(); //파일
		
		String filename = file.getOriginalFilename();
		//같은 이름의 파일 업로드 덮어쓰기 방지
		String uuid = UUID.randomUUID().toString(); 
		
		File uploadDir = new File("c:/upload");
		if (!uploadDir.exists()) uploadDir.mkdirs(); //폴더가 없으면 자동 생성
		
		File saveFile = new File(uploadDir, name + "_" + uuid + "_" + filename);
		
		try {
			file.transferTo(saveFile);
			model.addAttribute("data1", "파일 업로드 예제");
			model.addAttribute("data2", filename);
			model.addAttribute("data3", saveFile.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "viewPage_result";	
	}*/
}
