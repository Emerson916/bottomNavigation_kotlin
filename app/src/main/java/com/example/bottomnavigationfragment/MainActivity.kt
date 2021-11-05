package com.example.bottomnavigationfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.widget.Toolbar

import androidx.fragment.app.Fragment

import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    lateinit var btnHome : Button
    lateinit var btnCliente : Button
    lateinit var btnBuscar : Button


    lateinit var homeFragment: HomeFragment
    lateinit var clientesFragment: ClientesFragment
    lateinit var buscarFragment: BuscarFragment

    lateinit var toolbar: Toolbar

    lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       //setFragment(homeFragment)

        btnHome  = findViewById(R.id.btn_home)
        btnCliente = findViewById(R.id.btn_clientes)
        btnBuscar = findViewById(R.id.btn_buscar)

        bottomNavigation = findViewById(R.id.bottomNavegation)

        toolbar = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)

        toolbar.setTitle("Teste Drawer")


        buscarFragment = BuscarFragment()
        homeFragment = HomeFragment()
        clientesFragment = ClientesFragment()

        btnHome.setOnClickListener{
            setFragment(homeFragment)
        }

        btnCliente.setOnClickListener{
            setFragment(clientesFragment)
        }

        btnBuscar.setOnClickListener{
            setFragment(buscarFragment)
        }

        bottomNavigation.setOnItemSelectedListener {
            onNavigationItemSelected(it)
        }
    }



    private fun setFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame, fragment)
        fragmentTransaction.commit()

    }

     fun onNavigationItemSelected(item: MenuItem): Boolean {

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