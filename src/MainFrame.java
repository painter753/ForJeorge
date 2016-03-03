import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ���� on 08.02.2016.
 */
public class MainFrame extends JFrame {

    private JLabel textLabel, widthLabel;
    private JExtendedLabel extTextLabel;
    private JTextField startPosition, finishPosition, percent;
    private JLabel startPosLabel, finishPosLabel, percentLabel;
    private JPanel argsPanel, outputPanel;
    private JButton button;

    private TwoComponentJPanel TCJPanel;

    public MainFrame(){
        super();
        //Font font = new Font("lucida bright regular", Font.PLAIN, 16);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2));

        argsPanel = new JPanel();
        argsPanel.setBorder(new TitledBorder("Input args"));
        argsPanel.setLayout(new GridLayout(2, 1));


        startPosLabel = new JLabel("Dummy");
        startPosLabel.setForeground(new Color(1, 0, 0, 0.0f));
        argsPanel.add(startPosLabel);

        final Row row = new Row();
        row.setName("This is test2. Very small test2. Testing new line2");
        Span[] spansArr = {new Span(5,3,13.778f), new Span(11, 5, 32.778f), new Span(17, 4, 96.778f), new Span(21, 4, 99.778f)};
        row.setSpans(spansArr);

        button = new JButton("Analyze");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                TCJPanel.displayPercentage();
                //outputPanel.doLayout();

            }
        });

        argsPanel.add(button);

        add(argsPanel);


        outputPanel = new JPanel();
        outputPanel.setBorder(new TitledBorder("Output"));
        //outputPanel.setLayout(new GridLayout(2,1));
        outputPanel.setLayout(new GridBagLayout());

        TCJPanel = new TwoComponentJPanel(row);
        outputPanel.add(TCJPanel,
                new GridBagConstraints(
                        0, 0, //gridx-y
                        1, 1, //gridwidth-height
                        0, 0, //weight
                        GridBagConstraints.LINE_START,
                        GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0),
                        0, 0));


//        textLabel = new JLabel(row.getName());
//        outputPanel.add(textLabel,
//                new GridBagConstraints(
//                        0, 0, //gridx-y
//                        1, 1, //gridwidth-height
//                        0, 0, //weight
//                        GridBagConstraints.LINE_START,
//                        GridBagConstraints.NONE,
//                        new Insets(0, 0, 0, 0),
//                        0, 0));
//        extTextLabel = new JExtendedLabel(textLabel.getFont(), textLabel.getText());
//        extTextLabel.setForeground(new Color(1, 0, 0, 0.0f));
//        outputPanel.add(extTextLabel,
//                new GridBagConstraints(
//                        0, 1, //gridx-y
//                        1, 1, //gridwidth-height
//                        0, 0, //weight
//                        GridBagConstraints.LINE_START,
//                        GridBagConstraints.BOTH,
//                        new Insets(0, 0, 0, 0),
//                        0, 0));

        JLabel emptylabel = new JLabel("LABEL");
        emptylabel.setForeground(new Color(1,0,0,0.0f));
        outputPanel.add(emptylabel,
                new GridBagConstraints(
                        0, 2, //gridx-y
                        1, 1, //gridwidth-height
                        0, 1, //weight
                        GridBagConstraints.LINE_START,
                        GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0),
                        0, 0));

        System.out.println("Component count:  " + outputPanel.getComponentCount());

        add(outputPanel);




        setSize(600, 400);
        setLocation(200, 200);
        setVisible(true);


    }

}
