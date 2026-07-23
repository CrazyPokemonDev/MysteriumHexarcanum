@file:JvmName("MysteriumHexarcanumAbstractions")

package de.crazypokemondev.mysterium_hexarcanum

import de.crazypokemondev.mysterium_hexarcanum.registry.MysteriumHexarcanumRegistrar

fun initRegistries(vararg registries: MysteriumHexarcanumRegistrar<*>) {
    for (registry in registries) {
        initRegistry(registry)
    }
}

expect fun <T : Any> initRegistry(registrar: MysteriumHexarcanumRegistrar<T>)
