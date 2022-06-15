package com.example.cryptoapp.features.coinActivity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.cryptoapp.R
import com.example.cryptoapp.apiManager.*
import com.example.cryptoapp.apiManager.modles.CoinAboutItem
import com.example.cryptoapp.apiManager.modles.CoinsData
import com.example.cryptoapp.databinding.ActivityCoinBinding
import ir.dunijet.dunipool.apiManager.model.ChartData

class CoinActivity : AppCompatActivity() {
    lateinit var binding: ActivityCoinBinding
    lateinit var dataThisCoin : CoinsData.Data
    lateinit var dataThisAboutCoin : CoinAboutItem
    val apiManager = ApiManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoinBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.layoutToolbar.toolbar.title = dataThisCoin.coinInfo.fullName
//
//        val dataThisCoin = intent.getParcelableExtra<CoinsData.Data>("dataToSend")!!
        // put the title to what coins user is gonna click
        val fromIntent = intent.getBundleExtra("bundle")!!
        dataThisCoin = fromIntent.getParcelable<CoinsData.Data>("bundle1")!!

        if (fromIntent.getParcelable<CoinAboutItem>("bundle2") != null) {
            dataThisAboutCoin = fromIntent.getParcelable<CoinAboutItem>("bundle2")!!
        } else {
        dataThisAboutCoin = CoinAboutItem()
        }

        binding.layoutToolbar.toolbar.title = dataThisCoin.coinInfo.fullName

        initUi()

    }

    private fun initUi() {
       initChartUi()
        initStatistics()
        initAbout()
    }

    private fun initAbout() {
      // we get data with the help of intent from MarketActivity

        binding.layoutAbout.txtWebsite.text = dataThisAboutCoin.coinWebsite
        binding.layoutAbout.txtGithub.text = dataThisAboutCoin.coinGithub
        binding.layoutAbout.txtReddit.text = dataThisAboutCoin.coinReddit
        binding.layoutAbout.txtTwitter.text = "@" + dataThisAboutCoin.coinTwitter
        binding.layoutAbout.txtAboutCoin.text = dataThisAboutCoin.coinDesc

        // when we click it will open website github and reddit
        binding.layoutAbout.txtWebsite.setOnClickListener {
            openWebsiteDataCoin(dataThisAboutCoin.coinWebsite!!)
        }
        binding.layoutAbout.txtGithub.setOnClickListener {
            openWebsiteDataCoin(dataThisAboutCoin.coinGithub!!)
        }
        binding.layoutAbout.txtReddit.setOnClickListener {
            openWebsiteDataCoin(dataThisAboutCoin.coinReddit!!)
        }

        binding.layoutAbout.txtTwitter.setOnClickListener {
            //https://twitter.com/
             val twitter = "https://twitter.com/"
            val url = twitter+ binding.layoutAbout.txtTwitter
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }



    }

    private fun openWebsiteDataCoin(url: String) {

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)

    }

    private fun initStatistics() {

        binding.layoutStatistics.tvOpenAmount.text = dataThisCoin.dISPLAY.uSD.oPEN24HOUR
        binding.layoutStatistics.tvTodaysHighAmount.text = dataThisCoin.dISPLAY.uSD.hIGH24HOUR
        binding.layoutStatistics.tvTodayLowAmount.text = dataThisCoin.dISPLAY.uSD.lOW24HOUR
        binding.layoutStatistics.tvChangeTodayAmount.text = dataThisCoin.dISPLAY.uSD.cHANGE24HOUR
        binding.layoutStatistics.tvAlgorithm.text = dataThisCoin.coinInfo.algorithm
        binding.layoutStatistics.tvTotalVolume.text = dataThisCoin.dISPLAY.uSD.tOTALVOLUME24H
        binding.layoutStatistics.tvAvgMarketCapAmount.text = dataThisCoin.dISPLAY.uSD.mKTCAP
        binding.layoutStatistics.tvSupplyNumber.text = dataThisCoin.dISPLAY.uSD.sUPPLY
    }


    private fun initChartUi() {



        var period: String = HOUR
        requestAndShowChart(period)
        binding.layoutChart.radioGroupMain.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.radio_12h -> {
                    period = HOUR
                }
                R.id.radio_1d -> {
                    period = HOURS24
                }
                R.id.radio_1w -> {
                    period = WEEK
                }
                R.id.radio_1m -> {
                    period = MONTH
                }
                R.id.radio_3m -> {
                    period = MONTH3
                }
                R.id.radio_1y -> {
                    period = YEAR
                }
                R.id.radio_all -> {
                    period = ALL
                }
            }
            requestAndShowChart(period)
        }

        binding.layoutChart.txtChartPrice.text = dataThisCoin.dISPLAY.uSD.pRICE
        binding.layoutChart.txtChartChange1.text = " " + dataThisCoin.dISPLAY.uSD.cHANGE24HOUR

        if (dataThisCoin.coinInfo.fullName == "BUSD") {
            binding.layoutChart.txtChartChange2.text = "0%"
        } else {
            binding.layoutChart.txtChartChange2.text = dataThisCoin.rAW.uSD.cHANGEPCT24HOUR.toString().substring(0, 5) + "%"
        }

        val taghir = dataThisCoin.rAW.uSD.cHANGEPCT24HOUR
        if (taghir > 0) {

            binding.layoutChart.txtChartChange2.setTextColor(
                    ContextCompat.getColor(
                            binding.root.context,
                            R.color.colorGain
                    )
            )

            binding.layoutChart.txtChartUpdown.setTextColor(
                    ContextCompat.getColor(
                            binding.root.context,
                            R.color.colorGain
                    )
            )

            binding.layoutChart.txtChartUpdown.text = "▲"

            binding.layoutChart.sparkviewMain.lineColor = ContextCompat.getColor(
                    binding.root.context,
                    R.color.colorGain
            )

        } else if (taghir < 0) {

            binding.layoutChart.txtChartChange2.setTextColor(
                    ContextCompat.getColor(
                            binding.root.context,
                            R.color.colorLoss
                    )
            )

            binding.layoutChart.txtChartUpdown.setTextColor(
                    ContextCompat.getColor(
                            binding.root.context,
                            R.color.colorLoss
                    )
            )

            binding.layoutChart.txtChartUpdown.text = "▼"

            binding.layoutChart.sparkviewMain.lineColor = ContextCompat.getColor(
                    binding.root.context,
                    R.color.colorLoss
            )


        }

        binding.layoutChart.sparkviewMain.setScrubListener {

            // show price
            if ( it == null ) {
                binding.layoutChart.txtChartPrice.text = dataThisCoin.dISPLAY.uSD.pRICE
            } else {
                // show price this dot
                binding.layoutChart.txtChartPrice.text = "$ " + (it as ChartData.Data).close.toString()
            }

        }



    }


    fun requestAndShowChart(period: String) {

        apiManager.getChartData(
                dataThisCoin.coinInfo.name,
                period,
                object : ApiManager.ApiCallBack<Pair<List<ChartData.Data>, ChartData.Data?>> {
                    override fun success(data: Pair<List<ChartData.Data>, ChartData.Data?>) {
                        val chartAdapter = ChartAdapter(data.first, data.second?.open.toString())
                        binding.layoutChart.sparkviewMain.adapter = chartAdapter
                    }

                    override fun onError(errorMessage: String) {
                        Toast.makeText(
                                this@CoinActivity,
                                "error => " + errorMessage,
                                Toast.LENGTH_SHORT
                        ).show()
                    }
                })

    }

}