package de.crazypokemondev.mysterium_hexarcanum.config

import de.crazypokemondev.mysterium_hexarcanum.MysteriumHexarcanum
import me.fzzyhmstrs.fzzy_config.config.Config

// guide: https://moddedmc.wiki/en/project/fzzy-config/latest/docs/config-design/New-Configs#2-config-creation
class MysteriumHexarcanumClientConfig : Config(MysteriumHexarcanum.id("client_config")) {

    var testValue = 2.0

}