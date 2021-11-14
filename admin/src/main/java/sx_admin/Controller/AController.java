package sx_admin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sx_admin.Service.SX_ActionService;
import sx_admin.pojo.Action;

import java.util.List;

@Controller
public class AController {
    @Autowired
    private SX_ActionService sx_actionService;
    @RequestMapping("/test")
    public  String test(Model model){
        return  "test";
    }
    @RequestMapping("shuju")
    public List<Action> findall() // 查整个表
    {
        return sx_actionService.findall();
    }
}
