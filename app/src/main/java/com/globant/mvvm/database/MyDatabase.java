package com.globant.mvvm.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by mahesh.chakkarwar on 09/02/18.
 */
@Database(entities = {User.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase{

    public abstract UserDao userDao();
}
