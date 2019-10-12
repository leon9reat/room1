package com.medialink.room1.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.medialink.room1.model.Item;

import java.util.List;

@Dao
public interface ItemDAO {
    @Insert
    public void insert(Item... items);

    @Update
    public void update(Item... items);

    @Delete
    public void delete(Item... items);

    @Query("SELECT * FROM items")
    public List<Item> getItems();

    @Query("SELECT * FROM items WHERE id = :id")
    public Item getItemById(Long id);

}
