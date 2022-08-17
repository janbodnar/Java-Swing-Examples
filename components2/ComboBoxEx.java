package com.zetcode

import java.awt.EventQueue
import java.awt.event.ItemEvent
import java.awt.event.ItemListener
import javax.swing.GroupLayout
import javax.swing.GroupLayout.Alignment.BASELINE
import javax.swing.JComboBox
import javax.swing.JComponent
import javax.swing.JFrame
import javax.swing.JLabel

class ComboBoxEx(title: String) : JFrame(), ItemListener {

    private lateinit var display: JLabel
    private lateinit var box: JComboBox<String>

    init {
        createUI(title)
    }

    private fun createUI(title: String) {

        val distros = arrayOf(
            "Ubuntu", "Redhat", "Arch",
            "Debian", "Mint"
        )

        box = JComboBox<String>(distros)
        box.font = box.font.deriveFont(14f)
        box.addItemListener(this)

        display = JLabel("Ubuntu")
        display.font = display.font.deriveFont(14f)

        createLayout(box, display)

        setTitle(title)

        defaultCloseOperation = EXIT_ON_CLOSE
        setSize(400, 350)
        setLocationRelativeTo(null)
    }

    override fun itemStateChanged(e: ItemEvent) {

        if (e.stateChange == ItemEvent.SELECTED) {
            display.text = e.item.toString();
        }
    }

    private fun createLayout(vararg arg: JComponent) {

        val pane = contentPane
        val gl = GroupLayout(pane)
        pane.layout = gl

        gl.autoCreateContainerGaps = true
        gl.autoCreateGaps = true

        gl.setHorizontalGroup(
            gl.createSequentialGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
        )
        gl.setVerticalGroup(
            gl.createParallelGroup(BASELINE)
                .addComponent(arg[0])
                .addComponent(arg[1])
        )
        pack()
    }
}

private fun createAndShowGUI() {

    val frame = ComboBoxEx("JComboBox")
    frame.isVisible = true
}

fun main() {
    EventQueue.invokeLater(::createAndShowGUI)
}
