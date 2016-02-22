/**
 * Created by Иван on 19.02.2016.
 */
public class Span {

    private int start;
    private int length;
    //private Color color;
    private float percent;

    public Span(int start, int length, float percent){
        this.start = start;
        this.length = length;
        this.percent = percent;
    }


    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }
}
