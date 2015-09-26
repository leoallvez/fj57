package br.com.caelum.alunos.support;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by android5243 on 26/09/15.
 */
public class WebClient extends AsyncTask<String, Void, String>{

    private static final String URL = "http://www.caelum.com.br/mobile";

    public String post(String json) {
        HttpPost post = new HttpPost(URL);
        String jsonDeResposta = null;
        try {

            post.setEntity(new StringEntity(json));
            post.setHeader("Accept", "application/json");
            post.setHeader("Content-type", "application/json");

            DefaultHttpClient client = new DefaultHttpClient();
            HttpResponse reponse = client.execute(post);
            jsonDeResposta = EntityUtils.toString(reponse.getEntity());

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  jsonDeResposta;

    }

    @Override
    protected String doInBackground(String... params) {
        return post(params[0]);
    }
}
