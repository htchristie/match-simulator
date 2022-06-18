package me.dio.simulator.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Match(
    @SerializedName("descricao")
    val description: String,
    @SerializedName("local")
    val stadium: Stadium,
    @SerializedName("mandante")
    val homeTeam: Team,
    @SerializedName("visitante")
    val guestTeam: Team
): Parcelable
