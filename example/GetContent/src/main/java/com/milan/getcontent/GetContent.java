package com.milan.getcontent;

import android.os.CountDownTimer;
import android.os.StrictMode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Milan Pithadia on 10-Mar-18.
 */

public class GetContent {


    private static String result;
    private static Result res;;
    public static GetContent fromURL(String url)
    {
        result = "null";
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            URL u = new URL(url);
            URLConnection conn = u.openConnection();
            final BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            conn.getInputStream()));
            final StringBuffer buffer = new StringBuffer();
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                buffer.append(inputLine);
            in.close();
            new CountDownTimer(1,1)
            {
                public void onTick(long l) {}
                public void onFinish()
                {
                    if(in != null && result != null)
                    {
                        result = buffer.toString();
                        res.Result(true,buffer.toString());
                        cancel();
                    }else {
                        start();
                    }
                }
            }.start();
        }catch (final Exception e)
        {
            new CountDownTimer(1,1)
            {
                public void onTick(long l) {}
                public void onFinish()
                {
                    if(result != null)
                    {
                        result = e.toString();
                        res.Result(false,result);
                        cancel();
                    }else {
                        start();
                    }
                }
            }.start();
        }
        return new GetContent();
    }
    public GetContent setOnResultListener(Result res1)
    {
        res = res1;
        return this;
    }
    public interface Result
    {
        void Result(Boolean b, String result);
    }
}
