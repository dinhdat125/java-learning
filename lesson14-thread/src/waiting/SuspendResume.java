package waiting;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import utils.ImageUtils;

public class SuspendResume extends JFrame implements Runnable {

	private static final long serialVersionUID = 6902019894061644082L;

	private int counter = 0;
    
    private Container conn = this.getContentPane();
    private static Thread thread;

    private static final String TITLE = "Image Random - SuspendResume";
    private final String path = "/images/";
    private JLabel picLabel;
    private JButton buttonStop;
    private JButton buttonResume;
    private Color highlightButton = Color.ORANGE;
    String[] imagesName = {"1.jpg", "2.jpg", "3.jpg", "4.jpg", "5.jpg", "6.jpg", "7.jpg", 
    		"8.jpg", "9.jpg", "10.jpg", "11.jpg", "12.jpg", "13.jpg", "14.jpg"};
    public Random rd = new Random();
    int W = 500;
    int H = 500;

    public SuspendResume() {
        this.setTitle(TITLE);
        this.setSize(W, H);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(ImageUtils.createImage(ImageUtils.FLOWER_64PX, SuspendResume.class));
        conn.setLayout(null);
        initComponents();
        initEvent();
    }

    private void initEvent() {
        buttonStopEvent();
        buttonResumeEvent();
    }

    private void buttonStopEvent() {
        Color defaultColor = buttonStop.getBackground();
        buttonStop.addMouseListener(new MouseAdapter() {
            @SuppressWarnings("removal")	// suppress warning from suspend() method
			@Override
            public void mousePressed(MouseEvent e) {
                thread.suspend();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                buttonStop.setBackground(highlightButton);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                buttonStop.setBackground(defaultColor);
            }
        });
    }

    private void buttonResumeEvent() {
        buttonResume.addMouseListener(new MouseAdapter() {
            @SuppressWarnings("removal")	// suppress warning from suspend() method
			@Override
            public void mousePressed(MouseEvent e) {
                thread.resume();
            }
        });
    }

    private void initComponents() {
        picLabel = new JLabel();
        int preferredWidth = 150;
        int preferredHeigth = 250;
        picLabel.setBounds((W - preferredWidth) / 2, 0, preferredWidth, preferredHeigth);
        Image image = new ImageIcon(getClass().getResource(ImageUtils.DEF_GHOST)).getImage();
        image = image.getScaledInstance(preferredWidth, preferredHeigth, Image.SCALE_SMOOTH);
        picLabel.setIcon(new ImageIcon(image));
        conn.add(picLabel);

        Font font = new Font("Arial", Font.BOLD, 20);
        buttonStop = new JButton("STOP");
        buttonStop.setFont(font);
        buttonStop.setFocusPainted(false);
        buttonStop.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Dimension p2 = buttonStop.getPreferredSize();
        buttonStop.setBounds(120, 350, (int) p2.getWidth(), (int) p2.getHeight());
        conn.add(buttonStop);

        buttonResume = new JButton("Resume");
        buttonResume.setFont(font);
        buttonResume.setFocusPainted(false);
        buttonResume.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Dimension p3 = buttonResume.getPreferredSize();
        buttonResume.setBounds(250, 350, (int) p3.getWidth(), (int) p3.getHeight());
        conn.add(buttonResume);

    }

    public static void main(String[] args) {
        // Runnable
        SuspendResume ex04 = new SuspendResume();
        ex04.setVisible(true);

        // Thread
        thread = new Thread(ex04);
        thread.start();
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Start " + counter++);
            int numRandom = rd.nextInt(imagesName.length);
            Image image = new ImageIcon(getClass().getResource(path + imagesName[numRandom])).getImage();
            image = image.getScaledInstance(190, 200, Image.SCALE_SMOOTH);
            picLabel.setIcon(new ImageIcon(image));
            try {
                Thread.sleep(300);
            } catch (InterruptedException ex) {
            }
            System.out.println("End " + counter++);
        }
    }
}
