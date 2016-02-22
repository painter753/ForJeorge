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

    public MainFrame(){
        super();
        //Font font = new Font("lucida bright regular", Font.PLAIN, 16);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2));

        argsPanel = new JPanel();
        argsPanel.setBorder(new TitledBorder("Input args"));
        argsPanel.setLayout(new GridLayout(2, 1));


        startPosLabel = new JLabel("Dummy");
        argsPanel.add(startPosLabel);

        final Row row = new Row();
        row.setName("This is test2. Very small test2. Testing new line2");
        Span[] spansArr = {new Span(5,3,30.778f), new Span(11, 5, 77.778f), new Span(17, 4, 12.778f), new Span(21, 4, 99.778f)};
        row.setSpans(spansArr);

        button = new JButton("Analyze");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                extTextLabel.addRowAndCompile(row);

                //extTextLabel.setText(textLabel.getText().substring(Integer.parseInt(startPosition.getText()), Integer.parseInt(finishPosition.getText())));
            }
        });

        argsPanel.add(button);

        add(argsPanel);


        outputPanel = new JPanel();
        outputPanel.setBorder(new TitledBorder("Output"));
        outputPanel.setLayout(new GridLayout(2,1));



        textLabel = new JLabel(row.getName() + "1");
        textLabel.setBackground(Color.black);
        outputPanel.add(textLabel);
        extTextLabel = new JExtendedLabel(textLabel.getFont(), textLabel.getText());
        outputPanel.add(extTextLabel);

        add(outputPanel);

        setSize(600, 400);
        setLocation(200, 200);
        setVisible(true);


    }

}
