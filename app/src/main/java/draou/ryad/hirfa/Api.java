package draou.ryad.hirfa;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Api extends AsyncTask<String, Void, String>  {
    public final static String host = "http://10.0.3.2:8888/pfe";

    @Override
    protected String doInBackground(String... params) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        String result = null;
        try{
            URL url = new URL(host+"/hello.php?cat="+params[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStreamReader iStream = new InputStreamReader(connection.getInputStream());
            if (iStream == null) return null;
            reader = new BufferedReader(iStream);
            if (reader == null) return null;
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while((line = reader.readLine()) != null) stringBuffer.append(line);
            if(stringBuffer.length() == 0) return null;
            result = stringBuffer.toString();
        }catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        Log.d("TEST", "..................." + s);
    }
}
