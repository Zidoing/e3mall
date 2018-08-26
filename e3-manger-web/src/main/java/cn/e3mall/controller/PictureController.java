package cn.e3mall.controller;

import cn.e3mall.common.utils.FastDFSClient;
import cn.e3mall.common.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zhoulei
 * Date: 26/08/2018
 * Time: 21:27
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Controller
public class PictureController {


    @Value("${IMAGE_SERVER_URL}")
    private String IMAGE_SERVER_URL;

    @RequestMapping(value = "/pic/upload", produces = MediaType.TEXT_PLAIN_VALUE + ";charset=utf-8")
    @ResponseBody
    public String uploadFile(MultipartFile uploadFile) {
        Map map = new HashMap();
        try {
            FastDFSClient client = new FastDFSClient("classpath:conf/client.conf");

            String filename = uploadFile.getOriginalFilename();

            String extName = filename.substring(filename.lastIndexOf(".") + 1);

            String url = client.uploadFile(uploadFile.getBytes(), extName);

            System.out.println(url);

            url = url.split("picture/")[1];

            System.out.println(url);

            url = IMAGE_SERVER_URL + url;

            System.out.println(url);
            map.put("error", 0);
            map.put("url", url);


        } catch (Exception e) {
            map.put("error", 1);
            map.put("message", "图片上传失败");
        }
        return JsonUtils.objectToJson(map);
    }
}