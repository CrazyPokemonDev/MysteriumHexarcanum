package de.crazypokemondev.mysterium_hexarcanum.networking.msg

@JvmRecord
data class MsgExampleS2C(val payload: Int) : MysteriumHexarcanumMessageS2C {
   companion object : MysteriumHexarcanumMessageCompanion<MsgExampleS2C> {
       override val type = MsgExampleS2C::class.java
   }
}
