package com.example.smart_admin.controller;


import com.example.smart_admin.Utils.HttpUtils;
import com.example.smart_admin.Utils.JWTUtil;
import com.example.smart_admin.Utils.JsonUtil;
import com.example.smart_admin.Utils.RSAUtil;
import com.example.smart_admin.domain.LoginRequest;
import com.example.smart_admin.domain.SysUser;
import com.example.smart_admin.service.sysUserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.security.PrivateKey;
import java.util.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    sysUserService sysUserService;
    @Value("${privateKeyPath}")
    private String privateKeyPath;

    private String SMCODE="";
    public static StringBuilder getRandom() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        //每次随机生成一个数字，循环5次(下标从0开始)得到6个随机数，保存到数组里
        for(int i = 0; i <= 5; i++) {
            //只需要0-9之间的随机6位，所以nextInt(9)里就生成到9就好了，包含0在里面
            stringBuilder.append(random.nextInt(9));
        }
        return stringBuilder;
    }

    public String getSMCode(String phone){
        String host = "https://gyytz.market.alicloudapi.com";
        String path = "/sms/smsSend";
        String method = "POST";
        String appcode = "a165ea84682348e9ba1f5163cc19828f";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("mobile", phone);
        String smcode= String.valueOf(getRandom());
        querys.put("param", "**code**:"+smcode+",**minute**:5");
//smsSignId（短信前缀）和templateId（短信模板），可登录国阳云控制台自助申请。参考文档：http://help.guoyangyun.com/Problem/Qm.html
        querys.put("smsSignId", "2e65b1bb3d054466b82f0c9d125465e2");
        querys.put("templateId", "908e94ccf08b4476ba6c876d13f084ad");
        Map<String, String> bodys = new HashMap<String, String>();
        try {
            /**
             * 重要提示如下:
             * HttpUtils请从\r\n\t    \t* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java\r\n\t    \t* 下载
             *
             * 相应的依赖请参照
             * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
             */
            HttpResponse response = HttpUtils.doPost(host, path, method, headers, querys, bodys);
            System.out.println(response.toString());
            //获取response的body
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return smcode;
    }



    @PostMapping("/login")
    public Map<String,Object> login(@RequestBody LoginRequest request){
        SysUser userVO = new SysUser();
        Long userId = request.getUserId();
        String code=request.getPassCode();
        if (request.getAdminFlg().equals("true")&&code.equals(SMCODE)){
            userVO=sysUserService.selectUser(1001L);
            System.out.println(code+"   code");
            System.out.println(SMCODE+"   SMCODE");

        }else {
            System.out.println("没有验证码");
            String password = request.getPassword();
            System.out.println(userId);
            System.out.println(password);
            userVO = sysUserService.login(userId,password);
        }
        Map<String,Object> result = new HashMap<>();
        if(userVO==null){
            result.put("msg","登录失败");
            result.put("code","401");
        }else{
            PrivateKey privateKey=null;
            try {
                privateKey = RSAUtil.getPrivateKey(privateKeyPath);
            } catch (Exception e) {
                e.printStackTrace();
            }
            String userInfo = null;
            try {
                userInfo = JsonUtil.objToJson(userVO);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            //生成token
            String token = JWTUtil.generateToken(userInfo,privateKey,360000);
            result.put("code",200);
            result.put("data",userVO);
            result.put("msg","登录成功");
            result.put("token",token);
        }
        //session
        return result;
    }


    @GetMapping("/getCode")
    public void code(@RequestParam(value = "userId") Long userId){
        if (userId==1001){
            String phone= sysUserService.selectUser(userId).getPhonenumber();
            SMCODE=getSMCode(phone);
//            SMCODE="123456";
            System.out.println(SMCODE);
        }
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    SMCODE="";
                    System.out.println("时间到");
                    timer.cancel();
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        },5*60*1000);

    }
}
