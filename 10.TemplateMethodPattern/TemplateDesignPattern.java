import java.util.*;

// Base class : Consist template method implementation
abstract class ModelTrainer{
    protected void loadData(){
        System.out.println("Loading data from common source..");
    }

    protected abstract void processData();
    protected abstract void trainModel();
    protected abstract void evaluateModel();

    protected void saveModel(){
        System.out.println("Saving data at disk");
    }

    // Template method : consists order of execution
    public final void trainPipeline(){
        loadData();
        processData();
        trainModel();
        evaluateModel();
        saveModel();
    }
}

// Concrete class
class NeuralNetworkTrainer extends ModelTrainer{
    @Override
    protected void processData(){
        System.out.println("Processing data for NeuralNetworkTrainer");
    }

    @Override
    protected void trainModel(){
        System.out.println("NeuralNetworkTrainer - Training model");
    }

    @Override
    protected void evaluateModel(){
        System.out.println("NeuralNetworkTrainer - Evaluating model");
    }
}

// Concrete class
class DecisionTreeTrainer extends ModelTrainer{
    @Override
    protected void processData(){
        System.out.println("Processing data for DecisionTreeTrainer");
    }

    @Override
    protected void trainModel(){
        System.out.println("DecisionTreeTrainer - Training model");
    }

    @Override
    protected void evaluateModel(){
        System.out.println("DecisionTreeTrainer - Evaluating model");
    }
}

public class TemplateDesignPattern {
    public static void main(String[] args){
        ModelTrainer neuralModelTrainer = new NeuralNetworkTrainer();
        neuralModelTrainer.trainPipeline();

        ModelTrainer decisionModelTrainer = new DecisionTreeTrainer();
        decisionModelTrainer.trainPipeline();;
    }
}
