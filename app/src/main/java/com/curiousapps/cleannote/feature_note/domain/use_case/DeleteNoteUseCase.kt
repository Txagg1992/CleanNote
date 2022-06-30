package com.curiousapps.cleannote.feature_note.domain.use_case

import com.curiousapps.cleannote.feature_note.domain.model.Note
import com.curiousapps.cleannote.feature_note.domain.repo.NoteRepository

class DeleteNoteUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note){
        repository.deleteNote(note)
    }
}