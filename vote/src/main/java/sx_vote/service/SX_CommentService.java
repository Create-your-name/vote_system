package sx_vote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sx_vote.dao.mapper.SX_CommentMapper;
import sx_vote.dao.pojo.Comment;

import java.util.List;

@Service
public class SX_CommentService {
    @Autowired
    private SX_CommentMapper sx_commentMapper;

    public List<Comment> findall() // 查整个表
    {
        return sx_commentMapper.findall();
    }

    //增加一个分类
    public  int saveCategory(Comment comment) //增
    {
        return  sx_commentMapper.saveComment(comment);
    }


    public int updateCategory(Comment comment){

        return  sx_commentMapper.updateComment(comment);
    }   //改


    public  int deleteCategory(int id) //删
    {
        return sx_commentMapper.deleteComment(id);
    }

    public  Comment findByCid(int id) //查单个表
    {
        return sx_commentMapper.findByCid(id);
    }
}
