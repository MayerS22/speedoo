package com.example.combanquemisrspeedo.ui.screens.main.transfer

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.combanquemisrspeedo.R
import com.example.combanquemisrspeedo.navigation.Route
import com.example.combanquemisrspeedo.ui.uielements.SpeedoTextButton
import com.example.combanquemisrspeedo.ui.uielements.SpeedoTextField
import edu.android_security.ui.theme.G900
import edu.android_security.ui.theme.P300
import edu.android_security.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmountScreen(navController: NavController,modifier: Modifier = Modifier) {
    var recipientName by remember { mutableStateOf("") }
    var recipientAmount by remember { mutableStateOf("") }
    val isButtonEnabled = recipientName.isNotEmpty() && recipientAmount.isNotEmpty()
    val buttonColor = if (isButtonEnabled) P300 else P300.copy(alpha = 0.6f)
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }
    BackHandler {
        navController.popBackStack()
        navController.navigate(Route.BOTTOMNAVSCREEN)
    }
    if (showBottomSheet) {
        ModalBottomSheet(
            containerColor = Color.White,
            onDismissRequest = {
                showBottomSheet = false
            },
            sheetState = sheetState
        ) {
            FavouriteListSheet()
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.transfer),
                        fontSize = 20.sp,
                        color = G900,
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    navController.navigate(Route.BOTTOMNAVSCREEN)
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.back_arrow),
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Transparent
                )
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFFFFF8E7),
                                Color(0xFFFFEAEE),
                            )
                        )
                    )
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp)
                    .imePadding()
                    .verticalScroll(rememberScrollState())
            ) {
                Stepper(currentStep = 1)
                Text(
                    text = stringResource(R.string.how_much_are_you_sending),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 4.dp, top = 16.dp, bottom = 16.dp)
                )
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.White
                    ),
                    shape = MaterialTheme.shapes.small
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.Center
                    ) {

                        InputField(label = "Amount", initialValue = "1000")


                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Recipient Information",
                        style = MaterialTheme.typography.headlineSmall,
                        fontSize = 16.sp,
                        color = G900,
                        modifier=Modifier.padding(start = 4.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    TextButton(onClick = {
                        showBottomSheet = true
                    }) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            // Load the drawable resource using painterResource
                            Image(
                                painter = painterResource(id = R.drawable.redstar),
                                contentDescription = "Red star",
                                Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp)) // Space between image and text
                            Text(
                                text = "Favourite",
                                color = P300,
                                fontSize = 14.sp
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowRight, // Use any icon you want
                                contentDescription = "View all icon",
                                Modifier.size(16.dp),
                                tint = P300 // Optional: set the icon color
                            )
                        }

                    }

                }
                Spacer(modifier = Modifier.size(8.dp))
                SpeedoTextField(
                    labelText = stringResource(R.string.recipient_name),
                    placeholderText = stringResource(R.string.enter_recipient_name),
                    onTextChange =
                    {
                        recipientName = it

                    },
                    keyboardType = KeyboardType.Email,
                )
                Spacer(modifier = Modifier.size(16.dp))
                SpeedoTextField(
                    labelText = stringResource(R.string.recipient_amount),
                    placeholderText = "Enter Recipient Name",
                    onTextChange =
                    {
                        recipientAmount = it

                    },
                    keyboardType = KeyboardType.Email,
                )
                Spacer(modifier = Modifier.size(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    SpeedoTextButton(
                        text = "Continue",
                        textColor = White,
                        backgroundColor = buttonColor,
                        borderColor = buttonColor,
                    ) {
                        if (isButtonEnabled) {
                            navController.navigate(Route.CONFIRMATIONSCREEN)
                        }
                    }
                }

            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputField(label: String, initialValue: String) {
    var text by remember { mutableStateOf(initialValue) }

    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        // Label outside the text field
        Text(
            text = label,
            modifier = Modifier.padding(bottom = 16.dp),
            fontSize = 16.sp,
        )

        // OutlinedTextField for the input
        OutlinedTextField(
            value = text,

            onValueChange = { newText -> text = newText },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            textStyle = TextStyle(
                fontSize = 20.sp,    // Text size 16.sp
                fontWeight = FontWeight.Bold  // Bold text
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Gray,
                unfocusedBorderColor = Color.Gray
            )
        )
    }
}


@Preview
@Composable
private fun AmountPreview() {
    AmountScreen(rememberNavController())
}