package com.devhome.eduardobastos.bastosconsultoria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import mehdi.sakout.aboutpage.AboutPage;

public class SobreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_sobre);

        String descricao = "Sinta-se a vontade para entrar em contato comigo pelos diversos canais disponíveis abaixo:";
        View sobre = new AboutPage(this)
                .setImage(R.drawable.logoport)
                .setDescription(descricao)
                .addGroup("Redes Sociais e contato:")
                .addEmail("eduardobastos87@outlook.com", "Envie um email")
                .addWebsite("https://github.com/edudevhome", "Acesse o meu site")
                //.addGroup("Redes Sociais")
                .addFacebook("Edu Bastos", "Facebook")
                .addTwitter("@dudu_cnc", "Twitter")
                .addYoutube("lucassi.1012@gmail.com", "Youtube")
                .addInstagram("lucasdudan", "Instagram")
                .addGitHub("edudevhome", "GitHub")
                //.addPlayStore("google llc", "Play Store")
                .create();
        setContentView(sobre);
    }
}