package com.example.composejetpackmvvmproject.presentation.compose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.imageFromResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.composejetpackmvvmproject.R

class ColumnRowLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // here will use some Column and Row like Linear Layout

        setContent {
            ScrollableColumn(
                modifier = Modifier.fillMaxWidth()
                    .fillMaxHeight()
                    .background(Color(0xfff2f2f2))
            ) {

                Image(

                    bitmap = imageFromResource(res = resources, resId = R.drawable.mack),
                    modifier = Modifier.fillMaxWidth().height(200.dp),
                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier.padding(10.dp).fillMaxWidth().fillMaxHeight()
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Happy Family Meal",
                            style = TextStyle(
                                fontSize = TextUnit.Companion.Sp(25), color = Color(0xff868686)
                            ),
                        )

                        Text(
                            text = "250$",
                            style = TextStyle(
                                fontSize = TextUnit.Companion.Sp(16), color = Color(0xff228822)
                            ),
                        )
                    }
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(
                        text = "800 Calerous",
                        style = TextStyle(
                            fontSize = TextUnit.Companion.Sp(16), color = Color(0xff868686)
                        ),
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    Button(onClick = {},modifier = Modifier.align(Alignment.CenterHorizontally),) {
                        Text(
                            text = "Order Now",
                            style = TextStyle(
                                fontSize = TextUnit.Companion.Sp(16), color = Color(0xffffffff)
                            ),
                        )
                    }

                }
            }
        }
    }
}