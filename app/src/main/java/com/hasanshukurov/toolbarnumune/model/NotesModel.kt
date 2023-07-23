package com.hasanshukurov.toolbarnumune.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "noteTable")
data class NotesModel(

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "note")
    val note: String,

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null

    ) : java.io.Serializable
