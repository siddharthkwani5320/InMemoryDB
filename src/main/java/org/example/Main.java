package org.example;

import org.example.service.DbManagerService;

public class Main {
    public static void main(String[] args) {
        DbManagerService manager = new DbManagerService();
        manager.Manage();
    }
}