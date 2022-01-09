package com.jaiz.desktop;

import com.jaiz.desktop.launch.JzFxLauncher;

import java.util.Arrays;

public class TestApplication2 {

    public static void main(String[] args) {
        System.out.println("args = "+ Arrays.toString(args));
        JzFxLauncher.launch(args);
    }

}
