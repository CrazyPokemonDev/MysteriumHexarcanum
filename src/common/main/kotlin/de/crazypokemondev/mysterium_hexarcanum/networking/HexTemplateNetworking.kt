package de.crazypokemondev.mysterium_hexarcanum.networking

import de.crazypokemondev.mysterium_hexarcanum.MysteriumHexarcanum
import de.crazypokemondev.mysterium_hexarcanum.networking.msg.MysteriumHexarcanumMessageCompanion
import io.wispforest.owo.network.OwoNetChannel

object MysteriumHexarcanumNetworking {
    val CHANNEL: OwoNetChannel = OwoNetChannel.create(MysteriumHexarcanum.id("networking_channel"))

    fun init() {
        for (subclass in MysteriumHexarcanumMessageCompanion::class.sealedSubclasses) {
            subclass.objectInstance?.register(CHANNEL)
        }
    }
}
