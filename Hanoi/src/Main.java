import java.util.Random;

public class Main {
    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        System.out.println("Initialising agents");

        int layout[] = {3, 6, 4, 1};

        int agentCount = 10;
        int iterations = 1000;

        Agent agents[] = new Agent[agentCount];

        for (int i = 0; i < agentCount; i++) {
            agents[i] = new Agent(layout);
            agents[i].randomize();
        }

        System.out.println("Training " + String.valueOf(agentCount) + " agents for " + String.valueOf(iterations) + " iterations");

        Agent bestAgent = findBestAgent(agents);

        for (int i = 0; i < iterations; i++) {
            while (true) {
                Agent newBestAgent = findBestAgent(agents);

                if (bestAgent != newBestAgent) {
                    bestAgent = newBestAgent;

                    System.out.println("New best: " + String.valueOf(bestAgent.sclCases));

                    break;
                }

                for (int j = 0; j < agentCount; j++) {
                    if (agents[j] == bestAgent) {
                        continue;
                    }

                    agents[j].randomize();
                }
            }

            for (int j = 0; j < agentCount; j++) {
                if (agents[j] == bestAgent) {
                    continue;
                }

                for (int l = 1; l < bestAgent.net.layers.length - 1; l++) {
                    for (int k = 0; k < bestAgent.net.layers[l].length; k++) {
                        agents[j].net.layers[l][k].bias = bestAgent.net.layers[l][k].bias;

                        for (int x = 0; x < bestAgent.net.layers[l][k].weights.length; x++) {
                            agents[j].net.layers[l][k].weights[x] = bestAgent.net.layers[l][k].weights[x];
                        }
                    }
                }

                agents[j].randomize();
            }
        }

        float finalTest[] = {0, 1, 1, 1};

        System.out.println(bestAgent.think(finalTest));
    }

    Agent findBestAgent(Agent agents[]) {
        float testCases[][] = {{1, 0, 1, 1}, {1, 1, 0, 0}, {1, 1, 1, 1}, {0, 1, 0, 0}, {0, 0, 1, 1}, {0, 0, 0, 0}, {0, 1, 1, 1}, {1, 0, 0, 0}};

        Agent bestAgent = agents[0];

        for (int i = 0; i < agents.length; i++) {
            agents[i].sclCases = 0;

            for (int j = 0; j < testCases.length; j++) {
                if (agents[i].think(testCases[j]) == testCases[j][testCases[j].length - 1]) {
                    agents[i].sclCases++;
                }
            }

            if (agents[i].sclCases > bestAgent.sclCases) {
                bestAgent = agents[i];
            }
        }

        return bestAgent;
    }
}

