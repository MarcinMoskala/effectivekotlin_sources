package f_C5_Item33.s_3

class Pizza {
    val size: String
    val cheese: Int
    val olives: Int
    val bacon: Int

    constructor(
        size: String,
        cheese: Int,
        olives: Int,
        bacon: Int
    ) {
        this.size = size
        this.cheese = cheese
        this.olives = olives
        this.bacon = bacon
    }

    constructor(
        size: String,
        cheese: Int,
        olives: Int
    ) : this(size, cheese, olives, 0)

    constructor(
        size: String,
        cheese: Int
    ) : this(size, cheese, 0)

    constructor(size: String) : this(size, 0)
}
