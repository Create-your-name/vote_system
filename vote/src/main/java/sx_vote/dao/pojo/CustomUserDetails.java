package sx_vote.dao.pojo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUserDetails extends User {

    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, int userId) {
        super(username, password, true, true, true, true, authorities);
        setUserId(userId);
    }
}