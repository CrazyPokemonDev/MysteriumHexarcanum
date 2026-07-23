package de.crazypokemondev.mysterium_hexarcanum.client

import de.crazypokemondev.mysterium_hexarcanum.client.MysteriumHexarcanumClient
import net.fabricmc.api.ClientModInitializer

object FabricMysteriumHexarcanumClient : ClientModInitializer {
    override fun onInitializeClient() {
        MysteriumHexarcanumClient.init()
    }
}