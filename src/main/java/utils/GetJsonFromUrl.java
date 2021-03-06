package utils;


import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import java.io.IOException;


public class GetJsonFromUrl {


    public HttpResponse http (String url, String body, String login, String password){

        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            //HttpPost request = new HttpPost(url);
            HttpGet request = new HttpGet(url+body);
            StringEntity params = new StringEntity(body);
           // request.addHeader("content-type", "application/json");
            request.addHeader("Authorization", "Basic " + encodeCreds(login, password));
            //request.setEntity(params);
            HttpResponse result = httpClient.execute(request);
            String json = EntityUtils.toString(result.getEntity(), "UTF-8");

            com.google.gson.Gson gson = new com.google.gson.Gson();
            Response respuesta = gson.fromJson(json, Response.class);

            System.out.println(respuesta.getExample());
            System.out.println(respuesta.getFr());

        } catch (IOException ex) {
        }
        return null;
    }

    public class Response{

        private String example;
        private String fr;

        public String getExample() {
            return example;
        }
        public void setExample(String example) {
            this.example = example;
        }
        public String getFr() {
            return fr;
        }
        public void setFr(String fr) {
            this.fr = fr;
        }
    }

    public String encodeCreds(String login, String password){
        String creds = login + ":" + password;
        byte[] authEncBytes = Base64.encodeBase64(creds.getBytes());
        return new String(authEncBytes);
    }


}
