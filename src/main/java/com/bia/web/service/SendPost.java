package com.bia.web.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SendPost {
    public String load(String url,String query) throws IOException {
        URL restURL =new URL(url);
        HttpURLConnection conn = (HttpURLConnection) restURL.openConnection();
        conn.setRequestMethod("GET");
        conn.setDoOutput(true);
        conn.setAllowUserInteraction(false);
        BufferedReader bReader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line,resultStr="";
        while (null != (line = bReader.readLine())) {
            resultStr+=line;
        }
        bReader.close();
        return resultStr;
    }
    public static void main(String []args){

    }
}
