package ru.geekbrains.androidonkotlin.hw.mymovie

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
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
}