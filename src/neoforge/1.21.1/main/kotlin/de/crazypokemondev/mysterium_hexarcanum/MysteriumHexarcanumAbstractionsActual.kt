@file:JvmName("MysteriumHexarcanumAbstractionsActual")

package de.crazypokemondev.mysterium_hexarcanum

import de.crazypokemondev.mysterium_hexarcanum.registry.MysteriumHexarcanumRegistrar
import net.msrandom.multiplatform.annotations.Actual
import net.neoforged.neoforge.registries.RegisterEvent

actual fun <T : Any> initRegistry(registrar: MysteriumHexarcanumRegistrar<T>) {
        NeoForgeMysteriumHexarcanum.container.eventBus!!.addListener { event: RegisterEvent ->
            event.register(registrar.registryKey) { helper ->
                registrar.init(helper::register)
            }
        }
}