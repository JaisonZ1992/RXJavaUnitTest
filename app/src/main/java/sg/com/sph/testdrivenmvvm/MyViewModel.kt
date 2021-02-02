package sg.com.sph.testdrivenmvvm

import android.arch.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MyViewModel(private val dataRepository: DataRepository) {

    val testLiveData = MutableLiveData<String>()

    val myCompositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getStuff() {
        myCompositeDisposable.add(dataRepository.fetchData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ message -> handleResponse(message) }, { throwable -> println(throwable.printStackTrace())}))
    }

    fun handleResponse(message:String){
        testLiveData.value = message;
    }

}