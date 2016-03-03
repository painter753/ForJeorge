import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by Иван on 03.03.2016.
 */
public class TwoComponentJPanel extends JPanel {

    private JLabel originalTextLabel;
    private JExtendedLabel percentageLabel;
    private Row row;


    public TwoComponentJPanel(Row row){
        super();
        //setBorder(new LineBorder(Color.black));
        setLayout(new GridBagLayout());
        this.originalTextLabel = new JLabel(row.getName());
        this.percentageLabel = new JExtendedLabel(originalTextLabel.getFont(), originalTextLabel.getText());
        this.row = row;
        addComponents();

    }

    private void addComponents() {

        this.add(originalTextLabel,
                new GridBagConstraints(
                        0, 0, //gridx-y
                        1, 1, //gridwidth-height
                        0, 0, //weight
                        GridBagConstraints.LINE_START,
                        GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0),
                        0, 0));

        percentageLabel.setForeground(new Color(1, 0, 0, 0.0f));
        this.add(percentageLabel,
                new GridBagConstraints(
                        0, 1, //gridx-y
                        1, 1, //gridwidth-height
                        0, 0, //weight
                        GridBagConstraints.LINE_START,
                        GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0),
                        0, 0));

    }

    public void displayPercentage(){
        percentageLabel.addRowAndCompile(row);
    }

}
