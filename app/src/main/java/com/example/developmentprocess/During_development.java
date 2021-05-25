package com.example.developmentprocess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class During_development extends AppCompatActivity {

    int preSelectedIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_during_development);


        ListView listView = (ListView) findViewById(R.id.listview);


        final List<Usermodel> users = new ArrayList<>();
        users.add(new Usermodel(false, "Is my class/method having only 1 specific functionality?"));
        users.add(new Usermodel(false, "Am I following coding standards and naming conventions?"));
        users.add(new Usermodel(false, "Can I reuse the existing code? If not, is the code I am writing be reused in the future?"));
        users.add(new Usermodel(false, "Can my code be understood by my peers? Can the code review be easily done?"));
        users.add(new Usermodel(false, "Have I used the debugger to check each Line of my code"));
        users.add(new Usermodel(false, "Have I tested all possible values of variables during debugging in prior point"));
        users.add(new Usermodel(false, "Have I updated the task in time tracker sheet"));


        final Adapter adapter = new Adapter(this, users);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Usermodel model = users.get(i);

                if (model.isSelected())
                    model.setSelected(false);

                else
                    model.setSelected(true);
                users.set(i, model);
                adapter.updateRecords(users);



            }
        });

    }
}
