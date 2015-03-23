package app;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

public class Loading extends JFrame {

    private JPanel contentPane;

    public JProgressBar progressBar;
    public JLabel label;
    public JButton button;

    public Loading() {
        setResizable(false);
        setTitle("\u0417\u0430\u0433\u0440\u0443\u0437\u043A\u0430 \u043A\u043E\u043C\u043F\u043E\u043D\u0435\u043D\u0442\u043E\u0432...");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 495, 183);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        progressBar = new JProgressBar();

        progressBar.setStringPainted(true);
        progressBar.setBounds(15, 61, 459, 22);
        progressBar.setForeground(new Color(44, 184, 14));

        label = new JLabel("Идёт расчет времени...");
        label.setFont(new Font("Calibri Light", Font.PLAIN, 16));

        label.setBounds(15, 28, 400, 22);
        contentPane.setLayout(null);

        button = new JButton("Прервать");

        button.setFont(new Font("Tahoma", Font.PLAIN, 12));
        button.setBounds(198, 109, 92, 34);
        contentPane.add(button);
        contentPane.add(label);
        contentPane.add(progressBar);

        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

        int width = this.getWidth();
        int height = this.getHeight();

        int north = ((screenWidth - width) / 2);
        int east = (screenWidth - width);

        setLocation(east, 0);

        progressBar.setMaximum(100);
        progressBar.setMinimum(0);
        setVisible(true);
    }
}
