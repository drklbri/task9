package ru.vsu.cs.shevchenko_daniil;

import ru.vsu.cs.shevchenko_daniil.utils.ArrayUtils;
import ru.vsu.cs.shevchenko_daniil.utils.JTableUtils;
import ru.vsu.cs.shevchenko_daniil.utils.SwingUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Table extends JFrame {
    private JPanel mainPanel;
    private JButton loadFromFileButton;
    private JTable inTable;
    private JButton solutionButton;
    private JTable outTable;
    private JButton saveButton;

    private final JFileChooser fileChooserOpen;
    private final JFileChooser fileChooserSave;
    private final JMenuBar menuBarMain;
    private final JMenu menuLookAndFeel;

    public Table() {
        this.setTitle("Table");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        JTableUtils.initJTableForArray(inTable, 40, true, true, true, true);
        JTableUtils.initJTableForArray(outTable, 40, true, true, true, true);
        inTable.setRowHeight(25);
        outTable.setRowHeight(25);

        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");

        menuBarMain = new JMenuBar();
        setJMenuBar(menuBarMain);

        menuLookAndFeel = new JMenu();
        menuLookAndFeel.setText("Вид");
        menuBarMain.add(menuLookAndFeel);
        SwingUtils.initLookAndFeelMenu(menuLookAndFeel);

        this.pack();


        loadFromFileButton.addActionListener(e -> {
            try {
                if (fileChooserOpen.showOpenDialog(mainPanel) == JFileChooser.APPROVE_OPTION) {
                    int[] array = ArrayUtils.readIntArrayFromFile(fileChooserOpen.getSelectedFile().getPath());
                    JTableUtils.writeArrayToJTable(inTable, array);
                }
            } catch (Exception a) {
                SwingUtils.showErrorMessageBox(a);
            }
        });
        solutionButton.addActionListener(actionEvent -> {
            try {
                int[] array = JTableUtils.readIntArrayFromJTable(inTable);
                array = ListProcessing.fromListToIntArray(ListProcessing.createNewList(ListProcessing.intArrayToList(array)));
                JTableUtils.writeArrayToJTable(outTable, array);
            } catch (Exception e) {
                SwingUtils.showErrorMessageBox(e);
            }
        });
        saveButton.addActionListener(actionEvent -> {
            try {
                if (fileChooserSave.showSaveDialog(mainPanel) == JFileChooser.APPROVE_OPTION) {
                    int[] array = JTableUtils.readIntArrayFromJTable(outTable);
                    String file = fileChooserSave.getSelectedFile().getPath();
                    if (!file.toLowerCase().endsWith(".txt")) {
                        file += ".txt";
                    }
                    ArrayUtils.writeArrayToFile(file, array);
                }
            } catch (Exception e) {
                SwingUtils.showErrorMessageBox(e);
            }
        });
    }
}
