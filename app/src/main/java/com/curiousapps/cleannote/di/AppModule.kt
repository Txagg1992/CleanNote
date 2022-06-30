package com.curiousapps.cleannote.di

import android.app.Application
import androidx.room.Room
import com.curiousapps.cleannote.feature_note.data.data_source.NoteDataBase
import com.curiousapps.cleannote.feature_note.data.repository.NoteRepositoryImpl
import com.curiousapps.cleannote.feature_note.domain.repo.NoteRepository
import com.curiousapps.cleannote.feature_note.domain.use_case.DeleteNoteUseCase
import com.curiousapps.cleannote.feature_note.domain.use_case.GetNotesUseCase
import com.curiousapps.cleannote.feature_note.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDataBase(app: Application): NoteDataBase{
        return Room.databaseBuilder(
            app,
            NoteDataBase::class.java,
            NoteDataBase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDataBase): NoteRepository{
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases{
        return NoteUseCases(
            getNotes = GetNotesUseCase(repository),
            deleteNote = DeleteNoteUseCase(repository)
        )
    }


}