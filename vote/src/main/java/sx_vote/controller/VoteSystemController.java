package sx_vote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.thymeleaf.spring5.context.SpringContextUtils;
import sx_vote.dao.RegisterDTO;
import sx_vote.dao.pojo.Action;
import sx_vote.dao.pojo.Tag;
import sx_vote.dao.pojo.User;
import sx_vote.enums.EnuRoleType;
import sx_vote.enums.EnuSexType;
import sx_vote.service.SX_ActionService;
import sx_vote.service.SX_ActionTagService;
import sx_vote.service.SX_UserService;
import org.springframework.ui.Model;
import sx_vote.utils.SecurityContextUtil;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class VoteSystemController {
    @Autowired
    private SX_UserService sx_userService;
    @Autowired
    private  SX_ActionTagService sx_actionTagService;
    @Autowired
    private SX_ActionService sx_actionService;

 /*   public staticist<Tag> tagList;
    public  static String[] tagS;
    L*/
     /* static  {
        tagList = sx_actionTagService.findall();
        tagS = new String[tagList.size()];
        int i =0;
        for(Tag tag : tagList){
            tagS[i++] = tag.getTagid();
        }
    }*/
    /**
     * 首页
     *
     * @return
     * @Author 刘海
     * @Data 13:46 2021/10/27
     * @Param
     */
    @RequestMapping(value = {"/","/index","/index.html"})
    public String index(Model model) {
        List<Tag> tagList = sx_actionTagService.findall();
        String [] tagS = new String[tagList.size()];
        int i =0;
        for(Tag tag : tagList){
            tagS[i++] = tag.getTagid();
        }


        /**
          *     加班加班
          *@Author 刘海
          *@Data 17:41 2021/10/28
          *@Param
          *@return
          */

        model.addAttribute("tags",tagS);
        model.addAttribute("username",SecurityContextUtil.getLoginUserName());
        return "index";
    }

    @RequestMapping("/xiangmu")
    public String xiangmu(Model model) {

        return "xiangmu";
    }
    @RequestMapping("/test")
    public  String test(Model model){
        return  "test";
    }

    @RequestMapping("/chuangjian")
    public String chuangjian(Model model) {
        List<Tag> taglist = sx_actionTagService.findall();
        /**
          *         停！！！
          *@Author 刘海
          *@Data 8:57 2021/10/29
          *@Param
          *@return
          */
        int[] id = new int[sx_actionService.findall().size()];
        id=sx_actionService.findallMaxid();
        int Maxid =0;
        for ( int i : id){
            Maxid =i ;
        }
        Maxid++;
        System.out.println(Maxid);
        model.addAttribute("taglist" ,taglist);
        model.addAttribute("articleid",Maxid);
        model.addAttribute("userid",SecurityContextUtil.getLoginUserId());
        model.addAttribute("username",SecurityContextUtil.getLoginUserName());
        return "chuangjian";
    }

    @RequestMapping("/renyuan")
    public String renyuan(Model model) {

        return "renyuan";
    }

    @RequestMapping("/lianxi")
    public String lianxi(Model model) {

        return "lianxi";
    }

    @RequestMapping(value = "/fenlei")
    public String fenlei1(Model model) {
        List<Action> actionList = sx_actionService.findall();
        Action action = actionList.get(actionList.size()-1);
        Action action2 = actionList.get(actionList.size()-2);
        Action action3 = actionList.get(actionList.size()-3);
        Action action4 = actionList.get(actionList.size()-4);
        Action action5 = actionList.get(actionList.size()-5);
        Action action6 = actionList.get(actionList.size()-6);
        Action action7 = actionList.get(actionList.size()-7);
        Action action8 = actionList.get(actionList.size()-8);
        model.addAttribute("action",action);
        model.addAttribute("action2",action2);
        model.addAttribute("action3",action3);
        model.addAttribute("action4",action4);
        model.addAttribute("action5",action5);
        model.addAttribute("action6",action6);
        model.addAttribute("action7",action7);
        model.addAttribute("action8",action8);
        return "fenlei";
    }


    /**
     * 登录页面
     *
     * @return
     * @Author 刘海
     * @Data 13:47 2021/10/27
     * @Param
     */
    @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }

    /**
     * 注册页面
     *
     * @param model
     * @return
     */

    @RequestMapping(value = "/register")
    public String register(Model model) {
        //传一个空对象用于初始化页面
        model.addAttribute("register", new RegisterDTO());
        return "register";
    }

    /**
     * 注册用户
     *
     * @param registerForm  表单信息
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/adduser", method = RequestMethod.POST) //注册表
    public String addUser(@Valid @ModelAttribute("register") RegisterDTO registerForm, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) { // 验证是否符合注册规则
            //判断密码和确认密码是否匹配
            if (registerForm.getPassword().equals(registerForm.getPasswordConfirmation())) {
                //获取注册的密码
                String pwd = registerForm.getPassword();
                BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
                //计算密码哈希
                String hashPwd = bc.encode(pwd);
                //创建用户对象
                User newUser = new User();
                newUser.setCreatetime(LocalDateTime.now());
                newUser.setLastlogin(LocalDateTime.now());
                newUser.setUsername(registerForm.getUsername());
                newUser.setPassword(hashPwd);
                newUser.setRole(EnuRoleType.USER.getCode()); //该接口只允许普通用户注册
                newUser.setPhone(registerForm.getPhone());
                newUser.setEmail(registerForm.getEmail());
                newUser.setSex(registerForm.getSex());
                newUser.setAge(registerForm.getAge());
                newUser.setClasses(registerForm.getClasses());

                if (sx_userService.findByName(registerForm.getUsername()) == null) {
                    //如果用户不存在，保存到数据库
                    sx_userService.saveUser(newUser);
                } else {
                    //否则返回一个错误信息给网页
                    bindingResult.rejectValue("username", "err.username", "用户名已存在");
                    return "register";
                }
            } else {
                //密码和确认密码不匹配
                bindingResult.rejectValue("passwordConfirmation", "err.passCheck", "密码和确认密码不匹配");
                return "register";
            }
        } else {
            return "register";
        }
        return "redirect:/login";
    }



    /**
     * 投票页面
     */
    @RequestMapping(value = "/vote")
    public String vote(Model model,int id) {
        String tag ="泪目类";
        Action action = sx_actionService.findByCid(id);
        model.addAttribute("tags", tag);
        model.addAttribute("action",action);
        return "vote";
    }

  /*  @RequestMapping(value = "/fenlei")
    public String fenlei1(Model model) {
        List<Action> actionList = sx_actionService.findall();
        Action action = actionList.get(actionList.size()-1);
        Action action2 = actionList.get(actionList.size()-2);
        Action action3 = actionList.get(actionList.size()-3);
        Action action4 = actionList.get(actionList.size()-4);
        Action action5 = actionList.get(actionList.size()-5);
        Action action6 = actionList.get(actionList.size()-6);
        Action action7 = actionList.get(actionList.size()-7);
        Action action8 = actionList.get(actionList.size()-8);
        model.addAttribute("action",action);
        model.addAttribute("action2",action2);
        model.addAttribute("action3",action3);
        model.addAttribute("action4",action4);
        model.addAttribute("action5",action5);
        model.addAttribute("action6",action6);
        model.addAttribute("action7",action7);
        model.addAttribute("action8",action8);
        return "fenlei";
    }*/

}
