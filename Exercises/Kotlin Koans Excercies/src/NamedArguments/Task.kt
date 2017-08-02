package NamedArguments

/**
 * @return String
 */
fun joinOptions(options: Collection<String>) = options.joinToString(prefix="[", postfix="]")