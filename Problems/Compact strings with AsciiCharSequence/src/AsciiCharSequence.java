
public class AsciiCharSequence implements java.lang.CharSequence {
    byte[] content;

    public AsciiCharSequence(byte[] content) {
        this.content = content;
    }

    @Override
    public int length() {
        return content.length;
    }

    @Override
    public char charAt(int i) {
        return (char) content[i];
    }

    @Override
    public CharSequence subSequence(int i, int i1) {
        byte[] newContent = new byte[i1 - i];

        System.arraycopy(content, i, newContent, 0, newContent.length);

        return new AsciiCharSequence(newContent);
    }

    @Override
    public String toString() {
        return new String(content);
    }
}
