package com.harman.profile;

import com.amazonaws.auth.AWSCredentialsProvider;

public interface ProfileCredentials
{
    public void getCredentials(AWSCredentialsProvider a);
}
