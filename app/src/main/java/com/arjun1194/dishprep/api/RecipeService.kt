package com.arjun1194.dishprep.api

import android.view.SearchEvent
import com.arjun1194.dishprep.BuildConfig
import com.arjun1194.dishprep.data.model.SearchResponse
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeService {

    @GET("complexSearch")
    suspend fun searchRecipe(
        @Query("query") query: String,
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY
    ): SearchResponse

    companion object {
        fun create(): RecipeService {
            val logger = HttpLoggingInterceptor().apply {
                level =
                    HttpLoggingInterceptor.Level.BASIC
            }


            val authInterceptor = Interceptor {
                val newRequest = it.request().newBuilder()
                    .build()
                it.proceed(newRequest)
            }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .addInterceptor(authInterceptor)
                .build()



            return Retrofit.Builder()
                .baseUrl("https://api.spoonacular.com/recipes/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RecipeService::class.java)
        }
    }
}
