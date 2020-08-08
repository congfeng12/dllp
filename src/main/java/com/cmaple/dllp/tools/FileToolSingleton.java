package com.cmaple.dllp.tools;

import com.alibaba.fastjson.JSON;
import org.apache.poi.ss.formula.functions.T;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类名：文件处理工具 - FileToolSingleton
 * 功能描述： 进行文件的相关管理工具
 * 输入参数：NULL
 * 返回值：NULL
 * 异    常：无
 * 创建人：CMAPLE
 * 创建日期：2020-08-02
 */
public class FileToolSingleton {

    //私有化构造函数
    private FileToolSingleton() {

    }

    //内部类进行实例维护
    private static class FileToolSingletonInternal {
        private static FileToolSingleton fileToolSingleton = new FileToolSingleton();
    }

    //重写readResolve()方法，防止序列化及反序列化破坏单利模式
    private Object readResolve() {
        return FileToolSingleton.FileToolSingletonInternal.fileToolSingleton;
    }

    //返回实例的方法
    public static FileToolSingleton getFileToolSingletonExample() {
        return FileToolSingleton.FileToolSingletonInternal.fileToolSingleton;
    }

    /**
     * 函数名：文件处理函数 - 数据下载并保存文件 - saveFile（）
     * 功能描述：数据下载并保存文件
     * 输入参数：<按照参数定义顺序>
     *
     * @param filepath   String类型的文件路径
     * @param dataFormat String类型的文件类型
     * @param dataJson   String类型的数据内容
     *                   返回值：Map<String, Object>
     *                   异    常：IOException
     *                   创建人：CMAPLE
     *                   创建日期：2020-08-02
     */
    public Map<String, Object> saveFile(String filepath, String dataFormat, String dataJson) throws IOException {
        Map map = new HashMap<String, Object>();
        //创建文件夹对象     创建文件对象
        File file = new File(filepath);
        //如果文件夹不存在  就创建一个空的文件夹
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(filepath, "data." + dataFormat);
        //如果文件不存在  就创建一个空的文件
        if (!file2.exists()) {
            file2.createNewFile();
        }
        //写入数据
        //创建文件字节输出流
        FileOutputStream fos = new FileOutputStream(filepath + "/" + "data." + dataFormat);
        //开始写
        byte[] bytes = dataJson.getBytes();
        //将byte数组中的所有数据全部写入
        fos.write(bytes);
        //关闭流
        fos.close();

        map.put("RTCODE", "success");
        map.put("RTMSG", filepath + "/" + "data." + dataFormat + "  文件保存成功！");
        map.put("RTDATA", null);
        return map;
    }

    /**
     * 函数名：文件处理函数 - 读取文件并输出为指定数据类型 - saveFile（）
     * 功能描述：数据下载并保存文件
     * 输入参数：<按照参数定义顺序>
     *
     * @param filepath   String类型的文件路径
     * @param dataFormat String类型的文件格式
     * @param tClass     String类型的数据类型
     *                   返回值：Map<String, Object>
     *                   异    常：IOException
     *                   创建人：CMAPLE
     *                   创建日期：2020-08-02
     */
    public Map<String, Object> readFileToList(String filepath, String dataFormat, Class<T> tClass) throws IOException {
        Map map = new HashMap<String, Object>();
        BufferedReader in = new BufferedReader(new FileReader(filepath + "/data/" + "data." + dataFormat));
        String read;
        String out = null;
        while ((read = in.readLine()) != null) {
            if (read != null) {
                out = read;
            }
        }
        List<T> list = JSON.parseArray(out, tClass);
        map.put("RTCODE", "success");
        map.put("RTMSG", filepath + "/" + "data." + dataFormat + "  文件内容读取成功！");
        map.put("RTDATA", list);
        return map;
    }

}
