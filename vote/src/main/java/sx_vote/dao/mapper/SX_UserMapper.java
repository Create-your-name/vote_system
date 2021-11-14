package sx_vote.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import sx_vote.dao.pojo.Action;
import sx_vote.dao.pojo.Comment;
import sx_vote.dao.pojo.User;

import java.util.List;

@Repository
public interface SX_UserMapper extends BaseMapper<User> {
    @Select("select * from sx_user where username = #{username}")
    public User findByName(String username);
}
