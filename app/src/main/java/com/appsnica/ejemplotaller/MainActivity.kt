package com.appsnica.ejemplotaller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.appsnica.ejemplotaller.ui.theme.EjemploTallerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjemploTallerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    EjemploTallerTheme {
        //Greeting("Android")
        //LoginScreen()
       //ContactList(contacts)
        //AppContent()
        //UserList(sampleData)
        CrimeList(sampleCrimeData)
    }
}
@Composable
fun LoginScreen() {
    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            var username by remember { mutableStateOf(TextFieldValue()) }
            var password by remember { mutableStateOf(TextFieldValue()) }

            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Usuario") },
                modifier = Modifier.padding(16.dp)
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Contraseña") },
                modifier = Modifier.padding(16.dp)
            )

            Button(
                onClick = { /* Acción de inicio de sesión */ },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Iniciar Sesión")
            }
        }
    }
}
data class Contact(val name: String, val phoneNumber: String)

val contacts = listOf(
    Contact("Juan", "+1234567890"),
    Contact("María", "+0987654321"),
    Contact("Carlos", "+1122334455")
)


@Composable
fun ContactList(contacts: List<Contact>) {
    MaterialTheme {
        Surface(color = Color.White) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                contacts.forEach { contact ->
                    ContactItem(contact = contact)
                }
            }
        }
    }
}

@Composable
fun ContactItem(contact: Contact) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Phone,
            contentDescription = "Phone Icon",
            modifier = Modifier.size(48.dp)
        )
        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f)
        ) {
            Text(text = contact.name, style = MaterialTheme.typography.headlineMedium)
            Text(text = contact.phoneNumber, style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContent() {
    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Menú Hamburguesa") },
                    navigationIcon = {
                        IconButton(onClick = { /* Acción al hacer clic en el icono del menú */ }) {
                            Icon(Icons.Filled.Menu, contentDescription = "Menu Icon")
                        }
                    }
                )
            },
            content = { innerPadding ->
                Column(
                    modifier = Modifier.fillMaxSize().padding(innerPadding),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Contenido principal")
                }
            }
        )
    }
}

@Composable
fun UserList(users: List<User>) {
    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .background(Color(0xFFF0F0F0))
    ) {
        items(users) { user ->
            UserItem(user)
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
fun UserItem(user: User) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "ID: ${user.id}",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF6200EE)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Gender: ",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = user.gender,
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Age: ",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "${user.age}",
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Annual Income: ",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "${user.annualIncome}k",
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Spending Score: ",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "${user.spendingScore}",
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

val sampleData = listOf(
    User(id = 1, gender = "Male", age = 19, annualIncome = 15, spendingScore = 39),
    User(id = 2, gender = "Male", age = 21, annualIncome = 15, spendingScore = 81),
    User(id = 3, gender = "Female", age = 20, annualIncome = 16, spendingScore = 6)
)
data class User(
    val id: Int,
    val gender: String,
    val age: Int,
    val annualIncome: Int,
    val spendingScore: Int
)


@Composable
fun CrimeList(crimes: List<Crime>) {
    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .background(Color(0xFFF0F0F0))
    ) {
        items(crimes) { crime ->
            CrimeItem(crime)
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
fun CrimeItem(crime: Crime) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFBBDEFB)
        ),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF6200EE)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground), // Agrega un icono representativo
                    contentDescription = "Crime Icon",
                    modifier = Modifier.size(30.dp)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = "${crime.tipologia} (${crime.codCategoria})",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Departamento: ${crime.departamento}",
                    fontSize = 16.sp,
                    color = Color.DarkGray
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Cantidad: ${crime.cantidad}",
                    fontSize = 16.sp,
                    color = Color.DarkGray
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Casos Resueltos: ${crime.casosResuelto}",
                    fontSize = 16.sp,
                    color = Color.DarkGray
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Año: ${crime.annio}",
                    fontSize = 16.sp,
                    color = Color.DarkGray
                )
            }
        }
    }
}

data class Crime(
    val id: Int,
    val codCategoria: String,
    val tipologia: String,
    val departamento: String,
    val cantidad: Int,
    val casosResuelto: Int,
    val annio: Int
)
val sampleCrimeData = listOf(
    Crime(id = 1, codCategoria = "DFCV", tipologia = "Asesinato", departamento = "Estelí", cantidad = 153, casosResuelto = 138, annio = 2023),
    Crime(id = 2, codCategoria = "DFCV", tipologia = "Homicidio", departamento = "Carazo", cantidad = 68, casosResuelto = 53, annio = 2023),
    Crime(id = 3, codCategoria = "DFCV", tipologia = "Lesiones", departamento = "Managua", cantidad = 159, casosResuelto = 144, annio = 2023)
)