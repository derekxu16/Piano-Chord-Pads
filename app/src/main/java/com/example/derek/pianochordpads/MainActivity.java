package com.example.derek.pianochordpads;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

//Derek Xu 2016

public class MainActivity extends AppCompatActivity {
    SoundPool padsounds;
    int padtoAssign;
    int[] notesasInt = new int[22];
    String[] padnotes = new String[6];
    String[] padtype = new String[6];
    boolean edit = false;
    int sentFromPad;
    Button pad1, pad2, pad3, pad4, pad5, pad6;
    int note1, note2, note3, note4;
    int p1n1, p1n2, p1n3, p1n4, p2n1, p2n2, p2n3, p2n4, p3n1, p3n2, p3n3, p3n4, p4n1, p4n2, p4n3, p4n4, p5n1, p5n2, p5n3, p5n4, p6n1, p6n2, p6n3, p6n4;
    int[] playsounds = new int[24];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pad1 = (Button) findViewById(R.id.pad1);
        pad2 = (Button) findViewById(R.id.pad2);
        pad3 = (Button) findViewById(R.id.pad3);
        pad4 = (Button) findViewById(R.id.pad4);
        pad5 = (Button) findViewById(R.id.pad5);
        pad6 = (Button) findViewById(R.id.pad6);

        createArrays();

        AudioAttributes attributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build();

        padsounds = new SoundPool.Builder()
                .setMaxStreams(24)
                .setAudioAttributes(attributes)
                .build();

        listenButtons();

        Switch editswitch = (Switch) findViewById(R.id.switch1);
        editswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "You are now in edit mode. Tap on any of the pads to change what chord they play.", Toast.LENGTH_SHORT).show();
                    edit = true;
                } else {
                    edit = false;
                }
            }
        });
    }

