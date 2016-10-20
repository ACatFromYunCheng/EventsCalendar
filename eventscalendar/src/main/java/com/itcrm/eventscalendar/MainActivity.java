package com.itcrm.eventscalendar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.riontech.calendar.CustomCalendar;
import com.riontech.calendar.dao.EventData;
import com.riontech.calendar.dao.dataAboutDate;

import java.util.ArrayList;

/**
 * 添加calendar依赖后
 * 还需要在MyApplication的build.gradle中添加如下引用
 * classpath 'com.github.dcendents:android-maven-gradle-plugin:1.4.1'
 */
public class MainActivity extends AppCompatActivity {

    private CustomCalendar customCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        customCalendar = (CustomCalendar) findViewById(R.id.customCalendar);
        customCalendar.setBackgroundColor(Color.parseColor("#FF0000"));
    }

    private void initData() {
        String[] arr = {"2016-09-10", "2016-09-11", "2016-09-15", "2016-08-16", "2016-06-25"};
        //1<=eventCount<=3
        for (int i = 0; i < 5; i++) {
            int eventCount = 3;
            customCalendar.addAnEvent(arr[i], eventCount, getEventDataList(eventCount));
        }
    }

    private ArrayList<EventData> getEventDataList(int eventCount) {
        ArrayList<EventData> eventDatas = new ArrayList<>();
        ArrayList<dataAboutDate> dataaboutDates = new ArrayList<>();
        EventData eventData;
        dataAboutDate dataaboutDate;
        eventData = new EventData();
        for (int i = 1; i <= eventCount; i++) {
            dataaboutDate = new dataAboutDate();
            dataaboutDate.setSubject("摘要" + i);
            dataaboutDate.setRemarks("主题" + i);
            dataaboutDate.setTitle("标题" + i);
            dataaboutDate.setSubmissionDate("SubmissionDate");
            dataaboutDates.add(dataaboutDate);

            eventData.setData(dataaboutDates);
        }
        eventDatas.add(eventData);
        return eventDatas;
    }
}
