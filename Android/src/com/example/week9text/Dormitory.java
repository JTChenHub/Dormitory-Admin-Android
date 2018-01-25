package com.example.week9text;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class Dormitory extends Activity {

	private Spinner buildingSpinner = null;  
    private Spinner floorSpinner = null;   
    private Spinner roomSpinner = null;    
    ArrayAdapter<String> buildingAdapter = null; 
    ArrayAdapter<String> floorAdapter = null;   
    ArrayAdapter<String> roomAdapter = null;
    static String buildingPosition = null;
    static String floorPosition = null;
    private String[] building = null;
    private String[] floor = null;
   
    private String[] room =null;
           

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dormitory);
        setSpinner();

    }

    private void setSpinner()
    {        
        buildingSpinner = (Spinner)findViewById(R.id.spin_buiding);
        floorSpinner = (Spinner)findViewById(R.id.spin_floor);
        roomSpinner = (Spinner)findViewById(R.id.spin_room);
        building=DAO.getBuildingList();
        //����������ֵ
        buildingAdapter = new ArrayAdapter<String>(Dormitory.this,
                android.R.layout.simple_spinner_item, building);
        buildingSpinner.setAdapter(buildingAdapter);
        buildingSpinner.setSelection(0,true);  //����Ĭ��ѡ����˴�ΪĬ��ѡ�е�4��ֵ
        
//        floorAdapter = new ArrayAdapter<String>(Dormitory.this, 
//                android.R.layout.simple_spinner_item, floor[3]);
//        floorSpinner.setAdapter(floorAdapter);
//        floorSpinner.setSelection(0,true);  //Ĭ��ѡ�е�0��
//        
//        roomAdapter = new ArrayAdapter<String>(Dormitory.this,
//                android.R.layout.simple_spinner_item, room[3][0]);
//        roomSpinner.setAdapter(roomAdapter);
//        roomSpinner.setSelection(0, true);
        
        
        //ʡ�����������
        buildingSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            // ��ʾѡ��ı��ʱ�򴥷��˷�������Ҫʵ�ְ취����̬�ı�ؼ��������İ�ֵ
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3)
            {
               
                
            	floor=DAO.getFloor(building[position]);
                floorAdapter = new ArrayAdapter<String>(
                		Dormitory.this, android.R.layout.simple_spinner_item,floor );
                // ���ö��������б��ѡ������������
                floorSpinner.setAdapter(floorAdapter);
                buildingPosition = building[position];   
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0)
            {

            }
            
        });
        
        
        
        floorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                    int position, long arg3)
            {
            	room=DAO.getRoom(buildingPosition,floor[position]);
                roomAdapter = new ArrayAdapter<String>(Dormitory.this,
                        android.R.layout.simple_spinner_item, room);
                roomSpinner.setAdapter(roomAdapter);
                floorPosition=floor[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0)
            {
                
            }
        });
        //������������
        roomSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                    int position, long arg3)
            {
            	room[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0)
            {
                
            }
        });
    }

  
   
}
