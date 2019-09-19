package com.abousalem.hanginkotlin.view.main

import androidx.lifecycle.ViewModel
import com.abousalem.hanginkotlin.domain.repository.PlacesRepositoryImplementer
import com.abousalem.hanginkotlin.entities.state.ErrorPlacesState
import com.abousalem.hanginkotlin.entities.state.LoadingPlacesState
import com.abousalem.hanginkotlin.entities.state.PlacesState
import com.abousalem.hanginkotlin.entities.state.SuccessPlacesState
import io.reactivex.Observable
import javax.inject.Inject

class PlacesViewModel @Inject constructor(val repository: PlacesRepositoryImplementer) : ViewModel(){

    fun getPlaces(): Observable<PlacesState>{
        return repository.getPlaces()
            .map<PlacesState>{SuccessPlacesState(it)}
            .onErrorReturn { ErrorPlacesState(it.message?: "Invalid Email and Password!") }
            .startWith(LoadingPlacesState(loading = true))
            .concatWith(Observable.just(LoadingPlacesState(loading = false)))
    }
}