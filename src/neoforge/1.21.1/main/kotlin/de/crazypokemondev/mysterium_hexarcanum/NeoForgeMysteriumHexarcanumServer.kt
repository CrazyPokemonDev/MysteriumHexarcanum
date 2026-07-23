package de.crazypokemondev.mysterium_hexarcanum

import net.neoforged.fml.event.lifecycle.FMLDedicatedServerSetupEvent

object NeoForgeMysteriumHexarcanumServer {
    @Suppress("UNUSED_PARAMETER")
    fun init(event: FMLDedicatedServerSetupEvent) {
        MysteriumHexarcanum.initServer()
    }
}

