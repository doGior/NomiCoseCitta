package it.dogior.ncc.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import it.dogior.ncc.NomiCoseCittaTheme
import it.dogior.ncc.fadingEdge

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CategoryNote(nomeLista: String, text: String, modifier: Modifier = Modifier) {
    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.7f))
        ) {
            val (categories, listName) = createRefs()

            FlowRow(modifier = Modifier
                .constrainAs(categories) {
                    start.linkTo(parent.start, margin = 16.dp)
                    top.linkTo(parent.top, margin = 16.dp)
                    bottom.linkTo(listName.top, margin = 16.dp)
                }
                .padding(end = 8.dp),
                horizontalArrangement = Arrangement.Center) {
                Text(
                    text,
                    modifier = Modifier.padding(end = 16.dp),
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontSize = 19.sp,
                        lineHeight = 25.sp
                    ),
                    maxLines = 3,
                )
            }

            ConstraintLayout(
                modifier = Modifier
                    .constrainAs(listName) {
                        bottom.linkTo(parent.bottom)
                    }
                    .background(MaterialTheme.colorScheme.primary)
                    .fillMaxWidth(),
            ) {
                val (name, more) = createRefs()
                Text(
                    text = nomeLista,
                    style = MaterialTheme.typography.titleMedium.copy(fontSize = 26.sp),
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .constrainAs(name) {
                            start.linkTo(parent.start, margin = 16.dp)
//                            end.linkTo(parent.end, margin = 16.dp)
                        },
                    color = MaterialTheme.colorScheme.surfaceContainerHigh
                )

                Button(onClick = { /*TODO*/ },
                    modifier = Modifier.constrainAs(more){
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }, contentPadding = PaddingValues(0.dp)
                ){
                    Icon(
                        imageVector = Icons.Filled.MoreVert,
                        contentDescription = "More Options",
                        tint = MaterialTheme.colorScheme.surfaceContainerHigh,

                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun CategoryNotePreview() {
    NomiCoseCittaTheme {
        CategoryNote(
            "Lista 1",
            "Pokemon, Supereroi, Città, Nazioni, Divinità greche, Piante",
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }

}