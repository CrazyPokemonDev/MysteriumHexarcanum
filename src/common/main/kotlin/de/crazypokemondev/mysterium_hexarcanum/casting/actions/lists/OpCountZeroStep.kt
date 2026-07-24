package de.crazypokemondev.mysterium_hexarcanum.casting.actions.lists

import at.petrak.hexcasting.api.casting.asActionResult
import at.petrak.hexcasting.api.casting.castables.ConstMediaAction
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment
import at.petrak.hexcasting.api.casting.getDouble
import at.petrak.hexcasting.api.casting.getInt
import at.petrak.hexcasting.api.casting.iota.DoubleIota
import at.petrak.hexcasting.api.casting.iota.Iota
import kotlin.math.ceil
import kotlin.math.floor

object OpCountZeroStep : ConstMediaAction {
    override val argc: Int
        get() = 2

    override fun execute(
        args: List<Iota>,
        env: CastingEnvironment
    ): List<Iota> {
        val upper = floor(args.getDouble(0)).toInt()
        val step = args.getInt(1)
        return (0..upper step step).map { DoubleIota(it.toDouble()) }.asActionResult
    }
}