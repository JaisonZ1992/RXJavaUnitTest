package sg.com.sph.testdrivenmvvm

import io.reactivex.Single

interface DataRepository {
    fun fetchData(): Single<String>
}