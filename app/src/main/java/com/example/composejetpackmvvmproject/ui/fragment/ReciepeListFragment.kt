package com.example.composejetpackmvvmproject.ui.fragment

//import androidx.navigation.NavController
//import androidx.navigation.findNavController
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.composejetpackmvvmproject.R

class ReciepeListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = ComposeView(requireContext()).apply {
            setContent {
                Column(
                    modifier = Modifier.padding(
                        20.dp
                    ).fillMaxWidth().fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center

                ) {
                    Text(
                        text = "this is ReceipeList Fragment",
                        style = TextStyle(color = Color.Blue, fontSize = TextUnit.Companion.Sp(25))
                    )
                    Spacer(modifier = Modifier.padding(top = 20.dp))
                    Button(onClick = {
                        findNavController().navigate(R.id.action_reciepeListFragment_to_reciepeFragment)

                    }) {
                        Text(text = "Go To Next Page")
                    }
                }


            }
        }
        return view
    }
}