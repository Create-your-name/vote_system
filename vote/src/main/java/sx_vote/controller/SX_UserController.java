package sx_vote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sx_vote.dao.mapper.SX_UserMapper;
import sx_vote.dao.pojo.Action;
import sx_vote.dao.pojo.User;
import sx_vote.service.SX_ActionService;
import sx_vote.service.SX_UserService;

import java.util.List;

@Controller
@RequestMapping("/user")
public class SX_UserController {

    @Autowired
    private SX_UserService sx_userService;

    @ResponseBody
    @RequestMapping(value = "/findall")//,method = RequestMethod.GET
    public List<User> findall() // 查整个表
    {
        return sx_userService.getall();
    }
}
