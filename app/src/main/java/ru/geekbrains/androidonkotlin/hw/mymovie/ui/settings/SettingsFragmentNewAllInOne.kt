package ru.geekbrains.androidonkotlin.hw.mymovie.ui.settings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import ru.geekbrains.androidonkotlin.hw.mymovie.R

class SettingsFragmentNewAllInOne : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}