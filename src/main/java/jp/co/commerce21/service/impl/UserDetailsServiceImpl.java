package jp.co.commerce21.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import jp.co.commerce21.dao.UserDao;
import jp.co.commerce21.entity.User;
import jp.co.commerce21.entity.UserAccount;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;

//	@Autowired
//	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// usernameの値チェック
		if (StringUtils.isEmpty(username)) {
			throw new UsernameNotFoundException("Username is empty");
		}

		// usernameの取得
		User user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found: " + username);
		}

		if (!user.isEnabled()) {
			throw new UsernameNotFoundException("User not enabled: " + username);
		}

		// ユーザー情報を生成
		UserAccount userAccount = new UserAccount(user, getAuthorities(user));
		return userAccount;
	}

	private Collection<GrantedAuthority> getAuthorities(User user) {
		if (user.isAdmin()) {
			return AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER");
		} else {
			return AuthorityUtils.createAuthorityList("ROLE_USER");
		}
	}

//	@Transactional
//    public void registerAdmin(String username, String password) {
//        User user = new User(username, passwordEncoder.encode(password), true);
//        userDao.save(user);
//    }
//
//    @Transactional
//    public void registerUser(String username, String password) {
//        User user = new User(username, passwordEncoder.encode(password), false);
//        userDao.save(user);
//    }

}
