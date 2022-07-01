package com.curiousapps.cleannote.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.curiousapps.cleannote.ui.theme.*

@Entity
data class Note(

    val title: String,
    val content: String,
    val timeStamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
){
    companion object{
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink, Teal200)
    }
}

class InvalidNoteException(message: String): Exception(message)
