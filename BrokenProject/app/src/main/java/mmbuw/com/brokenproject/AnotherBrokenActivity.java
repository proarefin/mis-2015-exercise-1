package mmbuw.com.brokenproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import mmbuw.com.brokenproject.R;

public class AnotherBrokenActivity extends Activity {

    private TextView txtURL;
    private TextView htmlResponse;
    private Button connect;

    private String WebURL = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another_broken);

        txtURL = (TextView) findViewById(R.id.txtUrl);
        htmlResponse = (TextView) findViewById(R.id.htmlResponse);
        connect = (Button) findViewById(R.id.connect);

        Intent intent = getIntent();
        String message = intent.getStringExtra(BrokenActivity.EXTRA_MESSAGE);
        //What happens here? What is this? It feels like this is wrong.
        //Maybe the weird programmer who wrote this forgot to do something?

        Context context = getApplicationContext();
        CharSequence text = "Another : " + message;
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);

        toast.show();

        WebURL = "http://" + message;
        txtURL.setText(WebURL.toString());

        connect.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                Context context = getApplicationContext();
                CharSequence text = "Trying to connect";
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);

                toast.show();

                String output = fetchHTML(WebURL.toString()).toString();

                if(output == "" || output == null){
                    output = "URL Not Found";
                }

                htmlResponse.setText(output);

            }
        });

    }

    private String fetchHTML(String URL){

        String response = "";

        DefaultHttpClient user = new DefaultHttpClient();

        try {

            HttpGet req = new HttpGet(URL);
            HttpResponse _response = user.execute(req);

            int status = _response.getStatusLine().getStatusCode();

            if(status == HttpStatus.SC_OK){
                HttpEntity entity = _response.getEntity();

                if(entity != null){
                    response = EntityUtils.toString(entity);
                    return response;
                }
                else{
                    return null;
                }
            }

        }catch(ClientProtocolException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }catch(IllegalStateException e){
            e.printStackTrace();
        }


        return response;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.another_broken, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void fetchHTML(View view) throws IOException {


    }
}
