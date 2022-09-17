package com.aquib.notes.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.aquib.notes.db.NoteDatabase
import com.aquib.notes.db.model.Note
import com.aquib.notes.repositories.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application): AndroidViewModel(application) {

    private val noteRepository: NoteRepository

    val allNotes: LiveData<List<Note>>

    init {
        val noteDao = NoteDatabase.getInstance(application).noteDao()
        noteRepository = NoteRepository(noteDao)

        allNotes = noteRepository.getAllNotes()
    }

    // Launching a new coroutine to insert the data in a non-blocking way
    fun insert(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        noteRepository.insert(note)
    }

    fun update(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        noteRepository.update(note)
    }

    fun delete(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        noteRepository.delete(note)
    }

    fun deleteAllNotes() = viewModelScope.launch(Dispatchers.IO) {
        noteRepository.deleteAllNotes()
    }


}