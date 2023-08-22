package Collection;

import java.util.Objects;

public class Message {
    public final int sequence;
    public final String text;
    public Message(int sequence, String text) {
        this.sequence = sequence;
        this.text = text;
    }

    public boolean equals(Object o) {
        if (o instanceof Message m) {
            return Objects.equals(this.text, m.text) && this.sequence == m.sequence;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(sequence, text);
    }
}
