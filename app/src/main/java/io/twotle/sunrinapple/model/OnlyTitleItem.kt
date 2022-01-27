package io.twotle.sunrinapple.model

data class OnlyTitleItem(
    val title: String
) : Item {
    override val viewType: Int
        get() = OnlyTitleItem::class.hashCode()
}
