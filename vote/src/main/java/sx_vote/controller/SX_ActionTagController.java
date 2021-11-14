package sx_vote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sx_vote.dao.pojo.Comment;
import sx_vote.dao.pojo.Tag;
import sx_vote.service.SX_ActionTagService;

import java.util.List;
@Controller
@RequestMapping("/tag")
public class SX_ActionTagController {

    @Autowired
    private SX_ActionTagService sx_actionTagService;

    @ResponseBody
    @RequestMapping("/findall")
    public List<Tag> findall() // 查整个表
    {
        return sx_actionTagService.findall();
    }
}
