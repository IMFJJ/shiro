package com.study.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.study.model.User;
import com.study.util.RanderData;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by yangqj on 2017/4/21.  只有这里可以返回String  有一个疑问? https://blog.csdn.net/Sniper_Warren/article/details/78479066
 */
@Controller
public class HomeController {
    private String getAccessToken = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";// 用户凭证
    private static String appId = "wx2a0f9f8c288435cf";//	公众号的唯一标识
    private static String appSecret = "63455b7c329301d0ec72e6688d8e3ca9";//公众号的appsecret
    @RequestMapping(value="/login",method= RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String login(HttpServletRequest request, User user, Model model){
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
            request.setAttribute("msg", "用户名或密码不能为空！");
            return "login";
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(),user.getPassword());
        try {
            subject.login(token);
            return "redirect:usersPage";
        }catch (LockedAccountException lae) {
            token.clear();
            request.setAttribute("msg", "用户已经被锁定不能登录，请与管理员联系！");
            return "login";
        } catch (AuthenticationException e) {
            token.clear();
            request.setAttribute("msg", "用户或密码不正确！");
            return "login";
        }
    }
    @RequestMapping(value={"/usersPage",""})
    public String usersPage(){
        return "user/users";
    }

    @RequestMapping("/rolesPage")
    public String rolesPage(){
        return "role/roles";
    }

    @RequestMapping("/resourcesPage")
    public String resourcesPage(){
        return "resources/resources";
    }

    @RequestMapping("/403")
    public String forbidden(){
        return "403";
    }


    @RequestMapping("/getCode")
    public String getCode(HttpServletRequest req, HttpServletResponse resp, String code) {
        // 微信回调参数
        // TODO: 2018/6/9
        if ("0".equals(code)) {
            //微信服务器回调code不存在，重新请求
            code=req.getParameter("code");
        }
        //第二步：通过code换取网页授权access_token
        String url = getAccessToken.replace("APPID", appId).replace("SECRET", appSecret).replace("JSCODE", code);
        //发送post请求读取调用微信 https://api.weixin.qq.com/sns/jscode2session 接口获取openid用户唯一标识
        JSONObject jsonObject = JSON.parseObject(RanderData.sendPost(url));
        req.setAttribute("jsonObject",jsonObject);
        try {
            //RanderData.renderData(resp,jsonObject.toString(),UserController.class);
            //返回前端
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "wxIndex";
    }
}
