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

object OpCountStep : ConstMediaAction {
    override val argc: Int
        get() = 3

    override fun execute(
        args: List<Iota>,
        env: CastingEnvironment
    ): List<Iota> {
        val lower = ceil(args.getDouble(0)).toInt()
        val upper = floor(args.getDouble(1)).toInt()
        val step = args.getInt(2)
        return (lower..upper step step).map { DoubleIota(it.toDouble()) }.asActionResult
    }
}