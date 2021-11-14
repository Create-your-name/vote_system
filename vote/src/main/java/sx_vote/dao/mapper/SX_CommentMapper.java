package sx_vote.dao.mapper;


import org.springframework.stereotype.Repository;
import sx_vote.dao.pojo.Comment;

import java.util.List;

@Repository
public interface SX_CommentMapper {

    List<Comment> findall(); // 查整个表
    //增加一个分类
    int saveComment(Comment comment); //增
    int updateComment(Comment comment);   //改
    int deleteComment(int id); //删
    Comment findByCid(int id); //查单个表
}
