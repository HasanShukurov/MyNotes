package com.hasanshukurov.toolbarnumune.dependencyinjection

import android.content.Context
import androidx.room.Room
import com.hasanshukurov.toolbarnumune.repo.NoteRepository
import com.hasanshukurov.toolbarnumune.room.NoteDao
import com.hasanshukurov.toolbarnumune.room.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun injectRepo(noteDao: NoteDao) = NoteRepository(noteDao)

    @Provides
    @Singleton
    fun noteDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(context,NoteDatabase::class.java,"NoteDB").build()

    @Provides
    @Singleton
    fun noteDao(db: NoteDatabase) = db.noteDao()


}