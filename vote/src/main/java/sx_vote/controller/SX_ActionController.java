package sx_vote.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sx_vote.dao.pojo.Action;
import sx_vote.dao.pojo.Comment;
import sx_vote.service.SX_ActionService;
import sx_vote.service.SX_CommentService;

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
    @Value("${file.staticAccessPath}")
    private String staticAccessPath;
    @Value("${file.uploadFolder}")
    private String uploadFolder;

    @ResponseBody
    @RequestMapping("/findall")
    public List<Action> findall() // 查整个表
    {
        return sx_actionService.findall();
    }

    @RequestMapping("/insert")
    //增加一个分类
    public  String saveAction(Action action , MultipartFile uploadfile) throws IOException
    //增 Action action
    {
       /* return  sx_actionService.saveAction(action);*/
//定义上传文件的前缀
        String pre = "";
        //保证文件上传后 存到服务器的文件名的唯一性
        pre = UUID.randomUUID() + "";
        //获取文件的后缀名
        String suffix = "";
        if (uploadfile != null) {
            //.jpg
            String originalName = uploadfile.getOriginalFilename();
            suffix = originalName.substring(originalName.lastIndexOf("."));
        }
        //文件名
        String fileName = pre + suffix;

        //定义 文件上传的全路径
        String filePath = uploadFolder + "\\" + fileName;

        //创建file对象
        File f = new File(filePath);
        //目录是否存在，不存在则创建
        if (!f.isDirectory()) {
            f.mkdirs();
        }
        //上传文件
        uploadfile.transferTo(f);
        //上传到数据库的路径
        String url = "/upload/" + fileName;
        //设置图片的路径,保存到数据库
        action.setImg(url);
        //时间把当前时间设置过去
        //  voteInfo.setPdate(new Date());
        System.out.println("************" + action);
        action.setPowerCounts(0);
        Date date =new Date();
        System.out.println(date);
        int result = sx_actionService.saveAction(action);//插入数据
        return "redirect:/index";
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
