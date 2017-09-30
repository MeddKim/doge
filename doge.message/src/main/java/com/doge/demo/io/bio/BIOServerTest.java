package com.doge.demo.io.bio;

import java.io.IOException;

public class BIOServerTest {

    public static void main(String[] args) {
        try {
            ServerNormal.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
