package com.curiousapps.cleannote.feature_note.presentation.notes

import androidx.lifecycle.ViewModel
import com.curiousapps.cleannote.feature_note.domain.use_case.GetNotesUseCase
import com.curiousapps.cleannote.feature_note.domain.use_case.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val notesUseCases: NoteUseCases
): ViewModel(){


}