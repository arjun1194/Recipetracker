package com.arjun1194.dishprep.di

import com.arjun1194.dishprep.api.RecipeService
import com.arjun1194.dishprep.data.repository.RecipeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class ViewModelModule {


        @Provides
        @ViewModelScoped
        fun provideNewsRepository(
            newsService: RecipeService,
            ): RecipeRepository {
            return RecipeRepository(newsService)
        }


}