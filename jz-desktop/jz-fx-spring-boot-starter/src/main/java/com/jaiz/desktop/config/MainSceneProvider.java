package com.jaiz.desktop.config;

/**
 * 指定主场景的类
 */
public interface MainSceneProvider {

    Class<? extends MainSceneProvider> mainSceneControllerClass();

}
