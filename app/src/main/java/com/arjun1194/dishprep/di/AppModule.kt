package com.arjun1194.dishprep.di

import android.content.Context
import com.arjun1194.dishprep.api.RecipeService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun getContext(@ApplicationContext  context: Context): Context {
        return context;
    }

    @Provides
    @Singleton
    fun getRecipeService(): RecipeService {
        return RecipeService.create()
    }
}