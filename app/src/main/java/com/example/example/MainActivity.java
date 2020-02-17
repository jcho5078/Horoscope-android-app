package com.example.example;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

//https://kwongyo.tistory.com/5 푸쉬알람 만드는법!!!!!!!!!!!
//https://codeman77.tistory.com/29 설정값 유지시키는법!!!!!!
public class MainActivity extends AppCompatActivity {

    static  Calendar calendar = Calendar.getInstance();
    private SharedPreferences appData;
    public static int save_year = calendar.get(Calendar.YEAR);
    public static int save_month = calendar.get(Calendar.MONTH);
    public static int save_date = calendar.get(Calendar.DATE);
    public static int save_hour = 0;
    public static int save_min = 0;

    DatePickerDialog dialog;
    TimePickerDialog timedialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent serviceIntent = new Intent(this.getBaseContext(),TestService.class);
        this.startService(serviceIntent);



        dialog = new DatePickerDialog(this, listener, save_year, save_month, save_date);
        timedialog = new TimePickerDialog(this, timeSetListener, save_hour, save_min, true);

        //설정값 저장
        appData = getSharedPreferences("appData", MODE_PRIVATE);
        load();


    }

    public void SaveDate(View view) {
        dialog.show();
    }

    public  void SaveTime(View view){timedialog.show();}

    private void save() {
        // SharedPreferences 객체만으론 저장 불가능 Editor 사용
        SharedPreferences.Editor editor = appData.edit();

        // 저장시킬 이름이 이미 존재하면 덮어씌우기", save_month);
        editor.putInt("YEAR", save_year);
        editor.putInt("MONTH", save_month);
        editor.putInt("DATE", save_date);
        editor.putInt("HOUR", save_hour);
        editor.putInt("MIN", save_min);

        // apply, commit 내용저장
        editor.apply();
    }

    private void load() {
        // SharedPreferences 객체.get타입( 저장된 이름, 기본값 )
        // 저장된 이름이 존재하지 않을 시 기본값
        MainActivity.save_year = appData.getInt("YEAR", calendar.get(Calendar.YEAR));
        MainActivity.save_month = appData.getInt("MONTH", calendar.get(Calendar.MONTH));
        MainActivity.save_date = appData.getInt("DATE", calendar.get(Calendar.DATE));//기본값은 현재 오늘날짜
        MainActivity.save_hour = appData.getInt("HOUR", calendar.get(Calendar.HOUR));
        MainActivity.save_min = appData.getInt("MIN", calendar.get(Calendar.MINUTE));
    }


    //날짜 다이어로그
    private DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int date) {
            MainActivity.save_year = year;
            MainActivity.save_month = month;
            MainActivity.save_date = date;
            save();
            Toast.makeText(getApplicationContext(), "생일설정이 "+year + "년" + (month+1) + "월" + date +"일 으로 설정되었습니다.", Toast.LENGTH_SHORT).show();
        }
    };

    private TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            MainActivity.save_hour = hourOfDay;
            MainActivity.save_min = minute;
            save();
            Toast.makeText(getApplicationContext(), "알람설정이 "+ hourOfDay + "시 " + minute + "분 으로 설정되었습니다.", Toast.LENGTH_SHORT).show();
        }
    };

    //다른페이지 이동하기!!!!!!!!!!!!!!!!!!
    public void GotoSub1(View view) {
        Intent intent = new Intent(getApplicationContext(), Num1Activity.class);
        startActivity(intent);
    }

    public void GotoSub2(View view) {
        Intent intent = new Intent(getApplicationContext(), Num2Activity.class);
        startActivity(intent);
    }

    public void GotoSub3(View view) {
        Intent intent = new Intent(getApplicationContext(), Num3Activity.class);
        startActivity(intent);
    }

    public void GotoSub4(View view) {
        Intent intent = new Intent(getApplicationContext(), Num4Activity.class);
        startActivity(intent);
    }

    public void GotoSub5(View view) {
        Intent intent = new Intent(getApplicationContext(), Num5Activity.class);
        startActivity(intent);
    }

    public void GotoSub6(View view) {
        Intent intent = new Intent(getApplicationContext(), Num6Activity.class);
        startActivity(intent);
    }

    public void GotoSub7(View view) {
        Intent intent = new Intent(getApplicationContext(), Num7Activity.class);
        startActivity(intent);
    }

    public void GotoSub8(View view) {
        Intent intent = new Intent(getApplicationContext(), Num8Activity.class);
        startActivity(intent);
    }

    public void GotoSub9(View view) {
        Intent intent = new Intent(getApplicationContext(), Num9Activity.class);
        startActivity(intent);
    }

    public void GotoSub10(View view) {
        Intent intent = new Intent(getApplicationContext(), Num10Activity.class);
        startActivity(intent);
    }

    public void GotoSub11(View view) {
        Intent intent = new Intent(getApplicationContext(), Num11Activity.class);
        startActivity(intent);
    }

    public void GotoSub12(View view) {
        Intent intent = new Intent(getApplicationContext(), Num12Activity.class);
        startActivity(intent);
    }
}