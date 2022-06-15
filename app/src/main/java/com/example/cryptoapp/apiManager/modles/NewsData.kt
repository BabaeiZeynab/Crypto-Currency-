package com.example.cryptoapp.apiManager.modles


import com.google.gson.annotations.SerializedName

data class NewsData(
    @SerializedName("Data") val `data`: List<Data> = listOf(),
    @SerializedName("HasWarning") val hasWarning: Boolean = false, // false
    @SerializedName("Message") val message: String = "", // News list successfully returned
    @SerializedName("Promoted") val promoted: List<Any> = listOf(),
    @SerializedName("RateLimit") val rateLimit: RateLimit = RateLimit(),
    @SerializedName("Type") val type: Int = 0 // 100
) {
    data class Data(
        @SerializedName("body") val body: String = "", // The chief executive of crypto asset management company Galaxy Digital, Mike Novogratz, thinks the majority of crypto hedge funds could be headed toward dark days in the future. Novogratz outlined his opinions while speaking at Piper Sandler Global Exchange &#38; Brokerage Conference on Wednesday, predicting that two-thirds of the roughly 1900 crypto hedge funds in [&#8230;]The post The Majority of Crypto Hedge Funds Will Go Out of Business, Predicts Galaxy Digital CEO Mike Novogratz: Report appeared first on The Daily Hodl.
        @SerializedName("categories") val categories: String = "", // Business|BTC|Exchange|Altcoin
        @SerializedName("downvotes") val downvotes: String = "", // 1
        @SerializedName("guid") val guid: String = "", // https://dailyhodl.com/?p=205946
        @SerializedName("id") val id: String = "", // 27697042
        @SerializedName("imageurl") val imageurl: String = "", // https://images.cryptocompare.com/news/default/dailyhodl.png
        @SerializedName("lang") val lang: String = "", // EN
        @SerializedName("published_on") val publishedOn: Int = 0, // 1654891252
        @SerializedName("source") val source: String = "", // dailyhodl
        @SerializedName("source_info") val sourceInfo: SourceInfo = SourceInfo(),
        @SerializedName("tags") val tags: String = "", // Altcoins|Bitcoin|digital assets|Galaxy Digital|hedge funds|mike novogratz|News
        @SerializedName("title") val title: String = "", // The Majority of Crypto Hedge Funds Will Go Out of Business, Predicts Galaxy Digital CEO Mike Novogratz: Report
        @SerializedName("upvotes") val upvotes: String = "", // 0
        @SerializedName("url") val url: String = "" // https://dailyhodl.com/2022/06/10/the-majority-of-crypto-hedge-funds-will-go-out-of-business-predicts-galaxy-digital-ceo-mike-novogratz-report/
    ) {
        data class SourceInfo(
            @SerializedName("img") val img: String = "", // https://images.cryptocompare.com/news/default/dailyhodl.png
            @SerializedName("lang") val lang: String = "", // EN
            @SerializedName("name") val name: String = "" // The Daily Hodl
        )
    }

    class RateLimit
}