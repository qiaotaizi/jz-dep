package com.jaiz.desktop;

import com.jaiz.desktop.config.WarmUp;
import com.jaiz.desktop.launch.JzFxLauncher;

public class TestApplication2 {

    public static void main(String[] args) {
        JzFxLauncher.launch(WarmUp.AppEntry.class,args);
    }

}
