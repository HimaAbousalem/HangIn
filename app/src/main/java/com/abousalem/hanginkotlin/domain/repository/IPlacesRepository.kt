package com.abousalem.hanginkotlin.domain.repository

import com.abousalem.hanginkotlin.entities.response.Place
import io.reactivex.Observable

interface IPlacesRepository{
    fun getPlaces():Observable<List<Place>>
}