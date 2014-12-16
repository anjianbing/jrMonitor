package com.jd.jrjt.web.monitor;

import com.google.gson.Gson;
import com.jd.jrjt.entity.monitor.MonitorSystemDataDetail;
import com.jd.jrjt.entity.monitor.MonitorSystemDataInfo;
import com.jd.jrjt.entity.monitor.MonitorSystemUserConfig;
import com.jd.jrjt.service.mortior.MortorService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * LoginController负责打开登录页面(GET请求)和登录出错页面(POST请求)，
 * <p/>
 * 真正登录的POST请求由Filter完成,
 * 
 * @author syz
 */
@Controller
@RequestMapping()
public class MontiorController {
	private static final Log logger = LogFactory.getLog(MontiorController.class);

    @Resource
	private MortorService mortorService;

    @RequestMapping(value = "list")
    public String list(HttpSession session,Model model,
                             HttpServletResponse servletResponse, HttpServletRequest request) {
        try {
            List<MonitorSystemDataInfo> list = mortorService.getList();
            model.addAttribute("list",list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "list";
    }

    @RequestMapping("/get/{sid}")
    @ResponseBody
    public String get(@ModelAttribute("sid") Integer sid,
                           HttpServletResponse response, HttpServletRequest request) {
           MonitorSystemDataDetail ms = mortorService.get(sid);
           Gson gson = new Gson();
           String json = gson.toJson(ms);
           return json;

    }

    @RequestMapping("/getUserConfig/{sid}")
    @ResponseBody
    public String getUserConfig(@ModelAttribute("sid") Integer sid,
                           HttpServletResponse response, HttpServletRequest request) {
        List<MonitorSystemUserConfig> ms = mortorService.getUserConfigList(sid);
        Gson gson = new Gson();
        String json = gson.toJson(ms);
        return json;

    }
}
