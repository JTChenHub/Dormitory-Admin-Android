package com.example.week9text;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ExpandableListViewTest extends Activity  
{  
    @Override  
    public void onCreate(Bundle savedInstanceState)  
    {  
        super.onCreate(savedInstanceState);  
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.list_layout);  
        //����һ��BaseExpandableListAdapter����  
        ExpandableListAdapter adapter = new BaseExpandableListAdapter()  
        {  
            int[][] logos = new int[][]  
            {  
                {R.drawable.b1,R.drawable.b1,R.drawable.b1,R.drawable.b1},
                {R.drawable.b2,R.drawable.b2,R.drawable.b2,R.drawable.b2},  
                {R.drawable.b3,R.drawable.b3,R.drawable.b3 }
            };  
            private String[] CDs = new String[]  
                { "5A317", "5A318", "5A319"
//            		,"����","�Ϻ�","�㽭","����","����","����","ɽ��"
            		};  
            private String[][] songs = new String[][]  
            {   
                { "�½���", "��ʱ��", "������", "·����" },  
                { "����", "��˹", "����", "����" },  
                { "�԰�", "�ð���" , "����ɽ" }
//                ,  
//                { "����" },  
//                { "�Ϻ�" },  
//                { "����" },  
//                { "�Ͼ�"},  
//                { "����"},  
//                { "����"},  
//                { "�ൺ"},  
//                { "�ൺ"} 
            };  
            //��ȡָ����λ�á�ָ�����б�������б�������  
            @Override  
            public Object getChild(int groupPosition, int childPosition)  
            {  
                return songs[groupPosition][childPosition];  
            }  
            @Override  
            public long getChildId(int groupPosition, int childPosition)  
            {  
                return childPosition;  
            }  
            @Override  
            public int getChildrenCount(int groupPosition)  
            {  
                return songs[groupPosition].length;  
            }  
            private TextView getTextView()  
            {  
                //����ʵ����Ŀ�������б�Ļ���. ������б�û�пռ�Ķ��塣 ���磬���������������������ʽ������Ƶ���ʽ��ʾ��������Ϊ��ջ�ȵ�  
                AbsListView.LayoutParams lp = new AbsListView.LayoutParams(  
                        ViewGroup.LayoutParams.FILL_PARENT, 64);  //���ÿ�͸�   
                TextView textView = new TextView(ExpandableListViewTest.this);  
                textView.setLayoutParams(lp);  
                textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);  
                textView.setPadding(36, 0, 0, 0);  
                textView.setTextSize(20);  
                return textView;  
            }  
            //�÷�������ÿ����ѡ������  
            @Override  
            public View getChildView(int groupPosition, int childPosition,  
                    boolean isLastChild, View convertView, ViewGroup parent)  
            {  
                  
               
                LinearLayout ll = new LinearLayout(ExpandableListViewTest.this);  
                ll.setOrientation(0);  
                ImageView logo = new ImageView(ExpandableListViewTest.this);  
                logo.setImageResource(logos[groupPosition][childPosition]);  
                ll.addView(logo);  
                TextView textView = getTextView();            
                textView.setText(" "+getChild(groupPosition, childPosition).toString());                
                ll.addView(textView);             
                return ll;  
            }  
            //��ȡָ����λ�ô���������  
            @Override  
            public Object getGroup(int groupPosition)  
            {  
                return CDs[groupPosition];  
            }  
            @Override  
            public int getGroupCount()  
            {  
                return CDs.length;  
            }  
            @Override  
            public long getGroupId(int groupPosition)  
            {  
                return groupPosition;  
            }  
            //�÷�������ÿ����ѡ������  
            @Override  
            public View getGroupView(int groupPosition, boolean isExpanded,  
                    View convertView, ViewGroup parent)  
            {  
                LinearLayout ll = new LinearLayout(ExpandableListViewTest.this);  
                ll.setOrientation(0);  
                ImageView logo = new ImageView(ExpandableListViewTest.this);  
 //               logo.setImageResource(logos[groupPosition]);  
//                ll.addView(logo);  
                TextView textView = getTextView();  
                textView.setText(getGroup(groupPosition).toString());                 
                ll.addView(textView);             
                return ll;  
            }  
            @Override  
            public boolean isChildSelectable(int groupPosition, int childPosition)  
            {  
                return true;  
            }  
            @Override  
            public boolean hasStableIds()  
            {  
                return true;  
            }
			
        };  
        ExpandableListView expandListView = (ExpandableListView)  
            findViewById(R.id.list);  
        expandListView.setAdapter(adapter);  
    }  
}  