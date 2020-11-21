package com.example.calculator;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;
import static com.example.calculator.Ideone.calc;

public class MainActivity extends AppCompatActivity {

    TextView middle;
    TextView input;
    static TextView resultBox;
    String sign, value1;
    Double save;
    private static String operators = "+-*/^";/*список делиметров*/
    private static String delimiters = "() " + operators;
    public static boolean flag = true;
    boolean hasDot, isSpecialFunctionOn;
    private final String SAVE_STATE = "save"; /*финальная переменная - её нельзя изменить*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);/*ориентация*/
        middle = (TextView) findViewById(R.id.textView_out);
        input = (TextView) findViewById(R.id.input);
        resultBox = (TextView) findViewById(R.id.resultBox);
        hasDot = false;
        isSpecialFunctionOn = false;

    }
    /*методы для синхронизации поворота экрана*/
    /*сохраняется*/
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(SAVE_STATE, middle.getText().toString());

    }
    /*перерисовывается*/
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        middle.setText(savedInstanceState.getString(SAVE_STATE));
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_0(View view) {
        resultBox.setText("");
        middle.setText(middle.getText() + "0");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_1(View view) {
        resultBox.setText("");
        middle.setText(middle.getText() + "1");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_2(View view) {
        resultBox.setText("");
        middle.setText(middle.getText() + "2");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_3(View view) {
        resultBox.setText("");
        middle.setText(middle.getText() + "3");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_4(View view) {
        resultBox.setText("");
        middle.setText(middle.getText() + "4");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_5(View view) {
        resultBox.setText("");
        middle.setText(middle.getText() + "5");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_6(View view) {
        resultBox.setText("");
        middle.setText(middle.getText() + "6");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_7(View view) {
        resultBox.setText("");
        middle.setText(middle.getText() + "7");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_8(View view) {
        resultBox.setText("");
        middle.setText(middle.getText() + "8");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_9(View view) {
        resultBox.setText("");
        middle.setText(middle.getText() + "9");
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_dot(View view) {
        if (!hasDot) {
            if (middle.getText().equals("")) {
                middle.setText("0.");
            } else {
                middle.setText(middle.getText() + ".");
            }
            hasDot = true;
        }
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_clear(View view) {
        input.setText(null);
        middle.setText(null);
        resultBox.setText(null);
        value1 = null;
        sign = null;
        hasDot = false;
    }

    public void btnClick_del(View view) {
        if (middle.getText().equals("")) {
            middle.setText(null);
        } else {
            int len = middle.getText().length();
            String s = middle.getText().toString();
            if (s.charAt(len - 1) == '.') {
                hasDot = false;
                middle.setText(middle.getText().subSequence(0, middle.getText().length() - 1));
            } else {
                middle.setText(middle.getText().subSequence(0, middle.getText().length() - 1));
            }
        }
    }

    public void btnClick_x2(View view) {
        resultBox.setText("");
        middle.setText(middle.getText() + "(");
    }

    public void btnClick_x3(View view) {
        resultBox.setText("");
        middle.setText(middle.getText() + ")");
    }

    public void btnClick_1_x(View view) {
        resultBox.setText("");
        middle.setText(middle.getText() + "1/");
    }

    public void btnClick_ms(View view) {

        if (!resultBox.getText().equals("")) {
            value1=resultBox.getText().toString();
            save=Double.parseDouble(value1);
        }
    }

    public void btnClick_m_min(View view) {

        if (!resultBox.getText().equals("") &&  (save!=null) ) {
            value1=resultBox.getText().toString();
            save=save-Double.parseDouble(value1);
        }
    }
    public void btnClick_m_plus(View view) {

        if (!resultBox.getText().equals("") &&  (save!=null) ) {
            value1=resultBox.getText().toString();
            save=save+Double.parseDouble(value1);
        }
    }

    public void btnClick_mr(View view) {
        if (save!=null) {
            middle.setText(save.toString());
        }
    }

    public void btnClick_1_y(View view) {
        resultBox.setText("");
        middle.setText(middle.getText() + ")^(1/");
    }

    public void btnClick_perc(View view) {
        resultBox.setText("");
        middle.setText(middle.getText() + "%");
    }

    public void btnClick_plus(View view) {
        resultBox.setText("");
        middle.setText(middle.getText() + "+");
    }

    public void btnClick_minus(View view) {

        resultBox.setText("");
        middle.setText(middle.getText() + "-");

    }

    public void btnClick_multi(View view) {
        resultBox.setText("");
        middle.setText(middle.getText() + "*");
    }

    public void btnClick_dev(View view) {
        resultBox.setText("");
        middle.setText(middle.getText() + "/");

    }


    public void btnClick_pi(View view) {
        resultBox.setText("");
        middle.setText(middle.getText() + "3.141592653589793238462643");
    }

    public void btnClick_e(View view) {
        resultBox.setText("");
        middle.setText(middle.getText() + "2.71828182845904523536");
    }


    public void btnClick_log(View view) {
        resultBox.setText("");
        middle.setText(middle.getText() + "log(");
    }

    public void btnClick_ln(View view) {
        resultBox.setText("");
        middle.setText(middle.getText() + "ln(");
    }

    public void btnClick_xy(View view) {

        resultBox.setText("");
        middle.setText(middle.getText() + "^");
    }

    public void btnClick_sqrt(View view) {
        resultBox.setText("");
        middle.setText(middle.getText() + "√(");
    }

    public void btnClick_fact(View view) {
        resultBox.setText("");
        middle.setText(middle.getText() + "!");
    }

    public void btnClick_sin(View view) {
        resultBox.setText("");
        middle.setText(middle.getText() + "sin(");
    }

    public void btnClick_cos(View view) {
        resultBox.setText("");
        middle.setText(middle.getText() + "cos(");
    }

    public void btnClick_tan(View view) {
        resultBox.setText("");
        middle.setText(middle.getText() + "tan(");
    }

    private static boolean isDelimiter(String token) {/**/
        if (token.length() != 1) return false;
        for (int i = 0; i < delimiters.length(); i++) {
            if (token.charAt(0) == delimiters.charAt(i)) return true;
        }
        return false;
    }

    private static boolean isOperator(String token) {
        if (token.equals("u-")) return true;
        for (int i = 0; i < operators.length(); i++) {
            if (token.charAt(0) == operators.charAt(i)) return true;
        }
        return false;
    }

    private static boolean isFunction(String token) { /*и мы возвращ*/
        if (token.equals("√") || token.equals("sin") || token.equals("cos") || token.equals("tan") || token.equals("log") || token.equals("ln")) return true;
        else return false;
    }

    private static int priority(String token) {
        if (token.equals("(")) return 1;
        if (token.equals("+") || token.equals("-")) return 2;
        if (token.equals("*") || token.equals("/")) return 3;
        return 4;
    }

    public static List<String> parse(String infix) {/*парсим*//*переводим всё в польскую запись*/
        List<String> postfix = new ArrayList<String>();
        Deque<String> stack = new ArrayDeque<String>();
        StringTokenizer tokenizer = new StringTokenizer(infix, delimiters, true);
        String prev = "";
        String curr = "";
        while (tokenizer.hasMoreTokens()) {
            curr = tokenizer.nextToken();
            if (!tokenizer.hasMoreTokens() && isOperator(curr)) {
                resultBox.setText("Некорректное выражение.");
                flag = false;
                return postfix;
            }
            if (curr.equals(" ")) continue;
            if (isFunction(curr)) stack.push(curr);
            else if (isDelimiter(curr)) {
                if (curr.equals("(")) stack.push(curr);
                else if (curr.equals(")")) {
                    while (!stack.peek().equals("(")) {
                        postfix.add(stack.pop());
                        if (stack.isEmpty()) {
                            resultBox.setText("Скобки не согласованы.");
                            flag = false;
                            return postfix;
                        }
                    }
                    stack.pop();
                    if (!stack.isEmpty() && isFunction(stack.peek())) {
                        postfix.add(stack.pop());
                    }
                }
                else {
                    if (curr.equals("-") && (prev.equals("") || (isDelimiter(prev)  && !prev.equals(")")))) {
                        // унарный минус
                        curr = "u-";
                    }
                    else {
                        while (!stack.isEmpty() && (priority(curr) <= priority(stack.peek()))) {
                            postfix.add(stack.pop());
                        }

                    }
                    stack.push(curr);
                }

            }

            else {
                postfix.add(curr);
            }
            prev = curr;
        }

        while (!stack.isEmpty()) {
            if (isOperator(stack.peek())) postfix.add(stack.pop());
            else {
                resultBox.setText("Скобки не согласованы.");
                flag = false;
                return postfix;
            }
        }
        return postfix;
    }

    @SuppressLint("SetTextI18n")
    public void btnClick_eql(View view){
        flag = true;
            String s = (String) middle.getText();
        MainActivity n = new MainActivity();
            List<String> expression = n.parse(s);
            boolean flag = n.flag;
            if (flag) {
                for (String x : expression) System.out.print(x + " ");
                Double s1=calc(expression);
                resultBox.setText(s1.toString());
            }
        }
    }

class Ideone {
        public static Double calc(List<String> postfix) {
            Deque<Double> stack = new ArrayDeque<Double>();
            for (String x : postfix) {
                if (x.equals("√"))
                    stack.push(Math.sqrt(stack.pop()));
                else if (x.equals("%")) {
                    stack.push(stack.pop()/100);
                }
                else if (x.equals("ln")) {
                    double result = (-Math.log(1-stack.pop()))/stack.pop();
                    stack.push(result);
                }
                else if (x.equals("sin")) {
                    double result = (Math.sin(stack.pop()));
                    stack.push(result);
                }
                else if (x.equals("cos")) {
                    double result = (Math.cos(stack.pop()));
                    stack.push(result);
                }
                else if (x.equals("tan")) {
                    double result = (Math.tan(stack.pop()));
                    stack.push(result);
                }

                else if (x.equals("log")) stack.push(Math.log(stack.pop()));
                else if (x.equals("!")) {
                    double result = 1;
                    for (int i = 1; i <=stack.pop() ; i++) {
                        result = result * i;
                    }
                    stack.push(result);
                }
                else if (x.equals("+")) stack.push(stack.pop() + stack.pop());
                else if (x.equals("^"))
                { double a=stack.pop();
                    double b=stack.pop();
                    stack.push(Math.pow(b,a));
                }
                else if (x.equals("-")) {
                    Double b = stack.pop(), a = stack.pop();
                    stack.push(a - b);
                }
                else if (x.equals("*")) stack.push(stack.pop() * stack.pop());
                else if (x.equals("/")) {
                    Double b = stack.pop(), a = stack.pop();
                    stack.push(a / b);
                }
                else if (x.equals("u-")) stack.push(-stack.pop());
                else stack.push(Double.valueOf(x));
            }
        return stack.pop();
}
}