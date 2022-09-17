package com.aquib.notes.repositories

import android.app.Application
import androidx.lifecycle.LiveData
import com.aquib.notes.db.NoteDatabase
import com.aquib.notes.db.dao.NoteDao
import com.aquib.notes.db.model.Note


class NoteRepository(private val noteDao: NoteDao) {

    private val allNotes: LiveData<List<Note>> = noteDao.getAllNotes()

    suspend fun insert(note: Note) {
        noteDao.insert(note)
    }

    suspend fun update(note: Note) {
        noteDao.update(note)
    }

    suspend fun delete(note: Note) {
        noteDao.delete(note)
    }

    suspend fun deleteAllNotes() {
        noteDao.deleteAllNotes()
    }

    fun getAllNotes(): LiveData<List<Note>> = allNotes

}