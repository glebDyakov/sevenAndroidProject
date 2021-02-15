package gleb.first_app.mysevenandroidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int count=0;
    private Button btn_next, btn_true, btn_false;
    private TextView txt;
    private int quest_index=0;
    private TrueFalse[] questions= new TrueFalse[]{
            new TrueFalse(R.string.quest_1,true);
            new TrueFalse(R.string.quest_2,false);
            new TrueFalse(R.string.quest_3,true);
            new TrueFalse(R.string.quest_4,true);
            new TrueFalse(R.string.quest_5,true);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_false=(Button) findViewById(R.id.btn_false);
        btn_true=(Button) findViewById(R.id.btn_true);
        btn_next=(Button) findViewById(R.id.btn_next);
        btn_restart=(Button) findViewById(R.id.btn_restart);
        txt=(TextView) findViewById(R.id.result_txt);
        final int question=questions[quest_index].getQuestion();
        txt.setText(question);
        btn_true.setOnclickListener(new View.onClickListener(){
            @Override
            public void onClick(View view){
                checkAnswer(true);
            }
        });
        btn_restart.setOnclickListener(new View.onClickListener(){
            @Override
            public void onClick(View view){
                quest_index=0;
                final int question = question[quest_index].getQuestion();
                txt.setText(question);
                txt.setTextColor(Color.BLACK);
                btn_true.setVisibility(View.VISIBLE);
                btn_false.setVisibility(View.VISIBLE);
                btn_next.setVisibility(View.INVISIBLE);
            }
        });
        btn_false.setOnclickListener(new View.onClickListener(){
            @Override
            public void onClick(View view){
                if(quest_index < questions.length - 1){
                    quest_index++;
                    final int question=questions[quest_index].getQuestion();
                    txt.setText(question);
                    btn_true.setVisibility(View.VISIBLE);
                    btn_false.setVisibility(View.VISIBLE);
                    btn_next.setVisibility(View.INVISIBLE);
                }else{
                    txt.setText("вы всё прошли. результат ");
                    txt.setTextColor(Color.GREEN);
                    btn_next.setVisibility(View.INVISIBLE);
                    btn_restart.setVisibility(View.INVISIBLE);
                }

            }
        });
    }
    private void checkAnswer(boolean answer_user){
        boolean answer=questions[quest_index];
        if(answer_user == answer)
            Toast.makeText(MainActivity.this,"вы молодец всё верно", Toast.LENGTH_LONG).show();
            count++;
        else
            Toast.makeText(MainActivity.this,"вы молодец не верно", Toast.LENGTH_LONG).show();
        btn_true.setVisibility(View.INVISIBLE);
        btn_false.setVisibility(View.INVISIBLE);
        btn_next.setVisibility(View.VISIBLE);
    }
}