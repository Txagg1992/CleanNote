package com.curiousapps.cleannote.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.curiousapps.cleannote.feature_note.domain.util.NoteOrder
import com.curiousapps.cleannote.feature_note.domain.util.OrderType

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    onOrderChange: (NoteOrder) -> Unit
){
    Column(
        modifier = modifier
    ){
        Row(
            modifier = Modifier.fillMaxWidth()
        ){
            DefaultRadiobutton(
                text = "Title",
                selected = noteOrder is NoteOrder.Title,
                onselect = {onOrderChange(NoteOrder.Title(noteOrder.orderType))}
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadiobutton(
                text = "Date",
                selected = noteOrder is NoteOrder.Date,
                onselect = {onOrderChange(NoteOrder.Date(noteOrder.orderType))}
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadiobutton(
                text = "Color",
                selected = noteOrder is NoteOrder.Color,
                onselect = {onOrderChange(NoteOrder.Color(noteOrder.orderType))}
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ){
            DefaultRadiobutton(
                text = "Ascending",
                selected = noteOrder.orderType is OrderType.Ascending,
                onselect = {
                    onOrderChange(noteOrder.copy(OrderType.Ascending))}
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadiobutton(
                text = "Descending",
                selected = noteOrder.orderType is OrderType.Descending,
                onselect = {
                    onOrderChange(noteOrder.copy(OrderType.Descending))}
            )
        }

    }
}