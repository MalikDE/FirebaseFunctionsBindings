import bindings.Admin
import bindings.Functions
import functions.*


public external val exports: dynamic

fun main(args: Array<String>) {
    Admin.initializeApp(Functions.config().firebase)

    JoinGameFunction.export()
    CreateGameFunction.export()
    StartGameFunction.export()
    CaptureTileFunction.export()
    SelectTileFunction.export()

}