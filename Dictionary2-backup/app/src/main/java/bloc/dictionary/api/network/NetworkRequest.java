package bloc.dictionary.api.network;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Austin on 12/28/2015.
 */
public class NetworkRequest{
    public static final int ERROR_NO_WORD_FOUND = 1;
    private int errorCode;

    protected void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    private class callAPI extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            String urlString = params[0];

            String resultToDisplay = "";

            InputStream in = null;

            //network request
            try {
                URL url = new URL(urlString);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                in = new BufferedInputStream(urlConnection.getInputStream());


            } catch (Exception e) {
                System.out.println(e.getMessage());
                return e.getMessage();
            }
            return resultToDisplay;
        }
    }
}
