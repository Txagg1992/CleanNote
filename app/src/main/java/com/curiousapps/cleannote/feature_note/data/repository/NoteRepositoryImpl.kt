package com.curiousapps.cleannote.feature_note.data.repository

import com.curiousapps.cleannote.feature_note.data.data_source.NoteDao
import com.curiousapps.cleannote.feature_note.domain.model.Note
import com.curiousapps.cleannote.feature_note.domain.repo.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val dao: NoteDao
):  NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note)
    }


}