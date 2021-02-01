package com.example.composejetpackmvvmproject.presentation.ui.reciepeList

//import androidx.navigation.NavController
//import androidx.navigation.findNavController
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.savedinstancestate.savedInstanceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.example.composejetpackmvvmproject.presentation.BaseApplication
import com.example.composejetpackmvvmproject.presentation.component.*
import com.example.composejetpackmvvmproject.presentation.component.controller.SnackBarController
import com.example.composejetpackmvvmproject.presentation.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalMaterialApi
@AndroidEntryPoint
class ReciepeListFragment : Fragment() {

    @Inject
    lateinit var application: BaseApplication

    val viewModel: ReciepeListViewModel by viewModels()
    val snackBarController = SnackBarController(lifecycleScope)


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = ComposeView(requireContext()).apply {


            setContent {

                val receipes = viewModel.recipes.value
                val selectedCategory: FoodCategory? = viewModel.selectedCategory.value
                val isLoading: Boolean = viewModel.loading.value
                val reciepeScrollPosition =  viewModel.recipeScrollPosition

                /**********************************************************************/

                //three way to save data in compose widget
                //1- add it in remember block but will recreate when rotate screen
                var queryy = remember { mutableStateOf("beef") }
                //2- save it in savedInstanceState and will be save when rotate and needn't to use mutable state as it provide it as mutable state
                var _query = savedInstanceState { "beef" }
                //3- add it viewmodel lifecycle
                val query = viewModel.query.value

                /*********************************************************************/
                //1- for static SnackBar
                var isShowing = remember { mutableStateOf(false) }
                var error = remember { mutableStateOf("") }

                //2- for hostingSnackBar
                val snackbarHostState = remember { SnackbarHostState() }

                //3- for scaffold snakbar
                val scaffoldState = rememberScaffoldState()

                /*********************************************************************/


                AppTheme(darkTheme = application.isDark.value) {
                    Scaffold(
                        topBar = {
                            Surface(
                                modifier = Modifier.fillMaxWidth().padding(2.dp),
                                elevation = 8.dp,
                                color = MaterialTheme.colors.surface
                            ) {
                                Column {
                                    Row(
                                        Modifier.fillMaxWidth()
                                    ) {
                                        TextField(
                                            modifier = Modifier.fillMaxWidth(0.9f).padding(8.dp),
                                            value = query,
                                            onValueChange = { value ->
                                                viewModel.onQueryChange(value)
                                                //_query.value = value
                                                //queryy.value = value
                                            },
                                            label = {
                                                Text(text = "Search")
                                            },
                                            keyboardOptions = KeyboardOptions(
                                                keyboardType = KeyboardType.Text,
                                                imeAction = ImeAction.Search,
                                            ),
                                            leadingIcon = {
                                                Icon(Icons.Filled.Search)
                                            },
                                            onImeActionPerformed = { action, softKeyboardController ->
                                                if (action == ImeAction.Search) {
                                                    if (query.isEmpty()) {
                                                        //1- for static snackbar
//                                                        isShowing.value = true
//                                                        error.value = "search key is required"


                                                        //2- for snackbar
//                                                        lifecycleScope.launch {
//                                                            snackbarHostState.showSnackbar("search key is required",
//                                                                "Hide",duration = SnackbarDuration.Short)
//                                                        }

                                                        //3- for scaffold state
//                                                        lifecycleScope.launch {
//                                                            scaffoldState.snackbarHostState.showSnackbar(
//                                                                "search key is required",
//                                                                "Hide",
//                                                                duration = SnackbarDuration.Short
//                                                            )
//                                                        }

                                                        //4- for SnackBarController
                                                        snackBarController.showSnackBar(
                                                            scaffoldState,
                                                            "Search key is required",
                                                            "Hide"
                                                        )
//
                                                    } else
                                                        viewModel.onSearch()
                                                    softKeyboardController?.hideSoftwareKeyboard()
                                                }
                                            },
                                            textStyle = TextStyle(color = MaterialTheme.colors.onSurface),
                                            backgroundColor = MaterialTheme.colors.surface,
                                        )
                                        ConstraintLayout(modifier = Modifier.align(Alignment.CenterVertically)) {
                                            val switch = createRef()
                                            Switch(
                                                modifier = Modifier.constrainAs(switch) {
                                                    top.linkTo(parent.top)
                                                    bottom.linkTo(parent.bottom)
                                                    end.linkTo(parent.end)
                                                },
                                                checked = application.isDark.value,
                                                onCheckedChange = { application.toggleSwitch() })
                                        }
                                    }

                                    var scrollState = rememberScrollState()

                                    ScrollableRow(
                                        scrollState = scrollState
                                    ) {
                                        scrollState.scrollTo(viewModel.selectedPosititon)
                                        for (category in getAllCategory()) {
                                            CategoryShip(
                                                category = category.name,
                                                isSelected = category == selectedCategory,
                                                onSelectedChange = {
                                                    viewModel.onCategoryChanged(it)
                                                    viewModel.onPositionChanged(scrollState.value)
                                                },
                                                onclick = {
                                                    viewModel.onSearch()
                                                }
                                            )
                                        }
                                    }
                                }

                            }
                        },
                        bottomBar = {
                            MyBottomBar(navController = findNavController())
                        },
                        drawerContent = {
                            MyDrawer(navController = findNavController())
                        },
                        scaffoldState = scaffoldState,
                        snackbarHost = {
                            scaffoldState.snackbarHostState
                        }
                    ) {

                        Box(
                            modifier = Modifier.fillMaxWidth()
                                .background(MaterialTheme.colors.surface)
                        ) {
                            if (isLoading&&receipes.isEmpty()) {
                                LoadRecipesListShimmer(imageHeight = 250.dp)
                            } else {

                                LazyColumn {
                                    itemsIndexed(receipes) { index, receipe ->
                                        viewModel.onChangeRecipeScrollPosition(index)
                                        if (!isLoading)
                                            viewModel.onGetNext()
                                        RecipeCard(
                                            recipe = receipe,
                                            onclick = { })
                                    }
                                }
                            }

                            CircularLoading(isDisplayed = isLoading)

                            /******************************************************/
//                            MySnackBar(
//                                isShowing = isShowing.value,
//                                error = error.value,
//                                actionLabel = "ok",
//                                sbackBarAction = {
//                                    isShowing.value = !isShowing.value
//                                })

                            /******************************************************/

//                            MyHostedSnackBar(snackbarHostState = snackbarHostState)

                            /******************************************************/

                            DefaultSnackBar(
                                snackbarHostState = scaffoldState.snackbarHostState,
                                onDissmiss = { scaffoldState.snackbarHostState.currentSnackbarData?.dismiss() },
                                modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 40.dp)
                            )
                        }
                    }

//                    Column() {
//                    pulseAnimation()
//
//                    Row(
//                        modifier = Modifier.fillMaxWidth().height(100.dp),
//                        horizontalArrangement = Arrangement.Center
//                    ) {
//                        val state = remember { mutableStateOf(IDLE) }
//                        HeartAnimation.AnimatedHeartButton(
//                            modifier = Modifier.align(Alignment.CenterVertically),
//                            heartState = state,
//                            onToggle = {
//                                state.value = if (state.value == IDLE)
//                                    ACTIVE
//                                else
//                                    IDLE
//                            })
//                    }


//                  }
//

//                val receipes = viewModel.recipes.value
//                Column(
//                    modifier = Modifier.padding(
//                        20.dp
//                    ).fillMaxWidth().fillMaxHeight(),
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.Center
//
//                ) {
//                    Text(
//                        text = "this is ReceipeList Fragment",
//                        style = TextStyle(color = Color.Blue, fontSize = TextUnit.Companion.Sp(25))
//                    )
//                    Spacer(modifier = Modifier.padding(top = 20.dp))
//                    Button(onClick = {
//                        findNavController().navigate(R.id.action_reciepeListFragment_to_reciepeFragment)
//
//                    }) {
//                        Text(text = "Go To Next Page")
//                    }
//                }


                }
            }
        }
        return view
    }
}