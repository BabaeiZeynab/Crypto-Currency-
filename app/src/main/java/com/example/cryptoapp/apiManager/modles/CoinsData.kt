package com.example.cryptoapp.apiManager.modles


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class CoinsData(
    @SerializedName("Data") val `data`: List<Data> = listOf(),
    @SerializedName("HasWarning") val hasWarning: Boolean = false, // false
    @SerializedName("Message") val message: String = "", // Success
    @SerializedName("MetaData") val metaData: MetaData = MetaData(),
    @SerializedName("RateLimit") val rateLimit: RateLimit = RateLimit(),
    @SerializedName("SponsoredData") val sponsoredData: List<Any> = listOf(),
    @SerializedName("Type") val type: Int = 0 // 100
) {
    @Parcelize
    data class Data(
        @SerializedName("CoinInfo") val coinInfo: CoinInfo = CoinInfo(),
        @SerializedName("DISPLAY") val dISPLAY: DISPLAY = DISPLAY(),
        @SerializedName("RAW") val rAW: RAW = RAW()
    ) : Parcelable{

        @Parcelize
        data class CoinInfo(
            @SerializedName("Algorithm") val algorithm: String = "", // Ethash
            @SerializedName("AssetLaunchDate") val assetLaunchDate: String = "", // 2015-07-30
            @SerializedName("BlockNumber") val blockNumber: Int = 0, // 14947428
            @SerializedName("BlockReward") val blockReward: Double = 0.0, // 2.091122577540275
           //// @SerializedName("BlockTime") val blockTime: Double = 0.0, // 14.749542657575253
            @SerializedName("DocumentType") val documentType: String = "", // Webpagecoinp
            @SerializedName("FullName") val fullName: String = "", // Ethereum
            @SerializedName("Id") val id: String = "", // 7605
            @SerializedName("ImageUrl") val imageUrl: String = "", // /media/37746238/eth.png
            @SerializedName("Internal") val `internal`: String = "", // ETH
            @SerializedName("MaxSupply") val maxSupply: Double = 0.0, // 20999999.9769
            @SerializedName("Name") val name: String = "", // ETH
//            @SerializedName("NetHashesPerSecond") val netHashesPerSecond: Bi = 0.0, // 1063651897442529.9
            @SerializedName("ProofType") val proofType: String = "", // PoW
            @SerializedName("Rating") val rating: Rating = Rating(),
            @SerializedName("Type") val type: Int = 0, // 1
            @SerializedName("Url") val url: String = "" // /coins/eth/overview
        ): Parcelable {

            @Parcelize
            data class Rating(
                @SerializedName("Weiss") val weiss: Weiss = Weiss()
            ) :Parcelable{

                @Parcelize
                data class Weiss(
                    @SerializedName("MarketPerformanceRating") val marketPerformanceRating: String = "", // D+
                    @SerializedName("Rating") val rating: String = "", // B+
                    @SerializedName("TechnologyAdoptionRating") val technologyAdoptionRating: String = "" // A
                ):Parcelable
            }
        }


           @Parcelize
        data class DISPLAY(
            @SerializedName("USD") val uSD: USD = USD()
        ) :Parcelable{

               @Parcelize
            data class USD(
                @SerializedName("CHANGE24HOUR") val cHANGE24HOUR: String = "", // $ -157.66
                @SerializedName("CHANGEDAY") val cHANGEDAY: String = "", // $ -14.21
                @SerializedName("CHANGEHOUR") val cHANGEHOUR: String = "", // $ -20.19
                @SerializedName("CHANGEPCT24HOUR") val cHANGEPCT24HOUR: String = "", // -9.42
                @SerializedName("CHANGEPCTDAY") val cHANGEPCTDAY: String = "", // -0.93
                @SerializedName("CHANGEPCTHOUR") val cHANGEPCTHOUR: String = "", // -1.31
                @SerializedName("CIRCULATINGSUPPLY") val cIRCULATINGSUPPLY: String = "", // Ξ 121,138,664.1
                @SerializedName("CIRCULATINGSUPPLYMKTCAP") val cIRCULATINGSUPPLYMKTCAP: String = "", // $ 183.68 B
                @SerializedName("CONVERSIONSYMBOL") val cONVERSIONSYMBOL: String = "",
                @SerializedName("CONVERSIONTYPE") val cONVERSIONTYPE: String = "", // direct
                @SerializedName("FROMSYMBOL") val fROMSYMBOL: String = "", // Ξ
                @SerializedName("HIGH24HOUR") val hIGH24HOUR: String = "", // $ 1,678.53
                @SerializedName("HIGHDAY") val hIGHDAY: String = "", // $ 1,540.47
                @SerializedName("HIGHHOUR") val hIGHHOUR: String = "", // $ 1,537.55
                @SerializedName("IMAGEURL") val iMAGEURL: String = "", // /media/37746238/eth.png
                @SerializedName("LASTMARKET") val lASTMARKET: String = "", // Coinbase
                @SerializedName("LASTTRADEID") val lASTTRADEID: String = "", // 291615562
                @SerializedName("LASTUPDATE") val lASTUPDATE: String = "", // Just now
                @SerializedName("LASTVOLUME") val lASTVOLUME: String = "", // Ξ 0.08706
                @SerializedName("LASTVOLUMETO") val lASTVOLUMETO: String = "", // $ 131.94
                @SerializedName("LOW24HOUR") val lOW24HOUR: String = "", // $ 1,500.58
                @SerializedName("LOWDAY") val lOWDAY: String = "", // $ 1,512.55
                @SerializedName("LOWHOUR") val lOWHOUR: String = "", // $ 1,512.55
                @SerializedName("MARKET") val mARKET: String = "", // CryptoCompare Index
                @SerializedName("MKTCAP") val mKTCAP: String = "", // $ 183.68 B
                @SerializedName("MKTCAPPENALTY") val mKTCAPPENALTY: String = "", // 0 %
                @SerializedName("OPEN24HOUR") val oPEN24HOUR: String = "", // $ 1,673.97
                @SerializedName("OPENDAY") val oPENDAY: String = "", // $ 1,530.52
                @SerializedName("OPENHOUR") val oPENHOUR: String = "", // $ 1,536.50
                @SerializedName("PRICE") val pRICE: String = "", // $ 1,516.31
                @SerializedName("SUPPLY") val sUPPLY: String = "", // Ξ 121,138,664.1
                @SerializedName("TOPTIERVOLUME24HOUR") val tOPTIERVOLUME24HOUR: String = "", // Ξ 561,961.5
                @SerializedName("TOPTIERVOLUME24HOURTO") val tOPTIERVOLUME24HOURTO: String = "", // $ 880,717,164.3
                @SerializedName("TOSYMBOL") val tOSYMBOL: String = "", // $
                @SerializedName("TOTALTOPTIERVOLUME24H") val tOTALTOPTIERVOLUME24H: String = "", // Ξ 4.78 M
                @SerializedName("TOTALTOPTIERVOLUME24HTO") val tOTALTOPTIERVOLUME24HTO: String = "", // $ 7.27 B
                @SerializedName("TOTALVOLUME24H") val tOTALVOLUME24H: String = "", // Ξ 4.79 M
                @SerializedName("TOTALVOLUME24HTO") val tOTALVOLUME24HTO: String = "", // $ 7.29 B
                @SerializedName("VOLUME24HOUR") val vOLUME24HOUR: String = "", // Ξ 561,961.5
                @SerializedName("VOLUME24HOURTO") val vOLUME24HOURTO: String = "", // $ 880,717,164.3
                @SerializedName("VOLUMEDAY") val vOLUMEDAY: String = "", // Ξ 18,709.2
                @SerializedName("VOLUMEDAYTO") val vOLUMEDAYTO: String = "", // $ 28,593,772.7
                @SerializedName("VOLUMEHOUR") val vOLUMEHOUR: String = "", // Ξ 10,204.7
                @SerializedName("VOLUMEHOURTO") val vOLUMEHOURTO: String = "" // $ 15,534,869.7
            ): Parcelable
        }
        @Parcelize
        data class RAW(
            @SerializedName("USD") val uSD: USD = USD()
        ):Parcelable {


            @Parcelize
            data class USD(
                @SerializedName("CHANGE24HOUR") val cHANGE24HOUR: Double = 0.0, // -157.66000000000008
                @SerializedName("CHANGEDAY") val cHANGEDAY: Double = 0.0, // -14.210000000000036
                @SerializedName("CHANGEHOUR") val cHANGEHOUR: Double = 0.0, // -20.190000000000055
                @SerializedName("CHANGEPCT24HOUR") val cHANGEPCT24HOUR: Double = 0.0, // -9.41832888283542
                @SerializedName("CHANGEPCTDAY") val cHANGEPCTDAY: Double = 0.0, // -0.9284426208086165
                @SerializedName("CHANGEPCTHOUR") val cHANGEPCTHOUR: Double = 0.0, // -1.3140253823625156
                @SerializedName("CIRCULATINGSUPPLY") val cIRCULATINGSUPPLY: Double = 0.0, // 121138664.0615
                @SerializedName("CIRCULATINGSUPPLYMKTCAP") val cIRCULATINGSUPPLYMKTCAP: Double = 0.0, // 183683767703.09305
                @SerializedName("CONVERSIONSYMBOL") val cONVERSIONSYMBOL: String = "",
                @SerializedName("CONVERSIONTYPE") val cONVERSIONTYPE: String = "", // direct
                @SerializedName("FLAGS") val fLAGS: String = "", // 2052
                @SerializedName("FROMSYMBOL") val fROMSYMBOL: String = "", // ETH
                @SerializedName("HIGH24HOUR") val hIGH24HOUR: Double = 0.0, // 1678.53
                @SerializedName("HIGHDAY") val hIGHDAY: Double = 0.0, // 1540.47
                @SerializedName("HIGHHOUR") val hIGHHOUR: Double = 0.0, // 1537.55
                @SerializedName("IMAGEURL") val iMAGEURL: String = "", // /media/37746238/eth.png
                @SerializedName("LASTMARKET") val lASTMARKET: String = "", // Coinbase
                @SerializedName("LASTTRADEID") val lASTTRADEID: String = "", // 291615562
                @SerializedName("LASTUPDATE") val lASTUPDATE: Int = 0, // 1654997420
                @SerializedName("LASTVOLUME") val lASTVOLUME: Double = 0.0, // 0.08706109
                @SerializedName("LASTVOLUMETO") val lASTVOLUMETO: Double = 0.0, // 131.9393406732
                @SerializedName("LOW24HOUR") val lOW24HOUR: Double = 0.0, // 1500.58
                @SerializedName("LOWDAY") val lOWDAY: Double = 0.0, // 1512.55
                @SerializedName("LOWHOUR") val lOWHOUR: Double = 0.0, // 1512.55
                @SerializedName("MARKET") val mARKET: String = "", // CCCAGG
                @SerializedName("MEDIAN") val mEDIAN: Double = 0.0, // 1517.15
                @SerializedName("MKTCAP") val mKTCAP: Double = 0.0, // 183683767703.09305
                @SerializedName("MKTCAPPENALTY") val mKTCAPPENALTY: Int = 0, // 0
                @SerializedName("OPEN24HOUR") val oPEN24HOUR: Double = 0.0, // 1673.97
                @SerializedName("OPENDAY") val oPENDAY: Double = 0.0, // 1530.52
                @SerializedName("OPENHOUR") val oPENHOUR: Double = 0.0, // 1536.5
                @SerializedName("PRICE") val pRICE: Double = 0.0, // 1516.31
                @SerializedName("SUPPLY") val sUPPLY: Double = 0.0, // 121138664.0615
                @SerializedName("TOPTIERVOLUME24HOUR") val tOPTIERVOLUME24HOUR: Double = 0.0, // 561961.48879586
                @SerializedName("TOPTIERVOLUME24HOURTO") val tOPTIERVOLUME24HOURTO: Double = 0.0, // 880717164.3213664
                @SerializedName("TOSYMBOL") val tOSYMBOL: String = "", // USD
                @SerializedName("TOTALTOPTIERVOLUME24H") val tOTALTOPTIERVOLUME24H: Double = 0.0, // 4775508.79918757
                @SerializedName("TOTALTOPTIERVOLUME24HTO") val tOTALTOPTIERVOLUME24HTO: Double = 0.0, // 7269761086.54142
                @SerializedName("TOTALVOLUME24H") val tOTALVOLUME24H: Double = 0.0, // 4787437.681523138
                @SerializedName("TOTALVOLUME24HTO") val tOTALVOLUME24HTO: Double = 0.0, // 7287848970.115665
                @SerializedName("TYPE") val tYPE: String = "", // 5
                @SerializedName("VOLUME24HOUR") val vOLUME24HOUR: Double = 0.0, // 561961.48879586
                @SerializedName("VOLUME24HOURTO") val vOLUME24HOURTO: Double = 0.0, // 880717164.3213664
                @SerializedName("VOLUMEDAY") val vOLUMEDAY: Double = 0.0, // 18709.21477268345
                @SerializedName("VOLUMEDAYTO") val vOLUMEDAYTO: Double = 0.0, // 28593772.74276216
                @SerializedName("VOLUMEHOUR") val vOLUMEHOUR: Double = 0.0, // 10204.66160957138
                @SerializedName("VOLUMEHOURTO") val vOLUMEHOURTO: Double = 0.0 // 15534869.714629058
            ):Parcelable
        }
    }

    data class MetaData(
        @SerializedName("Count") val count: Int = 0 // 3245
    )

    class RateLimit
}