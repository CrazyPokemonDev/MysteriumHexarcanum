@file:JvmName("MysteriumHexarcanumAbstractionsActual")

package de.crazypokemondev.mysterium_hexarcanum

import de.crazypokemondev.mysterium_hexarcanum.registry.MysteriumHexarcanumRegistrar
import net.minecraft.core.Registry
import net.msrandom.multiplatform.annotations.Actual

actual fun <T : Any> initRegistry(registrar: MysteriumHexarcanumRegistrar<T>) {
    val registry = registrar.registry
    registrar.init { id, value -> Registry.register(registry, id, value) }
}
