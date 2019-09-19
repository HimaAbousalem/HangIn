package com.abousalem.hanginkotlin.view.main

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abousalem.hanginkotlin.R
import com.abousalem.hanginkotlin.entities.response.Place
import com.abousalem.hanginkotlin.entities.state.ErrorPlacesState
import com.abousalem.hanginkotlin.entities.state.LoadingPlacesState
import com.abousalem.hanginkotlin.entities.state.SuccessPlacesState
import com.abousalem.hanginkotlin.extenstion.isOnline
import com.abousalem.hanginkotlin.extenstion.toast
import com.abousalem.hanginkotlin.view.base.BaseActivity
import com.abousalem.hanginkotlin.view.base.ViewModelProvidersFactory
import com.abousalem.hanginkotlin.view.detailes.PlacesDetailedActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class MainActivity : BaseActivity(), OnItemClicked {

    lateinit var recyclerView: RecyclerView
    @Inject
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var places: ArrayList<Place>

    var placeAdapter: PlaceAdapter? = null

    @Inject
    lateinit var viewModelFactory: ViewModelProvidersFactory
    private lateinit var placesViewModel: PlacesViewModel
    private val disposable: CompositeDisposable? = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getActivityComponent().inject(this)
        placesViewModel = ViewModelProvider(this, viewModelFactory)[PlacesViewModel::class.java]

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = linearLayoutManager

        places = ArrayList()
        getPlaces()
    }

    private fun getPlaces() {
        //TODO:: Add Progressbar
        if(!isOnline()){
            toast("No Internet Connection!")
            return
        }
        disposable?.add(placesViewModel.getPlaces()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( {when(it) {
                is LoadingPlacesState->{
                    if(it.loading)
                        Timber.d("I'm Loading Places")
                    else Timber.d("I'm done Loading Places")}
                is ErrorPlacesState ->{Timber.d("Error: ${it.message}")}
                is SuccessPlacesState -> {
                    placeAdapter = PlaceAdapter(this, it.data!!, this)
                    recyclerView.adapter = placeAdapter
                }
            }
            },{}))
    }

    override fun onClick(position: Int) {
        startActivity(Intent(this, PlacesDetailedActivity::class.java))
    }
}
