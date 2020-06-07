package com.test;

import com.client.ClientInitClose;
import com.client.ClientInterface;
import com.client.ClientScanner;

import java.io.IOException;

public class ClientTest {

    public static void main(String[] args) {

        ClientInitClose cic = null;
        try {
            cic = new ClientInitClose();
            cic.clientInit();

            ClientInterface cv = new ClientInterface(cic);
            cv.clientMainPage();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                cic.clientClose();
                ClientScanner.closeScanner();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
