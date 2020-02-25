package com.sts.demo.controller;

import com.sts.demo.entities.ResultVO;
import com.sts.demo.entities.datasource.ThirdLoginParamVO;
import com.sts.demo.util.SignatureTookKit;
import org.jboss.netty.handler.codec.base64.Base64Encoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Arrays;

@RestController
@RequestMapping(value = "/third")
public class UserSSOLoginController {

    /**
     * 获取token
     * */
    @RequestMapping(value = "/getToken")
    @ResponseBody
    public ResultVO getToken(ThirdLoginParamVO param){
        String type = param.getType();

        ResultVO resultVO = new ResultVO();
        String dsname = param.getDsname();
        String busicentercode = param.getBusicentercode();
        String usercode = param.getUsercode();
        String langcode = param.getLangcode();
        String client_id = param.getClient_id();
        String client_security = param.getSecurity();
        URL url = null;

        OutputStream os = null;
        DataOutputStream dos = null;
        String resultToken = "";
        InputStream is = null;
        try{
            url= new URL("http://127.0.0.1:8886/service/genThirdPartyAccessToken");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setUseCaches(false);
            //conn.setRequestProperty("Content-Type","application/x-www-form-urlencode");
            conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", "10000");
            conn.setRequestProperty("userid", "admin");
            //HttpURLConnection  huc = (HttpURLConnection)conn;
            conn.setRequestMethod("POST");
            conn.connect();
            StringBuffer sb = new StringBuffer();
            String ts = (System.currentTimeMillis()+"").substring(0,6);
            byte[] arr = SignatureTookKit.digestSign(usercode.getBytes(),(usercode + ts + client_security + ts).getBytes());
            String security = new BASE64Encoder().encode(arr);
            String key = usercode + ts + client_security + ts;
            boolean isPass = SignatureTookKit.digestVerify(usercode.getBytes("utf-8"),key.getBytes("utf-8"),new BASE64Decoder().decodeBuffer(security));
            if(!isPass){
                return resultVO;
            }
            sb.append("type=").append(type);
            sb.append("&dsname=").append(dsname);
            sb.append("&usercode=").append(usercode);
            sb.append("&client_id=").append(client_id);
            sb.append("&security=").append(URLEncoder.encode(security,"utf-8"));
            sb.append("&ts=").append(ts);
            os = conn.getOutputStream();
            dos = new DataOutputStream(os);
            dos.writeBytes(sb.toString());
            dos.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null){
                resultToken += line;
            }

//            is = conn.getInputStream();
//            int ch;
//            while((ch = is.read()) != -1){
//                resultToken += String.valueOf((char)ch);
//            }
            resultVO.setSuccess(true);
            resultVO.setData(Arrays.asList(new String[]{resultToken}));
            return resultVO;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(dos != null){
                try {
                    dos.close();
                }catch (Exception e){

                }
            }

            if(os != null){
                try {
                    os.close();
                }catch (Exception e){

                }
            }

            if(is != null){
                try {
                    is.close();
                }catch (Exception e){

                }
            }
        }
        return null;
    }
}
