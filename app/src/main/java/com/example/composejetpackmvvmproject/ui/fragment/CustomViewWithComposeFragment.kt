package com.example.composejetpackmvvmproject.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.ActivityResultRegistry
import androidx.activity.result.contract.ActivityResultContract
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.AmbientContext
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.Fragment
import com.example.composejetpackmvvmproject.R
import com.example.composejetpackmvvmproject.ui.customview.HorizontalDottedProgress

class CustomViewWithComposeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        /********************************** Way to Handle View without layout in Fragment ********************************/
        val view = ComposeView(requireContext())
        view.apply {
            setContent {
                Column(
                    modifier = Modifier.padding(5.dp).fillMaxWidth().border(
                        BorderStroke(
                            1.dp,
                            Color.Blue
                        )
                    )
                ) {

                    Text(text = "Custom view will Embedded in this Fragment")
                    Spacer(modifier = Modifier.padding(top = 10.dp))

                    val customview = HorizontalDottedProgress(AmbientContext.current)
                    AndroidView(viewBlock = { customview })

                    Spacer(modifier = Modifier.padding(top = 10.dp))
                }

            }
        }


        /********************************** Way to Handle Custom View  with layout in Fragment ********************************/
        val view2 = inflater.inflate(R.layout.compose_with_customview_receipt, container, false)

        view2.findViewById<ComposeView>(R.id.horizontalView).apply {
            setContent {
                Column(
                    modifier = Modifier.padding(5.dp).fillMaxWidth().border(
                        BorderStroke(
                            1.dp,
                            Color.Blue
                        )
                    ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Text(text = "Custom view will Embedded in this Fragment")
                    Spacer(modifier = Modifier.padding(top = 20.dp))
                    CircularProgressIndicator()
                    Spacer(modifier = Modifier.padding(top = 20.dp))

                    val customview = HorizontalDottedProgress(AmbientContext.current)
                    AndroidView(viewBlock = { customview },modifier = Modifier.align(Alignment.CenterHorizontally))

                    Spacer(modifier = Modifier.padding(top = 10.dp))
                }
            }
        }
        return view2
    }
}