package com.cmaple.dllp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;

/**
 * 类名：双色球实体类 - DualColoredBall
 * 功能描述： 双色球实体类
 * 输入参数：NULL
 * 返回值：NULL
 * 异    常：无
 * 创建人：CMAPLE
 * 创建日期：2020-08-01
 */

@Data //给实体提供读写属性, 此外还提供了 equals()、hashCode()、toString() 方法
@Accessors(chain = true)  //chain 若为true，则setter方法返回当前对象()
@NoArgsConstructor  //提供无参构造器
@AllArgsConstructor //提供全参构造器
public class DualColoredBall {
    /**
     * 期数
     * 长度：7
     * 是否为null：N/S
     * 000000 为未获取到/其他的为正常获取
     **/
    private String issue;

    /**
     * 开奖日期
     * 长度：12
     * 是否为null：N/S
     * 0000-00-00（？） 为未获取到/其他的为正常获取例子：2020-07-30 (Thursday)
     **/
    private String drawDate;

    /**
     * 红色球
     * 长度：N/S
     * 是否为null：N/S
     * 1 - 33 选 6
     **/
    private ArrayList<Integer> redBall;

    /**
     * 蓝色球
     * 长度：N/S
     * 是否为null：N/S
     * 1 - 16 选 1
     **/
    private int blueBall;
}
