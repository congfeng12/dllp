package com.cmaple.dllp.until;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 类名：静态配置实体类 - StaticConfiguration
 * 功能描述： 静态配置实体类
 * 输入参数：NULL
 * 返回值：NULL
 * 异    常：无
 * 创建人：CMAPLE
 * 创建日期：2020-08-02
 */

@Component
@Data //给实体提供读写属性, 此外还提供了 equals()、hashCode()、toString() 方法
@Accessors(chain = true)  //chain 若为true，则setter方法返回当前对象()
@NoArgsConstructor  //提供无参构造器
@AllArgsConstructor //提供全参构造器
public class StaticConfiguration {

//    /**
//     * 深度学习缓存文件目录
//     * 长度：N/S
//     * 是否为null：N/S
//     **/
//    @Value(${DL.cache-file.path})
//    private String cachePath;
//
//    /**
//     * 深度学习模型储存目录
//     * 长度：N/S
//     * 是否为null：N/S
//     **/
//    @Value("DL.model-storage.path")
//    private String modelPath;

    /**
     * 学习数据记录目录
     * 长度：N/S
     * 是否为null：N/S
     **/
    @Value("${Learning.data.path}")
    private String dataPath;

    /**
     * 学习数据储存格式
     * 长度：N/S
     * 是否为null：N/S
     **/
    @Value("${Learning.file.format}")
    private String fileFormat;

    /**
     * 往期数据抓取网站(360彩票)
     * 长度：N/S
     * 是否为null：N/S
     **/
    @Value("${dual.colored.ball.old}")
    private String dualBallOld;

    /**
     * 双色球官网
     * 长度：N/S
     * 是否为null：N/S
     **/
    @Value("${dual.colored.ball}")
    private String dualBall;
}
