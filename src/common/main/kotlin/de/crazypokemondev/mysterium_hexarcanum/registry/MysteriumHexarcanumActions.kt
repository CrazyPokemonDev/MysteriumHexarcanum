package de.crazypokemondev.mysterium_hexarcanum.registry

import at.petrak.hexcasting.api.casting.ActionRegistryEntry
import at.petrak.hexcasting.api.casting.castables.Action
import at.petrak.hexcasting.api.casting.math.HexDir
import at.petrak.hexcasting.api.casting.math.HexPattern
import at.petrak.hexcasting.common.lib.HexRegistries
import at.petrak.hexcasting.common.lib.hex.HexActions
import de.crazypokemondev.mysterium_hexarcanum.casting.actions.lists.OpCount
import de.crazypokemondev.mysterium_hexarcanum.casting.actions.lists.OpCountStep
import de.crazypokemondev.mysterium_hexarcanum.casting.actions.lists.OpCountZero
import de.crazypokemondev.mysterium_hexarcanum.casting.actions.lists.OpCountZeroStep
import de.crazypokemondev.mysterium_hexarcanum.casting.actions.spells.OpCongratulate

object MysteriumHexarcanumActions : MysteriumHexarcanumRegistrar<ActionRegistryEntry>(
    HexRegistries.ACTION,
    { HexActions.REGISTRY },
) {
    val COUNT = make("count", HexDir.NORTH_WEST, "qaeaqwdedd", OpCount)
    val COUNT_ZERO = make("count_zero", HexDir.NORTH_WEST, "qaeaqdaqaa", OpCountZero)
    val COUNT_STEP  = make("count_step", HexDir.NORTH_WEST, "qaeaqwdeddw", OpCountStep)
    val COUNT_ZERO_STEP = make("count_zero_step", HexDir.NORTH_WEST, "qaeaqdaqaaw", OpCountZeroStep)
    val CONGRATULATE = make("congratulate", HexDir.WEST, "eed", OpCongratulate)

    val GREAT_CONGRATULATE = make("congratulate/great", HexDir.EAST, "qwwqqqwwqwded", OpCongratulate)

    private fun make(name: String, startDir: HexDir, signature: String, action: Action) =
        make(name, startDir, signature) { action }

    private fun make(name: String, startDir: HexDir, signature: String, getAction: () -> Action) = register(name) {
        ActionRegistryEntry(HexPattern.fromAngles(signature, startDir), getAction())
    }
}
