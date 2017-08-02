package DefaultArguments

fun foo(name: String, number: Int = 42, toUpperCase : Boolean = false) =
        (if (toUpperCase) name.toUpperCase() else name) + number
