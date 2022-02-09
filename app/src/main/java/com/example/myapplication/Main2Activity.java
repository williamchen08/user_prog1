package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;


public class Main2Activity extends AppCompatActivity {

    private Button send_btn;
    private EditText set_miles;
    public int ddd;

    class Data {
        int photo;
        String name;
    }

    public class MyAdapter extends BaseAdapter {
        private Main2Activity.Data[] data;
        private int veiw;
        public MyAdapter (Main2Activity.Data[] data , int veiw){
            this.data = data;
            this.veiw = veiw;
        }
        @Override
        public  int getCount(){
            return data.length;
        }
        @Override
        public Object getItem(int position){
            return data[position];
        }
        @Override
        public long getItemId(int position){
            return 0;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            convertView = getLayoutInflater().inflate(veiw,parent,false);
            TextView name = convertView.findViewById(R.id.name);
            name.setText(data[position].name);
            ImageView imageView= convertView.findViewById(R.id.imageView);
            imageView.setImageResource(data[position].photo);
            return convertView;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //create spinner
        String[] transNameArray = new String[]{"Walking","Boosted Mini S Board","Evolve Bamboo GTR 2in1","OneWheel XR", "MotoTec Skateboard", "Segway Ninebot S", "Segway Ninebot S-PLUS", "Razor Scooter", "GeoBlade 500", "Hovertrax Hoverboard"};
        int [] transPhotoArray = new  int[]{R.drawable.walking,R.drawable.boostedmini,R.drawable.gtr,R.drawable.onewheelxr, R.drawable.mototec,R.drawable.ninebot, R.drawable.ninebotplus, R.drawable.scooter, R.drawable.geoblade, R.drawable.hoverboard};
        Data[] transData = new  Data[transNameArray.length];
        for(int i=0;i<transData.length;i++){
            transData[i] = new Data();
            transData[i].name = transNameArray[i];
            transData[i].photo = transPhotoArray[i];
        }
        MyAdapter transAdapter = new MyAdapter(transData,R.layout.trans_list);
        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(transAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ddd = parent.getSelectedItemPosition();   ///get the selected element place id
//                textView1.setText("Position of selected element: "+String.valueOf(getid));
//                String getvalue = String.valueOf(parent.getItemAtPosition(position));   // getting the selected element value
//                textView2.setText("Value of Selected Spinner : "+getvalue);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

//        ddd = spinner.getSelectedItemPosition();

        send_btn = findViewById(R.id.btn_send);
        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                set_drink = findViewById(R.id.ed_drink);
                set_miles = findViewById(R.id.ed_mile);
                Editable miles = set_miles.getText();
                Intent i = new Intent();
                Bundle b = new Bundle();
//                b.putString("suger",suger);
                b.putString("drink", String.valueOf(ddd));
//                b.putString("ice",ice_opt);
                b.putString("ice", String.valueOf(miles));
                i.putExtras(b);
                setResult(101,i);
                finish();
            }

        });

    }


}