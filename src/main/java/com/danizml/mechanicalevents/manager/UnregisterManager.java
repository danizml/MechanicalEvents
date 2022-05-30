package com.danizml.mechanicalevents.manager;

public class UnregisterManager {
    public static void unregister() {
        MessageManager.stop();
        YMLManager.unregisterYML();
    }
}
