package de.crazypokemondev.mysterium_hexarcanum

import net.fabricmc.api.ModInitializer

object FabricMysteriumHexarcanum : ModInitializer {
    override fun onInitialize() {
        MysteriumHexarcanum.init()
    }
}
