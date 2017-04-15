package com.example.carlos.rubric;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class conenido2 extends AppCompatActivity {
    private ViewGroup layout;
    private ScrollView scrollView;
    ArrayList<RelativeLayout> relativeLayout=new ArrayList();
    ArrayList<Intent> intents=new ArrayList();
    EditText text,text2,text3,text4,tm;
    TextView tv;
    CheckBox chek;
    int id,tam=0,n,ii=1;
    String var="",num="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conenido2);
        layout = (ViewGroup) findViewById(R.id.content);
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        tv=(TextView) findViewById(R.id.textView2);
        tv.setText(getIntent().getStringExtra("name"));
        var=getIntent().getStringExtra("niveles");
        tam=Integer.parseInt(var);
        for(int i=0;i<tam;i++) {
            addChild(ii);
            ii++;
        }
    }
    public void remove(){
        int i=0;
        while(i<relativeLayout.size()) {
            chek=(CheckBox) relativeLayout.get(i).findViewById(R.id.delet);
            if (chek.isChecked()) {
                layout.removeViewAt(i);
                relativeLayout.remove(i);
                i=0;
            }else{
                i++;
            }
        }
    }

    private void addChild(int i) {
        LayoutInflater inflater = LayoutInflater.from(this);
        id = R.layout.level;
        RelativeLayout rl= (RelativeLayout) inflater.inflate(id, null, false);
        text= (EditText) rl.findViewById(R.id.editText);
        text.setText("Nivel "+(i));
        relativeLayout.add(rl);
        layout.addView(rl);
    }

    public void delet(View view) {
        remove();
    }

    public void end(View view) {
        finish();
    }

}
