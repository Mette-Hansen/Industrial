import org.ojalgo.OjAlgoUtils;
import org.ojalgo.optimisation.Expression;
import org.ojalgo.optimisation.ExpressionsBasedModel;
import org.ojalgo.optimisation.Optimisation;
import org.ojalgo.optimisation.Variable;

public class Ex1 {
    public static void main(String[] args) {
        ExpressionsBasedModel model = new ExpressionsBasedModel();

        /* 1. Defining the variables */
        //Max Profit = 3X + 4Y
        Variable ex1_x = model.addVariable("x").weight(3);
        Variable ex1_y = model.addVariable("y").weight(4);

        /* 2. Constraints */
        //ex1_x + 2Y ≤ 14
        Expression first_constraint = model.addExpression("First constraint")
                .upper(14)
                .set(ex1_x, 1)
                .set(ex1_y, 2);

        //3x-y>=0
        Expression second_constraint = model.addExpression("Second constraint")
                .lower(0)
                .set(ex1_x, 3)
                .set(ex1_y, -1);

        //x-y<=2
        Expression third_constraint = model.addExpression("Third constraint")
                .upper(2)
                .set(ex1_x, 1)
                .set(ex1_y, -1);

        Optimisation.Result result = model.maximise();

        System.out.println("Result: " + result);
        System.out.println("Model: " + model);
    }
}
