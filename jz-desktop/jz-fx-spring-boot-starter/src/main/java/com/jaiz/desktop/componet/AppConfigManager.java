package com.jaiz.desktop.componet;

import cn.hutool.json.JSONUtil;
import com.jaiz.desktop.config.JzFxProperties;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;

/**
 * 应用管理器
 */
@Component
@RequiredArgsConstructor
public class AppConfigManager {

    private final JzFxProperties properties;

    private Object configBean;

    /**
     * 提供类型转化后的configBean
     * @param <T>
     * @return
     */
    public <T> T configBean(){
        return (T)configBean;
    }

    /**
     * 初始化配置文件
     * 通过初始化文件构造configBean;
     */
    @PostConstruct
    public void initConfigFileAndConfigBean() throws IOException {

        var userHome = System.getProperty("user.home");

        //目录？
        File configDir = new File(userHome + File.separatorChar + "." + properties.getAppConfigDir());
        if (!configDir.exists()) {
            var mkFlag = configDir.mkdirs();
            if (mkFlag) {
                System.out.println("创建配置目录成功");
            }
        }
        //文件？
        File configJson = new File(configDir.getPath() + File.separatorChar + "config.json");
        if (!configJson.exists()) {
            var mkFlag = configJson.createNewFile();
            if (mkFlag) {
                System.out.println("创建配置文件成功");
            }
        }

        //读取json内容
        var json = readAll(configJson);
        if (StringUtils.isBlank(json)) {
            json = "{}";
        }

        configBean = JSONUtil.toBean(json,properties.getConfigBeanType());


    }

    private String readAll(File configJson) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader(configJson));
        String line;
        StringBuilder sb=new StringBuilder();
        while ((line=br.readLine())!=null){
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }

    /**
     * 同步配置内容到文件
     */
    public void syncConfigFile() throws IOException {
        var json=JSONUtil.toJsonStr(configBean)+System.lineSeparator();
        File configFile = new File(System.getProperty("user.home")+File.separatorChar+"."+properties.getAppConfigDir()+File.separatorChar+"config.json");
        writeAll(configFile,json);
    }

    private void writeAll(File configFile, String json) throws IOException {
        BufferedWriter bw=new BufferedWriter(new FileWriter(configFile));
        bw.write(json);
        bw.flush();
        bw.close();
    }
}
