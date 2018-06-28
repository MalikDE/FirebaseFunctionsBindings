package bindings

// https://firebase.google.com/docs/reference/functions/functions.https
// https://expressjs.com/en/api.html#res
// https://expressjs.com/en/api.html#req

external interface HttpsFunction {
    fun onRequest(handler: (Request, Response) -> Any): HttpsFunction
}

external interface Request {
    val query: dynamic
}

external interface Response {
    fun status(code: Int): Response
    fun send(message: String)
    fun end()
}