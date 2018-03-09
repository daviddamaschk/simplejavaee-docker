package de.mpc;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.Assert;
import org.junit.Test;

public class HelloIT {

    @Test
    public void callSayHello() throws UnirestException {
        HttpResponse<String> bookResponse = Unirest.get("http://localhost:7777/webapp/sayhello/David").asString();
        String result= bookResponse.getBody();
        Assert.assertEquals("Hello David", result);
    }
}
