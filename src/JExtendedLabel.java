import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Rectangle2D;

/**
 * Created by ���� on 18.02.2016.
 */
public class JExtendedLabel extends JLabel {

    private Font textFont;
    private Font percentageFont = new Font("TimesRoman", Font.PLAIN, 8);
    private FontRenderContext textFRC, percentageFRC;
    private String percentageFormat = "%.1f";

    private String text;
    private float width, height;

    private boolean analyzeFlag = false;
    private Span[] spans = null;



    private static final int RECTANGLE_HEIGHT = 50;
    private static final Color POS_COLOR = Color.GREEN;
    private static final Color NEG_COLOR = new Color(1,0,0, 1.0f);
    private static final Color GRID_COLOR = Color.black;



    public JExtendedLabel(Font f, String s){
        super("");
        textFont = f;
        text = s;
    }

    @Override
    protected void paintComponent(Graphics g) {
        System.out.println("paintComponent");
        if (!analyzeFlag){
            super.paintComponent(g);
        } else {

            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setFont(textFont);
            textFRC = g2.getFontRenderContext();
            g2.setFont(percentageFont);
            percentageFRC = g2.getFontRenderContext();

            System.out.println("text: " + text + "fullwidth: " + (float) textFont.getStringBounds(text, textFRC).getWidth());

            int position = 0;
            final float coordX = 0.0f;
            final float coordY = 1.0f;
            final float percentageCoordY = RECTANGLE_HEIGHT + 10;

            Span span = null;
            for (int i = 0; i < spans.length; i++){
                span = spans[i];
                if (span.getStart() == position) {
                    float prevStrWidth = (float) textFont.getStringBounds(text.substring( 0, span.getStart()), textFRC).getWidth();
                    float strWidth = (float) textFont.getStringBounds(text.substring(span.getStart(), span.getStart() + span.getLength()), textFRC).getWidth();
                    if (span.getPercent() < 0.5f) {
                        g2.setColor(GRID_COLOR);
                        g2.draw(new Rectangle2D.Float(coordX + prevStrWidth, coordY, strWidth, RECTANGLE_HEIGHT));
                        g2.setFont(percentageFont);
                        String percentageString = String.format(percentageFormat, span.getPercent());
                        float percentageStringWidth = (float) percentageFont.getStringBounds(percentageString, percentageFRC).getWidth();

                        g2.drawString(percentageString, coordX + prevStrWidth + strWidth/2 - percentageStringWidth/2, percentageCoordY);

                    } else if (span.getPercent() > 99.5f ) {
                        g2.setPaint(POS_COLOR);
                        g2.fill(new Rectangle2D.Float(coordX + prevStrWidth, coordY, strWidth, RECTANGLE_HEIGHT));
                        g2.setColor(GRID_COLOR);
                        g2.draw(new Rectangle2D.Float(coordX + prevStrWidth, coordY, strWidth, RECTANGLE_HEIGHT));
                        g2.setFont(percentageFont);
                        String percentageString = String.format(percentageFormat, span.getPercent());
                        float percentageStringWidth = (float) percentageFont.getStringBounds(percentageString, percentageFRC).getWidth();

                        g2.drawString(percentageString, coordX + prevStrWidth + strWidth/2 - percentageStringWidth/2, percentageCoordY);

                    } else {
                        g2.setPaint(POS_COLOR);
                        g2.fill(new Rectangle2D.Float(coordX + prevStrWidth, coordY + (RECTANGLE_HEIGHT - RECTANGLE_HEIGHT * span.getPercent() / 100), strWidth, RECTANGLE_HEIGHT * span.getPercent() / 100));
                        g2.setColor(GRID_COLOR);
                        g2.draw(new Rectangle2D.Float(coordX + prevStrWidth, coordY, strWidth, RECTANGLE_HEIGHT));
                        g2.setFont(percentageFont);
                        String percentageString = String.format(percentageFormat, span.getPercent());
                        float percentageStringWidth = (float) percentageFont.getStringBounds(percentageString, percentageFRC).getWidth();

                        g2.drawString(percentageString, coordX + prevStrWidth + strWidth/2 - percentageStringWidth/2, percentageCoordY);
                    }
                    position = span.getStart() + span.getLength();
                } else {
                    float prevStrWidth = (float) textFont.getStringBounds(text.substring( 0, span.getStart()), textFRC).getWidth();
                    float strWidth = (float) textFont.getStringBounds(text.substring(span.getStart(),  span.getStart() + span.getLength()), textFRC).getWidth();
                    if (span.getPercent() < 0.5f) {
                        g2.setColor(GRID_COLOR);
                        g2.draw(new Rectangle2D.Float(coordX + prevStrWidth, coordY, strWidth, RECTANGLE_HEIGHT));
                        g2.setFont(percentageFont);
                        String percentageString = String.format(percentageFormat, span.getPercent());
                        float percentageStringWidth = (float) percentageFont.getStringBounds(percentageString, percentageFRC).getWidth();

                        g2.drawString(percentageString, coordX + prevStrWidth + strWidth/2 - percentageStringWidth/2, percentageCoordY);
                    } else if (span.getPercent() > 99.5f ) {
                        g2.setPaint(POS_COLOR);
                        g2.fill(new Rectangle2D.Float(coordX + prevStrWidth, coordY, strWidth, RECTANGLE_HEIGHT));
                        g2.setColor(GRID_COLOR);
                        g2.draw(new Rectangle2D.Float(coordX + prevStrWidth, coordY, strWidth, RECTANGLE_HEIGHT));
                        g2.setFont(percentageFont);
                        String percentageString = String.format(percentageFormat, span.getPercent());
                        float percentageStringWidth = (float) percentageFont.getStringBounds(percentageString, percentageFRC).getWidth();

                        g2.drawString(percentageString, coordX + prevStrWidth + strWidth/2 - percentageStringWidth/2, percentageCoordY);
                    } else {
                        g2.setPaint(POS_COLOR);
                        g2.fill(new Rectangle2D.Float(coordX + prevStrWidth, coordY + (RECTANGLE_HEIGHT - RECTANGLE_HEIGHT * span.getPercent() / 100), strWidth, RECTANGLE_HEIGHT * span.getPercent() / 100));
                        g2.setColor(GRID_COLOR);
                        g2.draw(new Rectangle2D.Float(coordX + prevStrWidth, coordY, strWidth, RECTANGLE_HEIGHT));
                        g2.setFont(percentageFont);
                        String percentageString = String.format(percentageFormat, span.getPercent());
                        float percentageStringWidth = (float) percentageFont.getStringBounds(percentageString, percentageFRC).getWidth();

                        g2.drawString(percentageString, coordX + prevStrWidth + strWidth/2 - percentageStringWidth/2, percentageCoordY);
                    }
                    position = span.getStart() + span.getLength();
                }
            }

        }

    }

    public void addRowAndCompile(Row row){
        if (row != null && row.getSpans() != null && row.getName() != null){
            this.analyzeFlag = true;
            this.spans = row.getSpans();
            this.setText(row.getName());
        } else {
            System.out.println("[ERROR] Row is null or Spans are null or String is null");
        }
    }

    @Override
    public void setText(String text) {
        if (!analyzeFlag) super.setText(text);
        this.text = text;
        repaint();
    }


}
