package sx_vote.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import sx_vote.dao.pojo.CustomUserDetails;

public class SecurityContextUtil {
    /**
     * 从SpringSecurity上下文中获取用户名并返回
     * @return 用户名
     */
    public static String getLoginUserName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication.getPrincipal() instanceof User){
            User user = (User)authentication.getPrincipal();
            return user.getUsername();
        }
        return null;
    }
    /**
     * 从SpringSecurity上下文中获取userId并返回
     * @return
     */
    public static int getLoginUserId(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication.getPrincipal() instanceof CustomUserDetails){
            CustomUserDetails user = (CustomUserDetails)authentication.getPrincipal();
            return user.getUserId();
        }
        return 0;
    }
}
