package com.example.bottomnavigationfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.widget.Toolbar

import androidx.fragment.app.Fragment

import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var btnHome : Button
    lateinit var btnCliente : Button
    lateinit var btnBuscar : Button


    lateinit var homeFragment: HomeFragment
    lateinit var clientesFragment: ClientesFragment
    lateinit var buscarFragment: BuscarFragment

    lateinit var toolbar: Toolbar

    lateinit var bottomNavigation: BottomNavigationView
    lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       //setFragment(homeFragment)

        //Buttons
        btnHome  = findViewById(R.id.btn_home)
        btnCliente = findViewById(R.id.btn_clientes)
        btnBuscar = findViewById(R.id.btn_buscar)

        //BottomNavigation
        bottomNavigation = findViewById(R.id.bottomNavegation)

        navigationView = findViewById(R.id.navigationView)

        //Toolbar
        toolbar = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)

        toolbar.setTitle("Teste Drawer")

        //Fragmentos
        buscarFragment = BuscarFragment()
        homeFragment = HomeFragment()
        clientesFragment = ClientesFragment()

        //clicks nos buttons -- eventos

        btnHome.setOnClickListener{
            setFragment(homeFragment)
        }

        btnCliente.setOnClickListener{
            setFragment(clientesFragment)
        }

        btnBuscar.setOnClickListener{
            setFragment(buscarFragment)
        }

        //Evento de click do bottom navigation
        bottomNavigation.setOnItemSelectedListener { item ->
            onNavigationItemSelected(item)
        }

        //Evento de click do navigation
        navigationView.setNavigationItemSelectedListener()

    }



    private fun setFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame, fragment)
        fragmentTransaction.commit()

    }

     override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.id_home -> {
                setFragment(homeFragment)
            }

            R.id.id_cliente -> {
                setFragment(clientesFragment)
            }

            else -> {
                setFragment(buscarFragment)
            }
        }
        return true
    }
}