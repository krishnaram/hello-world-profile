package com.harman.profile;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.auth.SystemPropertiesCredentialsProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    ProfileCredentials profileCredentials;

    @Autowired
    private Environment environment;

    @GetMapping(value = "/", produces = MediaType.TEXT_PLAIN_VALUE)
    public String process(){

        AWSCredentialsProvider a = new SystemPropertiesCredentialsProvider();
        System.setProperty("aws.accessKeyId",environment.getProperty("aws.accessKeyId"));
        System.setProperty("aws.secretKey",environment.getProperty("aws.secretKey"));

        System.out.println(System.getProperty("aws.accessKeyId"));
        System.out.println(System.getProperty("aws.secretKey"));
        if (environment.getActiveProfiles()[0].equals("dev")) {
            profileCredentials = new DevProfileCredentials();
            profileCredentials.getCredentials(a);
            return "DEV PROFILE picked";
        } else if (environment.getActiveProfiles()[0].equals("prod")) {
            profileCredentials = new DevProfileCredentials();
            profileCredentials.getCredentials(a);
            return "PROD PROFILE picked";
        }
        return "COMMON profile picked";
    }
}
