package com.abousalem.hanginkotlin.entities.state

import com.abousalem.hanginkotlin.entities.response.Place

sealed class PlacesState
data class LoadingPlacesState(var loading: Boolean = false): PlacesState()
data class ErrorPlacesState(val message: String): PlacesState()
data class SuccessPlacesState(var data: List<Place>? = null): PlacesState()