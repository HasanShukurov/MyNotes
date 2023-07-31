package com.hasanshukurov.toolbarnumune.room

import androidx.room.*
import com.hasanshukurov.toolbarnumune.model.NotesModel

@Dao
interface NoteDao {

    @Query("SELECT * FROM noteTable")
    suspend fun allNotes() :List<NotesModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(note: NotesModel)

    @Delete
    suspend fun deleteNote(note: NotesModel)

    @Update
    suspend fun replaceNote(note: NotesModel)

    @Query("SELECT * FROM noteTable WHERE title like '%' || :searchText || '%'")
    suspend fun searchNote(searchText: String) : List<NotesModel>


}