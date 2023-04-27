package com.example.via_gmaps

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley


class http_api : AppCompatActivity() {
    private lateinit var queue: RequestQueue;
    private val TAG = "HTTPAPI"

    override fun onCreate(savedInstanceState: Bundle?) {
        var res: String
        super.onCreate(savedInstanceState)

        queue = Volley.newRequestQueue(this);
        val url = "https://jsonplaceholder.typicode.com/todos"

        val jsonRequest = JsonObjectRequest(url,null,
            { response ->
                res = "good"
            },
            {res = "bad" })
        jsonRequest.setTag(TAG)

        queue.add(jsonRequest)
    }

    override fun onStop() {
        super.onStop()
        queue.cancelAll(TAG);
    }
}