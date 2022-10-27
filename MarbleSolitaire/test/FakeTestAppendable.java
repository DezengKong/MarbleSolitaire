import java.io.IOException;

/**
 * The class to create a FakeAppendable to test the exception to appendable.
 */
public class FakeTestAppendable implements Appendable {

  @Override
  public Appendable append(CharSequence csq) throws IOException {
    throw new IOException("Wrong output");
  }

  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    throw new IOException("Wrong output");
  }

  @Override
  public Appendable append(char c) throws IOException {
    throw new IOException("Wrong output");
  }
}

