package com.wahid.newinandroidapp.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ContentView(modifier: Modifier = Modifier) {




/*    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        var clicks by rememberSaveable { mutableIntStateOf(0) }
        ClickCounter(
            clicks = clicks,
            onClick = { clicks++ }
        )

    }*/
/*    val movies = listOf(
        Movie(1, "The Shawshank Redemption", 1994),
        Movie(2, "The Godfather", 1972),
        Movie(3, "The Dark Knight", 2008),
        Movie(4, "Pulp Fiction", 1994),
        Movie(5, "The Lord of the Rings: The Return of the King", 2003),
        Movie(6, "Forrest Gump", 1994),
        Movie(7, "Inception", 2010),
        Movie(8, "The Matrix", 1999),
        Movie(9, "Goodfellas", 1990),
        Movie(10, "The Silence of the Lambs", 1991),
    )
    MoviesScreen(movies = movies)*/
}


@Composable
fun MoviesScreen(movies:List<Movie>) {
    LazyColumn(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

        items(movies, { it.id }) {
            Movie(movie = it)
            Spacer(modifier = Modifier.padding(8.dp))
        }

    }

}

@Composable
fun Movie(movie: Movie) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
        colors = CardDefaults.cardColors(
            containerColor = androidx.compose.ui.graphics.Color(0xFFBBDEFB),
            contentColor = androidx.compose.ui.graphics.Color(0xFF0D47A1)
        )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = "${movie.title} (${movie.releaseYear})", modifier = Modifier.padding(32.dp))
        }
    }

}


@Composable
fun ClickCounter(clicks:Int, onClick:()-> Unit) {
    Button(onClick = onClick) {
        Text(text = "Clicked $clicks times")
    }
}