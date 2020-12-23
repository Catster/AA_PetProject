package com.kva.aa_petproject.exceptions

open class ViewTypeNotFoundException : RuntimeException {
    /**
     * Constructs a `ViewTypeNotFoundException` with no detail message.
     */
    constructor() : super() {}

    /**
     * Constructs a `ViewTypeNotFoundException` with the specified
     * detail message.
     *
     * @param   s   the detail message.
     */
    constructor(s: String?) : super(s) {}
}