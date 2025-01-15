package cat.itb.m78.exercices.Stateless

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import m78exercices.composeapp.generated.resources.Res
import m78exercices.composeapp.generated.resources.generatedFace
import org.jetbrains.compose.resources.painterResource

data class Contact(val fullName: String, val email: String, val phone: String)
val contact = Contact("Marta Casserres", "marta@example.com", "934578484")
@Composable
fun ContactApp() {
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.White)
            .padding(0.dp, 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(Modifier.weight(1f))
        Image(
            painter = painterResource(Res.drawable.generatedFace),
            modifier = Modifier.size((100.dp)),
            contentDescription = null
        )
        Spacer(Modifier.height(10.dp))
        Text(contact.fullName, fontSize = 2.em, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(5.dp))
        Card() {
            Column (
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Row {
                    Icon(Icons.Default.Email, "email")
                    Text(contact.email)
                }
                Row {
                    Icon(Icons.Default.Phone, "phone")
                    Text(contact.phone)
                }
            }
        }
        Spacer(Modifier.weight(2f))
    }
}