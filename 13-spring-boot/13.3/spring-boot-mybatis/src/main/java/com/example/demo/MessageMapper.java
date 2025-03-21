package com.example.demo;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;

// 13.3.3. MyBatis Mapperインターフェイスの作成例
@Mapper
public interface MessageMapper {
	@Select("SELECT text FROM messages ORDER BY id")
	List<Message> findAll();

	@Insert("INSERT INTO messages(text) VALUES(#{text})")
	int create(Message message);
}