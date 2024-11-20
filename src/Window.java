import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class Window implements ActionListener {
    private JFrame mainFrame;
    private JPanel controlPanel;
    private JMenuBar mb;
    private JMenu file, edit, help;
    private JMenuItem cut, copy, paste, selectAll;
    private JTextArea ta; //typing area
    private JFrame jf;
    private JTextArea ta3;
    private JScrollPane sp;
    private JPanel CtrlP;

    private int WIDTH = 800;
    private int HEIGHT = 700;
    private JButton B1;
    private JButton B2;
    private ImageIcon IC;


    public Window() {
        prepareGUI();
    }


    public static void main(String[] args) {
        Window E1 = new Window();

    }

    private void prepareGUI() {
        mainFrame = new JFrame("Pokedex");
        CtrlP = new JPanel();
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setLayout(new GridLayout(2, 1));
        CtrlP.setLayout(new GridLayout(1,2));


        B1 = new JButton("ENTER");
        B2 = new JButton("CLEAR");

        ta = new JTextArea("ENTER POKEMON HERE");
        ta.setBounds(50, 5, WIDTH - 100, HEIGHT - 50);
        ta.setBorder(new LineBorder(Color.BLACK));

        ta3 = new JTextArea();
        ta3.setBorder(new LineBorder(Color.BLACK));
        sp = new JScrollPane(ta3);
        B1.setForeground(Color.green);
        B2.setForeground(Color.red);
        Font f = new Font( "Chalkboard", Font.ITALIC, 15 );
        Font f2 = new Font( "Chalkboard", Font.ITALIC, 12 );
        ta.setFont( f );

        B1.setFont( f );
        B2.setFont( f );

//        JFrame jf = new JFrame();
//        jf.setBounds(50, 800, WIDTH - 100, HEIGHT - 50);
//        ImageIcon IC = new ImageIcon("Ditto-Anime.avif");
//        jf.add(new JLabel(IC));
//        jf.pack();
//        jf.setVisible(true);










        mainFrame.add(CtrlP);

        mainFrame.add(ta);



        mainFrame.add(sp);


        CtrlP.add(B1);
        CtrlP.add(B2);








        //menu at top
        cut = new JMenuItem("cut");
        copy = new JMenuItem("copy");
        paste = new JMenuItem("paste");
        selectAll = new JMenuItem("selectAll");
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);

        mb = new JMenuBar();
        file = new JMenu("File");
        edit = new JMenu("Edit");
        help = new JMenu("Help");
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        mb.add(file);
        mb.add(edit);
        mb.add(help);
        //end menu at top


        mainFrame.add(mb);
        mainFrame.setJMenuBar(mb);



        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());


        B1.setActionCommand("ENTER");
        B2.setActionCommand("CLEAR");


        B1.addActionListener(new ButtonClickListener());
        B2.addActionListener(new ButtonClickListener());



        mainFrame.setVisible(true);


    }


    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("ENTER")) {


                System.out.println();




            } else if (command.equals("CLEAR")) {

                ta.setText("ENTER POKEMON HERE");
//                ta2.setText("");
                ta3.setText("");







            }
        }
    }








    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cut)
            ta.cut();
        if (e.getSource() == paste)
            ta.paste();
        if (e.getSource() == copy)
            ta.copy();
        if (e.getSource() == selectAll)
            ta.selectAll();
    }



    public void HtmlRead() {

        try {
            System.out.println();
            URL url = new URL("https://pokeapi.co/api/v2/pokemon/ditto");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream())
            );
            String line;

            while ( (line = reader.readLine()) != null ) {
                System.out.println(url);
                if (line.contains("{")) {
//                    System.out.println(line);
                    line = line.substring(line.indexOf("{")+ 6);
                    int end = line.indexOf("\"");
                    int oEnd = line.indexOf("\'");


                    if(end> -1){
                        System.out.println(line.substring(0, end));



                    } else{
                        System.out.println(line.substring(0, oEnd));




                    }




                }

            }
            reader.close();
        } catch(Exception ex) {
            System.out.println(ex);
        }

    }





}





