package sx_vote.dao.mapper;

import org.springframework.stereotype.Repository;
import sx_vote.dao.pojo.Action;
import sx_vote.dao.pojo.Comment;

import java.util.List;
@Repository
public interface SX_ActionMapper{
    List<Action> findall(); // 查整个表
    //增加一个分类
    int saveAction(Action action); //增
    int updateAction(int number);   //改
    int deleteAction(int id); //删
    Action findByCid(int id); //查单个表

    int[] findallMaxid();
}
