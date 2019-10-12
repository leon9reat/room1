package com.medialink.room1;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.medialink.room1.dao.ItemDAO;
import com.medialink.room1.model.Item;

@Database(entities = {Item.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ItemDAO getItemDAO();
}
