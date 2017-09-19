import javafx.application.Application
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.FlowPane
import javafx.scene.text.Font
import javafx.scene.text.FontWeight
import javafx.stage.Screen
import javafx.stage.Stage

/**
 * @author Thomas Povinelli
 * * Created 2017-Sep-13
 * * In AspectRatioTest
 */
class Main: Application() {

    tailrec fun gcd(x: Double, y: Double): Double {
        if (x == y) return x;
        if (x < y) return gcd(x, y - x)
        if (x > y) return gcd(x - y, y)
        return 0.0
    }

    @Throws(Exception::class)
    override fun start(primaryStage: Stage) {
        val width = Screen.getPrimary().bounds.width
        val height = Screen.getPrimary().bounds.height
        val gcd = gcd(width, height)
        val l = Label("The aspect ratio of your primary screen is ${(width / gcd).toInt()}:${(height / gcd).toInt()}")
        val b = Button("OK")
        b.onAction = EventHandler<ActionEvent> { primaryStage.close() }
        l.font = Font.font(Font.getDefault().family, FontWeight.BOLD, 18.0)
        primaryStage.title = "Aspect Ratio Information"
        val pane = FlowPane(l, b)
        pane.alignment = Pos.CENTER
        pane.padding = Insets(5.0)
        pane.hgap = 5.0
        pane.vgap = 5.0
        primaryStage.scene = Scene(pane)
        primaryStage.show()

    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(Main::class.java)
        }
    }
}
