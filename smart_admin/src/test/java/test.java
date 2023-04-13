import com.example.smart_admin.Utils.HttpUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.http.HttpResponse;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class test {


    public static void main(String[] args) {
//        Date date = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHMMss");
//        String str =simpleDateFormat.format(date);
//        System.out.println("p"+str);
//
//        String state="2";
//        if (state=="2"){
//            System.out.println(true);
//        }
        //创建并启动StopWatch
        StopWatch stopwatch = StopWatch.createStarted();
        //业务逻辑......
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }


        stopwatch.stop();
        //分钟,不足59秒,返回0
        System.out.println("分钟单位" +  " :" + stopwatch.getTime(TimeUnit.MINUTES));
        //毫秒单位
        System.out.println("毫秒单位" + " :" + stopwatch.getTime(TimeUnit.MILLISECONDS));
        //微妙单位
        System.out.println("微妙单位" + " :" +stopwatch.getTime(TimeUnit.MICROSECONDS));
    }

}
