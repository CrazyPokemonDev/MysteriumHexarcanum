package de.crazypokemondev.mysterium_hexarcanum

import de.crazypokemondev.mysterium_hexarcanum.config.MysteriumHexarcanumConfigs
import net.minecraft.resources.ResourceLocation
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import de.crazypokemondev.mysterium_hexarcanum.networking.MysteriumHexarcanumNetworking
import de.crazypokemondev.mysterium_hexarcanum.registry.MysteriumHexarcanumActions

object MysteriumHexarcanum {
    const val MODID = "mysterium_hexarcanum"

    @JvmField
    val LOGGER: Logger = LogManager.getLogger(MODID)



    @JvmStatic
    fun id(path: String): ResourceLocation = ResourceLocation.fromNamespaceAndPath(MODID, path)

    fun init() {
        initRegistries(
            MysteriumHexarcanumActions,
        )
        MysteriumHexarcanumNetworking.init()
        MysteriumHexarcanumConfigs.init()
    }

    fun initServer() {
    }
}
