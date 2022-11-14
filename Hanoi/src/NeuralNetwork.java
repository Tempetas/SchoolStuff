import java.util.Random;

public class NeuralNetwork {
  public Neuron layers[][];

  public NeuralNetwork(int layout[]) {
    layers = new Neuron[layout.length][];

    for (int i = 0; i < layout.length; i++) {
      layers[i] = new Neuron[layout[i]];
      for (int j = 0; j < layout[i]; j++) {
        layers[i][j] = new Neuron(i == (layout.length - 1) ? 0 : layout[i + 1]);
      }
    }
  }

  void randomize() {
    Random rand = new Random(System.currentTimeMillis());

    for (int i = 1; i < layers.length - 1; i++) {
      for (int j = 0; j < layers[i].length; j++) {
        for (int k = 0; k < layers[i + 1].length; k++) {
          layers[i][j].weights[k] += rand.nextFloat() / 10 - 0.05f;
        }
        layers[i][j].bias += rand.nextFloat() / 10 - 0.05f;
      }
    }
  }

  void think() {
    for (int i = 1; i < layers.length; i++) {

      for (int ne = 0; ne < layers[i].length; ne++) {
        layers[i][ne].value = 0;

        for (int pr = 0; pr < layers[i - 1].length; pr++) {
          layers[i][ne].value += layers[i - 1][pr].value * layers[i - 1][pr].weights[ne];
        }

        layers[i][ne].value += layers[i][ne].bias;
        layers[i][ne].activate();
      }

    }
  }
}

