package design.creational.builder;

/**
 * Lets you construct complex objects step by step. The pattern allows you to produce different
 * types and representations of an object using the same construction code.
 *
 * Builder is widely used in Java core libraries:
 * java.lang.StringBuilder#append() (unsynchronized)
 * java.lang.StringBuffer#append() (synchronized)
 * java.nio.ByteBuffer#put() (also in CharBuffer, ShortBuffer, IntBuffer, LongBuffer, FloatBuffer
 * and DoubleBuffer)
 * javax.swing.GroupLayout.Group#addComponent()
 * All implementations java.lang.Appendable
 *
 * Identification: The Builder pattern can be recognized in a class, which has a single creation
 * method and several methods to configure the resulting object. Builder methods often support
 * chaining (for example, someBuilder.setValueA(1).setValueB(2).create()).
 */
public class BuilderDesignPattern {

  public static void main(String... args) {

  }


}
