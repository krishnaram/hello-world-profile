package com.harman;

import com.harman.profile.ProfileCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ComponentScan()
public class Helloworld
{

    @Autowired
    private Environment environment;

    public static void main(String[] args)
    {
        SpringApplication.run(Helloworld.class, args);
    }
}

