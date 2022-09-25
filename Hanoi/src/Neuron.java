package Hanoi;

public class Neuron {
  public float weights[];
  public float bias;

  public float value;

  public Neuron(int inNextLayer) {
    weights = new float[inNextLayer];
  }

  public void activate() {
    value = (value > 0.5) ? 1 : 0;
  }
}

