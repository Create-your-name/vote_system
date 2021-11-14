package sx_vote.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import sx_vote.dao.pojo.CustomUserDetails;
import sx_vote.dao.pojo.User;
import sx_vote.enums.EnuRoleType;

import java.util.Collections;


@Component
public class SpringSecurityUserDetailService implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    SX_UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //将用户取出交给SpringSecurity框架，自动验证密码
        User user = userService.findByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在："+username);
        }
        //new 一个权限对象，暂时为Null
        SimpleGrantedAuthority role = new SimpleGrantedAuthority(EnuRoleType.valueOf(user.getRole()));
        // 封装用户信息，并返回。参数分别是：用户名，密码，用户权限
        return new CustomUserDetails(user.getUsername(), user.getPassword(), Collections.singletonList(role), user.getAutoid());
    }
}
