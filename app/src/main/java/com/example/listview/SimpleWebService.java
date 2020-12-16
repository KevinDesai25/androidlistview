package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SimpleWebService extends AppCompatActivity {

    TextView tvResult;
    Button btSubmit;
    EditText etUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_web_service);

        //find
        btSubmit = findViewById(R.id.btSubmit);
        tvResult = findViewById(R.id.tvResult);
        etUserName = findViewById(R.id.etUserName);

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RequestQueue requestQueue = Volley.newRequestQueue(SimpleWebService.this);

                StringRequest request = new StringRequest(Request.Method.POST, "http://192.168.0.101/myservice/myser.php",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                try {
                                    JSONObject obj = new JSONObject(response);

                                    JSONObject subObj = obj.getJSONObject("product");

                                    String name = subObj.getString("name");
                                    String price = subObj.getString("price");
                                    tvResult.setText(" Name of product  = " + name+ "\n Price of the Product = "+ price);

                                } catch (JSONException e) {
                                    Log.e("json", e.getMessage());
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        tvResult.setText(error.getMessage());
                    }
                }) {

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String, String> params = new HashMap<>();
                        params.put("user", etUserName.getText().toString());

                        Log.e("serveice call", "getParams: " + params);
                        return params;
                    }
                };

                try {
                    requestQueue.add(request);
                    Toast.makeText(SimpleWebService.this, "Calling service", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    tvResult.setText("catch :" + e.getMessage());
                }

            }
        });
    }
}
