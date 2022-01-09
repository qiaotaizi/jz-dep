package com.jaiz.desktop.config;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JzFxProperties {

    /**
     * 应用名称，作为mainScene的标题
     */
    private String appName = "defaultJzFxApp" ;

    /**
     * 应用配置文件名称
     */
    private String appConfigDir = "defaultJzFxAppConfigDir";

    /**
     * 应用配置序列化/反序列化对象类型
     */
    private Class<?> configBeanType = DefaultConfigBeanType.class;

}
