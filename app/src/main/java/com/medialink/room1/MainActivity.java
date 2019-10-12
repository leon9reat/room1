package com.medialink.room1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.medialink.room1.dao.ItemDAO;
import com.medialink.room1.model.Item;

import java.util.List;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener {
    
    private Button btnInsert, btnLoad;
    private AppDatabase database;
    private ItemDAO itemDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnInsert = findViewById(R.id.btn_insert);
        btnLoad = findViewById(R.id.btn_load);

        btnInsert.setOnClickListener(this);
        btnLoad.setOnClickListener(this);

        database = Room.databaseBuilder(this, AppDatabase.class, "mydb")
                .allowMainThreadQueries()
                .build();
        itemDAO = database.getItemDAO();
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_insert:
                Item item = new Item();
                item.setName("Item001");
                item.setDescription("Item 001");
                item.setQuantity(1000L);

                itemDAO.insert(item);
                break;
            case R.id.btn_load:
                List<Item> items = itemDAO.getItems();
                System.out.println(items.size());
                break;
        }
    }
}
