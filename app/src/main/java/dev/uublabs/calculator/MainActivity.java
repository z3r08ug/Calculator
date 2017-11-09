package dev.uublabs.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.NaN;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private boolean useDoub, useDoub1;
    private final String TAG = "MainActivity";
    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnC;
    private Button btnPlus;
    private Button btnPercent;
    private Button btnMinus;
    private Button btnMultiply;
    private Button btnDivide;
    private Button btnDecimal;
    private Button btnSqrt;
    private Button btnSin;
    private Button btnCos;
    private Button btnTan;
    private Button btnLn;
    private Button btnLog;
    private Button btnFrac;
    private Button btnEx;
    private Button btnX2;
    private Button btnXy;
    private Button btnAbs;
    private Button btnPi;
    private Button btnE;
    private Button btnNeg;
    private Button btnParen;
    private Button btnEquals;
    private List<Button> buttons;
    private TextView tvComputation;
    private TextView tvComputationPreview;
    private double value1, value2;
    private int v1, v2;
    private int action;

    private int whole1, whole2, dec1, dec2;
    private double num1, num2;
    private String n1, n2, n3, n4;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindButtons();
    }

    public void bindButtons()
    {
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnC = findViewById(R.id.btnc);
        btnPlus = findViewById(R.id.btnPlus);
        btnPercent = findViewById(R.id.btnPercent);
        btnMinus = findViewById(R.id.btnMinus);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        btnDecimal = findViewById(R.id.btnDecimal);
        btnNeg = findViewById(R.id.btnNegative);
        btnParen = findViewById(R.id.btnParenthesis);
        btnEquals = findViewById(R.id.btnEquals);
        btnSqrt = findViewById(R.id.btnSquareRoot);
        btnSin = findViewById(R.id.btnSin);
        btnCos = findViewById(R.id.btnCos);
        btnTan = findViewById(R.id.btnTan);
        btnLn = findViewById(R.id.btnNlog);
        btnLog = findViewById(R.id.btnLog);
        btnFrac = findViewById(R.id.btnFrac);
        btnEx = findViewById(R.id.btnEx);
        btnX2 = findViewById(R.id.btnX2);
        btnXy = findViewById(R.id.btnToY);
        btnAbs = findViewById(R.id.btnAbs);
        btnPi = findViewById(R.id.btnPi);
        btnE = findViewById(R.id.btnE);

        buttons = new ArrayList<Button>();
        buttons.add(btn0);
        buttons.add(btn1);
        buttons.add(btn2);
        buttons.add(btn3);
        buttons.add(btn4);
        buttons.add(btn5);
        buttons.add(btn6);
        buttons.add(btn7);
        buttons.add(btn8);
        buttons.add(btn9);
        buttons.add(btnC);
        buttons.add(btnPlus);
        buttons.add(btnPercent);
        buttons.add(btnMinus);
        buttons.add(btnMultiply);
        buttons.add(btnDivide);
        buttons.add(btnDecimal);
        buttons.add(btnNeg);
        //buttons.add(btnParen);
        buttons.add(btnEquals);
//        buttons.add(btnSqrt);
//        buttons.add(btnSin);
//        buttons.add(btnCos);
//        buttons.add(btnTan);
//        buttons.add(btnLn);
//        buttons.add(btnLog);
//        buttons.add(btnFrac);
//        buttons.add(btnEx);
//        buttons.add(btnX2);
//        buttons.add(btnAbs);
//        buttons.add(btnPi);
//        buttons.add(btnE);

        for(Button b : buttons)
        {
            b.setOnClickListener(this);
        }

        tvComputation = findViewById(R.id.tvComputation);
        tvComputationPreview = findViewById(R.id.tvComputationPreview);

        value1 = 0;
        value2 = 0;

        v1 = 0;
        v2=0;
        action = 0;

        n1="";
        n2="";
        n3="";
        n4="";

        useDoub=false;
        useDoub1=false;
    }

    @Override
    public void onClick(View v)
    {
        Button b = (Button)v;

        //user pushed equals
        if(b.getId() == R.id.btnEquals)
        {
            switch(action)
            {
                case 1:
                {
                    if(useDoub || useDoub1)
                    {
                        if (n2=="")
                            n2="0";
                        if(n4=="")
                            n4="0";
                        int w1 = Integer.parseInt(n1) + Integer.parseInt(n3);
                        int w2 = Integer.parseInt(n2) + Integer.parseInt(n4);
                        if(w2>=10)
                        {
                            w2-=10;
                            w1+=1;
                        }
                        num1=Double.parseDouble(n1+"."+n2);
                        num2=Double.parseDouble(n3+"."+n4);
                        Log.d(TAG, "add: "+num1 + " " + num2);
                        num1+=num2;
                        num2=0;
                        n1 = ""+w1;
                        n2=""+w2;
                        n3="";
                        n4="";
                        tvComputation.setText(num1+"");
                        action = 0;
                        useDoub=true;
                        useDoub1=false;
                    }
                    else if(!useDoub1 && !useDoub)
                    {
                        v1 =Integer.parseInt(n1);
                        v2 = Integer.parseInt(n3);
                        tvComputation.setText((v1+v2) + "");
                        action = 0;
                        n1=""+(v1+v2);
                        n2="";
                        n3="";
                        n4="";
                        action=0;
                        useDoub=false;
                        useDoub1=false;
                    }
                    break;
                }
                case 2:
                {
                    if(useDoub || useDoub1)
                    {
                        if (n2=="")
                            n2="0";
                        if(n4=="")
                            n4="0";
                        int w1 = Integer.parseInt(n1) - Integer.parseInt(n3);
                        int w2 = Integer.parseInt(n2) - Integer.parseInt(n4);
                        if(w2<0)
                        {
                            w2+=10;
                            w1-=1;
                        }
                        num1=Double.parseDouble(n1+"."+n2);
                        num2=Double.parseDouble(n3+"."+n4);
                        Log.d(TAG, "add: "+num1 + " " + num2);
                        num1-=num2;
                        num2=0;
                        n1 = ""+w1;
                        n2=""+w2;
                        n3="";
                        n4="";
                        tvComputation.setText(num1+"");
                        action = 0;
                        useDoub=true;
                        useDoub1=false;
                    }
                    else if(!useDoub1 && !useDoub)
                    {
                        v1 =Integer.parseInt(n1);
                        v2 = Integer.parseInt(n3);
                        tvComputation.setText((v1-v2) + "");
                        action = 0;
                        n1=""+(v1-v2);
                        n2="";
                        n3="";
                        n4="";
                        action=0;
                        useDoub=false;
                        useDoub1=false;
                    }
                    break;
                }
                case 3:
                {
                    if(useDoub || useDoub1)
                    {
                        if (n2=="")
                            n2="0";
                        if(n4=="")
                            n4="0";
                        num1=Double.parseDouble(n1+"."+n2);
                        num2=Double.parseDouble(n3+"."+n4);
                        num1*=num2;
                        num2=0;
                        int whole = (int) num1;
                        int fract = (int) ((num1 - whole) * 100);
                        n1 = ""+whole;
                        n2=""+fract;
                        n3="";
                        n4="";
                        tvComputation.setText(num1+"");
                        action = 0;
                        useDoub=true;
                        useDoub1=false;
                    }
                    else if(!useDoub1 && !useDoub)
                    {
                        v1 =Integer.parseInt(n1);
                        v2 = Integer.parseInt(n3);
                        tvComputation.setText((v1*v2) + "");
                        action = 0;
                        n1=""+(v1*v2);
                        n2="";
                        n3="";
                        n4="";
                        action=0;
                        useDoub=false;
                        useDoub1=false;
                    }
                    break;
                }
                case 4:
                {
                    if(useDoub || useDoub1)
                    {
                        if (n2=="")
                            n2="0";
                        if(n4=="")
                            n4="0";
                        num1=Double.parseDouble(n1+"."+n2);
                        num2=Double.parseDouble(n3+"."+n4);
                        num1/=num2;
                        num2=0;
                        int whole = (int) num1;
                        int fract = (int) ((num1 - whole) * 100);
                        n1 = ""+whole;
                        n2=""+fract;
                        n3="";
                        n4="";
                        tvComputation.setText(num1+"");
                        action = 0;
                        useDoub=true;
                        useDoub1=false;
                    }
                    else if(!useDoub1 && !useDoub)
                    {
                        num1 =Integer.parseInt(n1);
                        num2 = Integer.parseInt(n3);
                        num1/=num2;
                        num2=0;
                        int whole = (int) num1;
                        int fract = (int) ((num1 - whole) * 100);
                        n1 = ""+whole;
                        n2=""+fract;
                        n3="";
                        n4="";
                        tvComputation.setText(num1+"");
                        action = 0;
                        useDoub=true;
                        useDoub1=false;
                    }
                    break;
                }

            }

        }
        //multiply
        else if(b.getId() == R.id.btnMultiply)
        {
            tvComputation.setText(tvComputation.getText().toString() + " * ");
            action = 3;
        }
        else if(b.getId() == R.id.btnc)
        {
            tvComputation.setText(0+"");
            value2=0;
            value1=0;
            v1=0;
            v2=0;
            action = 0;
            useDoub = false;
            useDoub1=false;
            n1="";
            n2="";
            n3="";
            n4="";
            num1=0;
            num2=0;
        }
        //subtract
        else if(b.getId() == R.id.btnMinus)
        {
            tvComputation.setText(tvComputation.getText().toString() + " - ");
            action = 2;
        }
        //add
        else if(b.getId() == R.id.btnPlus)
        {
            tvComputation.setText(tvComputation.getText().toString() + " + ");
            action = 1;
        }
        //divide
        else if(b.getId() == R.id.btnDivide)
        {
            tvComputation.setText(tvComputation.getText().toString() + " / ");
            action = 4;
        }
        //add decimal
        else if(b.getId() == R.id.btnDecimal)
        {
            if(action == 0)
            {
                //value1 = v1 + 0.0;
                tvComputation.setText(n1 + ".");
                useDoub=true;
            }
            else
            {
                //value2 = v2 + 0.0;
                tvComputation.setText(tvComputation.getText().toString() + ".");
                useDoub1=true;
            }
        }
        else if(b.getId() == R.id.btnNegative)
        {
            int x=0;
            if(action==0)
            {
                x=Integer.parseInt(n1);
                x*=-1;
                n1=""+x;
                //tvComputation.setText();
            }
            else
            {
                x=Integer.parseInt(n3);
                x*=-1;
                n3=""+x;
            }
        }
//        else if(b.getId() == R.id.btnSquareRoot)
//        {
//            double x=Double.parseDouble(n1+"."+n2);
//            double y=0;
//            if(action==0)
//            {
//                y=Math.sqrt(x);
//                int whole = (int) y;
//                int fract = (int) ((y - whole) * 100);
//                n1 = ""+whole;
//                n2=""+fract;
//                tvComputation.setText(""+y);
//            }
//        }
        else if(b.getId() == R.id.btnSin)
        {
            double x=Double.parseDouble(n1+"."+n2);
            double y=0;
            if(action==0)
            {
                y=Math.sin(x);
                int whole = (int) y;
                int fract = (int) ((y - whole) * 100);
                n1 = ""+whole;
                n2=""+fract;
                tvComputation.setText(""+y);
            }
        }
        else if(b.getId() == R.id.btnCos)
        {
            double x=Double.parseDouble(n1+"."+n2);
            double y=0;
            if(action==0)
            {
                y=Math.cos(x);
                int whole = (int) y;
                int fract = (int) ((y - whole) * 100);
                n1 = ""+whole;
                n2=""+fract;
                tvComputation.setText(""+y);
            }
        }
        else if(b.getId() == R.id.btnTan)
        {
            double x=Double.parseDouble(n1+"."+n2);
            double y=0;
            if(action==0)
            {
                y=Math.tan(x);
                int whole = (int) y;
                int fract = (int) ((y - whole) * 100);
                n1 = ""+whole;
                n2=""+fract;
                tvComputation.setText(""+y);
            }
        }
        else if(b.getId() == R.id.btnNlog)
        {
            double x=Double.parseDouble(n1+"."+n2);
            double y=0;
            if(action==0)
            {
                y=Math.log(x);
                int whole = (int) y;
                int fract = (int) ((y - whole) * 100);
                n1 = ""+whole;
                n2=""+fract;
                tvComputation.setText(""+y);
            }
        }
        else if(b.getId() == R.id.btnLog)
        {
            double x=Double.parseDouble(n1+"."+n2);
            double y=0;
            if(action==0)
            {
                y=Math.log10(x);
                int whole = (int) y;
                int fract = (int) ((y - whole) * 100);
                n1 = ""+whole;
                n2=""+fract;
                tvComputation.setText(""+y);
            }
        }
        else if(b.getId() == R.id.btnFrac)
        {
            double x=Double.parseDouble(n1+"."+n2);
            double y=0;
            if(action==0)
            {
                y=1/y;
                int whole = (int) y;
                int fract = (int) ((y - whole) * 100);
                n1 = ""+whole;
                n2=""+fract;
                tvComputation.setText(""+y);
            }
        }
        else if(b.getId() == R.id.btnEx)
        {
            double x=Double.parseDouble(n1+"."+n2);
            double y=0;
            if(action==0)
            {
                y=Math.pow(Math.E, x);
                int whole = (int) y;
                int fract = (int) ((y - whole) * 100);
                n1 = ""+whole;
                n2=""+fract;
                tvComputation.setText(""+y);
            }
        }
        else if(b.getId() == R.id.btnX2)
        {
            double x=Double.parseDouble(n1+"."+n2);
            double y=0;
            if(action==0)
            {
                y=x*x;
                int whole = (int) y;
                int fract = (int) ((y - whole) * 100);
                n1 = ""+whole;
                n2=""+fract;
                tvComputation.setText(""+y);
            }
        }
        else if(b.getId() == R.id.btnToY)
        {
            double x=Double.parseDouble(n1+"."+n2);
            double y=0;
            if(action==0)
            {
                y=Math.pow(x, 2);
                int whole = (int) y;
                int fract = (int) ((y - whole) * 100);
                n1 = ""+whole;
                n2=""+fract;
                tvComputation.setText(""+y);
            }
        }
        else if(b.getId() == R.id.btnAbs)
        {
            double x=Double.parseDouble(n1+"."+n2);
            double y=0;
            if(action==0)
            {
                y=Math.abs(x);
                int whole = (int) y;
                int fract = (int) ((y - whole) * 100);
                n1 = ""+whole;
                n2=""+fract;
                tvComputation.setText(""+y);
            }
        }
        else if(b.getId() == R.id.btnPi)
        {
            double y=0;
            if(action==0)
            {
                y=Math.PI;
                int whole = (int) y;
                int fract = (int) ((y - whole) * 100);
                n1 = ""+whole;
                n2=""+fract;
                tvComputation.setText(""+y);
            }
        }
        else if(b.getId() == R.id.btnE)
        {
            double y=0;
            if(action==0)
            {
                y=Math.E;
                int whole = (int) y;
                int fract = (int) ((y - whole) * 100);
                n1 = ""+whole;
                n2=""+fract;
                tvComputation.setText(""+y);
            }
        }
        else
        {
            if(!useDoub && action==0)
            {
                n1 += b.getText().toString();
                tvComputation.setText(n1);
            }
            else if(!useDoub1 && action !=0)
            {
                String cur = tvComputation.getText().toString();
                n3 += b.getText().toString();
                tvComputation.setText(cur+b.getText().toString());
            }
            else if(useDoub && action==0)
            {
                n2 += b.getText().toString();
                tvComputation.setText(tvComputation.getText().toString() + b.getText().toString());
            }
            else if(useDoub1 && action!=0)
            {
                n4+=b.getText().toString();
                tvComputation.setText(tvComputation.getText().toString() + b.getText().toString());
            }
        }
    }
}
