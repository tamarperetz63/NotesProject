package com.example.mynewandroidproject

import android.app.Application
import com.example.mynewandroidproject.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

object Session {
	val notesList = mutableListOf<NoteData>()
}

class MyApplication : Application() {
	override fun onCreate() {
		super.onCreate()

		startKoin {
			androidContext(applicationContext)
			modules(appModule)
		}

	}

}