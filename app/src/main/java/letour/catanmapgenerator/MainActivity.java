package letour.catanmapgenerator;


import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import java.util.Random;
import java.lang.StringBuilder;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// http://stackoverflow.com/questions/8801047/how-to-fill-color-in-image-in-particular-area
// http://stackoverflow.com/questions/34788307/fill-a-image-view-or-bitmap-with-color-in-android-dynamically-and-sequentially
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int min = 1;
        int max = 5;

        int numOre = 0;
        int numBrick = 0;
        int numLumber = 0;
        int numWheat = 0;
        int numSheep = 0;
        int numDesert = 0;

        int maxOre = 3;
        int maxBrick = 3;
        int maxLumber = 4;
        int maxWheat = 4;
        int maxSheep = 4;
        int maxDesert = 1;

        //int[] randomResources = new int[19];
        /*Random randomGenerator = new Random();

        int[] orePositions = new int[3]; // Array of ore positions
        int[] brickPositions = new int[3];
        int[] lumberPositions = new int[4];
        int[] wheatPositions = new int[4];
        int[] sheepPositions = new int[4];*/

        //int[] randomResources = {6,1,1,1,1,2,2,2,3,3,3,4,4,4,4,5,5,5,5};

        List<Integer> randomResources = new ArrayList<Integer>();
        randomResources.add(3);
        randomResources.add(1);
        randomResources.add(1);
        randomResources.add(1);
        randomResources.add(1);
        randomResources.add(2);
        randomResources.add(2);
        randomResources.add(2);
        randomResources.add(0);
        randomResources.add(3);
        randomResources.add(3);
        randomResources.add(4);
        randomResources.add(4);
        randomResources.add(4);
        randomResources.add(4);
        randomResources.add(5);
        randomResources.add(5);
        randomResources.add(5);
        randomResources.add(5);

        Collections.shuffle(randomResources);

        //shuffleArray(randomResources);
        /*for (int i = 0; i < randomResources.length; i++) {
            System.out.println(randomResources[i]);
        }*/
        /*for(int i = 0; i < 3; i++)
        {
            int ran = randomGenerator.nextInt(max - min) + min;
            while(randomResources[ran-1]!=0)
            {
                ran = randomGenerator.nextInt(max - min) + min;
            }
            else {
                orePositions[i] = ran;
                randomResources[ran - 1] = 1;
            }
        }
        StringBuilder sb = new StringBuilder(10);
        sb.append("hex");
        sb.append(randomResources[orePositions[0]]);
        String id1 = sb.toString();
        int resID = getResources().getIdentifier(id1, "id", getPackageName());
        HexagonMaskView hex1 = ((HexagonMaskView) findViewById(resID));
        hex1.setImageResource(R.drawable.ore);*/



        /*for(int i = 0; i < randomResources.length; i++)
        {
            randomResources[i] = randomGenerator.nextInt(max - min) + min;
            if(randomResources[i] == 1)
            {
                // Find different resource if there's already 3 ore
                if(numOre == maxOre) {
                    while (randomResources[i] == 1)
                        randomResources[i] = randomGenerator.nextInt(max - min) + min;
                }
                else
                    numOre++;

            }
            else if(randomResources[i]==2)
            {
                // Find different resource if there's already 3 brick
                if(numBrick == maxBrick) {
                    while (randomResources[i] == 2)
                        randomResources[i] = randomGenerator.nextInt(max - min) + min;
                }
                else
                    numBrick++;
            }
            else if(randomResources[i]==3)
            {
                // Find different resource if there's already 3 ore
                if(numLumber == maxLumber) {
                    while (randomResources[i] == 3)
                        randomResources[i] = randomGenerator.nextInt(max - min) + min;
                }
                else
                    numLumber++;
            }
            else if(randomResources[i]==4)
            {
                // Find different resource if there's already 3 ore
                if(numWheat == maxWheat) {
                    while (randomResources[i] == 4)
                        randomResources[i] = randomGenerator.nextInt(max - min) + min;
                }
                else
                    numWheat++;
            }
            else if(randomResources[i]==5)
            {
                // Find different resource if there's already 3 ore
                if(numSheep == maxSheep) {
                    while (randomResources[i] == 5)
                        randomResources[i] = randomGenerator.nextInt(max - min) + min;
                }
                else
                    numSheep++;
            }
        }


        int index = randomGenerator.nextInt(max - min) + min;*/
        //int index2 = randomGenerator.nextInt(max - min) + min;
        //int dice = index + index2;

        /*Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;*/

        HexagonMaskView hex1 = (HexagonMaskView) findViewById(R.id.hex1);
        //hex1.getLayoutParams().height = 500;
        //hex1.requestLayout();
        //hex1.setImageResource(R.drawable.lumber);

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int height = displaymetrics.heightPixels;
        int width = displaymetrics.widthPixels;

        int hexlen = width / 6;
        int halfhexlen = hexlen / 2;

        hex1.setWid(hexlen);
        hex1.setLen(hexlen);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        params.setMarginStart(hexlen + halfhexlen);
        hex1.setLayoutParams(params);

        if(randomResources.get(0) == 1)
            hex1.setImageResource(R.drawable.lumber);
        else if(randomResources.get(0) == 2)
            hex1.setImageResource(R.drawable.brick);
        else if(randomResources.get(0) == 3)
            hex1.setImageResource(R.drawable.ore);
        else if(randomResources.get(0) == 4)
            hex1.setImageResource(R.drawable.wheat);
        else if(randomResources.get(0) == 5)
            hex1.setImageResource(R.drawable.sheep);
        else if(randomResources.get(0) == 0)
            hex1.setImageResource(R.drawable.desert);



        HexagonMaskView hex2 = (HexagonMaskView) findViewById(R.id.hex2);

        RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        hex2.setWid(hexlen);
        hex2.setLen(hexlen);
        params2.setMarginStart(hexlen + hexlen + halfhexlen - 50);
        hex2.setLayoutParams(params2);


        if(randomResources.get(1) == 1)
            hex2.setImageResource(R.drawable.lumber);
        else if(randomResources.get(1) == 2)
            hex2.setImageResource(R.drawable.brick);
        else if(randomResources.get(1) == 3)
            hex2.setImageResource(R.drawable.ore);
        else if(randomResources.get(1) == 4)
            hex2.setImageResource(R.drawable.wheat);
        else if(randomResources.get(1) == 5)
            hex2.setImageResource(R.drawable.sheep);
        else
            hex2.setImageResource(R.drawable.desert);

        ////
        HexagonMaskView hex3 = (HexagonMaskView) findViewById(R.id.hex3);

        RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        hex3.setWid(hexlen);
        hex3.setLen(hexlen);
        params3.setMarginStart(3 * hexlen + halfhexlen - 100);
        hex3.setLayoutParams(params3);

        if(randomResources.get(2) == 1)
            hex3.setImageResource(R.drawable.lumber);
        else if(randomResources.get(2) == 2)
            hex3.setImageResource(R.drawable.brick);
        else if(randomResources.get(2) == 3)
            hex3.setImageResource(R.drawable.ore);
        else if(randomResources.get(2) == 4)
            hex3.setImageResource(R.drawable.wheat);
        else if(randomResources.get(2) == 5)
            hex3.setImageResource(R.drawable.sheep);
        else
            hex3.setImageResource(R.drawable.desert);
        ////
        HexagonMaskView hex4 = (HexagonMaskView) findViewById(R.id.hex4);

        RelativeLayout.LayoutParams params4 = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        hex4.setWid(hexlen);
        hex4.setLen(hexlen);
        //params4.setMarginStart(hexlen);
        params4.setMargins(hexlen + 25, halfhexlen + (halfhexlen / 2) - 15, 0, 0);
        hex4.setLayoutParams(params4);


        if(randomResources.get(3) == 1)
            hex4.setImageResource(R.drawable.lumber);
        else if(randomResources.get(3) == 2)
            hex4.setImageResource(R.drawable.brick);
        else if(randomResources.get(3) == 3)
            hex4.setImageResource(R.drawable.ore);
        else if(randomResources.get(3) == 4)
            hex4.setImageResource(R.drawable.wheat);
        else if(randomResources.get(3) == 5)
            hex4.setImageResource(R.drawable.sheep);
        else
            hex4.setImageResource(R.drawable.desert);
        ////
        HexagonMaskView hex5 = (HexagonMaskView) findViewById(R.id.hex5);

        RelativeLayout.LayoutParams params5 = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        hex5.setWid(hexlen);
        hex5.setLen(hexlen);
        //params4.setMarginStart(hexlen);
        params5.setMargins(hexlen + 25 + hexlen - 50, halfhexlen + (halfhexlen / 2) - 15, 0, 0);
        hex5.setLayoutParams(params5);

        if(randomResources.get(4) == 1)
            hex5.setImageResource(R.drawable.lumber);
        else if(randomResources.get(4) == 2)
            hex5.setImageResource(R.drawable.brick);
        else if(randomResources.get(4) == 3)
            hex5.setImageResource(R.drawable.ore);
        else if(randomResources.get(4) == 4)
            hex5.setImageResource(R.drawable.wheat);
        else if(randomResources.get(4) == 5)
            hex5.setImageResource(R.drawable.sheep);
        else
            hex5.setImageResource(R.drawable.desert);

        ////
        HexagonMaskView hex6 = (HexagonMaskView) findViewById(R.id.hex6);

        RelativeLayout.LayoutParams params6 = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        hex6.setWid(hexlen);
        hex6.setLen(hexlen);
        //params4.setMarginStart(hexlen);
        params6.setMargins(hexlen + 25 + 2 * (hexlen - 50), halfhexlen + (halfhexlen / 2) - 15, 0, 0);
        hex6.setLayoutParams(params6);

        if(randomResources.get(5) == 1)
            hex6.setImageResource(R.drawable.lumber);
        else if(randomResources.get(5) == 2)
            hex6.setImageResource(R.drawable.brick);
        else if(randomResources.get(5) == 3)
            hex6.setImageResource(R.drawable.ore);
        else if(randomResources.get(5) == 4)
            hex6.setImageResource(R.drawable.wheat);
        else if(randomResources.get(5) == 5)
            hex6.setImageResource(R.drawable.sheep);
        else
            hex6.setImageResource(R.drawable.desert);

        ////
        HexagonMaskView hex7 = (HexagonMaskView) findViewById(R.id.hex7);

        RelativeLayout.LayoutParams params7 = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        hex7.setWid(hexlen);
        hex7.setLen(hexlen);
        params7.setMargins(hexlen + 25 + 3 * (hexlen - 50), halfhexlen + (halfhexlen / 2) - 15, 0, 0);
        hex7.setLayoutParams(params7);

        if(randomResources.get(6) == 1)
            hex7.setImageResource(R.drawable.lumber);
        else if(randomResources.get(6) == 2)
            hex7.setImageResource(R.drawable.brick);
        else if(randomResources.get(6) == 3)
            hex7.setImageResource(R.drawable.ore);
        else if(randomResources.get(6) == 4)
            hex7.setImageResource(R.drawable.wheat);
        else if(randomResources.get(6) == 5)
            hex7.setImageResource(R.drawable.sheep);
        else
            hex7.setImageResource(R.drawable.desert);

        ////
        HexagonMaskView hex8 = (HexagonMaskView) findViewById(R.id.hex8);

        RelativeLayout.LayoutParams params8 = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        hex8.setWid(hexlen);
        hex8.setLen(hexlen);
        params8.setMargins(halfhexlen + 50, hexlen + halfhexlen - 30, 0, 0);
        hex8.setLayoutParams(params8);

        if(randomResources.get(7) == 1)
            hex8.setImageResource(R.drawable.lumber);
        else if(randomResources.get(7) == 2)
            hex8.setImageResource(R.drawable.brick);
        else if(randomResources.get(7) == 3)
            hex8.setImageResource(R.drawable.ore);
        else if(randomResources.get(7) == 4)
            hex8.setImageResource(R.drawable.wheat);
        else if(randomResources.get(7) == 5)
            hex8.setImageResource(R.drawable.sheep);
        else
            hex8.setImageResource(R.drawable.desert);

        ////
        HexagonMaskView hex9 = (HexagonMaskView) findViewById(R.id.hex9);

        RelativeLayout.LayoutParams params9 = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        hex9.setWid(hexlen);
        hex9.setLen(hexlen);
        params9.setMargins(hexlen + halfhexlen, hexlen + halfhexlen - 30, 0, 0);
        hex9.setLayoutParams(params9);

        if(randomResources.get(8) == 1)
            hex9.setImageResource(R.drawable.lumber);
        else if(randomResources.get(8) == 2)
            hex9.setImageResource(R.drawable.brick);
        else if(randomResources.get(8) == 3)
            hex9.setImageResource(R.drawable.ore);
        else if(randomResources.get(8) == 4)
            hex9.setImageResource(R.drawable.wheat);
        else if(randomResources.get(8) == 5)
            hex9.setImageResource(R.drawable.sheep);
        else
            hex9.setImageResource(R.drawable.desert);

        ////
        HexagonMaskView hex10 = (HexagonMaskView) findViewById(R.id.hex10);

        RelativeLayout.LayoutParams params10 = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        hex10.setWid(hexlen);
        hex10.setLen(hexlen);
        params10.setMargins(hexlen + hexlen + halfhexlen - 50, hexlen + halfhexlen - 30, 0, 0);
        hex10.setLayoutParams(params10);

        if(randomResources.get(9) == 1)
            hex10.setImageResource(R.drawable.lumber);
        else if(randomResources.get(9) == 2)
            hex10.setImageResource(R.drawable.brick);
        else if(randomResources.get(9) == 3)
            hex10.setImageResource(R.drawable.ore);
        else if(randomResources.get(9) == 4)
            hex10.setImageResource(R.drawable.wheat);
        else if(randomResources.get(9) == 5)
            hex10.setImageResource(R.drawable.sheep);
        else
            hex10.setImageResource(R.drawable.desert);

        ////
        HexagonMaskView hex11 = (HexagonMaskView) findViewById(R.id.hex11);

        RelativeLayout.LayoutParams params11 = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        hex11.setWid(hexlen);
        hex11.setLen(hexlen);
        params11.setMargins(3 * hexlen + halfhexlen - 100, hexlen + halfhexlen - 30, 0, 0);
        hex11.setLayoutParams(params11);


        if(randomResources.get(10) == 1)
            hex11.setImageResource(R.drawable.lumber);
        else if(randomResources.get(10) == 2)
            hex11.setImageResource(R.drawable.brick);
        else if(randomResources.get(10) == 3)
            hex11.setImageResource(R.drawable.ore);
        else if(randomResources.get(10) == 4)
            hex11.setImageResource(R.drawable.wheat);
        else if(randomResources.get(10) == 5)
            hex11.setImageResource(R.drawable.sheep);
        else
            hex11.setImageResource(R.drawable.desert);

        ////
        HexagonMaskView hex12 = (HexagonMaskView) findViewById(R.id.hex12);

        RelativeLayout.LayoutParams params12 = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        hex12.setWid(hexlen);
        hex12.setLen(hexlen);
        params12.setMargins(4 * hexlen + halfhexlen - 150, hexlen + halfhexlen - 30, 0, 0);
        hex12.setLayoutParams(params12);

        if(randomResources.get(11) == 1)
            hex12.setImageResource(R.drawable.lumber);
        else if(randomResources.get(11) == 2)
            hex12.setImageResource(R.drawable.brick);
        else if(randomResources.get(11) == 3)
            hex12.setImageResource(R.drawable.ore);
        else if(randomResources.get(11) == 4)
            hex12.setImageResource(R.drawable.wheat);
        else if(randomResources.get(11) == 5)
            hex12.setImageResource(R.drawable.sheep);
        else
            hex12.setImageResource(R.drawable.desert);

        ////
        HexagonMaskView hex13 = (HexagonMaskView) findViewById(R.id.hex13);

        RelativeLayout.LayoutParams params13 = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        hex13.setWid(hexlen);
        hex13.setLen(hexlen);
        params13.setMargins(hexlen + 25, 3 * (halfhexlen + (halfhexlen / 2) - 15), 0, 0);
        hex13.setLayoutParams(params13);

        if(randomResources.get(12) == 1)
            hex13.setImageResource(R.drawable.lumber);
        else if(randomResources.get(12) == 2)
            hex13.setImageResource(R.drawable.brick);
        else if(randomResources.get(12) == 3)
            hex13.setImageResource(R.drawable.ore);
        else if(randomResources.get(12) == 4)
            hex13.setImageResource(R.drawable.wheat);
        else if(randomResources.get(12) == 5)
            hex13.setImageResource(R.drawable.sheep);
        else
            hex13.setImageResource(R.drawable.desert);

        ////
        HexagonMaskView hex14 = (HexagonMaskView) findViewById(R.id.hex14);

        RelativeLayout.LayoutParams params14 = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        hex14.setWid(hexlen);
        hex14.setLen(hexlen);
        params14.setMargins( 2 * hexlen - 25, 3 * (halfhexlen + (halfhexlen / 2) - 15), 0, 0);
        hex14.setLayoutParams(params14);

        if(randomResources.get(13) == 1)
            hex14.setImageResource(R.drawable.lumber);
        else if(randomResources.get(13) == 2)
            hex14.setImageResource(R.drawable.brick);
        else if(randomResources.get(13) == 3)
            hex14.setImageResource(R.drawable.ore);
        else if(randomResources.get(13) == 4)
            hex14.setImageResource(R.drawable.wheat);
        else if(randomResources.get(13) == 5)
            hex14.setImageResource(R.drawable.sheep);
        else
            hex14.setImageResource(R.drawable.desert);

        ////
        HexagonMaskView hex15 = (HexagonMaskView) findViewById(R.id.hex15);

        RelativeLayout.LayoutParams params15 = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        hex15.setWid(hexlen);
        hex15.setLen(hexlen);
        params15.setMargins( 3 * hexlen - 75, 3 * (halfhexlen + (halfhexlen / 2) - 15), 0, 0);
        hex15.setLayoutParams(params15);

        if(randomResources.get(14) == 1)
            hex15.setImageResource(R.drawable.lumber);
        else if(randomResources.get(14) == 2)
            hex15.setImageResource(R.drawable.brick);
        else if(randomResources.get(14) == 3)
            hex15.setImageResource(R.drawable.ore);
        else if(randomResources.get(14) == 4)
            hex15.setImageResource(R.drawable.wheat);
        else if(randomResources.get(14) == 5)
            hex15.setImageResource(R.drawable.sheep);
        else
            hex15.setImageResource(R.drawable.desert);

        ////
        HexagonMaskView hex16 = (HexagonMaskView) findViewById(R.id.hex16);

        RelativeLayout.LayoutParams params16 = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        hex16.setWid(hexlen);
        hex16.setLen(hexlen);
        params16.setMargins( 4 * hexlen - 125, 3 * (halfhexlen + (halfhexlen / 2) - 15), 0, 0);
        hex16.setLayoutParams(params16);

        if(randomResources.get(15) == 1)
            hex16.setImageResource(R.drawable.lumber);
        else if(randomResources.get(15) == 2)
            hex16.setImageResource(R.drawable.brick);
        else if(randomResources.get(15) == 3)
            hex16.setImageResource(R.drawable.ore);
        else if(randomResources.get(15) == 4)
            hex16.setImageResource(R.drawable.wheat);
        else if(randomResources.get(15) == 5)
            hex16.setImageResource(R.drawable.sheep);
        else
            hex16.setImageResource(R.drawable.desert);

        ////
        HexagonMaskView hex17 = (HexagonMaskView) findViewById(R.id.hex17);

        RelativeLayout.LayoutParams params17 = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        hex17.setWid(hexlen);
        hex17.setLen(hexlen);
        params17.setMargins(hexlen + halfhexlen, 4 * (halfhexlen + (halfhexlen / 2) - 15), 0, 0);
        hex17.setLayoutParams(params17);


        if(randomResources.get(16) == 1)
            hex17.setImageResource(R.drawable.lumber);
        else if(randomResources.get(16) == 2)
            hex17.setImageResource(R.drawable.brick);
        else if(randomResources.get(16) == 3)
            hex17.setImageResource(R.drawable.ore);
        else if(randomResources.get(16) == 4)
            hex17.setImageResource(R.drawable.wheat);
        else if(randomResources.get(16) == 5)
            hex17.setImageResource(R.drawable.sheep);
        else
            hex17.setImageResource(R.drawable.desert);

        ////
        HexagonMaskView hex18 = (HexagonMaskView) findViewById(R.id.hex18);

        RelativeLayout.LayoutParams params18 = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        hex18.setWid(hexlen);
        hex18.setLen(hexlen);
        params18.setMargins(hexlen + hexlen + halfhexlen - 50, 4 * (halfhexlen + (halfhexlen / 2) - 15), 0, 0);
        hex18.setLayoutParams(params18);

        if(randomResources.get(17) == 1)
            hex18.setImageResource(R.drawable.lumber);
        else if(randomResources.get(17) == 2)
            hex18.setImageResource(R.drawable.brick);
        else if(randomResources.get(17) == 3)
            hex18.setImageResource(R.drawable.ore);
        else if(randomResources.get(17) == 4)
            hex18.setImageResource(R.drawable.wheat);
        else if(randomResources.get(17) == 5)
            hex18.setImageResource(R.drawable.sheep);
        else
            hex18.setImageResource(R.drawable.desert);

        ////
        HexagonMaskView hex19 = (HexagonMaskView) findViewById(R.id.hex19);

        RelativeLayout.LayoutParams params19 = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        hex19.setWid(hexlen);
        hex19.setLen(hexlen);
        params19.setMargins(3 * hexlen + halfhexlen - 100, 4 * (halfhexlen + (halfhexlen / 2) - 15), 0, 0);
        hex19.setLayoutParams(params19);

        if(randomResources.get(18) == 1)
            hex19.setImageResource(R.drawable.lumber);
        else if(randomResources.get(18) == 2)
            hex19.setImageResource(R.drawable.brick);
        else if(randomResources.get(18) == 3)
            hex19.setImageResource(R.drawable.ore);
        else if(randomResources.get(18) == 4)
            hex19.setImageResource(R.drawable.wheat);
        else if(randomResources.get(18) == 5)
            hex19.setImageResource(R.drawable.sheep);
        else
            hex19.setImageResource(R.drawable.desert);


        //RoundedImageView circ1 = (RoundedImageView) findViewById(R.id.circ1);
        //circ1.setImageResource((R.drawable.catan_board_draft2));

        ///////////
        ////////////
        /////

        /*RelativeLayout rl = (RelativeLayout) findViewById(R.id.relLay);
        RelativeLayout.LayoutParams params;

        HexagonMaskView c = (HexagonMaskView) findViewById(R.id.image);
        int test;
        test = c.getId();
        params = new RelativeLayout.LayoutParams(30,40);
        params.leftMargin = 50;
        params.topMargin = 60;
        rl.addView(c, params);

        HexagonMaskView c2 = (HexagonMaskView) findViewById(R.id.image2);
        params = new RelativeLayout.LayoutParams(30,40);
        params.leftMargin = 80;
        params.topMargin = 90;
        rl.addView(c2,params);*/

        //params.addRule(RelativeLayout.RIGHT_OF, test);

        //HexagonMaskView test = new HexagonMaskView(this);
        //test.setImageResource(R.drawable.image);

    }

    static void shuffleArray(int[] ar)
    {
        // If running on Java 6 or older, use `new Random()` on RHS here
        //Random rnd = ThreadLocalRandom.current();
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
    public void randomize(View v) {
        List<Integer> randomResources = new ArrayList<Integer>();
        randomResources.add(3);
        randomResources.add(1);
        randomResources.add(1);
        randomResources.add(1);
        randomResources.add(1);
        randomResources.add(2);
        randomResources.add(2);
        randomResources.add(2);
        randomResources.add(0);
        randomResources.add(3);
        randomResources.add(3);
        randomResources.add(4);
        randomResources.add(4);
        randomResources.add(4);
        randomResources.add(4);
        randomResources.add(5);
        randomResources.add(5);
        randomResources.add(5);
        randomResources.add(5);

        Collections.shuffle(randomResources);

        //shuffleArray(randomResources);
        /*for (int i = 0; i < randomResources.length; i++) {
            System.out.println(randomResources[i]);
        }*/
        /*for(int i = 0; i < 3; i++)
        {
            int ran = randomGenerator.nextInt(max - min) + min;
            while(randomResources[ran-1]!=0)
            {
                ran = randomGenerator.nextInt(max - min) + min;
            }
            else {
                orePositions[i] = ran;
                randomResources[ran - 1] = 1;
            }
        }
        StringBuilder sb = new StringBuilder(10);
        sb.append("hex");
        sb.append(randomResources[orePositions[0]]);
        String id1 = sb.toString();
        int resID = getResources().getIdentifier(id1, "id", getPackageName());
        HexagonMaskView hex1 = ((HexagonMaskView) findViewById(resID));
        hex1.setImageResource(R.drawable.ore);*/



        /*for(int i = 0; i < randomResources.length; i++)
        {
            randomResources[i] = randomGenerator.nextInt(max - min) + min;
            if(randomResources[i] == 1)
            {
                // Find different resource if there's already 3 ore
                if(numOre == maxOre) {
                    while (randomResources[i] == 1)
                        randomResources[i] = randomGenerator.nextInt(max - min) + min;
                }
                else
                    numOre++;

            }
            else if(randomResources[i]==2)
            {
                // Find different resource if there's already 3 brick
                if(numBrick == maxBrick) {
                    while (randomResources[i] == 2)
                        randomResources[i] = randomGenerator.nextInt(max - min) + min;
                }
                else
                    numBrick++;
            }
            else if(randomResources[i]==3)
            {
                // Find different resource if there's already 3 ore
                if(numLumber == maxLumber) {
                    while (randomResources[i] == 3)
                        randomResources[i] = randomGenerator.nextInt(max - min) + min;
                }
                else
                    numLumber++;
            }
            else if(randomResources[i]==4)
            {
                // Find different resource if there's already 3 ore
                if(numWheat == maxWheat) {
                    while (randomResources[i] == 4)
                        randomResources[i] = randomGenerator.nextInt(max - min) + min;
                }
                else
                    numWheat++;
            }
            else if(randomResources[i]==5)
            {
                // Find different resource if there's already 3 ore
                if(numSheep == maxSheep) {
                    while (randomResources[i] == 5)
                        randomResources[i] = randomGenerator.nextInt(max - min) + min;
                }
                else
                    numSheep++;
            }
        }


        int index = randomGenerator.nextInt(max - min) + min;*/
        //int index2 = randomGenerator.nextInt(max - min) + min;
        //int dice = index + index2;

        HexagonMaskView hex1 = (HexagonMaskView) findViewById(R.id.hex1);
        //hex1.setImageResource(R.drawable.lumber);
        if(randomResources.get(0) == 1)
            hex1.setImageResource(R.drawable.lumber);
        else if(randomResources.get(0) == 2)
            hex1.setImageResource(R.drawable.brick);
        else if(randomResources.get(0) == 3)
            hex1.setImageResource(R.drawable.ore);
        else if(randomResources.get(0) == 4)
            hex1.setImageResource(R.drawable.wheat);
        else if(randomResources.get(0) == 5)
            hex1.setImageResource(R.drawable.sheep);
        else if(randomResources.get(0) == 0)
            hex1.setImageResource(R.drawable.desert);

        HexagonMaskView hex2 = (HexagonMaskView) findViewById(R.id.hex2);
        //hex2.setImageResource(R.drawable.desert);
        if(randomResources.get(1) == 1)
            hex2.setImageResource(R.drawable.lumber);
        else if(randomResources.get(1) == 2)
            hex2.setImageResource(R.drawable.brick);
        else if(randomResources.get(1) == 3)
            hex2.setImageResource(R.drawable.ore);
        else if(randomResources.get(1) == 4)
            hex2.setImageResource(R.drawable.wheat);
        else if(randomResources.get(1) == 5)
            hex2.setImageResource(R.drawable.sheep);
        else
            hex2.setImageResource(R.drawable.desert);

        ////
        HexagonMaskView hex3 = (HexagonMaskView) findViewById(R.id.hex3);

        if(randomResources.get(2) == 1)
            hex3.setImageResource(R.drawable.lumber);
        else if(randomResources.get(2) == 2)
            hex3.setImageResource(R.drawable.brick);
        else if(randomResources.get(2) == 3)
            hex3.setImageResource(R.drawable.ore);
        else if(randomResources.get(2) == 4)
            hex3.setImageResource(R.drawable.wheat);
        else if(randomResources.get(2) == 5)
            hex3.setImageResource(R.drawable.sheep);
        else
            hex3.setImageResource(R.drawable.desert);
        ////
        HexagonMaskView hex4 = (HexagonMaskView) findViewById(R.id.hex4);

        if(randomResources.get(3) == 1)
            hex4.setImageResource(R.drawable.lumber);
        else if(randomResources.get(3) == 2)
            hex4.setImageResource(R.drawable.brick);
        else if(randomResources.get(3) == 3)
            hex4.setImageResource(R.drawable.ore);
        else if(randomResources.get(3) == 4)
            hex4.setImageResource(R.drawable.wheat);
        else if(randomResources.get(3) == 5)
            hex4.setImageResource(R.drawable.sheep);
        else
            hex4.setImageResource(R.drawable.desert);
        ////
        HexagonMaskView hex5 = (HexagonMaskView) findViewById(R.id.hex5);

        if(randomResources.get(4) == 1)
            hex5.setImageResource(R.drawable.lumber);
        else if(randomResources.get(4) == 2)
            hex5.setImageResource(R.drawable.brick);
        else if(randomResources.get(4) == 3)
            hex5.setImageResource(R.drawable.ore);
        else if(randomResources.get(4) == 4)
            hex5.setImageResource(R.drawable.wheat);
        else if(randomResources.get(4) == 5)
            hex5.setImageResource(R.drawable.sheep);
        else
            hex5.setImageResource(R.drawable.desert);

        ////
        HexagonMaskView hex6 = (HexagonMaskView) findViewById(R.id.hex6);

        if(randomResources.get(5) == 1)
            hex6.setImageResource(R.drawable.lumber);
        else if(randomResources.get(5) == 2)
            hex6.setImageResource(R.drawable.brick);
        else if(randomResources.get(5) == 3)
            hex6.setImageResource(R.drawable.ore);
        else if(randomResources.get(5) == 4)
            hex6.setImageResource(R.drawable.wheat);
        else if(randomResources.get(5) == 5)
            hex6.setImageResource(R.drawable.sheep);
        else
            hex6.setImageResource(R.drawable.desert);

        ////
        HexagonMaskView hex7 = (HexagonMaskView) findViewById(R.id.hex7);

        if(randomResources.get(6) == 1)
            hex7.setImageResource(R.drawable.lumber);
        else if(randomResources.get(6) == 2)
            hex7.setImageResource(R.drawable.brick);
        else if(randomResources.get(6) == 3)
            hex7.setImageResource(R.drawable.ore);
        else if(randomResources.get(6) == 4)
            hex7.setImageResource(R.drawable.wheat);
        else if(randomResources.get(6) == 5)
            hex7.setImageResource(R.drawable.sheep);
        else
            hex7.setImageResource(R.drawable.desert);

        ////
        HexagonMaskView hex8 = (HexagonMaskView) findViewById(R.id.hex8);

        if(randomResources.get(7) == 1)
            hex8.setImageResource(R.drawable.lumber);
        else if(randomResources.get(7) == 2)
            hex8.setImageResource(R.drawable.brick);
        else if(randomResources.get(7) == 3)
            hex8.setImageResource(R.drawable.ore);
        else if(randomResources.get(7) == 4)
            hex8.setImageResource(R.drawable.wheat);
        else if(randomResources.get(7) == 5)
            hex8.setImageResource(R.drawable.sheep);
        else
            hex8.setImageResource(R.drawable.desert);

        ////
        HexagonMaskView hex9 = (HexagonMaskView) findViewById(R.id.hex9);

        if(randomResources.get(8) == 1)
            hex9.setImageResource(R.drawable.lumber);
        else if(randomResources.get(8) == 2)
            hex9.setImageResource(R.drawable.brick);
        else if(randomResources.get(8) == 3)
            hex9.setImageResource(R.drawable.ore);
        else if(randomResources.get(8) == 4)
            hex9.setImageResource(R.drawable.wheat);
        else if(randomResources.get(8) == 5)
            hex9.setImageResource(R.drawable.sheep);
        else
            hex9.setImageResource(R.drawable.desert);

        ////
        HexagonMaskView hex10 = (HexagonMaskView) findViewById(R.id.hex10);

        if(randomResources.get(9) == 1)
            hex10.setImageResource(R.drawable.lumber);
        else if(randomResources.get(9) == 2)
            hex10.setImageResource(R.drawable.brick);
        else if(randomResources.get(9) == 3)
            hex10.setImageResource(R.drawable.ore);
        else if(randomResources.get(9) == 4)
            hex10.setImageResource(R.drawable.wheat);
        else if(randomResources.get(9) == 5)
            hex10.setImageResource(R.drawable.sheep);
        else
            hex10.setImageResource(R.drawable.desert);

        ////
        HexagonMaskView hex11 = (HexagonMaskView) findViewById(R.id.hex11);

        if(randomResources.get(10) == 1)
            hex11.setImageResource(R.drawable.lumber);
        else if(randomResources.get(10) == 2)
            hex11.setImageResource(R.drawable.brick);
        else if(randomResources.get(10) == 3)
            hex11.setImageResource(R.drawable.ore);
        else if(randomResources.get(10) == 4)
            hex11.setImageResource(R.drawable.wheat);
        else if(randomResources.get(10) == 5)
            hex11.setImageResource(R.drawable.sheep);
        else
            hex11.setImageResource(R.drawable.desert);

        ////
        HexagonMaskView hex12 = (HexagonMaskView) findViewById(R.id.hex12);

        if(randomResources.get(11) == 1)
            hex12.setImageResource(R.drawable.lumber);
        else if(randomResources.get(11) == 2)
            hex12.setImageResource(R.drawable.brick);
        else if(randomResources.get(11) == 3)
            hex12.setImageResource(R.drawable.ore);
        else if(randomResources.get(11) == 4)
            hex12.setImageResource(R.drawable.wheat);
        else if(randomResources.get(11) == 5)
            hex12.setImageResource(R.drawable.sheep);
        else
            hex12.setImageResource(R.drawable.desert);

        ////
        HexagonMaskView hex13 = (HexagonMaskView) findViewById(R.id.hex13);

        if(randomResources.get(12) == 1)
            hex13.setImageResource(R.drawable.lumber);
        else if(randomResources.get(12) == 2)
            hex13.setImageResource(R.drawable.brick);
        else if(randomResources.get(12) == 3)
            hex13.setImageResource(R.drawable.ore);
        else if(randomResources.get(12) == 4)
            hex13.setImageResource(R.drawable.wheat);
        else if(randomResources.get(12) == 5)
            hex13.setImageResource(R.drawable.sheep);
        else
            hex13.setImageResource(R.drawable.desert);

        ////
        HexagonMaskView hex14 = (HexagonMaskView) findViewById(R.id.hex14);

        if(randomResources.get(13) == 1)
            hex14.setImageResource(R.drawable.lumber);
        else if(randomResources.get(13) == 2)
            hex14.setImageResource(R.drawable.brick);
        else if(randomResources.get(13) == 3)
            hex14.setImageResource(R.drawable.ore);
        else if(randomResources.get(13) == 4)
            hex14.setImageResource(R.drawable.wheat);
        else if(randomResources.get(13) == 5)
            hex14.setImageResource(R.drawable.sheep);
        else
            hex14.setImageResource(R.drawable.desert);

        ////
        HexagonMaskView hex15 = (HexagonMaskView) findViewById(R.id.hex15);

        if(randomResources.get(14) == 1)
            hex15.setImageResource(R.drawable.lumber);
        else if(randomResources.get(14) == 2)
            hex15.setImageResource(R.drawable.brick);
        else if(randomResources.get(14) == 3)
            hex15.setImageResource(R.drawable.ore);
        else if(randomResources.get(14) == 4)
            hex15.setImageResource(R.drawable.wheat);
        else if(randomResources.get(14) == 5)
            hex15.setImageResource(R.drawable.sheep);
        else
            hex15.setImageResource(R.drawable.desert);

        ////
        HexagonMaskView hex16 = (HexagonMaskView) findViewById(R.id.hex16);

        if(randomResources.get(15) == 1)
            hex16.setImageResource(R.drawable.lumber);
        else if(randomResources.get(15) == 2)
            hex16.setImageResource(R.drawable.brick);
        else if(randomResources.get(15) == 3)
            hex16.setImageResource(R.drawable.ore);
        else if(randomResources.get(15) == 4)
            hex16.setImageResource(R.drawable.wheat);
        else if(randomResources.get(15) == 5)
            hex16.setImageResource(R.drawable.sheep);
        else
            hex16.setImageResource(R.drawable.desert);

        ////
        HexagonMaskView hex17 = (HexagonMaskView) findViewById(R.id.hex17);

        if(randomResources.get(16) == 1)
            hex17.setImageResource(R.drawable.lumber);
        else if(randomResources.get(16) == 2)
            hex17.setImageResource(R.drawable.brick);
        else if(randomResources.get(16) == 3)
            hex17.setImageResource(R.drawable.ore);
        else if(randomResources.get(16) == 4)
            hex17.setImageResource(R.drawable.wheat);
        else if(randomResources.get(16) == 5)
            hex17.setImageResource(R.drawable.sheep);
        else
            hex17.setImageResource(R.drawable.desert);

        ////
        HexagonMaskView hex18 = (HexagonMaskView) findViewById(R.id.hex18);

        if(randomResources.get(17) == 1)
            hex18.setImageResource(R.drawable.lumber);
        else if(randomResources.get(17) == 2)
            hex18.setImageResource(R.drawable.brick);
        else if(randomResources.get(17) == 3)
            hex18.setImageResource(R.drawable.ore);
        else if(randomResources.get(17) == 4)
            hex18.setImageResource(R.drawable.wheat);
        else if(randomResources.get(17) == 5)
            hex18.setImageResource(R.drawable.sheep);
        else
            hex18.setImageResource(R.drawable.desert);

        ////
        HexagonMaskView hex19 = (HexagonMaskView) findViewById(R.id.hex19);

        if(randomResources.get(18) == 1)
            hex19.setImageResource(R.drawable.lumber);
        else if(randomResources.get(18) == 2)
            hex19.setImageResource(R.drawable.brick);
        else if(randomResources.get(18) == 3)
            hex19.setImageResource(R.drawable.ore);
        else if(randomResources.get(18) == 4)
            hex19.setImageResource(R.drawable.wheat);
        else if(randomResources.get(18) == 5)
            hex19.setImageResource(R.drawable.sheep);
        else
            hex19.setImageResource(R.drawable.desert);
    }

}


