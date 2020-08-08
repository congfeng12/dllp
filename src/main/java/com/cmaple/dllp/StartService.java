package com.cmaple.dllp;

import com.cmaple.dllp.until.StaticConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Scanner;


/**
 * 继承Application接口后项目启动时会按照执行顺序执行run方法
 * 通过设置Order的value来指定执行的顺序
 */
@Component
@Order(value = 2)
public class StartService implements ApplicationRunner {

    @Autowired
    StaticConfiguration configuration = new StaticConfiguration();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("程序初始化！");
        System.out.println("请使用SpringBoot容器启动程序！");
        boolean leave = true;
        boolean fileexists = false;
        File file = new File(configuration.getDataPath());
        //进行执行前检查
        if (file.exists()) {
            fileexists = true;
        }
        System.out.println("所需本地路径（" + configuration.getDataPath() + "）是否存在：" + fileexists);
        //创建输入
        Scanner scanner = new Scanner(System.in);
        //输入执行程序
        while (leave == true) {
            System.out.println("请输入命令！");
            String line = scanner.nextLine();
            //判断是否退出
            if ("exit".equals(line)) {
                leave = false;
                System.out.println("程序已退出！");
            }
        }
    }

}
