package ru.geekbrains.androidonkotlin.hw.mymovie

import android.Manifest
import android.app.SearchManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    // особый доступ к чувствительным данным
    private val contactsPermissionRequest =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (it) {
                // КОНТАКТЫ открываем только при наличии разрешения пользователя
                val navController = findNavController(R.id.nav_host_fragment)
                val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
                navController.navigate(R.id.contactsListFragment)
                drawerLayout.closeDrawer(GravityCompat.START)

            } else {
                val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
                drawerLayout.closeDrawer(GravityCompat.START)
                Toast.makeText(
                    applicationContext, getString(R.string.requestPermissionReadContactsSadlyText),
                    Toast.LENGTH_LONG
                ).show()
            }
        }

    private val locationPermissionRequest =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (it) {
                // КОНТАКТЫ открываем только при наличии разрешения пользователя
                val navController = findNavController(R.id.nav_host_fragment)
                val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
                navController.navigate(R.id.locationFragment)
                drawerLayout.closeDrawer(GravityCompat.START)

            } else {
                val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
                drawerLayout.closeDrawer(GravityCompat.START)
                Toast.makeText(
                    applicationContext, getString(R.string.requestPermissionLocationSadlyText),
                    Toast.LENGTH_LONG
                ).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, getString(R.string.testSnackebarText), Snackbar.LENGTH_LONG)
                .setAction(getString(R.string.testSnackebarActionText), null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_favorites, R.id.nav_ratings
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        val bottomNavView: BottomNavigationView = findViewById(R.id.nav_view_bottom)
        bottomNavView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        val manager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searItem = menu.findItem(R.id.menu_search)
        val searchView = searItem.actionView as SearchView
        searchView.setSearchableInfo(manager.getSearchableInfo(componentName))
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus()
                searchView.setQuery("", false)
                searItem.collapseActionView()
                val bundle = Bundle()
                bundle.putString("ARG_SEARCH", query?.trim())
                val navController = findNavController(R.id.nav_host_fragment)
                navController.navigate(R.id.searchFragment, bundle)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                //TODO("Not yet implemented")
                return false
            }
        })

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_search_history -> {
                val navController = findNavController(R.id.nav_host_fragment)
                navController.navigate(R.id.settingsFragmentNewAllInOne)
            }
            R.id.action_settings -> {
                val navController = findNavController(R.id.nav_host_fragment)
                navController.navigate(R.id.settingsFragmentNewAllInOne)
            }
            R.id.action_unwanted_content_list -> {
                val navController = findNavController(R.id.nav_host_fragment)
                navController.navigate(R.id.unwantedListFragment)
            }
            R.id.action_marked_as_adult_by_me_list -> {
                val navController = findNavController(R.id.nav_host_fragment)
                navController.navigate(R.id.markedAaaListFragment)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    fun onMenuAboutClick(item: MenuItem) {
        val navController = findNavController(R.id.nav_host_fragment)
        navController.navigate(R.id.aboutFragment)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
    }

    fun onMenuContactsListClick(item: MenuItem) {
        val navController = findNavController(R.id.nav_host_fragment)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_CONTACTS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            navController.navigate(R.id.contactsListFragment)
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            if (shouldShowRequestPermissionRationale(Manifest.permission.READ_CONTACTS)) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    Snackbar.make(
                        requireViewById(R.id.drawer_layout), // Parent view
                        getString(R.string.requestPermissionReadContactsText), // Message to show
                        Snackbar.LENGTH_LONG
                    )
                        .setAction(getString(R.string.requestPermissionActionText)) {
                            contactsPermissionRequest.launch(Manifest.permission.READ_CONTACTS)
                        }.show()
                }
            } else {
                contactsPermissionRequest.launch(Manifest.permission.READ_CONTACTS)
            }
        }
    }

    fun onMenuLocationClick(item: MenuItem) {
        val navController = findNavController(R.id.nav_host_fragment)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            navController.navigate(R.id.locationFragment)
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            if (shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION)) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    Snackbar.make(
                        requireViewById(R.id.drawer_layout), // Parent view
                        getString(R.string.requestPermissionLocationText), // Message to show
                        Snackbar.LENGTH_LONG
                    )
                        .setAction(getString(R.string.requestPermissionActionText)) {
                            locationPermissionRequest.launch(Manifest.permission.ACCESS_FINE_LOCATION)
                        }.show()
                }
            } else {
                locationPermissionRequest.launch(Manifest.permission.ACCESS_FINE_LOCATION)
            }
        }
    }

    fun onMenuMapClick(item: MenuItem) {
        val navController = findNavController(R.id.nav_host_fragment)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            navController.navigate(R.id.mapsFragment)
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            if (shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION)) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    Snackbar.make(
                        requireViewById(R.id.drawer_layout), // Parent view
                        getString(R.string.requestPermissionLocationText), // Message to show
                        Snackbar.LENGTH_LONG
                    )
                        .setAction(getString(R.string.requestPermissionActionText)) {
                            locationPermissionRequest.launch(Manifest.permission.ACCESS_FINE_LOCATION)
                        }.show()
                }
            } else {
                locationPermissionRequest.launch(Manifest.permission.ACCESS_FINE_LOCATION)
            }
        }
    }
}