package ru.geekbrains.androidonkotlin.hw.mymovie.ui.contacts

import android.app.Application
import android.provider.ContactsContract
import androidx.lifecycle.ViewModel
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.Contact
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.TestMoviesRepository
import ru.geekbrains.androidonkotlin.hw.mymovie.domain.interfaces.CallBack

class ContactsListViewModel(
    var app: Application,
    private val repository: TestMoviesRepository
) : ViewModel() {
    private val contentResolver by lazy { app.contentResolver }
    private val contacts = mutableListOf<Contact>()

    fun fetchData(callBack: CallBack<List<Contact>>) {
        val cursor = contentResolver.query(
            ContactsContract.Contacts.CONTENT_URI,
            null,
            null,
            null,
            ContactsContract.Contacts.DISPLAY_NAME + " ASC"
        )
        val safeCursor = cursor ?: return
        while (safeCursor.moveToNext()) {
            val displayName =
                safeCursor.getString(safeCursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
            contacts.add(Contact(displayName))
        }
        callBack.onResult(contacts)
        safeCursor.close()
    }

}