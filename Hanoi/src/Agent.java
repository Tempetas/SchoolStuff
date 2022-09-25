package Hanoi;

public class Agent {
  public NeuralNetwork net;
  public int sclCases;

  public Agent(int layers[]) {
    net = new NeuralNetwork(layers);
  }

  public void randomize() {
    net.randomize();
  }

  float think(float inputs[]) {
    for (int i = 0; i < inputs.length - 1; i++) {
      net.layers[0][i].value = inputs[i];
    }

    net.think();

    return net.layers[net.layers.length - 1][0].value;
  }
}

