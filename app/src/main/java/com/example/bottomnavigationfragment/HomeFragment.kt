package com.example.bottomnavigationfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class HomeFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    //metodo chamado quando for criar o fragmento na activity
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        //salva o historico de tela, para quando girar não perder o conteúdo
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

}