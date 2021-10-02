import org.ojalgo.optimisation.Expression;
import org.ojalgo.optimisation.ExpressionsBasedModel;
import org.ojalgo.optimisation.Optimisation;
import org.ojalgo.optimisation.Variable;

public class Ex2 {
    public static void main(String[] args) {
        ExpressionsBasedModel model = new ExpressionsBasedModel();

        /* 1. Defining the variables */
        //Max Profit = 0.4X + 3.2Y
        Variable ex1_x = model.addVariable("x").weight(0.4);
        Variable ex1_y = model.addVariable("y").weight(3.2);

        /* 2. Constraints */
        //x<=5
        Expression first_constraint = model.addExpression("First constraint")
                .upper(5)
                .set(ex1_x, 1);

        //x+y<=7
        Expression second_constraint = model.addExpression("Second constraint")
                .upper(7)
                .set(ex1_x, 1)
                .set(ex1_y, 1);

        //x+2y>=4
        Expression third_constraint = model.addExpression("Third constraint")
                .lower(4)
                .set(ex1_x, 1)
                .set(ex1_y, 2);

        //y<=x+5 --> y-x<=5
        Expression fourth_constraint = model.addExpression("Third constraint")
                .upper(5)
                .set(ex1_x, -1)
                .set(ex1_y, 1);

        //X ≥ 0
        Expression Xpositive = model.addExpression("X positive")
                .lower(0)//
                .set(ex1_x, 1);

        //Y ≥ 0
        Expression Ypositive = model.addExpression("Y positive")
                .lower(0)
                .set(ex1_y, 1);
        Optimisation.Result result = model.maximise();

        System.out.println("Result: " + result);
        System.out.println("Model: " + model);

    }
}
