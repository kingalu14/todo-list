package net.kinginfotech.service;

import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    private String user;

    @Override
    public String getHelloMessage(String user) {
        return "Hello "+ user;
    }

    @Override
    public String getWelcomeMessage() {
        return "Welcome To This Demo Application";
    }
}
