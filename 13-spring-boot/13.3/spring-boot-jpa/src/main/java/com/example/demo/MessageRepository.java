package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

// 13.3.2. Spring Data JPA Repositoryインターフェイスの作成例
public interface MessageRepository extends JpaRepository<Message, Integer> {
}