package sx_admin.Controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sx_admin.pojo.Action;
import sx_admin.Service.SX_ActionService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/Action")
public class SX_ActionController {
    /**
      *     投票活动的 访问数据库的 控制器
     *      包含了 投票活动的具体内容 sx_Action  和 sx_Comment 两张表
      *@Author 刘海
      *@Data 9:16 2021/10/27
      *@Param
      *@return
      */
    @Autowired
    private SX_ActionService sx_actionService;

    @ResponseBody
    @RequestMapping("/findall")
    public List<Action> findall() // 查整个表
    {
        return sx_actionService.findall();
    }


   /* @ResponseBody*//*
    @RequestMapping("/update")
    public String updateAction(int number){
        System.out.println(number);
        sx_actionService.updateAction(number);

        return "redirect:/fenlei";
    }   //改*/
    /* @ResponseBody*/
   @RequestMapping("/update")
    public String updateAction(HttpServletRequest request){
        String number =request.getParameter("id");
        int sum =Integer.parseInt(number);
        System.out.println(sum);
        sx_actionService.updateAction(sum);

        return "redirect:/fenlei";
    }   //改*/
    @ResponseBody
    @RequestMapping("/delecte")
    public  int deleteAction(int id) //删
    {
        return  sx_actionService.deleteAction(id);
    }
    @ResponseBody
    @RequestMapping("/findById")
    Action findByCid(int id) //查单个表
    {
        return  sx_actionService.findByCid(id);
    }

    @ResponseBody
    @RequestMapping("/findallMaxid")
    public  int[] findallMaxid(){
        return sx_actionService.findallMaxid();
    }


}
