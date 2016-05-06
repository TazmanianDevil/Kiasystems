package ru.kiasystems.model.utils.rest;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.impl.client.BasicCredentialsProvider;

/**
 * Created by User on 06.05.2016.
 */
public class CustomCredentialsProvider extends BasicCredentialsProvider {
    public void setCredentials(Credentials credentials) {
        this.setCredentials(AuthScope.ANY, credentials);

    }
}
