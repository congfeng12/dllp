package com.cmaple.dllp.ann.neuralnet;

import com.cmaple.dllp.ann.neuralnet.math.IActivationFunction;

import java.util.ArrayList;

/**
 * 类名：人工神经元实体类 - Neuron
 * 功能描述： 双色球实体类
 * 输入参数：NULL
 * 返回值：NULL
 * 异    常：无
 * 创建人：CMAPLE
 * 创建日期：2020-08-02
 */
public class Neuron {
    /**
     * 权重
     **/
    protected ArrayList<Double> weight;
    /**
     * 输入
     **/
    private ArrayList<Double> input;
    /**
     * 输出
     **/
    private Double output;
    /**
     * 输出函数
     **/
    private Double outputBeforeActivation;
    /**
     * 输入数量
     **/
    private int numberOfInputs = 0;
    /**
     * 偏执
     **/
    private Double bias = 1.0;
    /**
     * 激活函数
     **/
    private IActivationFunction activationFunction;

    public Neuron(int numberofInputs, IActivationFunction iaf){
        numberOfInputs = numberofInputs;
        weight = new ArrayList<>(numberofInputs +1);
        input = new ArrayList<>(numberofInputs);
        activationFunction = iaf;

    }

//    public void init(){
//        for (int i = 0; i <= numberOfInputs ; i++) {
//            double newWeight = RandomNumberGenerator.GenerateNext();
//        }
//    }


}
