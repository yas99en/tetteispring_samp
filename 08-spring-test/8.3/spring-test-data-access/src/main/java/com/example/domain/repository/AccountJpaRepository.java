package com.example.domain.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.model.Account;

@Profile("jpa") // JPA使用時のRepository定義
@Repository
public class AccountJpaRepository {

	@PersistenceContext
	EntityManager entityManager;

	// 新しいアカウントを作成する
	@Transactional
	public void create(Account account) {
		entityManager.persist(account);
	}
	
}
