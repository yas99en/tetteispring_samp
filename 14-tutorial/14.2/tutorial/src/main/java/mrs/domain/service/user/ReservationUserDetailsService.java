package mrs.domain.service.user;

import mrs.domain.model.User;
import mrs.domain.repository.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// 14.2.8.2. 認証ユーザー取得処理の実装 ReservationUserDetailsService.java
@Service
public class ReservationUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException(username + " is not found."));
		return new ReservationUserDetails(user);
	}
	
}