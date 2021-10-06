import org.ojalgo.optimisation.Expression;
import org.ojalgo.optimisation.ExpressionsBasedModel;
import org.ojalgo.optimisation.Optimisation;
import org.ojalgo.optimisation.Variable;

public class Ex3 {
    public static void main(String[] args) {
        ExpressionsBasedModel model = new ExpressionsBasedModel();

        /* 1. Defining the variables */
        //Max revenue (Objective function) = 1.90X + 1.50Y
        Variable ex3_x = model.addVariable("Gallons of gasoline").weight(1.9);
        Variable ex3_y = model.addVariable("Gallons of of fuel oil").weight(1.5);

        /* 2. Constraints */
        //x-2y>=0
        Expression first_constraint = model.addExpression("First constraint")
                .lower(0)
                .set(ex3_x, 1)
                .set(ex3_y, -2);

        //y>=3 mil
        Expression second_constraint = model.addExpression("Second constraint")
                .lower(3000000)
                .set(ex3_y, 1);

        //x<=6.4 mil
        Expression third_constraint = model.addExpression("Third constraint")
                .upper(6400000)
                .set(ex3_x, 1);

        //X ≥ 0
        Expression Xpositive = model.addExpression("X positive")
                .lower(0)//
                .set(ex3_x, 1);

        //Y ≥ 0
        Expression Ypositive = model.addExpression("Y positive")
                .lower(0)
                .set(ex3_y, 1);
        Optimisation.Result result = model.maximise();

        System.out.println("Result: " + result);
        System.out.println("Model: " + model);

    }
}
