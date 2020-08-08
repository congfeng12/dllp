package com.cmaple.dllp.ann.neuralnet.math;

/**
 * 类名：激活函数接口 - IActivationFunction
 * 功能描述： 激活函数接口
 * 输入参数：NULL
 * 返回值：NULL
 * 异    常：无
 * 创建人：CMAPLE
 * 创建日期：2020-08-02
 */
public interface IActivationFunction {

    double calc(double x);
    public enum  ActivationFunctionENUM{
        STEP, LINEAR, SIGMOID, HYPERTAN
    }
}
