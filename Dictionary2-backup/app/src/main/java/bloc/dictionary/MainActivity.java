package bloc.dictionary;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    EditText searchInputOne;
    EditText searchInputTwo;
    EditText searchInputThree;
    EditText searchInputFour;
    EditText searchInputFive;
    String wordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = MainActivity.this.getApplicationContext();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        searchInputOne = new EditText(MainActivity.this);
        searchInputOne = (EditText) findViewById(R.id.field_one);

        searchInputOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText input = searchInputOne;
                wordInput = input.getText().toString();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Add edittext field", Toast.LENGTH_LONG).show();
            }
        });

        Button searchButton = (Button) findViewById(R.id.search_button);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String serverURL = "http://dictionaryapi.net/api/definition/" + wordInput;
                new GetAsyncTask().execute(serverURL);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class GetAsyncTask extends AsyncTask<String, Void, Void>{

        private String Content;
        private String Error = null;
        String data ="";
        int sizeData = 0;
        TextView jsonParsed = (TextView) findViewById(R.id.jsonParsed);

        @Override
        protected Void doInBackground(String... urls) {
            BufferedReader reader = null;

            try{
                URL url = new URL(urls[0]);
                URLConnection urlConnection = url.openConnection();
                urlConnection.setDoOutput(true);
                OutputStreamWriter streamWriter = new OutputStreamWriter(urlConnection.getOutputStream());
                streamWriter.write(data);
                streamWriter.flush();

               BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line = null;

                while((line = reader.readLine()) != null){
                    stringBuilder.append(line + "");
                }

                Content = stringBuilder.toString();

            } catch (Exception e) {
                Error = e.getMessage();
            }
            finally
            {
                try{
                    reader.close();
                }
                catch(Exception e){}
            }
            return null;
        }
        protected void onPostExecute(Void unused){
            String outputData = "";
            JSONObject jsonResponse;

            try{
                jsonResponse = new JSONObject(Content);
                JSONArray jsonMainNode = jsonResponse.optJSONArray("Android");

                    int jsonArrayLength = jsonMainNode.length();
                for(int i = 0; i < jsonArrayLength; i++){
                    JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);

                    String word = jsonChildNode.optString("word").toString();
                    String partOfSpeech = jsonChildNode.optString("PartOfSpeech").toString();
                    String forms = jsonChildNode.optString("Forms").toString();
                    String definitions = jsonChildNode.optString("Definitions").toString();

                    outputData += " Word : "+ word +
                            "Part of Speech : "+ partOfSpeech +
                            "Form(s) : "+ forms +
                            "Definition(s) : " + definitions;
                    jsonParsed.setText(outputData);
                }
            }catch(Exception e){

            }
        }
    }
}

