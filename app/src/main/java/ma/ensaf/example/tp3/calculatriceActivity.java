package ma.ensaf.example.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class calculatriceActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener  {

    private boolean dotUsed = false;

    private boolean equalClicked = false;
    private String lastExpression = "";

    private final static int EXCEPTION = -1;
    private final static int IS_NUMBER = 0;
    private final static int IS_OPERAND = 1;
    private final static int IS_OPEN_PARENTHESIS = 2;
    private final static int IS_CLOSE_PARENTHESIS = 3;
    private final static int IS_DOT = 4;

    Button buttonNumber0, buttonNumber1, buttonNumber2, buttonNumber3, buttonNumber4, buttonNumber5, buttonNumber6,
            buttonNumber7, buttonNumber8, buttonNumber9;

    Button buttonClear, buttonBackspace, buttonPercent, buttonDivision, buttonMultiplication, buttonSubtraction,
            buttonAddition, buttonEqual, buttonDot, buttonRacineCarree, buttonPlusMoins, buttonPow, buttonClerE, buttonInverse;
    TextView textViewInputNumbers;

    ScriptEngine scriptEngine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculatrice);

        scriptEngine = new ScriptEngineManager().getEngineByName("rhino");

        initializeViewVariables();
        setOnClickListeners();
        setOnTouchListener();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_standard) {
            // Code pour le mode standard (si nécessaire)
            return true;
        } else if (id == R.id.menu_scientific) {
            Intent intent = new Intent(this, calculatriceActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initializeViewVariables()
    {
        buttonNumber0 = (Button) findViewById(R.id.button_zero);
        buttonNumber1 = (Button) findViewById(R.id.button_one);
        buttonNumber2 = (Button) findViewById(R.id.button_two);
        buttonNumber3 = (Button) findViewById(R.id.button_three);
        buttonNumber4 = (Button) findViewById(R.id.button_four);
        buttonNumber5 = (Button) findViewById(R.id.button_five);
        buttonNumber6 = (Button) findViewById(R.id.button_six);
        buttonNumber7 = (Button) findViewById(R.id.button_seven);
        buttonNumber8 = (Button) findViewById(R.id.button_eight);
        buttonNumber9 = (Button) findViewById(R.id.button_nine);

        buttonRacineCarree = (Button) findViewById(R.id.button_RacineCarree);
        buttonClear = (Button) findViewById(R.id.button_clear);
        buttonClerE = (Button) findViewById(R.id.button_clearElement);
        buttonBackspace = (Button) findViewById(R.id.button_backspace);
        buttonPercent = (Button) findViewById(R.id.button_percent);
        buttonDivision = (Button) findViewById(R.id.button_division);
        buttonMultiplication = (Button) findViewById(R.id.button_multiplication);
        buttonSubtraction = (Button) findViewById(R.id.button_subtraction);
        buttonAddition = (Button) findViewById(R.id.button_addition);
        buttonEqual = (Button) findViewById(R.id.button_equal);
        buttonDot = (Button) findViewById(R.id.button_dot);
        buttonPlusMoins = (Button) findViewById(R.id.button_plusmoins);
        buttonPow = (Button) findViewById(R.id.button_pow);
        buttonInverse = (Button) findViewById(R.id.button_inverse);
        textViewInputNumbers = (TextView) findViewById(R.id.textView_input_numbers);
    }

    private void setOnClickListeners()
    {
        buttonNumber0.setOnClickListener((View.OnClickListener) this);
        buttonNumber1.setOnClickListener((View.OnClickListener) this);
        buttonNumber2.setOnClickListener((View.OnClickListener) this);
        buttonNumber3.setOnClickListener((View.OnClickListener) this);
        buttonNumber4.setOnClickListener((View.OnClickListener) this);
        buttonNumber5.setOnClickListener((View.OnClickListener) this);
        buttonNumber6.setOnClickListener((View.OnClickListener) this);
        buttonNumber7.setOnClickListener((View.OnClickListener) this);
        buttonNumber8.setOnClickListener((View.OnClickListener) this);
        buttonNumber9.setOnClickListener((View.OnClickListener) this);

        buttonClear.setOnClickListener((View.OnClickListener) this);
        buttonBackspace.setOnClickListener((View.OnClickListener) this);
        buttonPercent.setOnClickListener((View.OnClickListener) this);
        buttonDivision.setOnClickListener((View.OnClickListener) this);
        buttonMultiplication.setOnClickListener((View.OnClickListener) this);
        buttonSubtraction.setOnClickListener((View.OnClickListener) this);
        buttonAddition.setOnClickListener((View.OnClickListener) this);
        buttonEqual.setOnClickListener((View.OnClickListener) this);
        buttonDot.setOnClickListener((View.OnClickListener) this);
        buttonInverse.setOnClickListener((View.OnClickListener) this);
        buttonPow.setOnClickListener((View.OnClickListener) this);
        buttonRacineCarree.setOnClickListener((View.OnClickListener) this);
        buttonClerE.setOnClickListener((View.OnClickListener) this);
        buttonPlusMoins.setOnClickListener((View.OnClickListener) this);
    }

    private void setOnTouchListener()
    {
        buttonNumber0.setOnTouchListener((View.OnTouchListener) this);
        buttonNumber1.setOnTouchListener((View.OnTouchListener) this);
        buttonNumber2.setOnTouchListener((View.OnTouchListener) this);
        buttonNumber3.setOnTouchListener((View.OnTouchListener) this);
        buttonNumber4.setOnTouchListener((View.OnTouchListener) this);
        buttonNumber5.setOnTouchListener((View.OnTouchListener) this);
        buttonNumber6.setOnTouchListener((View.OnTouchListener) this);
        buttonNumber7.setOnTouchListener((View.OnTouchListener) this);
        buttonNumber8.setOnTouchListener((View.OnTouchListener) this);
        buttonNumber9.setOnTouchListener((View.OnTouchListener) this);

        buttonClear.setOnTouchListener((View.OnTouchListener) this);
        buttonBackspace.setOnTouchListener((View.OnTouchListener) this);
        buttonPercent.setOnTouchListener((View.OnTouchListener) this);
        buttonDivision.setOnTouchListener((View.OnTouchListener) this);
        buttonMultiplication.setOnTouchListener((View.OnTouchListener) this);
        buttonSubtraction.setOnTouchListener((View.OnTouchListener) this);
        buttonAddition.setOnTouchListener((View.OnTouchListener) this);
        buttonDot.setOnTouchListener((View.OnTouchListener) this);
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();

        if (viewId == R.id.button_zero) {
            if (addNumber("0")) equalClicked = false;
        } else if (viewId == R.id.button_one) {
            if (addNumber("1")) equalClicked = false;
        } else if (viewId == R.id.button_two) {
            if (addNumber("2")) equalClicked = false;
        } else if (viewId == R.id.button_three) {
            if (addNumber("3")) equalClicked = false;
        } else if (viewId == R.id.button_four) {
            if (addNumber("4")) equalClicked = false;
        } else if (viewId == R.id.button_five) {
            if (addNumber("5")) equalClicked = false;
        } else if (viewId == R.id.button_six) {
            if (addNumber("6")) equalClicked = false;
        } else if (viewId == R.id.button_seven) {
            if (addNumber("7")) equalClicked = false;
        } else if (viewId == R.id.button_eight) {
            if (addNumber("8")) equalClicked = false;
        } else if (viewId == R.id.button_nine) {
            if (addNumber("9")) equalClicked = false;
        } else if (viewId == R.id.button_addition) {
            if (addOperand("+")) equalClicked = false;
        } else if (viewId == R.id.button_subtraction) {
            if (addOperand("-")) equalClicked = false;
        } else if (viewId == R.id.button_multiplication) {
            if (addOperand("x")) equalClicked = false;
        } else if (viewId == R.id.button_division) {
            if (addOperand("\u00F7")) equalClicked = false;
        } else if (viewId == R.id.button_percent) {
            if (addOperand("%")) equalClicked = false;
        } else if (viewId == R.id.button_dot) {
            if (addDot()) equalClicked = false;
        } else if (viewId == R.id.button_backspace) {
            if (handleBackspace()) equalClicked = false;
        } else if (viewId == R.id.button_clearElement) {
            if (clearElement()) equalClicked = false;
        } else if (viewId == R.id.button_inverse) {
            if (inverseNumber()) equalClicked = false;
        } else if (viewId == R.id.button_pow) {
            if (squareNumber()) equalClicked = false;
        } else if (viewId == R.id.button_RacineCarree) {
            if (calculateSquareRoot()) equalClicked = false;
        }else if (viewId == R.id.button_clear) {
            textViewInputNumbers.setText("");
            dotUsed = false;
            equalClicked = false;
        } else if (viewId == R.id.button_equal) {
            if (textViewInputNumbers.getText().toString() != null && !textViewInputNumbers.getText().toString().equals(""))
                calculate(textViewInputNumbers.getText().toString());
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent)
    {
        switch (motionEvent.getAction())
        {
            case MotionEvent.ACTION_DOWN:
            {
                view.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
                view.invalidate();
                break;
            }
            case MotionEvent.ACTION_UP:
            {
                view.getBackground().clearColorFilter();
                view.invalidate();
                break;
            }
        }
        return false;
    }

    private boolean addDot()
    {
        boolean done = false;

        if (textViewInputNumbers.getText().length() == 0)
        {
            textViewInputNumbers.setText("0.");
            dotUsed = true;
            done = true;
        } else if (dotUsed == true)
        {
        } else if (defineLastCharacter(textViewInputNumbers.getText().charAt(textViewInputNumbers.getText().length() - 1) + "") == IS_OPERAND)
        {
            textViewInputNumbers.setText(textViewInputNumbers.getText() + "0.");
            done = true;
            dotUsed = true;
        } else if (defineLastCharacter(textViewInputNumbers.getText().charAt(textViewInputNumbers.getText().length() - 1) + "") == IS_NUMBER)
        {
            textViewInputNumbers.setText(textViewInputNumbers.getText() + ".");
            done = true;
            dotUsed = true;
        }
        return done;
    }

    private boolean handleBackspace() {
        String currentInput = textViewInputNumbers.getText().toString();
        if (!currentInput.isEmpty()) {
            char lastChar = currentInput.charAt(currentInput.length() - 1);
            if (lastChar == 'x' || lastChar == '\u00F7' || lastChar == '%' || lastChar == '+' || lastChar == '-') {
                // Si le dernier caractère est un opérateur, supprimez trois caractères pour gérer les opérations telles que "sin", "cos", etc.
                textViewInputNumbers.setText(currentInput.substring(0, currentInput.length() - 3));
            } else {
                textViewInputNumbers.setText(currentInput.substring(0, currentInput.length() - 1));
            }
            return true;
        }
        return false;
    }
    private boolean clearElement() {
        String currentInput = textViewInputNumbers.getText().toString();
        if (!currentInput.isEmpty()) {
            String[] elements = currentInput.split("(?<=[x\u00F7%+\\-])|(?=[x\u00F7%+\\-])");

            if (elements.length > 1) {
                StringBuilder newInput = new StringBuilder();
                for (int i = 0; i < elements.length - 1; i++) {
                    newInput.append(elements[i]);
                }
                textViewInputNumbers.setText(newInput.toString());
            } else {
                textViewInputNumbers.setText("");
            }
            return true;
        }
        return false;
    }

    private boolean inverseNumber() {
        String currentInput = textViewInputNumbers.getText().toString();

        if (!currentInput.isEmpty()) {
            try {
                // Convertit la chaîne en double
                double number = Double.parseDouble(currentInput);

                // Vérifie si le nombre est différent de zéro avant d'inverser
                if (number != 0) {
                    double result = 1 / number;

                    // Affiche le résultat avec une certaine précision
                    textViewInputNumbers.setText(formatResult(result));
                    return true;
                } else {
                    // Gère la division par zéro
                    Toast.makeText(getApplicationContext(), "Division by zero is not allowed", Toast.LENGTH_SHORT).show();
                }
            } catch (NumberFormatException e) {
                // Gère les erreurs de conversion
                Toast.makeText(getApplicationContext(), "Invalid number format", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                // Gère les autres exceptions
                Toast.makeText(getApplicationContext(), "An error occurred", Toast.LENGTH_SHORT).show();
            }
        }
        return false;
    }

    private String formatResult(double result) {
        // Utilisez une instance de DecimalFormat pour formater le résultat
        DecimalFormat decimalFormat = new DecimalFormat("#.########");
        return decimalFormat.format(result);
    }
    private boolean squareNumber() {
        String currentInput = textViewInputNumbers.getText().toString();

        if (!currentInput.isEmpty()) {
            try {
                double number = Double.parseDouble(currentInput);
                double squaredNumber = Math.pow(number, 2);

                textViewInputNumbers.setText(String.valueOf(squaredNumber));

                return true;
            } catch (NumberFormatException e) {
                Toast.makeText(getApplicationContext(), "Invalid input for squaring", Toast.LENGTH_SHORT).show();
            }
        }

        return false;
    }
    private boolean calculateSquareRoot() {
        String currentInput = textViewInputNumbers.getText().toString();

        if (!currentInput.isEmpty()) {
            try {
                double number = Double.parseDouble(currentInput);

                if (number >= 0) {
                    double squareRoot = Math.sqrt(number);

                    textViewInputNumbers.setText(String.valueOf(squareRoot));
                    return true;
                } else {
                    Toast.makeText(getApplicationContext(), "Cannot calculate square root of a negative number", Toast.LENGTH_SHORT).show();
                }
            } catch (NumberFormatException e) {
                Toast.makeText(getApplicationContext(), "Invalid input for square root", Toast.LENGTH_SHORT).show();
            }
        }

        return false;
    }
    private boolean addOperand(String operand)
    {
        boolean done = false;
        int operationLength = textViewInputNumbers.getText().length();
        if (operationLength > 0)
        {
            String lastInput = textViewInputNumbers.getText().charAt(operationLength - 1) + "";

            if ((lastInput.equals("+") || lastInput.equals("-") || lastInput.equals("*") || lastInput.equals("\u00F7") || lastInput.equals("%")))
            {
                Toast.makeText(getApplicationContext(), "Wrong format", Toast.LENGTH_LONG).show();
            } else if (operand.equals("%") && defineLastCharacter(lastInput) == IS_NUMBER)
            {
                textViewInputNumbers.setText(textViewInputNumbers.getText() + operand);
                dotUsed = false;
                equalClicked = false;
                lastExpression = "";
                done = true;
            } else if (!operand.equals("%"))
            {
                textViewInputNumbers.setText(textViewInputNumbers.getText() + operand);
                dotUsed = false;
                equalClicked = false;
                lastExpression = "";
                done = true;
            }
        } else
        {
            Toast.makeText(getApplicationContext(), "Wrong Format. Operand Without any numbers?", Toast.LENGTH_LONG).show();
        }
        return done;
    }

    private boolean addNumber(String number)
    {
        boolean done = false;
        int operationLength = textViewInputNumbers.getText().length();
        if (operationLength > 0)
        {
            String lastCharacter = textViewInputNumbers.getText().charAt(operationLength - 1) + "";
            int lastCharacterState = defineLastCharacter(lastCharacter);

            if (operationLength == 1 && lastCharacterState == IS_NUMBER && lastCharacter.equals("0"))
            {
                textViewInputNumbers.setText(number);
                done = true;
            } else if (lastCharacterState == IS_OPEN_PARENTHESIS)
            {
                textViewInputNumbers.setText(textViewInputNumbers.getText() + number);
                done = true;
            } else if (lastCharacterState == IS_CLOSE_PARENTHESIS || lastCharacter.equals("%"))
            {
                textViewInputNumbers.setText(textViewInputNumbers.getText() + "x" + number);
                done = true;
            } else if (lastCharacterState == IS_NUMBER || lastCharacterState == IS_OPERAND || lastCharacterState == IS_DOT)
            {
                textViewInputNumbers.setText(textViewInputNumbers.getText() + number);
                done = true;
            }
        } else
        {
            textViewInputNumbers.setText(textViewInputNumbers.getText() + number);
            done = true;
        }
        return done;
    }


    private void calculate(String input)
    {
        String result = "";
        try
        {
            String temp = input;
            if (equalClicked)
            {
                temp = input + lastExpression;
            } else
            {
                saveLastExpression(input);
            }
            result = scriptEngine.eval(temp.replaceAll("%", "/100").replaceAll("x", "*").replaceAll("[^\\x00-\\x7F]", "/")).toString();
            BigDecimal decimal = new BigDecimal(result);
            result = decimal.setScale(8, BigDecimal.ROUND_HALF_UP).toPlainString();
            equalClicked = true;

        } catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), "Wrong Format", Toast.LENGTH_SHORT).show();
            return;
        }

        if (result.equals("Infinity"))
        {
            Toast.makeText(getApplicationContext(), "Division by zero is not allowed", Toast.LENGTH_SHORT).show();
            textViewInputNumbers.setText(input);

        } else if (result.contains("."))
        {
            result = result.replaceAll("\\.?0*$", "");
            textViewInputNumbers.setText(result);
        }
    }

    private void saveLastExpression(String input)
    {
        String lastOfExpression = input.charAt(input.length() - 1) + "";
        if (input.length() > 1)
        {
            if (lastOfExpression.equals(")"))
            {
                lastExpression = ")";
                int numberOfCloseParenthesis = 1;

                for (int i = input.length() - 2; i >= 0; i--)
                {
                    if (numberOfCloseParenthesis > 0)
                    {
                        String last = input.charAt(i) + "";
                        if (last.equals(")"))
                        {
                            numberOfCloseParenthesis++;
                        } else if (last.equals("("))
                        {
                            numberOfCloseParenthesis--;
                        }
                        lastExpression = last + lastExpression;
                    } else if (defineLastCharacter(input.charAt(i) + "") == IS_OPERAND)
                    {
                        lastExpression = input.charAt(i) + lastExpression;
                        break;
                    } else
                    {
                        lastExpression = "";
                    }
                }
            } else if (defineLastCharacter(lastOfExpression + "") == IS_NUMBER)
            {
                lastExpression = lastOfExpression;
                for (int i = input.length() - 2; i >= 0; i--)
                {
                    String last = input.charAt(i) + "";
                    if (defineLastCharacter(last) == IS_NUMBER || defineLastCharacter(last) == IS_DOT)
                    {
                        lastExpression = last + lastExpression;
                    } else if (defineLastCharacter(last) == IS_OPERAND)
                    {
                        lastExpression = last + lastExpression;
                        break;
                    }
                    if (i == 0)
                    {
                        lastExpression = "";
                    }
                }
            }
        }
    }

    private int defineLastCharacter(String lastCharacter)
    {
        try
        {
            Integer.parseInt(lastCharacter);
            return IS_NUMBER;
        } catch (NumberFormatException e)
        {
        }

        if ((lastCharacter.equals("+") || lastCharacter.equals("-") || lastCharacter.equals("x") || lastCharacter.equals("\u00F7") || lastCharacter.equals("%")))
            return IS_OPERAND;

        if (lastCharacter.equals("("))
            return IS_OPEN_PARENTHESIS;

        if (lastCharacter.equals(")"))
            return IS_CLOSE_PARENTHESIS;

        if (lastCharacter.equals("."))
            return IS_DOT;

        return -1;
    }
}