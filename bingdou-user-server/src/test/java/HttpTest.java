import com.bingdou.tools.CodecUtils;
import com.bingdou.tools.HttpClientUtil;
import com.bingdou.tools.constants.KeyGroup;

/**
 * Created by gaoshan on 16-11-2.
 */
public class HttpTest {

    public static void main(String[] args){

        StringBuffer sb = new StringBuffer();
        sb.append("{\"login_name\":");
        sb.append("\"").append("gaoshan").append("\",");
        sb.append("\"password\":");
        sb.append("\"").append("123456").append("\"");
        sb.append("}");

        System.out.println(sb.toString());
        String param = "version=xxxx&request_source_index=live&param=";
        String url = "http://localhost:8090/v1/user/register";
        try {
            String sign = CodecUtils.getMySign(sb.toString(),KeyGroup.DEFAULT);
            String signParam = "&sign="+sign;
            String encodeParam = CodecUtils.aesEncode(sb.toString(), KeyGroup.DEFAULT);
            HttpClientUtil.doPostStringHttpClient("test",url,param+encodeParam+signParam,3000,3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
