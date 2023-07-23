package com.hasanshukurov.toolbarnumune.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hasanshukurov.toolbarnumune.model.NotesModel

@Database(entities = [NotesModel::class], version = 1)
abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao() : NoteDao
}