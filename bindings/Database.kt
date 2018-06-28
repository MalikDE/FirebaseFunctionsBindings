package bindings

// https://firebase.google.com/docs/reference/js/firebase.database.Database
// https://firebase.google.com/docs/reference/js/firebase.database.ServerValue
// https://firebase.google.com/docs/reference/js/firebase.database.Reference
// https://firebase.google.com/docs/reference/js/firebase.database.Query
// https://firebase.google.com/docs/reference/functions/functions.database.RefBuilder#onWrite

external interface Database {
    fun ref(path: String = definedExternally): Reference

    /**
     * Namespace to access constants
     */
    interface NameSpace {
        val ServerValue: ServerValue
    }
}

external interface ServerValue {
    val TIMESTAMP: Any
}

external interface Reference : Query {
    val key: String?
    val parent: Reference
    val root: Reference

    fun child(path: String): Reference
    fun push(): Reference
    fun push(value: Any?, onComplete: ((FirebaseError) -> Unit)? = definedExternally): Reference
    fun set(value: Any): Promise<Unit>
    fun update(values: dynamic): Promise<Unit>
    fun remove(): Promise<Unit>

    fun <T> onWrite(handler: (Event<T>) -> Any): CloudFunction
    fun <T> onCreate(handler: (Event<T>) -> Any): CloudFunction
    fun <T> transaction(transactionUpdate: (T?) -> T?): Promise<TransacResult<T>>
}

external interface TransacResult<T> {
    val committed: Boolean
    val snapshot: DataSnapshot<T>
}

external interface Query {
    val ref: Reference

    fun equalTo(value: Any?): Query
    fun orderByChild(path: String): Query
    fun orderByKey(): Query
    fun orderByValue(): Query

    fun limitToFirst(limit:Int): Query
    fun limitToLast(limit:Int): Query

    fun endAt(value: Any): Query
    fun startAt(value: Any): Query

    fun <T> once(type: String): Promise<DataSnapshot<T>>
}

//external class  ThenableReference<T> : Promise<T>, Reference

