package ru.yandex.practicum.moviessearch.data.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.yandex.practicum.moviessearch.data.dto.MovieCastResponse
import ru.yandex.practicum.moviessearch.data.dto.MovieDetailsResponse
import ru.yandex.practicum.moviessearch.data.dto.MoviesSearchResponse

interface IMDbApiService {
    @GET("/imdb/")
    fun searchMovies(@Query("expression") expression: String): Call<MoviesSearchResponse>

    @GET("/imdb/")
    fun getMovieDetails(@Query("movie_id") movieId: String): Call<MovieDetailsResponse>

    @GET("/imdb/FullCast/")
    fun getFullCast(@Query("movie_id") movieId: String): Call<MovieCastResponse>

}