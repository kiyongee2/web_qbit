package com.file.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.file.model.FileEntity;
import com.file.model.MemberDTO;
import com.file.repository.FileRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FileService {
	
	private final FileRepository fileRepo;

	public void saveFile(MemberDTO member, Model model) throws IOException {
		String name = member.getName();  
		MultipartFile file = member.getFileImage(); 
		
		String originalFilename = file.getOriginalFilename(); 
		String uuid = UUID.randomUUID().toString(); 
		String storedFilename = name + "_" + uuid + originalFilename;
		
		//폴더가 없으면 자동 생성
		File uploadDir = new File("c:/upload");
		if (!uploadDir.exists()) uploadDir.mkdirs(); 
		
		File saveFile = new File(uploadDir, storedFilename);
		file.transferTo(saveFile); //업로드 폴더에 저장
		
		//DB에 저장
		FileEntity entity = FileEntity.builder()
				.uploderName(name)
				.originalFilename(originalFilename)
				.storedFilename(storedFilename)
				.uploadTime(LocalDateTime.now())
				.build();
		
		fileRepo.save(entity);		
		
		model.addAttribute("data1", "파일 업로드 예제");
		model.addAttribute("data2", originalFilename);
		model.addAttribute("data3", saveFile.getName());
	}
}