//This will check if a button is pressed and determine the correct action
    public void listenButtons() {
        pad1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (edit == true) {
                    sentFromPad = 1;
                    startActivityForResult(new Intent(getApplicationContext(), Pop.class), 122);
                } else {
                    playsounds[0] = padsounds.play(p1n1, 1, 1, 1, 0, 1);
                    playsounds[1] = padsounds.play(p1n2, 1, 1, 1, 0, 1);
                    playsounds[2] = padsounds.play(p1n3, 1, 1, 1, 0, 1);
                    playsounds[3] = padsounds.play(p1n4, 1, 1, 1, 0, 1);
                }
            }
        });
        pad2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (edit == true) {
                    sentFromPad = 2;
                    startActivityForResult(new Intent(getApplicationContext(), Pop.class), 122);
                } else {
                    playsounds[4] = padsounds.play(p2n1, 1, 1, 1, 0, 1);
                    playsounds[5] = padsounds.play(p2n2, 1, 1, 1, 0, 1);
                    playsounds[6] = padsounds.play(p2n3, 1, 1, 1, 0, 1);
                    playsounds[7] = padsounds.play(p2n4, 1, 1, 1, 0, 1);
                }
            }
        });
        pad3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (edit == true) {
                    sentFromPad = 3;
                    startActivityForResult(new Intent(getApplicationContext(), Pop.class), 122);
                } else {
                    padsounds.play(p3n1, 1, 1, 1, 0, 1);
                    padsounds.play(p3n2, 1, 1, 1, 0, 1);
                    padsounds.play(p3n3, 1, 1, 1, 0, 1);
                    padsounds.play(p3n4, 1, 1, 1, 0, 1);
                }
            }
        });
        pad4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (edit == true) {
                    sentFromPad = 4;
                    startActivityForResult(new Intent(getApplicationContext(), Pop.class), 122);
                } else {
                    padsounds.play(p4n1, 1, 1, 1, 0, 1);
                    padsounds.play(p4n2, 1, 1, 1, 0, 1);
                    padsounds.play(p4n3, 1, 1, 1, 0, 1);
                    padsounds.play(p4n4, 1, 1, 1, 0, 1);
                }
            }
        });
        pad5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (edit == true) {
                    sentFromPad = 5;
                    startActivityForResult(new Intent(getApplicationContext(), Pop.class), 122);
                } else {
                    padsounds.play(p5n1, 1, 1, 1, 0, 1);
                    padsounds.play(p5n2, 1, 1, 1, 0, 1);
                    padsounds.play(p5n3, 1, 1, 1, 0, 1);
                    padsounds.play(p5n4, 1, 1, 1, 0, 1);
                }
            }
        });
        pad6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (edit == true) {
                    sentFromPad = 6;
                    startActivityForResult(new Intent(getApplicationContext(), Pop.class), 122);
                } else {
                    padsounds.play(p6n1, 1, 1, 1, 0, 1);
                    padsounds.play(p6n2, 1, 1, 1, 0, 1);
                    padsounds.play(p6n3, 1, 1, 1, 0, 1);
                    padsounds.play(p6n4, 1, 1, 1, 0, 1);
                }
            }
        });
    }

    //When the user is done with the popup window, the data is sent back
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 122 && resultCode == RESULT_OK) {
            padnotes[sentFromPad-1] = data.getStringExtra("getnote");
            padtype[sentFromPad-1] = data.getStringExtra("gettype");
            setChordstoPad(sentFromPad);
        }
    }

    public void createArrays() {
        notesasInt[0] = R.raw.g3;
        notesasInt[1] = R.raw.ab3;
        notesasInt[2] = R.raw.a3;
        notesasInt[3] = R.raw.bb3;
        notesasInt[4] = R.raw.b3;
        notesasInt[5] = R.raw.c4;
        notesasInt[6] = R.raw.db4;
        notesasInt[7] = R.raw.d4;
        notesasInt[8] = R.raw.eb4;
        notesasInt[9] = R.raw.e4;
        notesasInt[10] = R.raw.f4;
        notesasInt[11] = R.raw.gb4;
        notesasInt[12] = R.raw.g4;
        notesasInt[13] = R.raw.ab4;
        notesasInt[14] = R.raw.a4;
        notesasInt[15] = R.raw.bb4;
        notesasInt[16] = R.raw.b4;
        notesasInt[17] = R.raw.c5;
        notesasInt[18] = R.raw.db5;
        notesasInt[19] = R.raw.d4;
        notesasInt[20] = R.raw.eb5;
        notesasInt[21] = R.raw.e5;
    }

    // Assigns the soundpools to play certain chords
    public void setChordstoPad (int pad) {
        switch (pad) {
            case 1:
                pad1.setText(padnotes[0] + getchordtext(padtype[0]));
                Chordnotes(intfromNotes(padnotes[0]),padtype[0]);
                p1n1 = padsounds.load(this, note1, 1);
                p1n2 = padsounds.load(this, note2, 1);
                p1n3 = padsounds.load(this, note3, 1);
                if (note4 != 0) {
                    p1n4 = padsounds.load(this, note4, 1);
                }
                break;
            case 2:
                pad2.setText(padnotes[1] + getchordtext(padtype[1]));
                Chordnotes(intfromNotes(padnotes[1]),padtype[1]);
                p2n1 = padsounds.load(this, note1, 1);
                p2n2 = padsounds.load(this, note2, 1);
                p2n3 = padsounds.load(this, note3, 1);
                if (note4 != 0) {
                    p2n4 = padsounds.load(this, note4, 1);
                }
                break;
            case 3:
                pad3.setText(padnotes[2] + getchordtext(padtype[2]));
                Chordnotes(intfromNotes(padnotes[2]),padtype[2]);
                p3n1 = padsounds.load(this, note1, 1);
                p3n2 = padsounds.load(this, note2, 1);
                p3n3 = padsounds.load(this, note3, 1);
                if (note4 != 0) {
                    p3n4 = padsounds.load(this, note4, 1);
                }
                break;
            case 4:
                pad4.setText(padnotes[3] + getchordtext(padtype[3]));
                Chordnotes(intfromNotes(padnotes[3]),padtype[3]);
                p4n1 = padsounds.load(this, note1, 1);
                p4n2 = padsounds.load(this, note2, 1);
                p4n3 = padsounds.load(this, note3, 1);
                if (note4 != 0) {
                    p4n4 = padsounds.load(this, note4, 1);
                }
                break;
            case 5:
                pad5.setText(padnotes[4] + getchordtext(padtype[4]));
                Chordnotes(intfromNotes(padnotes[4]),padtype[4]);
                p5n1 = padsounds.load(this, note1, 1);
                p5n2 = padsounds.load(this, note2, 1);
                p5n3 = padsounds.load(this, note3, 1);
                if (note4 != 0) {
                    p5n4 = padsounds.load(this, note4, 1);
                }
                break;
            case 6:
                pad6.setText(padnotes[5] + getchordtext(padtype[5]));
                Chordnotes(intfromNotes(padnotes[5]),padtype[5]);
                p6n1 = padsounds.load(this, note1, 1);
                p6n2 = padsounds.load(this, note2, 1);
                p6n3 = padsounds.load(this, note3, 1);
                if (note4 != 0) {
                    p6n4 = padsounds.load(this, note4, 1);
                }
                break;
        }
        note1 = 0;
        note2 = 0;
        note3 = 0;
        note4 = 0;
    }

    public void Chordnotes(int tonic, String type) {
        switch (type) {
            case "maj":
                note1 = notesasInt[tonic];
                note2 = notesasInt[tonic + 4];
                note3 = notesasInt[tonic + 7];
                break;
            case "min":
                note1 = notesasInt[tonic];
                note2 = notesasInt[tonic + 3];
                note3 = notesasInt[tonic + 7];
                break;
            case "V7":
                if (tonic >=5) {
                    note1 = notesasInt[tonic-5];
                    note2 = notesasInt[tonic-1];
                    note3 = notesasInt[tonic+2];
                    note4 = notesasInt[tonic+5];
                } else if (tonic<5){
                    note1 = notesasInt[tonic+7];
                    note2 = notesasInt[tonic +11];
                    note3 = notesasInt[tonic + 14];
                    note4 = notesasInt[tonic + 17];
                }
                break;
        }
    }

    public int intfromNotes(String note){
        switch(note) {
            case "A":
                return 2;
            case "A#":
                return 3;
            case "B":
                return 4;
            case "C":
                return 5;
            case "C#":
                return 6;
            case "D":
                return 7;
            case "D#":
                return 8;
            case "E":
                return 9;
            case "F":
                return 10;
            case "F#":
                return 11;
            case "G":
                return 12;
            case "G#":
                return 13;
            default:
                return 0;
        }
    }

    public String getchordtext(String type) {
        switch (type){
            case "maj":
                return "M";
            case "min":
                return "min";
            case "V7":
                return "V7";
            default: return "N/A";
        }
    }

}

