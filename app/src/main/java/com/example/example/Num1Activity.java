package com.example.example;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Num1Activity extends AppCompatActivity {

    String url = "http:운세.asia/물병자리";
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_num1);
        new Num1Activity.Descrip().execute();
    }

    private class Descrip extends AsyncTask<Void, Void, Void> {
        String date;
        String desc;
        String desc2;
        String desc3;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(Num1Activity.this);
            mProgressDialog.setTitle("Wait please");
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Document document = Jsoup.connect(url).get();
                Elements dateToday = document
                        .select("body > div.container > div.wrapper > div.gray_back > div.content > div.wrap2 > h4");
                Elements description = document
                        .select("body > div.container > div.wrapper > div.gray_back > div.content > div.wrap2 > p:nth-child(12)");
                Elements description2 = document
                        .select("body > div.container > div.wrapper > div.gray_back > div.content > div.wrap2 > p:nth-child(15)");
                Elements description3 = document
                        .select("body > div.container > div.wrapper > div.gray_back > div.content > div.wrap2 > p:nth-child(16)");
                //select("meta[name=description]"); 원본
                //select("div[class=wrap2]").select("p")      ==>이걸로 운세사이트 크롤링 한번 해보자!
                // Locate the content attribute
                date = String.valueOf(dateToday.text());
                desc = String.valueOf(description.text());// ==> 요주의 코드@@@@@@@@@@@@@@@@@
                desc2 = String.valueOf(description2.text());
                desc3 = String.valueOf(description3.text());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            TextView textView_date = (TextView) findViewById(R.id.textView_date);
            TextView textView_contents = (TextView) findViewById(R.id.textView_contents);
            TextView textView_contents2 = (TextView) findViewById(R.id.textView_contents2);
            TextView textView_contents3 = (TextView) findViewById(R.id.textView_contents3);

            textView_date.setText(date);
            textView_contents.setText(desc);
            textView_contents2.setText(desc2);
            textView_contents3.setText(desc3);

            mProgressDialog.dismiss();
        }
    }
}
