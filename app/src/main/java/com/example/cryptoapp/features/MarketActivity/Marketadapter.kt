package com.example.cryptoapp.features.MarketActivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cryptoapp.R
import com.example.cryptoapp.apiManager.IMG_URL
import com.example.cryptoapp.apiManager.modles.CoinsData
import com.example.cryptoapp.databinding.ItemRecyclerBinding


class Marketadapter(private val data: ArrayList<CoinsData.Data>, private val  recyclerCallback:RecyclerCallBack) :RecyclerView.Adapter<Marketadapter.MarketViewHolder>(){

    lateinit var binding: ItemRecyclerBinding

    inner class MarketViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
        fun bindViews(dataCoin: CoinsData.Data) {

            binding.txtCoinName.text = dataCoin.coinInfo.fullName
            binding.txtPrice.text = dataCoin.dISPLAY.uSD.pRICE

            val taghir = dataCoin.rAW.uSD.cHANGEPCT24HOUR
            if (taghir > 0) {
                binding.txtTaghir.setTextColor(
                        ContextCompat.getColor(
                                binding.root.context,
                                R.color.colorGain
                        )
                )
                binding.txtTaghir.text =
                        dataCoin.rAW.uSD.cHANGEPCT24HOUR.toString().substring(0, 4) + "%"
            } else if (taghir < 0) {
                binding.txtTaghir.setTextColor(
                        ContextCompat.getColor(
                                binding.root.context,
                                R.color.colorLoss
                        )
                )
                binding.txtTaghir.text =
                        dataCoin.rAW.uSD.cHANGEPCT24HOUR.toString().substring(0, 5) + "%"
            } else {
                binding.txtTaghir.text = "0%"
            }

            val marketCap = dataCoin.rAW.uSD.mKTCAP / 1000000000
            val indexDot = marketCap.toString().indexOf('.')
            binding.txtMarketCap.text = "$" + marketCap.toString().substring(0 , indexDot + 3) + " B"

            Glide
                    .with(itemView)
                    .load(IMG_URL + dataCoin.coinInfo.imageUrl)
                    .into(binding.imgItem)


            itemView.setOnClickListener {
                recyclerCallback.onCoinItemClicked(dataCoin)
            }

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarketViewHolder {

      binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MarketViewHolder(binding.root)

    }

    override fun onBindViewHolder(holderMarket: MarketViewHolder, position: Int) {

         holderMarket.bindViews(data[position])

    }

    override fun getItemCount(): Int {
       return data.size
    }

    interface RecyclerCallBack {
        fun onCoinItemClicked(dataCoin: CoinsData.Data)

    }


}