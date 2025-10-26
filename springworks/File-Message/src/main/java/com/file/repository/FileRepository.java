package com.file.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.file.model.FileEntity;

public interface FileRepository extends JpaRepository<FileEntity, Long>{

}
