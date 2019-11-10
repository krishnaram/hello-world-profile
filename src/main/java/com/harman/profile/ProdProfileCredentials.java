package com.harman.profile;

import com.amazonaws.auth.AWSCredentialsProvider;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Component
@Profile("prod")
public class ProdProfileCredentials implements ProfileCredentials
{

    public void getCredentials(AWSCredentialsProvider a) {
        OutputStream os = null;
        try {
            os = new FileOutputStream(new File("/credentials.txt"));
            os.write(a.getCredentials().getAWSAccessKeyId().getBytes());
            os.write(a.getCredentials().getAWSSecretKey().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            a.getCredentials();

        }
    }
}
