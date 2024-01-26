package com.example.tbc_test8_sidebar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tbc_test8_sidebar.databinding.ActivityMainBinding
import com.example.tbc_test8_sidebar.presentation.adapter.MenuItemsRecyclerAdapter
import com.example.tbc_test8_sidebar.presentation.model.RecyclerItem


class MainActivity : AppCompatActivity() {


    private lateinit var menuRecyclerAdapter: MenuItemsRecyclerAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setUpRv()
        listeners()

    }

    private fun listeners() {
        menuRecyclerAdapter.itemOnClick = {
            when (it) {
                1 -> {
                    Toast.makeText(applicationContext, "Navigated to Dashboard", Toast.LENGTH_SHORT)
                        .show()
                }

                2 -> {
                    Toast.makeText(applicationContext, "Navigated to mail", Toast.LENGTH_SHORT)
                        .show()
                }

                3 -> {
                    Toast.makeText(
                        applicationContext,
                        "Navigated to Notifications",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                4 -> {
                    Toast.makeText(applicationContext, "Navigated to Calendar", Toast.LENGTH_SHORT)
                        .show()
                }

                5 -> {
                    Toast.makeText(
                        applicationContext,
                        "Navigated to Statistics",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                6 -> {
                    Toast.makeText(applicationContext, "Navigated to Options", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    private fun setUpRv() {
        menuRecyclerAdapter = MenuItemsRecyclerAdapter()
        menuRecyclerAdapter.setItems(
            listOf(
                RecyclerItem(1, "Dashboard", R.drawable.ic_dashboard),
                RecyclerItem(2, "Pesan", R.drawable.ic_mail),
                RecyclerItem(3, "Notifikasi", R.drawable.ic_notification),
                RecyclerItem(4, "Kalendar", R.drawable.ic_calendar),
                RecyclerItem(5, "Statistik", R.drawable.ic_statistics),
                RecyclerItem(6, "Pengaturan", R.drawable.ic_settings)
            )
        )
        binding.rvDrawerItems.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = menuRecyclerAdapter
        }
    }
}