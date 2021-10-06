import org.ojalgo.optimisation.Expression;
import org.ojalgo.optimisation.ExpressionsBasedModel;
import org.ojalgo.optimisation.Optimisation;
import org.ojalgo.optimisation.Variable;

public class Ex4 {
    public static void main(String[] args) {
        ExpressionsBasedModel model = new ExpressionsBasedModel();

        /* 1. Defining the variables */
        //Max Profit = 30X + 10Y
        Variable ex1_x = model.addVariable("table").weight(30).integer(true);
        Variable ex1_y = model.addVariable("chair").weight(10).integer(true);

        /* 2. Constraints */
        //Max hours per week
        //6x+3y<=40
        Expression first_constraint = model.addExpression("First constraint")
                .upper(40)
                .set(ex1_x, 6)
                .set(ex1_y,3);

        //Customer demand
        //-3x+y>=0
        Expression second_constraint = model.addExpression("Second constraint")
                .lower(0)
                .set(ex1_x, -3)
                .set(ex1_y, 1);

        //Storage
        //4x+y<=16
        Expression third_constraint = model.addExpression("Third constraint")
                .upper(16)
                .set(ex1_x, 4)
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
