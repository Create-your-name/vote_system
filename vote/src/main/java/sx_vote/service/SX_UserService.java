package sx_vote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sx_vote.dao.mapper.SX_UserMapper;
import sx_vote.dao.pojo.User;

import java.util.List;

@Service
public class SX_UserService {

    @Autowired
    private SX_UserMapper sx_userMapper;

    //查询所有
    public List<User> getall() {
        return sx_userMapper.selectList(null);
    }

    /**
      *     根据id查询符合调节的分类
      *@Author 刘海
      *@Data 14:01 2021/10/27
      *@Param
      *@return
      */
    public User findById(int id){
        return  sx_userMapper.selectById(id);
    }
    /**
     * 通过用户名查询用户是否存在
     * @param userName
     * @return
     */
    public User findByName(String userName) {
        return sx_userMapper.findByName(userName);
    }
    //修改
    public int updateUser(User user) {
        return sx_userMapper.updateById(user);
    }
    //删除
    public int deleteUser(int id) {
        return sx_userMapper.deleteById(id);
    }
    //增加
    public int saveUser(User user) {
        return sx_userMapper.insert(user);
    }
}
