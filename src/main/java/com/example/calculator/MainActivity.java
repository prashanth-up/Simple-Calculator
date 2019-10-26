package com.example.calculator;

        import android.os.Bundle;
        import java.text.NumberFormat;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

        import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button one,two,three,four,five,six,sevenuh,eight,nine,zero,samadengan,bagi,kali,tambah,kurang,koma,clear;
    EditText txt_layar,proses_layar;
    int op;
    double angka1, angka2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init()
    {
        txt_layar =  findViewById(R.id.txt_layar);
        proses_layar =  findViewById(R.id.proses_layar);

        one =  findViewById(R.id.one);
        two =  findViewById(R.id.two);
        three =  findViewById(R.id.three);
        four =  findViewById(R.id.four);
        five =  findViewById(R.id.five);
        six =  findViewById(R.id.six);
        sevenuh =  findViewById(R.id.seven);
        eight =  findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero =  findViewById(R.id.zero);
        koma =  findViewById(R.id.koma);

        tambah =  findViewById(R.id.plus);
        bagi =  findViewById(R.id.bagi);
        kurang =  findViewById(R.id.min);
        kali = findViewById(R.id.kali);
        samadengan = findViewById(R.id.sd);
        clear = findViewById(R.id.c);


        txt_layar.setKeyListener(null);
        proses_layar.setKeyListener(null);

        
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        sevenuh.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        koma.setOnClickListener(this);
        tambah.setOnClickListener(this);
        kurang.setOnClickListener(this);
        bagi.setOnClickListener(this);
        kali.setOnClickListener(this);
        clear.setOnClickListener(this);
        samadengan.setOnClickListener(this);
        samadengan.setEnabled(false);
    }

    public void onClick(View v)
    {
        switch(v.getId()){
            case R.id.one:
                addAngka("1");
                break;
            case R.id.two:
                addAngka("2");
                break;
            case R.id.three:
                addAngka("3");
                break;
            case R.id.four:
                addAngka("4");
                break;
            case R.id.five:
                addAngka("5");
                break;
            case R.id.six:
                addAngka("6");
                break;
            case R.id.seven:
                addAngka("7");
                break;
            case R.id.eight:
                addAngka("8");
                break;
            case R.id.nine:
                addAngka("9");
                break;
            case R.id.zero:
                addAngka("0");
                break;
            case R.id.koma:
                addAngka(".");
                break;
            case R.id.plus:
                angka1 = Double.parseDouble(txt_layar.getText().toString());
                op = 1;
                txt_layar.setText("");
                statusBtn(false);
                break;

            case R.id.min:
                angka1 = Double.parseDouble(txt_layar.getText().toString());
                op = 2;
                txt_layar.setText("");
                statusBtn(false);
                break;
            case R.id.kali:
                angka1 = Double.parseDouble(txt_layar.getText().toString());
                op = 3;
                txt_layar.setText("");
                statusBtn(false);
                break;
            case R.id.bagi:
                angka1 = Double.parseDouble(txt_layar.getText().toString());
                op = 4;
                txt_layar.setText("");
                statusBtn(false);
                break;
            case R.id.sd:
                angka2 = Double.parseDouble(txt_layar.getText().toString());
                NumberFormat n = NumberFormat.getInstance();
                n.setMaximumFractionDigits(2);
                statusBtn(true);
                switch(op){
                    case 1:
                        txt_layar.setText(n.format(angka1+angka2));
                        proses_layar.setText(Double.toString(angka1)+"+"+Double.toString(angka2));
                        break;
                    case 2:
                        txt_layar.setText(n.format(angka1-angka2));
                        proses_layar.setText(n.format(angka1)+"-"+n.format(angka2));
                        break;
                    case 3:
                        txt_layar.setText(n.format(angka1*angka2));
                        proses_layar.setText(n.format(angka1)+"x"+n.format(angka2));
                        break;
                    case 4:
                        txt_layar.setText(n.format(angka1/angka2));
                        proses_layar.setText(n.format(angka1)+"÷"+n.format(angka2));
                        break;
                }
                break;
            case R.id.c:
                clear();
                break;

        }
    }


    private void addAngka(String angka)
    {
        String txt = txt_layar.getText().toString();
        txt+=angka;

        txt_layar.setText(txt);

    }
    private void statusBtn(Boolean sts)
    {
        samadengan.setEnabled(true);
        kali.setEnabled(sts);
        bagi.setEnabled(sts);
        kurang.setEnabled(sts);
        tambah.setEnabled(sts);
    }

    private void clear()
    {
        statusBtn(true);
        proses_layar.setText("");
        txt_layar.setText("");
    }
}