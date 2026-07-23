package de.crazypokemondev.mysterium_hexarcanum

import de.crazypokemondev.mysterium_hexarcanum.client.NeoForgeMysteriumHexarcanumClient
import de.crazypokemondev.mysterium_hexarcanum.datagen.NeoForgeMysteriumHexarcanumDatagen
import net.neoforged.bus.api.IEventBus
import net.neoforged.fml.ModContainer
import net.neoforged.fml.ModList
import net.neoforged.fml.common.Mod

@Mod(MysteriumHexarcanum.MODID)
class NeoForgeMysteriumHexarcanum(modBus: IEventBus, container: ModContainer) {
    init {
        modBus.apply {
            addListener(NeoForgeMysteriumHexarcanumClient::init)
            addListener(NeoForgeMysteriumHexarcanumDatagen::init)
            addListener(NeoForgeMysteriumHexarcanumServer::init)
        }
        MysteriumHexarcanum.init()
    }

    companion object {
        internal val container: ModContainer
            get() = ModList.get().getModContainerById(MysteriumHexarcanum.MODID).get()
    }
}
