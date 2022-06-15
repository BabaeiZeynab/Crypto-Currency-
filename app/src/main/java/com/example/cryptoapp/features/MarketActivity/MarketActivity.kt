package com.example.cryptoapp.features.MarketActivity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cryptoapp.apiManager.ApiManager
import com.example.cryptoapp.apiManager.modles.CoinAboutItem
import com.example.cryptoapp.apiManager.modles.CoinsAboutData
import com.example.cryptoapp.apiManager.modles.CoinsData
import com.example.cryptoapp.databinding.ActivityMarketBinding
import com.example.cryptoapp.features.coinActivity.CoinActivity
import com.google.gson.Gson

class MarketActivity : AppCompatActivity(), Marketadapter.RecyclerCallBack {


    lateinit var binding: ActivityMarketBinding
    lateinit var dataNews: ArrayList<Pair<String, String>>
    val apiManager = ApiManager()
    lateinit var aboutDataMap: MutableMap<String, CoinAboutItem>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMarketBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // read data from assest file json one

        binding.swipeRefreshMain.setOnRefreshListener {

            initUi()

            Handler(Looper.getMainLooper()).postDelayed({
                binding.swipeRefreshMain.isRefreshing = false
            }, 1500)

        }



    }

    override fun onResume() {
        super.onResume()

        initUi()

    }

    private fun initUi() {
        //show news
        getNewsFromApi()

        //get Coins
        getTopCoins()

        getABoutFromAssets()

    }

    private fun getABoutFromAssets() {

        val fileInString = applicationContext.assets
                .open("currencyinfo.json")
                .bufferedReader()
                .use { it.readText() }

        aboutDataMap = mutableMapOf<String, CoinAboutItem>()

        val gson = Gson()
        val dataAboutAll = gson.fromJson(fileInString, CoinsAboutData::class.java)

        dataAboutAll.forEach {
            aboutDataMap[it.currencyName] = CoinAboutItem(
                    it.info.web,
                    it.info.github,
                    it.info.twt,
                    it.info.desc,
                    it.info.reddit
            )
        }

    }

    private fun getTopCoins() {
        apiManager.getCoinsList(object : ApiManager.ApiCallBack<List<CoinsData.Data>> {
            override fun success(data: List<CoinsData.Data>) {
                showDataInRecyclear(data)
            }

            override fun onError(message: String) {


                Toast.makeText(this@MarketActivity, message, Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun showDataInRecyclear(data: List<CoinsData.Data>) {

        val marketAdpter = Marketadapter(ArrayList(data), this)
        binding.layoutWatchlist.recyclerMain.adapter = marketAdpter
        binding.layoutWatchlist.recyclerMain.layoutManager = LinearLayoutManager(this)
    }

    private fun getNewsFromApi() {

        apiManager.getNews(object : ApiManager.ApiCallBack<ArrayList<Pair<String, String>>> {
            override fun success(data: ArrayList<Pair<String, String>>) {
                dataNews = data
                refreshNews()
            }

            override fun onError(message: String) {
                Toast.makeText(this@MarketActivity, message, Toast.LENGTH_SHORT).show()
            }

        })
    }

    fun refreshNews() {

        var randomAccess = (0..49).random()
        binding.layoutNews.imgNews.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(dataNews[randomAccess].second))
            startActivity(intent)
        }
        binding.layoutNews.txtNews.text = dataNews[randomAccess].first
        binding.layoutNews.txtNews.setOnClickListener {
            refreshNews()
        }
    }

    override fun onCoinItemClicked(dataCoin: CoinsData.Data) {
        val intent = Intent(this, CoinActivity::class.java)

        val bundle = Bundle()
        bundle.putParcelable("bundle1", dataCoin)
        bundle.putParcelable("bundle2", aboutDataMap[dataCoin.coinInfo.name])

        intent.putExtra("bundle", bundle)
        startActivity(intent)
    }


}