package cn.e3mall.fast;

import cn.e3mall.common.utils.FastDFSClient;
import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.junit.Test;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: zhoulei
 * Date: 26/08/2018
 * Time: 18:46
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class FastDFSTest {

    @Test
    public void testUpload() throws IOException, MyException {
        //创建一个配置文件 文件名任意  内容是tracker服务器地址
        // 使用全局对象加载配置文件
        ClientGlobal.init("/Users/zhoulei/IdeaProjects/e3mall/e3-manger-web/src/main/resources/conf/client.conf");


        // 创建一个trackclient 对象

        TrackerClient trackerClient = new TrackerClient();
        // 通过trackerclient获取trackserver对象
        TrackerServer trackerServer = trackerClient.getConnection();
        System.out.println(trackerServer);
        // 创建一个storageserver 的引用
        StorageServer storageServer = null;
        //创建一个storageclient,参数需要tracerserver和storageserver
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        // 使用storageclient 上传文件
        String path = "/Users/zhoulei/IdeaProjects/e3mall/e3-manger-web/src/test/java/cn/e3mall/fast/aaa.jpg";
        String[] strings = storageClient.upload_file(path, "jpg", null);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    @Test
    public void testFastDFSClient() throws Exception {
        FastDFSClient fastDFSClient = new FastDFSClient("/Users/zhoulei/IdeaProjects/e3mall/e3-manger-web/src/main/resources/conf/client.conf");

        String s = fastDFSClient.uploadFile("/Users/zhoulei/IdeaProjects/e3mall/e3-manger-web/src/test/java/cn/e3mall/fast/aaa.jpg");

        System.out.println(s);

        String result = s.split("picture/")[0];


        System.out.println(result);
    }
}