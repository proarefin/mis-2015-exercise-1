// MIS Exercise 1
// Bauhaus
package mmbuw.com.brokenproject;
//All bugs fixed
//All are
// solved


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;


public class BrokenActivity extends Activity {

    public static String EXTRA_MESSAGE = "URL";

    private EditText AuntEdit;
    private Button goUrl;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broken);
        AuntEdit = (EditText) findViewById(R.id.edittext);
        goUrl = (Button) findViewById(R.id.goUrl);

        intent = new Intent(this,AnotherBrokenActivity.class);

        Context context = getApplicationContext();
        CharSequence text = "Broken Activity Start";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);

        toast.show();

        // android:onClick="brokenFunction"

        goUrl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

                Context context = getApplicationContext();
                CharSequence text = AuntEdit.getText().toString();
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);

                toast.show();

                System.out.println("If this appears in your console, you fixed a bug.");
                intent.putExtra(EXTRA_MESSAGE,AuntEdit.getText().toString());
                //String message = "This string will be passed to the new activity";
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.broken, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        /*int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        } */
        return super.onOptionsItemSelected(item);
    }




    public void brokenFunction(View v) {
        //I was once, perhaps, possibly a functioning function

        if (AuntEdit.getText().toString().equals("Timmy")) {
            System.out.println("Timmy fixed a bug!");



    //fetchHTML(V);
            //WebView myWebView = (WebView) findViewById(R.id.webview);
            //myWebView.loadUrl("http://www.google.com");



            Context context = getApplicationContext();
            CharSequence text = "Broken Function Triggered";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);

            toast.show();




        System.out.println("If this appears in your console, you fixed a bug.");
            Intent intent = new Intent(this,AnotherBrokenActivity.class);
        //String message = "This string will be passed to the new activity";
            startActivity(intent);
    }
}
}