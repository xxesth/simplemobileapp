package com.example.donbonte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.donbonte.R;

import java.util.ArrayList;
import java.util.Arrays;

public class log extends AppCompatActivity {
    Integer[] lestachesetquestions = {R.string.welcometext, R.string.tache1, R.string.question1,R.string.tache2, R.string.question2,R.string.tache3, R.string.question3,R.string.tache4, R.string.question4, R.string.tache5, R.string.question5,R.string.tache6, R.string.question6,R.string.tache7, R.string.question7,R.string.tache8, R.string.question8, R.string.tache9, R.string.question9,R.string.tache10, R.string.question10,R.string.tache11, R.string.question11,R.string.tache12, R.string.question12, R.string.tache13, R.string.question13,R.string.tache14, R.string.question14,R.string.tache15, R.string.question15,R.string.tache16, R.string.question16, R.string.finishtext};
    String[] lestachesfr = {"Bienvenue", "Appelez un(e) ami(e) qui vous n'avez pas appelé longtemps", "Qu'avez-vous ressenti?", "Retournez merci au personnel de la cafétéria", "Pourquoi on doit être gentil?",
            "Offrez votre ami(e) du thé/café", "Est-ce que les petites choses comme cela peuvent être précieuses ?", "Imaginez réaliser les choses dont vous rêviez, imaginez vivre vos rêves", "Est-ce aussi brillant et génial que vous en rêviez ? Est-ce que les choses perdent leur valeur quand nous les obtenons?",
            "Nourrissez un animal des rues", "Pourquoi aider quelqu’un nous rend heureux, quelle est l'importance des animaux ?", "Ecoutez votre musique préférée avec les yeux fermés", "Qu'avez-vous ressenti? Quel est le but de la musique?",
            "Retrouvez vos amis et passez du temps ensemble", "Est-ce que l'amitié est imporant, pourquoi?","Lisez 20 pages d'un livre","Pourquoi faire ce qu'il faut est souvent plus difficile ?","Pensez aux choses qui vous rendent heureux et essayez-en une","Qu'est-ce qui nous rend heureux ?",
            "Faites la chose ce que vous avez remis plus tard","Qu'en avez-vous pensé ? Est-ce que passer du temps avec soi-même est imporant ?","Passez temps dans une espace verte", "Est-ce que passer du temps dans la nature nous fait nous sentir en paix? Pourquoi c'est comme cela?",
            "Imaginez avoir une vie paisible dans le futur. Comment serait-il? Par exemple, comment serait votre routine quotidienne ?", "Qu'est-ce que la paix ? Résultat d'actions ou conséquence d'habitudes ? Ou alors ?","Dites à une personne sur qui vous comptez combien vous l'aimez","Quelle est la différence entre les personnes en qui nous avons confiance et celles en qui nous n'avons pas confiance",
            "Promenez-vous tout seul et pensez de quelque chose","Qu'avez-vous pensé? Est-ce important de passer du temps avec soi-même ?","Offrir quelque chose à quelqu'un","Pourquoi recevoir des cadeaux nous rend heureux ?","Rencontrez un nouveau person","On a dit que le monde est petit, que pensez-vous de cela?","Vous avez fini tous les tâches. Continuez votre chemin"};
    String[] lestacheseng = {"Welcome","Call a pal that you didn't speak for a long time","What did you feel?","Return thanks to the cafeteria staff","Why we should be kind?","Offer your friend a cup of tea/coffee","Can little things like that be precious?","Imagine achieving the things you dreamed of, imagine living your dreams","Is it as shiny and brilliant as you dreamed? Do the things lose their value when we get them?","Feed a stray animal","Are animals important? Why we feel good when we help someone?",
            "Listen your favorite music with closed eyes","What did you feel? What is the purpose of music?","Meet up with your friends and spend time together","Is friendship important, why?","Read 20 pages","Why doing the right thing is often harder ?","Think about the things that make you happy and try one","What makes us happy?","Do that thing you've been putting off for so long","What did you feel?",
            "Spend time in a green space","Was it restful? Why nature makes us calm and peaceful?","Imagine having a peaceful life in the future. What kind of life that would have been? For example, how would be your daily routine?","What is peace? A result of actions or a consequence of habitudes? Or else?","Say a person you rely on how much you love him","What is the difference between people we trust and we don't trust","Take a walk alone and think what you want","What did you think? Is it important to spend time with ourselves?","Gift something to someone","Why receiving gifts make us happy?",
            "Meet a new person","It is a small world, isn't it?"};
    String[] lestachestr = {"Hoş geldiniz","uzun zamandır aramadığın bir arkadaşını ara","ne hissettin? arkadaşlık önemli midir? niçin?","yemekhanedeki çalışana kolay gelsin de","niçin nazik olmalıyız?","arkadaşına ufak bir şeyler ısmarla","böyle küçük şeyler değerli midir?","hayalini kurduğun şeylere ulaştığını hayal et","bir şeye sahip olduğumuzda o şey değerini mi yitirir?","bir sokak hayvanını besle","hayvanların önemi nedir? birisine yardım etmek bizi neden mutlu eder?","en sevdiğin müziği aç ve gözlerini kapatıp dinle","ne hissettin? sence müziğin amacı nedir?","arkadaşlarınla buluş ve birlikte vakit geçirin","arkadaşlık önemli midir, neden?",
            "20 sayfa kitap oku","doğru olan şeyleri yapmak neden zordur?","seni mutlu eden şeyleri düşün ve birini yap","ne olduğunda mutlu oluruz?","uzun zamandır ertelediğin o şeyi yap","nasıl hissettin?","yeşil bir alanda vakit geçir","doğada vakit geçirmek bize neden genelde huzurlu gelir?","huzurlu bir geleceğe sahip olduğunu hayal et. nasıl bir yaşantın olurdu?","sence huzur nedir? Olaylar sonucunda mı oluşur yoksa bir yaşama biçiminin meyvesi midir? ya da başka ne olabilir?","güvendiğin bir insana onu ne kadar sevdiğini söyle","güvendiğimiz insanlarla güvenmediğimiz insanlar arasındaki fark nedir?",
            "tek başına bir yürüyüşe çık ve düşün","neler düşündün? kendimizle vakit geçirmek önemli midir?","birisine ufak bir hediye al","hediyeleşmek neden mutluluk vericidir?","yeni birisiyle tanış","dünya büyük bir yer midir küçük bir yer midir?", "Bütün görevleri tamamladın. Düşünmeye devam et"};
    //Integer[] lestaches2 = {};
    String[] lestaches2 = {};
    int numero;
    SharedPreferences menulang;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_log);
        Intent intent2 = getIntent();
        numero =intent2.getIntExtra("monnumero",0);
        //ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(lestaches2));
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(lestaches2));
        /*for (int m = 0; m<=numero;) {
            arrayList.add(lestachesetquestions[m]);
            lestaches2 = arrayList.toArray(lestaches2);
            //System.out.println(m);
            //System.out.println(Arrays.toString(lestaches2));
            m++;
        }*/
        menulang = this.getSharedPreferences("langua", Context.MODE_PRIVATE);
        String menulang2 = menulang.getString("langua", null);
        if (menulang2==null){
            menulang2="English";}
        if (menulang2.matches("Français")){
            for (int m = 0; m<=numero;) {
                arrayList.add(lestachesfr[m]);
                lestaches2 = arrayList.toArray(lestaches2);
                m++;
            }
            listView = findViewById(R.id.listViewtaches);
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.murecyclerviewlayout, R.id.thetacherecycler, lestaches2);
            listView.setAdapter(arrayAdapter);
        }else if (menulang2.matches("English")){
            for (int m = 0; m<=numero;) {
                arrayList.add(lestacheseng[m]);
                lestaches2 = arrayList.toArray(lestaches2);
                m++;
            }
            listView = findViewById(R.id.listViewtaches);
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.murecyclerviewlayout, R.id.thetacherecycler, lestaches2);
            listView.setAdapter(arrayAdapter);
        }
        else if (menulang2.matches("Türkçe")){
            for (int m = 0; m<=numero;) {
                arrayList.add(lestachestr[m]);
                lestaches2 = arrayList.toArray(lestaches2);
                m++;
            }
            listView = findViewById(R.id.listViewtaches);
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.murecyclerviewlayout, R.id.thetacherecycler, lestaches2);
            listView.setAdapter(arrayAdapter);
        }else{
            for (int m = 0; m<=numero;) {
                arrayList.add(lestacheseng[m]);
                lestaches2 = arrayList.toArray(lestaches2);
                m++;
            }
            listView = findViewById(R.id.listViewtaches);
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.murecyclerviewlayout, R.id.thetacherecycler, lestaches2);
            listView.setAdapter(arrayAdapter);
        }
        //listView = findViewById(R.id.listViewtaches);
        //ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this, R.layout.murecyclerviewlayout, R.id.thetacherecycler, lestaches2);
        //listView.setAdapter(arrayAdapter);
    }
        public void goactivity(View view){
            Intent goactivity = new Intent(log.this, MainActivity.class);
            startActivity(goactivity);
        }
}