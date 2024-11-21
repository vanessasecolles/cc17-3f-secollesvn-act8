package com.feeltheboard.bookshelf

import android.app.Application
import androidx.compose.runtime.staticCompositionLocalOf
import com.feeltheboard.bookshelf.data.BookShelfContainer
import com.feeltheboard.bookshelf.data.BookShelfContainerImpl
import com.feeltheboard.bookshelf.ui.BookShelfViewModel

/** 1. A static CompositionLocal providing the [BookShelfViewModel] for the app */
val LocalBookShelfViewModel =
    staticCompositionLocalOf<BookShelfViewModel> {
    error("No BookShelfViewModel provided")
}

class BookShelfApplication: Application() {
    private lateinit var bookShelfContainer: BookShelfContainer
    lateinit var bookShelfViewModel: BookShelfViewModel
    override fun onCreate() {
        super.onCreate()
        bookShelfContainer = BookShelfContainerImpl()

        val booksRepository = bookShelfContainer.booksRepository
        bookShelfViewModel = BookShelfViewModel(booksRepository)
    }
}