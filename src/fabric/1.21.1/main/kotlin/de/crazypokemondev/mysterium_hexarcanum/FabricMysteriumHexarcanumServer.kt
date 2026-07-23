package de.crazypokemondev.mysterium_hexarcanum

import net.fabricmc.api.DedicatedServerModInitializer

object FabricMysteriumHexarcanumServer : DedicatedServerModInitializer {
    override fun onInitializeServer() {
        MysteriumHexarcanum.initServer()
    }
}
