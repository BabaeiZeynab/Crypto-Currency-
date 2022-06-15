package com.example.cryptoapp.apiManager

import com.example.cryptoapp.apiManager.modles.CoinsData
import com.example.cryptoapp.apiManager.modles.NewsData
import ir.dunijet.dunipool.apiManager.model.ChartData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query




interface ApiService {

    @Headers(API_KEY)
    @GET("v2/news/")
    fun getNews(

        @Query("sortOrder") sortOrder: String = "popular"
    ): Call<NewsData>



    @Headers(API_KEY)
    @GET("top/totalvolfull")
    fun getCoins(
        @Query("tsym") to_symbol: String = "USD",
        @Query("limit") limit_data: Int = 40

    ): Call<CoinsData>





    /// read chart from api
    @Headers(API_KEY)
    @GET("{period}")
    fun getChartData(
            @Path("period") period :String ,
            @Query("fsym") fromSymbol :String ,
            @Query("limit") limit :Int ,
            @Query("aggregate")  aggregate:Int ,
            @Query("tsym") toSymbol :String = "USD"
    ) :Call<ChartData>


}

