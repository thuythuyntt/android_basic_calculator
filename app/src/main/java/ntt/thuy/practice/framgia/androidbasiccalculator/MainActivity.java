package ntt.thuy.practice.framgia.androidbasiccalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static ntt.thuy.practice.framgia.androidbasiccalculator.Constants.DIVISION_STRING;
import static ntt.thuy.practice.framgia.androidbasiccalculator.Constants.DOT_STRING;
import static ntt.thuy.practice.framgia.androidbasiccalculator.Constants.MULTIPLICATION_STRING;
import static ntt.thuy.practice.framgia.androidbasiccalculator.Constants.SUBTRACTION_STRING;
import static ntt.thuy.practice.framgia.androidbasiccalculator.Constants.SUMMATION_STRING;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTextInput, mTextResult;
//    private ImageView mButtonBackSpace;
//    private TextView mButtonParenthesis, mButtonPercent, mButtonDivision, mButtonMultiplication, mButtonSubtraction, mButtonSummation, mButtonClear, mButtonDot, mButtonResult, mButton0, mButton1, mButton2, mButton3, mButton4, mButton5, mButton6, mButton7, mButton8, mButton9;

//    @BindView(R.id.text_input)
//    TextView mTextInput;
//    @BindView(R.id.text_result)
//    TextView mTextResult;
//    @BindView(R.id.button_backspace)
//    ImageView mButtonBackspace;
//    @BindView(R.id.button_parenthesis)
//    TextView mButtonParenthesis;
//    @BindView(R.id.button_percent)
//    TextView mButtonPercent;
//    @BindView(R.id.button_division)
//    TextView mButtonDivision;
//    @BindView(R.id.button_7)
//    TextView mButton7;
//    @BindView(R.id.button_8)
//    TextView mButton8;
//    @BindView(R.id.button_9)
//    TextView mButton9;
//    @BindView(R.id.button_multiplication)
//    TextView mButtonMultiplication;
//    @BindView(R.id.button_4)
//    TextView mButton4;
//    @BindView(R.id.button_5)
//    TextView mButton5;
//    @BindView(R.id.button_6)
//    TextView mButton6;
//    @BindView(R.id.button_subtraction)
//    TextView mButtonSubtraction;
//    @BindView(R.id.button_1)
//    TextView mButton1;
//    @BindView(R.id.button_2)
//    TextView mButton2;
//    @BindView(R.id.button_3)
//    TextView mButton3;
//    @BindView(R.id.button_summation)
//    TextView mButtonSummation;
//    @BindView(R.id.button_clear)
//    TextView mButtonClear;
//    @BindView(R.id.button_0)
//    TextView mButton0;
//    @BindView(R.id.button_dot)
//    TextView mButtonDot;
//    @BindView(R.id.button_result)
//    TextView mButtonResult;

private int[] ids= {R.id.button_backspace, R.id.button_parenthesis, R.id.button_percent,
        R.id.button_division, R.id.button_multiplication, R.id.button_subtraction,
        R.id.button_summation, R.id.button_clear, R.id.button_dot, R.id.button_result,
        R.id.button_0, R.id.button_1, R.id.button_2, R.id.button_3, R.id.button_4, R.id.button_5,
        R.id.button_6, R.id.button_7, R.id.button_8, R.id.button_9};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializationView();
//        ButterKnife.bind(this);
    }

    private void initializationView() {
        mTextInput = (TextView) findViewById(R.id.text_input);

        mTextResult = (TextView) findViewById(R.id.text_result);
//
//        findViewById(R.id.button_backspace).setOnClickListener(this);
//
//        findViewById(R.id.button_parenthesis).setOnClickListener(this);
//
//        findViewById(R.id.button_percent).setOnClickListener(this);
//
//        findViewById(R.id.button_division).setOnClickListener(this);
//
//        findViewById(R.id.button_multiplication).setOnClickListener(this);
//
//        findViewById(R.id.button_subtraction).setOnClickListener(this);
//
//        findViewById(R.id.button_summation).setOnClickListener(this);
//
//        findViewById(R.id.button_clear).setOnClickListener(this);
//
//        findViewById(R.id.button_dot).setOnClickListener(this);
//
//        findViewById(R.id.button_result).setOnClickListener(this);
//
//        findViewById(R.id.button_0).setOnClickListener(this);
//
//        findViewById(R.id.button_1).setOnClickListener(this);
//
//        findViewById(R.id.button_2).setOnClickListener(this);
//
//        findViewById(R.id.button_3).setOnClickListener(this);
//
//        findViewById(R.id.button_4).setOnClickListener(this);
//
//        findViewById(R.id.button_5).setOnClickListener(this);
//
//        findViewById(R.id.button_6).setOnClickListener(this);
//
//        findViewById(R.id.button_7).setOnClickListener(this);
//
//        findViewById(R.id.button_8).setOnClickListener(this);
//
//        findViewById(R.id.button_9).setOnClickListener(this);

        for (int id:ids){
            findViewById(id).setOnClickListener(this);
        }
    }

//    @OnClick({R.id.button_backspace, R.id.button_parenthesis, R.id.button_percent, R.id.button_division, R.id.button_7, R.id.button_8, R.id.button_9, R.id.button_multiplication, R.id.button_4, R.id.button_5, R.id.button_6, R.id.button_subtraction, R.id.button_1, R.id.button_2, R.id.button_3, R.id.button_summation, R.id.button_clear, R.id.button_0, R.id.button_dot, R.id.button_result})
//    public void onViewClicked(View view) {
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_backspace:
                String input = mTextInput.getText().toString();
                mTextInput.setText(input.substring(0, input.length()-1));
                break;
//
//            case R.id.button_parenthesis:
//                break;
//
//            case R.id.button_percent:
//                break;

            case R.id.button_division:
                formatInputString(DIVISION_STRING);
                break;

            case R.id.button_0:
            case R.id.button_1:
            case R.id.button_2:
            case R.id.button_3:
            case R.id.button_4:
            case R.id.button_5:
            case R.id.button_6:
            case R.id.button_7:
            case R.id.button_8:
            case R.id.button_9:
                formatInputString(((TextView)view).getText().toString());
                break;

            case R.id.button_multiplication:
                formatInputString(MULTIPLICATION_STRING);
                break;

            case R.id.button_subtraction:
                formatInputString(SUBTRACTION_STRING);
                break;

            case R.id.button_summation:
                formatInputString(SUMMATION_STRING);
                break;

            case R.id.button_clear:
                mTextInput.setText("");
                mTextResult.setText("0");
                break;

            case R.id.button_dot:
                formatInputString(DOT_STRING);
                break;

            case R.id.button_result:
                Logic logic = new Logic();
                double rs = logic.calculator(logic.infixToPostfix(logic.processString(mTextInput.getText().toString())));
                mTextResult.setText(String.valueOf(rs));
                break;
        }
    }

    private void formatInputString(String string) {
        String input = mTextInput.getText().toString();
        mTextInput.setText(new StringBuilder(input).append(string));
    }
}
