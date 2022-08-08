package com.anubhav.tiwari.square_closedpullrequests.presentation.pull_request_list.components


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.anubhav.tiwari.square_closedpullrequests.domain.model.PullRequestItem
import com.anubhav.tiwari.square_closedpullrequests.presentation.ui.theme.Purple500


@Composable
fun PullRequestListItem(
pullRequestItem: PullRequestItem
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        elevation = 8.dp,
        backgroundColor = MaterialTheme.colors.background,
        modifier = Modifier.padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier,
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.size(100.dp), horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(50.dp))
                    ) {
                        AsyncImage(
                            model = pullRequestItem.userImage,
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .height(50.dp)
                        .width(100.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = pullRequestItem.userName,
                        style = MaterialTheme.typography.body2,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        color = Purple500
                    )
                }
            }
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(75.dp)
                        .padding(start = 15.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = pullRequestItem.title,
                        fontWeight = FontWeight.Bold,
                        maxLines = 3)
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(75.dp)
                        .padding(start = 15.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(modifier = Modifier.padding(top = 5.dp)) {
                        Text(text = "Created At:", fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(text = pullRequestItem.createdAt)
                    }
                    Row(modifier = Modifier.padding(bottom = 5.dp)) {
                        Text(text = "Closed At:", fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(text = pullRequestItem.closedAt)
                    }

                }
            }

        }
    }
}

/*@Preview(showBackground = true)
@Composable
fun DefaultUserPreview() {
    PullRequestListItem()
}*/
