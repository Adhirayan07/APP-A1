import javax.swing.*;
import java.awt.*;

public class TextEditor extends JFrame {
    JTextArea area = new JTextArea();

    TextEditor() {
        setTitle("Simple Text Editor");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new JScrollPane(area), BorderLayout.CENTER);

        JMenuBar bar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem clear = new JMenuItem("Clear");
        JMenuItem exit = new JMenuItem("Exit");

        newItem.addActionListener(e -> area.setText(""));
        clear.addActionListener(e -> area.setText(""));
        exit.addActionListener(e -> System.exit(0));

        file.add(newItem);
        file.add(clear);
        file.addSeparator();
        file.add(exit);

        JMenu edit = new JMenu("Edit");
        JMenuItem cut = new JMenuItem("Cut");
        JMenuItem copy = new JMenuItem("Copy");
        JMenuItem paste = new JMenuItem("Paste");

        cut.addActionListener(e -> area.cut());
        copy.addActionListener(e -> area.copy());
        paste.addActionListener(e -> area.paste());

        edit.add(cut);
        edit.add(copy);
        edit.add(paste);

        bar.add(file);
        bar.add(edit);
        setJMenuBar(bar);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TextEditor();
    }
}
