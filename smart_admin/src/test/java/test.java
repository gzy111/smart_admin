import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHMMss");
        String str =simpleDateFormat.format(date);
        System.out.println("p"+str);

        String state="2";
        if (state=="2"){
            System.out.println(true);
        }
    }
}
