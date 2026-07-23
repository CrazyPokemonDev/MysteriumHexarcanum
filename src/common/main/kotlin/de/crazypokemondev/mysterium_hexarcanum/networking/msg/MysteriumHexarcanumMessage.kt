package de.crazypokemondev.mysterium_hexarcanum.networking.msg

import de.crazypokemondev.mysterium_hexarcanum.MysteriumHexarcanum
import de.crazypokemondev.mysterium_hexarcanum.networking.MysteriumHexarcanumNetworking
import de.crazypokemondev.mysterium_hexarcanum.networking.handler.applyOnClient
import de.crazypokemondev.mysterium_hexarcanum.networking.handler.applyOnServer
import io.wispforest.owo.network.ClientAccess
import io.wispforest.owo.network.OwoNetChannel
import io.wispforest.owo.network.ServerAccess
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.server.level.ServerPlayer

sealed interface MysteriumHexarcanumMessage

sealed interface MysteriumHexarcanumMessageC2S : MysteriumHexarcanumMessage {
    fun <T> T.sendToServer() where T : Record {
        MysteriumHexarcanumNetworking.CHANNEL.clientHandle().send(this)
    }
}

sealed interface MysteriumHexarcanumMessageS2C : MysteriumHexarcanumMessage {
}

fun <T> T.sendToPlayer(player: ServerPlayer) where T : Record {
    MysteriumHexarcanumNetworking.CHANNEL.serverHandle(player).send( this)
}

fun <T> T.sendToPlayers(players: Iterable<ServerPlayer>) where T : Record {
    players.forEach { sendToPlayer(it) }
}

sealed interface MysteriumHexarcanumMessageCompanion<T> where T : MysteriumHexarcanumMessage, T : Record {
    val type: Class<T>

    fun apply(msg: T, access: ServerAccess): Unit {
        MysteriumHexarcanum.LOGGER.debug("Server received packet from {}: {}", access.player().name.string, this)
        when (msg) {
            is MysteriumHexarcanumMessageC2S -> msg.applyOnServer(access)
            else -> MysteriumHexarcanum.LOGGER.warn("Message not handled on server: {}", msg::class)
        }
    }

    fun apply(msg: T, access: ClientAccess): Unit {
        MysteriumHexarcanum.LOGGER.debug("Client received packet: {}", this)
        when (msg) {
            is MysteriumHexarcanumMessageS2C -> msg.applyOnClient(access)
            else -> MysteriumHexarcanum.LOGGER.warn("Message not handled on client: {}", msg::class)
        }
    }

    fun register(channel: OwoNetChannel) {
        channel.registerServerbound(type) { msg, access -> apply(msg, access) }
    }
}
