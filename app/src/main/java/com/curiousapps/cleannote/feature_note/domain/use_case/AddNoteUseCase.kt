package com.curiousapps.cleannote.feature_note.domain.use_case

import com.curiousapps.cleannote.feature_note.domain.model.InvalidNoteException
import com.curiousapps.cleannote.feature_note.domain.model.Note
import com.curiousapps.cleannote.feature_note.domain.repo.NoteRepository

class AddNoteUseCase(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note){
        if (note.title.isBlank()){
            throw InvalidNoteException("The title of the note cannot be empty.")
        }
        if (note.content.isBlank()){
            throw InvalidNoteException("The content of the note cannot be empty.")
        }

        repository.insertNote(note)

    }
}