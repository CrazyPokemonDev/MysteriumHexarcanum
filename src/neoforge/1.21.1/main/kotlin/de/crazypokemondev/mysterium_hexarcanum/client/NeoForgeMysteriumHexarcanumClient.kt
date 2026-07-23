package de.crazypokemondev.mysterium_hexarcanum.client

import de.crazypokemondev.mysterium_hexarcanum.client.MysteriumHexarcanumClient
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent
import net.neoforged.neoforge.client.gui.IConfigScreenFactory
import thedarkcolour.kotlinforforge.neoforge.forge.LOADING_CONTEXT

object NeoForgeMysteriumHexarcanumClient {
    @Suppress("UNUSED_PARAMETER")
    fun init(event: FMLClientSetupEvent) {
        MysteriumHexarcanumClient.init()
    }
}