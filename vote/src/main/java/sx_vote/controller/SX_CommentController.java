package sx_vote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sx_vote.dao.pojo.Comment;
import sx_vote.service.SX_CommentService;

import java.util.List;

@Controller
@RequestMapping("/Comment")
public class SX_CommentController {

    /**
      *     投票活动的
      *@Author 刘海
      *@Data 9:17 2021/10/27
      *@Param
      *@return
      */
    @Autowired
   private SX_CommentService sx_commentService;

    @ResponseBody
    @RequestMapping("/findall")
    public List<Comment> findall() // 查整个表
    {
        return sx_commentService.findall();
    }
    @ResponseBody
    @RequestMapping("/insert")
    //增加一个分类
    public  int saveCategory(Comment comment) //增
    {
        return  sx_commentService.saveCategory(comment);
    }

    @ResponseBody
    @RequestMapping("/update")
    public int updateCategory(Comment comment){

        return  sx_commentService.updateCategory(comment);
    }   //改
    @ResponseBody
    @RequestMapping("/delecte")
    public  int deleteCategory(int id) //删
    {
        return  sx_commentService.deleteCategory(id);
    }
    @ResponseBody
    @RequestMapping("/findById")
    Comment findByCid(int id) //查单个表
    {
        return  sx_commentService.findByCid(id);
    }


}
