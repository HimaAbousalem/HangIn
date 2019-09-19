package com.abousalem.hanginkotlin.domain.repository

import com.abousalem.hanginkotlin.domain.api.ApiServices
import com.abousalem.hanginkotlin.entities.response.Place
import io.reactivex.Observable
import javax.inject.Inject

class PlacesRepositoryImplementer @Inject constructor(private val service: ApiServices): IPlacesRepository{
    override fun getPlaces(): Observable<List<Place>> {
        return service.getPlaces()
    }


}