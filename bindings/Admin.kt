package bindings

@JsModule("firebase-admin")
@JsNonModule
external object Admin {
    fun initializeApp(config: dynamic)
    fun database(): Database

    /**
     * Namespace to access constant but OK for [Database.TIMESTAMP]
     */
    @JsName("database")
    val databaseNs: Database.NameSpace
}


