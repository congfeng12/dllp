package com.cmaple.dllp.tools;

import com.alibaba.fastjson.JSON;
import com.cmaple.dllp.model.DualColoredBall;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类名：下载学习数据 - DownloadDataSingleton
 * 功能描述： 爬取指定网站的数据信息并保存为指定的文件格式
 * 输入参数：NULL
 * 返回值：NULL
 * 异    常：无
 * 创建人：CMAPLE
 * 创建日期：2020-08-02
 */
public class DownloadDataSingleton {

    //私有化构造函数
    private DownloadDataSingleton() {

    }

    //内部类进行实例维护
    private static class DownloadDataSingletonInternal {
        private static DownloadDataSingleton downloadDataSingleton = new DownloadDataSingleton();
    }

    //重写readResolve()方法，防止序列化及反序列化破坏单利模式
    private Object readResolve() {
        return DownloadDataSingleton.DownloadDataSingletonInternal.downloadDataSingleton;
    }

    //返回实例的方法
    public static DownloadDataSingleton getDownloadDataSingletonExample() {
        return DownloadDataSingleton.DownloadDataSingletonInternal.downloadDataSingleton;
    }

    /**
     * 函数名：爬取信息函数 - 抓取双色球数据 - crawlDCB（）
     * 功能描述：抓取双色球数据
     * 输入参数：<按照参数定义顺序>
     *
     * @param dataPath    String类型的token密钥
     * @param dataFormat  User类型的用户信息
     * @param dualBallOld User类型的用户信息
     *                    返回值：Map<String, Object>
     *                    异    常：无
     *                    创建人：CMAPLE
     *                    创建日期：2020-08-02
     */
    public Map<String, Object> crawlDCB(String dataPath, String dataFormat, String dualBallOld) throws IOException {
        Map map = new HashMap<String, Object>();
        List list = new ArrayList<DualColoredBall>();
        //抓取网站信息
        Document html = Jsoup.connect(dualBallOld).get();
        Elements tbody = html.select("tbody").select("tr");
        //保存双色球信息
        for (int i = 0; i < tbody.size(); i++) {
            Elements dcb = tbody.get(i).select("td");
            ArrayList redball = new ArrayList<Integer>();
            String[] redballs = dcb.select("td").get(2).select("span").text().split(" ");
            for (int j = 0; j < 6; j++) {
                redball.add(Integer.parseInt(redballs[j]));
            }
            list.add(new DualColoredBall(
                    dcb.select("td").get(0).text(),
                    dcb.select("td").get(1).text().split("\\(")[0],
                    redball,
                    Integer.parseInt(dcb.select("td").get(3).select("span.ball_1").text()))
            );
        }
        String jsonString = JSON.toJSONString(list);
        map = FileToolSingleton.getFileToolSingletonExample().saveFile(dataPath, dataFormat, jsonString);
        //更新返回信息
        map.put("RTMSG", "" + map.get("RTMSG"));
        return map;
    }

}
