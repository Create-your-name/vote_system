package sx_vote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sx_vote.dao.mapper.SX_ActionMapper;
import sx_vote.dao.pojo.Action;
import sx_vote.dao.pojo.Comment;

import java.util.List;

@Service
public class SX_ActionService {
    @Autowired
    private SX_ActionMapper sx_actionMapper;

    public List<Action> findall() // 查整个表
    {
        return  sx_actionMapper.findall();
    }

    //增加一个分类
    public int[] findallMaxid(){
        return  sx_actionMapper.findallMaxid();
    }
    public int saveAction(Action action) //增
    {
        return  sx_actionMapper.saveAction(action);
    }
    public int updateAction(int number)   //改
    {
        System.out.println(number);
        return  sx_actionMapper.updateAction(number);
    }
    public int deleteAction(int id) //删
    {
        return  sx_actionMapper.deleteAction(id);
    }
    public Action findByCid(int id) //查单个表
    {
        return  sx_actionMapper.findByCid(id);
    }
}
