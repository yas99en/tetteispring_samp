package mrs.domain.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import mrs.domain.model.User;

// 14.2.8.2. 認証ユーザー取得処理の実装 UserRepository.java
public interface UserRepository extends JpaRepository<User, String> {
}