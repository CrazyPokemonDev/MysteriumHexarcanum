package de.crazypokemondev.mysterium_hexarcanum.config

import me.fzzyhmstrs.fzzy_config.api.ConfigApi
import me.fzzyhmstrs.fzzy_config.api.RegisterType

object MysteriumHexarcanumConfigs {
    //instance of your config loaded from file and automatically registered to the SyncedConfigRegistry and ClientConfigRegistry using the getId() method
    val COMMON_CONFIG = ConfigApi.registerAndLoadConfig(::MysteriumHexarcanumCommonConfig)

    //adding the registerType, you can register a config as client-only. No syncing will occur. Useful for client-only mods.
    val CLIENT_CONFIG = ConfigApi.registerAndLoadConfig(::MysteriumHexarcanumClientConfig, RegisterType.CLIENT)

    fun init() {}
}