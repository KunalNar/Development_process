package com.example.developmentprocess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Page2 extends AppCompatActivity {
    int preSelectedIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        ListView listView = (ListView) findViewById(R.id.listview);


        final List<Usermodel> users = new ArrayList<>();
        users.add(new Usermodel(false, "Have I read the entire requirement document?"));
        users.add(new Usermodel(false, "Is the requirement clear, including the main purpose it will solve?"));
        users.add(new Usermodel(false, "Is the algorithm and logic written on paper/notepad?"));
        users.add(new Usermodel(false, "Will my logic have any impact on other working areas of code, If yes have I written down the impacting areas to check later"));
        users.add(new Usermodel(false, "Is the work broken down into small modules"));
        users.add(new Usermodel(false, "Is the structure of classes/methods written down on paper/notepad"));
        users.add(new Usermodel(false, "Have I taken pull of main branch and created sub-branch"));
        users.add(new Usermodel(false, "Are there any corner cases/ negative scenarios missing"));
        users.add(new Usermodel(false, "if multiple developers are working on same project, have I done an internal discussion to clear the understanding about conflicts & work split"));
        users.add(new Usermodel(false, "Can the functionality be scaled easily without causing impact ex. payment integration - addition of any new payment type should cause no impact on existing payment types"));




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
