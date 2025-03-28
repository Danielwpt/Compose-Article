package com.example.article

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.article.ui.theme.ArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArticleTheme {
                ArticleScreen(modifier = Modifier)
            }
        }
    }
}

@Composable
fun ArticleScreen(modifier : Modifier = Modifier) {
    Column {
        DisplayArticleImage(modifier)
        DisplayArticleContents(modifier)
    }
}

@Composable
fun DisplayArticleImage(modifier : Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.bg_compose_background),
        contentDescription = stringResource(R.string.article_background_description),
        modifier = modifier.fillMaxWidth()
    )
}

@Composable
fun DisplayArticleContents(modifier: Modifier = Modifier) {
    Text(text = stringResource(id = R.string.article_title), modifier.padding(16.dp), fontSize = 24.sp)
    Text(text = stringResource(id = R.string.article_first_description), modifier.padding(16.dp, 0.dp, 16.dp, 0.dp), textAlign = TextAlign.Justify)
    Text(text = stringResource(id = R.string.article_second_description), modifier.padding(16.dp), textAlign = TextAlign.Justify)
}

@Preview(showSystemUi = true)
@Composable
fun DisplayArticleImagePreview(modifier : Modifier = Modifier) {
    Column {
        DisplayArticleImage()
        DisplayArticleContents()
    }
}